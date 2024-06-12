<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
<% response.setHeader("Pragma", "no-cache"); %>
<% response.setDateHeader("Expires", 0); %>
<!doctype html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body>
    <div
      class="flex flex-col items-center justify-center min-h-screen py-2 bg-gray-100"
    >
      <main
        class="flex flex-col items-center justify-center w-full flex-1 py-20 text-center"
      >
        <div class="bg-white rounded-2xl shadow-2xl flex w-2/3 max-w-4xl">
          <div class="w-3/5 m-5 p-5 px-5">
            <div class="text-left font-bold">
              <span class="text-red-500">Touhou</span>
              <span class="text-black">Project</span>
            </div>
            <div class="py-10">
              <h2 class="text-3xl font-bold mb-2 text-sky-500">
                Iniciar Sesion
              </h2>
              <div
                class="border-2 w-10 border-green-500 inline-block mb-2"
              ></div>
              <!--Form Contro -->
              <div
                class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700"
              >
                <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
                    <form class="space-y-4 md:space-y-6" action="loginServlet" method="POST">
                    <div>
                      <label
                        for="email"
                        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                        >Usuario</label
                      >
                      <input
                        type="text"
                        name="email"
                        id="email"
                        class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                        placeholder="name@company.com"
                        required=""
                      />
                    </div>
                    <div>
                      <label
                        for="password"
                        class="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                        >Contraseña</label
                      >
                      <input
                        type="password"
                        name="password"
                        id="password"
                        placeholder="••••••••"
                        class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                        required=""
                      />
                    </div>
                    <div class="flex items-center justify-between">
                      <div class="flex items-start">
                        <div class="flex items-center h-5">
                          <input
                            id="remember"
                            aria-describedby="remember"
                            type="checkbox"
                            class="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-primary-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-primary-600 dark:ring-offset-gray-800"
                            required=""
                          />
                        </div>
                        <div class="ml-3 text-sm">
                          <label
                            for="remember"
                            class="text-gray-500 dark:text-gray-300"
                            >Recordar credenciales</label
                          >
                        </div>
                      </div>
                      <a
                        href="#"
                        class="text-sm font-medium text-primary-600 hover:underline dark:text-primary-500"
                        >¿Olvidaste tu contraseña?</a
                      >
                    </div>
                    <button
                      type="submit"
                      name="login"
                      value="z"
                      class="w-full text-white bg-primary-600 hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
                    >
                      Iniciar Sesion
                    </button>
                    <p
                      class="text-sm font-light text-gray-500 dark:text-gray-400"
                    >
                      ¿No tienes una cuenta?
                      <a
                        href="#"
                        class="font-medium text-primary-600 hover:underline dark:text-primary-500"
                        >Registrarte</a
                      >
                    </p>
                  </form>
                </div>
              </div>
            </div>
          </div>
          <!--Imagen -->
          <div
            class="w-2/5 bg-[#ad2831] text-white rounded-tr-2xl rounded-br-2xl py-36 px-12"
          >
            <h1 class="text-3xl font-bold mb-2">Welcome to Gensokyo</h1>
            <div class="border-2 w-10 border-white inline-block mb-2"></div>
            <p class="mb-2">
              Gensokyo es un lugar donde la magia y la realidad se mezclan para
              crear un mundo unico.
            </p>
          </div>
        </div>
        <div class="text-start m-4">
          <h2 class="text-3xl font-bold text-gray-500 mb-2"> Mensaje: <%= request.getAttribute("mensaje") != null ? request.getAttribute("mensaje") : "" %></h2>
          <h2 class="text-3xl font-bold text-gray-500 mb-2"> Intentos Permitidos: <%= request.getAttribute("intentos") != null ? request.getAttribute("intentos") : "" %></h2>
          </div>
      </main>
    </div>
      
  </body>
</html>
