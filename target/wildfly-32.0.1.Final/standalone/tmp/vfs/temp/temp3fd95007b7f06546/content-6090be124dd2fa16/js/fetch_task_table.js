document.addEventListener("DOMContentLoaded", function () {
  let projectMap = new Map();

  // Fetch projects to populate the projectId dropdown
  fetch("/taskProject-1.0-SNAPSHOT/conexion/project/all")
    .then((response) => response.json())
    .then((data) => {
      let projectSelect = document.getElementById("projectId");
      data.forEach((project) => {
        let option = document.createElement("option");
        option.value = project.id;
        option.text = project.nombre;
        projectSelect.add(option);
        projectMap.set(project.id, project.nombre);
      });
    })
    .catch((error) => console.error("Error fetching projects:", error));

  // Handle form submission
  document
    .getElementById("taskForm")
    .addEventListener("submit", function (event) {
      event.preventDefault();

      let formData = new FormData(this);
      fetch("/taskProject-1.0-SNAPSHOT/conexion/task/save", {
        method: "POST",
        body: new URLSearchParams(formData),
      })
        .then((response) => response.text())
        .then((message) => {
          document.getElementById("taskMessage").innerText = message;
          this.reset();
          console.log(formData);
          fetchTasks(); // Refresh the task list after saving
        })
        .catch((error) => console.error("Error saving task:", error));
    });

  // Fetch tasks to populate the task table
  function fetchTasks() {
    fetch("/taskProject-1.0-SNAPSHOT/conexion/task/all")
      .then((response) => {
        if (!response.ok) {
          throw new Error(response.statusText);
        }
        return response.json();
      })
      .then((data) => {
        console.log("Datos recibidos de tareas:", data);
        let tableBody = document.getElementById("taskTableBody");
        if (data.length === 0) {
          tableBody.innerHTML = "<tr><td colspan='9'>No hay tareas</td></tr>";
        } else {
          tableBody.innerHTML = ""; // Clear existing rows
          data.forEach((task) => {
            console.log("Task data:", task); // Log cada tarea individual
            let row = document.createElement("tr");
            row.innerHTML = `
                    <td class="py-3 px-6">${task.id || "test"}</td>
                    <td class="py-3 px-6">${task.nombre}</td>
                    <td class="py-3 px-6">${task.descripcion}</td>
                    <td class="py-3 px-6">${task.fechaInicio}</td>
                    <td class="py-3 px-6">${task.fechaFin}</td>
                    <td class="py-3 px-6">${task.prioridad}</td>
                    <td class="py-3 px-6">${task.state}</td>
                    <td class="py-3 px-6">${projectMap.get(task.proyectoId)}</td>
                    <td class="py-3 px-6">${task.miembroEquipoId}</td>
                    <td class="py-3 px-6 text-center">
                          <a href="#" class="text-blue-500 hover:text-blue-700" onclick="editTask(${task.id})"><i class="fas fa-edit"></i></a>
                          <a href="#" class="text-red-500 hover:text-red-700 ml-2" onclick="deleteTask(${task.id})"><i class="fas fa-trash-alt"></i></a>
                    </td>
                  `;
            tableBody.appendChild(row);
          });
        }
      })
      .catch((error) => {
        document.getElementById("taskMessage").innerText =
          "Error al cargar las tareas. Intenta nuevamente más tarde.";
        console.error("Error fetching tasks:", error);
        document.getElementById("taskTableBody").innerHTML =
          "<tr><td colspan='9'>Error al cargar las tareas</td></tr>";
      });
  }

  //Function to handle edit and delete tasks
  window.editTask = function (taskId) {
    fetch(`/taskProject-1.0-SNAPSHOT/conexion/task/getTarea/${taskId}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error(response.statusText);
        }
        return response.json();
      })
      .then((task) => {
        let elements = {
          taskId: document.getElementById("taskId"),
          nombre: document.getElementById("taskName"),
          descripcion: document.getElementById("taskDescription"),
          fechaInicio: document.getElementById("taskStartDate"),
          fechaFin: document.getElementById("taskEndDate"),
          prioridad: document.getElementById("taskPriority"),
          state: document.getElementById("taskStatus"),
          proyectoId: document.getElementById("projectId"),
          miembroEquipoId: document.getElementById("memberId"),
        };
        console.log(task);
        for (let key in elements) {
          if (elements[key]) {
            elements[key].value = task[key];
          } else {
            console.error(`Element with ID "${key}" not found`);
          }
        }
      })
      .catch((error) => {
        let taskMessage = document.getElementById("taskMessage");
        if (taskMessage) {
          taskMessage.innerText =
            "Error al cargar la tarea para edición: " + error;
        }
        console.error("Error fetching task for editing:", error);
      });
  };

  window.deleteTask = function (taskId) {
    if (confirm("¿Estás seguro de que deseas eliminar esta tarea?")) {
      fetch(`/taskProject-1.0-SNAPSHOT/conexion/task/delete/${taskId}`, {
        method: "DELETE",
      })
        .then((response) => {
          console.log("Response status:", response.status); // Agrega esta línea
          if (!response.ok) {
            throw new Error("Tarea borrada", response.statusText);
          }
          return response.text();
        })
        .then((message) => {
          document.getElementById("taskMessage").innerText = message;
          fetchTasks();
        })
        .catch((error) => {
          document.getElementById("taskMessage").innerText = "Tarea borrada: ";
          console.error("Error deleting task:", error);
        });
    }
  };

  // Initial fetch of tasks
  fetchTasks();
});
