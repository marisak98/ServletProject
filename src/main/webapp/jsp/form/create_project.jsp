<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>${project.id > 0 ? "Editar Proyecto" : "Crear Proyecto"}</title>
</head>
<body>
    <h1>${project.id > 0 ? "Editar Proyecto" : "Crear Proyecto"}</h1>
    <form action="projects" method="post">
        <input type="hidden" name="id" value="${project.id}">
        <div>
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="${project.nombre}">
        </div>
        <div>
            <label for="descripcion">Descripción:</label>
            <textarea id="descripcion" name="descripcion">${project.descripcion}</textarea>
        </div>
        <div>
            <label for="fechaInicio">Fecha de Inicio:</label>
            <input type="date" id="fechaInicio" name="fechaInicio" value="${project.fechaInicio}">
        </div>
        <div>
            <label for="fechaFin">Fecha de Fin:</label>
            <input type="date" id="fechaFin" name="fechaFin" value="${project.fechaFin}">
        </div>
        <div>
            <label for="estado">Estado:</label>
            <input type="text" id="estado" name="estado" value="${project.estado}">
        </div>
        <div>
            <button type="submit">${project.id > 0 ? "Actualizar" : "Guardar"}</button>
        </div>
    </form>
    <a href="list">Volver a la lista</a>
</body>
</html>

