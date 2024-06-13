<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Diagrama de Gantt con Bootstrap y CRUD</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- DHTMLX Gantt CSS -->
    <link rel="stylesheet" href="https://cdn.dhtmlx.com/gantt/edge/dhtmlxgantt.css">
    <!-- Custom CSS -->
    <style>
        #gantt_here {
            width: 100%;
            height: 500px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1>Diagrama de Gantt</h1>
        <div id="gantt_here"></div>
        <button class="btn btn-primary mt-3" data-toggle="modal" data-target="#addTaskModal">Añadir Tarea</button>
    </div>

    <!-- Modal para añadir tareas -->
    <div class="modal fade" id="addTaskModal" tabindex="-1" aria-labelledby="addTaskModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addTaskModalLabel">Añadir Tarea</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addTaskForm">
                        <div class="form-group">
                            <label for="taskName">Nombre de la Tarea</label>
                            <input type="text" class="form-control" id="taskName" required>
                        </div>
                        <div class="form-group">
                            <label for="taskStartDate">Fecha de Inicio</label>
                            <input type="date" class="form-control" id="taskStartDate" required>
                        </div>
                        <div class="form-group">
                            <label for="taskDuration">Duración (días)</label>
                            <input type="number" class="form-control" id="taskDuration" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Añadir</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- DHTMLX Gantt JS -->
    <script src="https://cdn.dhtmlx.com/gantt/edge/dhtmlxgantt.js"></script>
    <script>
        gantt.init("gantt_here");

        let tasks = {
            data: [
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Diagrama de Gantt con Bootstrap y CRUD</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- DHTMLX Gantt CSS -->
    <link rel="stylesheet" href="https://cdn.dhtmlx.com/gantt/edge/dhtmlxgantt.css">
    <!-- Custom CSS -->
    <style>
        #gantt_here {
            width: 100%;
            height: 500px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1>Diagrama de Gantt</h1>
        <div id="gantt_here"></div>
        <button class="btn btn-primary mt-3" data-toggle="modal" data-target="#addTaskModal">Añadir Tarea</button>
    </div>

    <!-- Modal para añadir tareas -->
    <div class="modal fade" id="addTaskModal" tabindex="-1" aria-labelledby="addTaskModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="addTaskModalLabel">Añadir Tarea</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addTaskForm">
                        <div class="form-group">
                            <label for="taskName">Nombre de la Tarea</label>
                            <input type="text" class="form-control" id="taskName" required>
                        </div>
                        <div class="form-group">
                            <label for="taskStartDate">Fecha de Inicio</label>
                            <input type="date" class="form-control" id="taskStartDate" required>
                        </div>
                        <div class="form-group">
                            <label for="taskDuration">Duración (días)</label>
                            <input type="number" class="form-control" id="taskDuration" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Añadir</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- DHTMLX Gantt JS -->
    <script src="https://cdn.dhtmlx.com/gantt/edge/dhtmlxgantt.js"></script>
    <script>
        gantt.init("gantt_here");

        let tasks = {
            data: [
                {id: 1, text: "Task #1", start_date: "01-04-2024", duration: 5, progress: 0.4},
                {id: 2, text: "Task #2", start_date: "03-04-2024", duration: 3, progress: 0.6}
            ],
            links: [
                {id: 1, source: 1, target: 2, type: "0"}
            ]
        };

        gantt.parse(tasks);

        // Añadir tarea
        $("#addTaskForm").on("submit", function(event) {
            event.preventDefault();
            let taskName = $("#taskName").val();
            let taskStartDate = $("#taskStartDate").val();
            let taskDuration = $("#taskDuration").val();
            let newTask = {
                id: gantt.uid(),
                text: taskName,
                start_date: gantt.date.parseDate(taskStartDate, "xml_date"),
                duration: taskDuration
            };
            gantt.addTask(newTask);
            $("#addTaskModal").modal("hide");
        });

        // Añadir botones de Editar y Eliminar
        gantt.attachEvent("onTaskClick", function(id, e) {
            const target = e.target || e.srcElement;
            if (target.classList.contains("gantt_tree_content")) {
                $("#taskActionsModal").modal("show");
                $("#editTaskBtn").off("click").on("click", function() {
                    // Lógica para editar la tarea
                    let task = gantt.getTask(id);
                    $("#editTaskName").val(task.text);
                    $("#editTaskStartDate").val(gantt.date.date_to_str("%Y-%m-%d")(task.start_date));
                    $("#editTaskDuration").val(task.duration);
                    $("#saveEditTaskBtn").off("click").on("click", function() {
                        task.text = $("#editTaskName").val();
                        task.start_date = gantt.date.parseDate($("#editTaskStartDate").val(), "yyyy-MM-dd");
                        task.duration = $("#editTaskDuration").val();
                        gantt.updateTask(id);
                        $("#taskActionsModal").modal("hide");
                    });
                });
                $("#deleteTaskBtn").off("click").on("click", function() {
                    // Lógica para eliminar la tarea
                    gantt.deleteTask(id);
                    $("#taskActionsModal").modal("hide");
                });
            }
        });
    </script>

    <!-- Modal para editar y eliminar tareas -->
    <div class="modal fade" id="taskActionsModal" tabindex="-1" aria-labelledby="taskActionsModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="taskActionsModalLabel">Acciones de Tarea</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <button id="editTaskBtn" class="btn btn-primary mr-2">Editar</button>
                    <button id="deleteTaskBtn" class="btn btn-danger">Eliminar</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

