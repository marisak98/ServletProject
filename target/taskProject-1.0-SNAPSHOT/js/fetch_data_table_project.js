document.addEventListener("DOMContentLoaded", function () {
  fetchProjects();
});

function fetchProjects() {
  fetch("/conexion/project/all")
    .then((response) => response.json())
    .then((data) => {
      let tableBody = document.getElementById("projectTableBody");
      tableBody.innerHTML = ""; // Clear existing rows
      data.forEach((project) => {
        let row = document.createElement("tr");
        row.innerHTML = `
                    <td class="py-3 px-6">${project.id}</td>
                    <td class="py-3 px-6">${project.nombre}</td>
                    <td class="py-3 px-6">${project.descripcion}</td>
                    <td class="py-3 px-6">${project.fechaInicio}</td>
                    <td class="py-3 px-6">${project.fechaFin}</td>
                    <td class="py-3 px-6">
                        <button class="bg-blue-500 text-white px-4 py-2 rounded">Action</button>
                    </td>
                `;
        tableBody.appendChild(row);
      });
    })
    .catch((error) => console.error("Error fetching projects:", error));
}
