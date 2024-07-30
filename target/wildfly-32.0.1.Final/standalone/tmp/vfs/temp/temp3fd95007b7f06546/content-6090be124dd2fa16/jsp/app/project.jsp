<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <main class="p-4 sm:px-4 sm:py-4">
    <div class="overflow-hidden rounded-[0.5rem] border bg-background shadow">
      <div class="hidden flex-col md:flex">
        <section class="flex items-center justify-between mb-2 p-4">
            <div class="space-y-1">
              <h2 class="text-xl sm:text-2xl text-foreground font-semibold tracking-tight">
                Proyectos Disponibles
              </h2>
              <p class="text-xs sm:text-sm text-muted-foreground">
                Lista de todos los proyectos activos.
              </p>
            </div>
            <div class="flex items-center gap-x-1">
              <button
                      type="submit"
                      value="z"
                      class="border-emerald-500 bg-emerald-500 text-white hover:bg-emerald-700 hover:text-white border border-input bg-background shadow-sm hover:bg-accent hover:text-accent-foreground"
                    >
                    Nuevo Proyecto
                    </button>
                <%@include file="./_components/create_new_project.jsp"  %>
</div>
            </section>
            <!--End first section-->
            <section class="flex items-center gap-2 mb-1 p-4">
              <p class="text-sm text-gray-400 flex items-center gap-x-1">
               <span>Proyectos</span>
              </p>

            </section>
            <div class="border-b"></div>
            <div class="flex-1 space-y-4 p-8 pt-6">
              <div class="space-y-4">
                <%@include file="../table/project_available_table.jsp"%>
              </div>
            </div>
      </div>
    </div>
  </main>
</html>
