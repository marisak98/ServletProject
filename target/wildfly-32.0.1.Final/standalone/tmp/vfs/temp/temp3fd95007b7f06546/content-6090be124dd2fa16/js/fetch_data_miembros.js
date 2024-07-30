document.addEventListener("DOMContentLoaded", function () {
  fetchMembers();

  // Función para obtener los miembros
  function fetchMembers() {
    fetch("/taskProject-1.0-SNAPSHOT/conexion/member/all")
      .then((response) => response.json())
      .then((data) => {
        let tableBody = document.getElementById("tableBody");
        tableBody.innerHTML = "";
        data.forEach((member) => {
          let row = document.createElement("tr");
          row.innerHTML = `
                            <th scope="row">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault${member.id}">
                                </div>
                            </th>
                            <td>${member.id}</td>
                            <td>${member.nombre}</td>
                            <td>${member.correo}</td>
                            <td>${member.rol}</td>
                            <td>
                                <button type="button" class="btn btn-primary btn-sm px-3" onclick="openEditModal(${member.id})">
                                    <i class="bx bx-edit"></i>
                                </button>
                                <button type="button" class="btn btn-danger btn-sm px-3" onclick="deleteMember(${member.id})">
                                    <i class="bx bxs-x-circle"></i>
                                </button>
                            </td>
                        `;
          tableBody.appendChild(row);
        });
        console.log(member);
      })
      .catch((error) => console.error("Error fetching members:", error));
  }

  // Función para abrir el modal de edición con los datos del miembro
  window.openEditModal = function (id) {
    fetch(
      `http://127.0.0.1:8080/taskProject-1.0-SNAPSHOT/conexion/member/getMember/${id}`,
    )
      .then((response) => response.json())
      .then((member) => {
        document.getElementById("editId").value = member.id;
        document.getElementById("editNombre").value = member.nombre;
        document.getElementById("editCorreo").value = member.correo;
        document.getElementById("editRol").value = member.rol;
        $("#editModal").modal("show");
      })
      .catch((error) => console.error("Error fetching member:", error));
  };

  // Función para eliminar un miembro
  window.deleteMember = function (id) {
    console.log("Deleting member with ID:", id); // Verifica el ID
    if (confirm("¿Estás seguro de eliminar este miembro?")) {
      fetch(`/taskProject-1.0-SNAPSHOT/conexion/member/delete/${id}`, {
        method: "DELETE",
      })
        .then((response) => response.json())
        .then((data) => {
          console.log(data); // Verifica la respuesta del servidor
          if (data.success) {
            fetchMembers();
          } else {
            alert("Error al eliminar miembro");
          }
        })
        .catch((error) => console.error("Error deleting member:", error));
    }
  };
});
