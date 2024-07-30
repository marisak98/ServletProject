document.addEventListener("DOMContentLoaded", function () {
  fetchProjects();
});

function fetchProjects() {
  fetch("/taskProject-1.0-SNAPSHOT/conexion/project/all")
    .then((response) => response.json())
    .then((data) => {
      populateTable(data);
    })
    .catch((error) => console.error("Error fetching projects:", error));
}

function populateTable(data) {
  let tableBody = document.getElementById("projectTableBody");
  tableBody.innerHTML = "";
  data.forEach((project) => {
    let row = document.createElement("tr");
    row.innerHTML = `
      <td class="py-3 px-6">${project.id || "N/A"}</td>
      <td class="py-3 px-6">${project.nombre}</td>
      <td class="py-3 px-6">${project.descripcion}</td>
      <td class="py-3 px-6">${project.fechaInicio}</td>
      <td class="py-3 px-6">${project.fechaFin}</td>
      <td class="py-3 px-6">${project.status}</td>
      <td>
        <button type="button" class="bg-blue-500 text-white px-4 py-2 rounded-md shadow-sm" onclick="openEditModal(${project.id})">
          Editar
        </button>
        <button type="button" class="bg-red-500 text-white px-4 py-2 rounded-md shadow-sm" onclick="confirmDelete(${project.id})">
          Eliminar
        </button>
      </td>
    `;
    tableBody.appendChild(row);
  });
}

function openEditModal(id) {
  fetch(`/taskProject-1.0-SNAPSHOT/conexion/project/getProject/${id}`)
    .then((response) => response.json())
    .then((project) => {
      document.getElementById("editProjectId").value = project.id;
      document.getElementById("editProjectName").value = project.nombre;
      document.getElementById("editProjectDescription").value =
        project.descripcion;
      document.getElementById("editProjectStartDate").value =
        project.fechaInicio;
      document.getElementById("editProjectEndDate").value = project.fechaFin;
      document.getElementById("editProjectStatus").value = project.estado;
      document.getElementById("editModal").classList.remove("hidden");
    })
    .catch((error) => console.error("Error fetching project:", error));
}

function closeEditModal() {
  document.getElementById("editModal").classList.add("hidden");
}

function confirmDelete(id) {
  document.getElementById("deleteConfirmModal").classList.remove("hidden");
  document.getElementById("confirmDeleteButton").onclick = function () {
    deleteProject(id);
  };
}

function closeDeleteModal() {
  document.getElementById("deleteConfirmModal").classList.add("hidden");
}

function deleteProject(id) {
  fetch(`/taskProject-1.0-SNAPSHOT/conexion/project/delete/${id}`, {
    method: "DELETE",
  })
    .then((response) => response.json())
    .then((data) => {
      if (data.success) {
        fetchProjects();
        closeDeleteModal();
        showNotification("Proyecto eliminado exitosamente.");
      } else {
        alert("Error al eliminar proyecto");
      }
    })
    .catch((error) => console.error("Error deleting project:", error));
}

function showNotification(message, isError = false) {
  const notificationContainer = document.getElementById(
    "notificationContainer",
  );
  const notificationMessage = document.getElementById("notificationMessage");

  notificationMessage.textContent = message;
  notificationMessage.className = isError
    ? "bg-red-500 text-white px-4 py-2 rounded-md shadow-sm"
    : "bg-blue-500 text-white px-4 py-2 rounded-md shadow-sm";

  notificationContainer.classList.remove("hidden");

  setTimeout(() => {
    notificationContainer.classList.add("hidden");
  }, 3000);
}
