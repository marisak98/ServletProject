<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Miembros</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<section class="intro">
    <div class="d-flex justify-content-between align-items-center">
        <div class="input-group">
            <div class="form-outline" data-mdb-input-init>
                <input type="search" id="form1" class="form-control" />
                <label class="form-label" for="form1">Search</label>
            </div>
            <button type="button" class="btn btn-primary btn-sm px-3">
                <i class="bx bx-search-alt-2"></i>
            </button>
        </div>
        <!--Button ADD -->
        <div>
            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addModal">Agregar</button>
        </div>
    </div>
    <div class="bg-image h-100" style="background-color: #6095F0;">
        <div class="mask d-flex align-items-center h-100">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12">
                        <div class="card shadow-2-strong" style="background-color: #f5f7fa;">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-borderless mb-0">
                                        <thead>
                                            <tr>
                                                <th scope="col">
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" />
                                                    </div>
                                                </th>
                                                <th scope="col">ID</th>
                                                <th scope="col">NOMBRE</th>
                                                <th scope="col">CORREO</th>
                                                <th scope="col">ROL</th>
                                                <th scope="col">ACCIONES</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tableBody">
                                            <!-- Aquí se llenará con JavaScript -->
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Modal para agregar miembro -->
<div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addModalLabel">Agregar Miembro</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="/taskProject-1.0-SNAPSHOT/conexion/member/save" method="post" id="addMemberForm">
                  <div class="form-group">
                        <label for="addNombre">Cedula</label>
                        <input type="text" name="cedula" class="form-control" id="addNombre"  required>
                    </div>

                    <div class="form-group">
                        <label for="addNombre">Nombre</label>
                        <input type="text" name="nombre" class="form-control" id="addNombre" required>
                    </div>
                    <div class="form-group">
                        <label for="addCorreo">Correo</label>
                        <input type="email" name="correo" class="form-control" id="addCorreo" required>
                    </div>
                    <div class="form-group">
                        <label for="addRol">Rol</label>
                        <input type="text" class="form-control" name="rol" id="addRol" required>
                    </div>
                    <button type="submit" class="btn btn-primary" name="accion" value="Guardar">Guardar</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Modal para editar miembro -->
<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Editar Miembro</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editMemberForm" action="/taskProject-1.0-SNAPSHOT/conexion/member/update" method="POST" >
                 <!-- Campo oculto para el ID de la tarea -->
                    <input type="text" id="editId" name="EditId">
                    <div class="form-group">
                        <label for="editNombre">Nombre</label>
                        <input type="text" class="form-control" id="editNombre" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="editCorreo">Correo</label>
                        <input type="email" class="form-control" id="editCorreo" name="correo" required>
                    </div>
                    <div class="form-group">
                        <label for="editRol">Rol</label>
                        <input type="text" class="form-control" id="editRol" name="rol" required>
                    </div>
                    <button type="submit" class="btn btn-primary" name="accion" value="ActualizarM" >Guardar Cambios</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/taskProject-1.0-SNAPSHOT/js/fetch_data_miembros.js"></script>
</body>
</html>
