<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.touhousoft.taskproject.model.Tareas" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
  </head>
  <body>
    <div class="container mx-auto py-12">
      <h2 class="text-gray-800 font-lg font-bold mb-4">Agregar Tarea</h2>
      <form id="taskForm" action="/taskProject-1.0-SNAPSHOT/conexion/task/update" class="grid grid-cols-2 gap-4">
         <!-- Campo oculto para el ID de la tarea -->
        <input type="hidden" id="taskId" name="taskId" />

        <div class="mb-4">
          <label for="taskName" class="block text-gray-700 text-sm font-bold mb-2">Nombre de la Tarea:</label>
          <input type="text" id="taskName" name="taskName" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
        </div>
        <div class="mb-4">
          <label for="taskDescription" class="block text-gray-700 text-sm font-bold mb-2">Descripción:</label>
          <textarea id="taskDescription" name="taskDescription" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"></textarea>
        </div>
        <div class="mb-4">
          <label for="taskStartDate" class="block text-gray-700 text-sm font-bold mb-2">Fecha de Inicio:</label>
          <input type="date" id="taskStartDate" name="taskStartDate" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
        </div>
        <div class="mb-4">
          <label for="taskEndDate" class="block text-gray-700 text-sm font-bold mb-2">Fecha de Fin:</label>
          <input type="date" id="taskEndDate" name="taskEndDate" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" required>
        </div>
        <div class="mb-4">
          <label for="taskPriority" class="block text-gray-700 text-sm font-bold mb-2">Prioridad:</label>
          <select id="taskPriority" name="taskPriority" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
            <option value="ALTA">Alta</option>
            <option value="MEDIA">Media</option>
            <option value="BAJA">Baja</option>
          </select>
        </div>
        <div class="mb-4">
          <label for="taskStatus" class="block text-gray-700 text-sm font-bold mb-2">Estado:</label>
          <select id="taskStatus" name="taskStatus" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
            <option value="PENDING">Pendiente</option>
            <option value="IN_PROGRESS">En Progreso</option>
            <option value="COMPLETED">Completada</option>
          </select>
        </div>
        <div class="mb-4">
          <label for="projectId" class="block text-gray-700 text-sm font-bold mb-2">Proyecto:</label>
          <select id="projectId" name="projectId" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
            <!-- Aquí se llenarán los proyectos con JavaScript -->
          </select>
        </div>
        <div class="mb-4">
          <label for="memberId" class="block text-gray-700 text-sm font-bold mb-2">Miembro del Equipo:</label>
          <input type="number" id="memberId" name="memberId" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
        </div>
        <div class="col-span-2 flex items-center justify-between">
          <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Guardar Tarea</button>
          <button type="submit" name="accion" value="Actualizar" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Editar Tarea</button>
        </div>
      </form>
        <div id="taskMessage" class="mt-4 text-red-500"></div>
      <h2 class="text-gray-800 font-lg font-bold mb-4 mt-8">Tareas</h2>
      <table class="min-w-full bg-white border border-gray-300 rounded-lg shadow-md">
        <thead>
          <tr class="w-full bg-gray-200 text-gray-600 uppercase text-sm leading-normal">
            <th class="py-3 px-6 text-left">ID</th>
            <th class="py-3 px-6 text-left">Nombre</th>
            <th class="py-3 px-6 text-left">Descripción</th>
            <th class="py-3 px-6 text-left">Fecha de Inicio</th>
            <th class="py-3 px-6 text-left">Fecha de Fin</th>
            <th class="py-3 px-6 text-left">Prioridad</th>
            <th class="py-3 px-6 text-left">Estado</th>
            <th class="py-3 px-6 text-left">Proyecto</th>
            <th class="py-3 px-6 text-left">Miembro del Equipo</th>
            <th class="py-3 px-6 text-left">Acciones</th>
          </tr>
        </thead>
        <tbody id="taskTableBody">
          <!-- Aquí se llenará con JavaScript -->
        </tbody>
      </table>
    </div>

    <script src="../../../js/fetch_task_table.js"></script>
  </body>
</html>
