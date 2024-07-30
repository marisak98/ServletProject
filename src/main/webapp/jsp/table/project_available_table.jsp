<!-- Tabla de Proyectos -->
<div class="container mx-auto py-12">
    <h2 class="text-gray-800 font-lg font-bold mb-4">Proyectos</h2>
    <table class="min-w-full bg-white border border-gray-300 rounded-lg shadow-md">
        <thead>
            <tr class="w-full bg-gray-200 text-gray-600 uppercase text-sm leading-normal">
                <th class="py-3 px-6 text-left">ID</th>
                <th class="py-3 px-6 text-left">Nombre</th>
                <th class="py-3 px-6 text-left">Descripción</th>
                <th class="py-3 px-6 text-left">Fecha de Inicio</th>
                <th class="py-3 px-6 text-left">Fecha de Fin</th>
                <th class="py-3 px-6 text-left">Estado</th>
                <th class="py-3 px-6 text-left">Acciones</th>
            </tr>
        </thead>
        <tbody id="projectTableBody">
            <!-- Aquí se llenará con JavaScript -->
        </tbody>
    </table>
    <script>
       document.addEventListener("DOMContentLoaded", function () {
  fetchProjects();
});

function fetchProjects() {
  fetch("/taskProject-1.0-SNAPSHOT/conexion/project/all")
    .then((response) => response.json())
    .then((data) => {
      console.log(data); // Imprime en la consola del navegador
      alert(JSON.stringify(data, null, 2)); // Muestra el JSON en una alerta
      populateTable(data); // Llama a la función para llenar la tabla
    })
    .catch((error) => console.error("Error fetching projects:", error));
}

function populateTable(data) {
  let tableBody = document.getElementById("projectTableBody");
  tableBody.innerHTML = ""; // Clear existing rows
  data.forEach(async (project) => {
    let row = document.createElement("tr");
    row.innerHTML = `
      <td class="py-3 px-6">${project.id || 'N/A'}</td>
      <td class="py-3 px-6">${project.nombre}</td>
      <td class="py-3 px-6">${project.descripcion}</td>
      <td class="py-3 px-6">${project.fechaInicio}</td>
      <td class="py-3 px-6">${project.fechaFin}</td>
      <td class="py-3 px-6">${project.status}</td>
      <td class="py-3 px-6">
        <button class="bg-blue-500 text-white px-4 py-2 rounded">Action</button>
      </td>
    `;
    tableBody.appendChild(row);
  });
}

                
    </script>
</div>

