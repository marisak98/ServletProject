<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8"/>
  </head>
  <body>
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
    </div>

    <!-- Modal para Editar Proyecto -->
    <div id="editModal" class="fixed inset-0 bg-gray-500 bg-opacity-75 flex items-center justify-center hidden">
      <div class="bg-white p-6 rounded-lg shadow-lg w-full max-w-lg">
        <h3 class="text-xl font-semibold mb-4">Editar Proyecto</h3>
        <form id="editProjectForm" action="/taskProject-1.0-SNAPSHOT/conexion/project/update" method="POST">
          <input type="text" id="editProjectId" name="id">
          <div class="mb-4">
            <label for="editProjectName" class="block text-sm font-medium text-gray-700">Nombre</label>
            <input type="text" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-1 focus:ring-blue-500 sm:text-sm" id="editProjectName" name="nombre" required>
          </div>
          <div class="mb-4">
            <label for="editProjectDescription" class="block text-sm font-medium text-gray-700">Descripción</label>
            <textarea class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-1 focus:ring-blue-500 sm:text-sm" id="editProjectDescription" name="descripcion" required></textarea>
          </div>
          <div class="mb-4">
            <label for="editProjectStartDate" class="block text-sm font-medium text-gray-700">Fecha de Inicio</label>
            <input type="date" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-1 focus:ring-blue-500 sm:text-sm" id="editProjectStartDate" name="fechaInicio" required>
          </div>
          <div class="mb-4">
            <label for="editProjectEndDate" class="block text-sm font-medium text-gray-700">Fecha de Fin</label>
            <input type="date" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-1 focus:ring-blue-500 sm:text-sm" id="editProjectEndDate" name="fechaFin" required>
          </div>
          <div class="mb-4">
            <label for="editProjectStatus" class="block text-sm font-medium text-gray-700">Estado</label>
            <input type="text" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-1 focus:ring-blue-500 sm:text-sm" id="editProjectStatus" name="estado" required>
          </div>
          <div class="flex justify-end">
            <button type="button" class="bg-gray-300 text-gray-800 px-4 py-2 rounded-md shadow-sm mr-2" onclick="closeEditModal()">Cancelar</button>
            <button type="submit" name="accion"  value="Actualizar" class="bg-blue-500 text-white px-4 py-2 rounded-md shadow-sm">Guardar Cambios</button>
          </div>
        </form>
      </div>
    </div>

    <!-- Modal para Confirmar Eliminación -->
    <div id="deleteConfirmModal" class="fixed inset-0 bg-gray-500 bg-opacity-75 flex items-center justify-center hidden">
      <div class="bg-white p-6 rounded-lg shadow-lg w-full max-w-sm">
        <h3 class="text-xl font-semibold mb-4">Confirmar Eliminación</h3>
        <p>¿Estás seguro de eliminar este proyecto?</p>
        <div class="flex justify-end mt-4">
          <button type="button" class="bg-gray-300 text-gray-800 px-4 py-2 rounded-md shadow-sm mr-2" onclick="closeDeleteModal()">Cancelar</button>
          <button type="button" class="bg-red-500 text-white px-4 py-2 rounded-md shadow-sm" id="confirmDeleteButton">Eliminar</button>
        </div>
      </div>
    </div>

    <!-- Scripts -->
    <script src="/taskProject-1.0-SNAPSHOT/js/fetch_data_project.js"></script>
  </body>
</html>

