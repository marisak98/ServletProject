/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: WildFly Full 32.0.1.Final (WildFly Core 24.0.1.Final) - 2.3.13.Final
 * Generated at: 2024-07-30 20:33:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.sidebar;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class layout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/jsp/sidebar/components/logo.jsp", Long.valueOf(1722371582234L));
    _jspx_dependants.put("/jsp/sidebar/sidebar.jsp", Long.valueOf(1722371582235L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private jakarta.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
        throws java.io.IOException, jakarta.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(jakarta.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JBWEB004248: JSPs only permit GET POST or HEAD");
return;
}

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      response.addHeader("X-Powered-By", "JSP/3.1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("    <title>My APP</title>\n");
      out.write("    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/styles.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/vendor/iconfonts/mdi/css/materialdesignicons.min.css\">\n");
      out.write("\n");
      out.write("    <!--css plugins-->\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/shared/style.css\">\n");
      out.write("    <!--Layout styles-->\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/demo_1/style.css\">\n");
      out.write("    <!--End layout styles-->\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/img/favicon.ico\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("        <div class=\"top\">\n");
      out.write("            <div class=\"logo\">\n");
      out.write("                ");
      out.write("<i class=\"bx bxs-component\"></i>\n");
      out.write("<span>TouhouProject</span>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <i class='bx bx-menu' id=\"btn\"></i>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"user\">\n");
      out.write("            <img src=\"https://i.pinimg.com/564x/b6/62/d6/b662d679db4da7f3f87018c6cc30674a.jpg\" alt=\"user\" class=\"user-img\">\n");
      out.write("            <div>\n");
      out.write("                <p class=\"bold\">Client.B</p>\n");
      out.write("                <p>Admin</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("<ul>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/main/dashboard\">\n");
      out.write("      <i class='bx bx-grid-alt'></i>\n");
      out.write("      <span class=\"nav-item\">Dashboard</span>\n");
      out.write("    </a>\n");
      out.write("    <span class=\"tooltip\">Dashboard</span>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/main/project\">\n");
      out.write("      <i class='bx bx-task'></i>\n");
      out.write("      <span class=\"nav-item\">Proyectos</span>\n");
      out.write("    </a>\n");
      out.write("    <span class=\"tooltip\">Proyectos</span>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/main/profile\">\n");
      out.write("      <i class='bx bxs-user-detail'></i>\n");
      out.write("      <span class=\"nav-item\">Perfil</span>\n");
      out.write("    </a>\n");
      out.write("    <span class=\"tooltip\">Perfil</span>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/main/employee\">\n");
      out.write("      <i class='bx bx-user'></i>\n");
      out.write("      <span class=\"nav-item\">Empleados</span>\n");
      out.write("    </a>\n");
      out.write("    <span class=\"tooltip\">Empleados</span>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/main/report\">\n");
      out.write("      <i class='bx bxs-report'></i>\n");
      out.write("      <span class=\"nav-item\">Reportes</span>\n");
      out.write("    </a>\n");
      out.write("    <span class=\"tooltip\">Reportes</span>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/main/settings\">\n");
      out.write("      <i class='bx bx-cog'></i>\n");
      out.write("      <span class=\"nav-item\">Configuraciones</span>\n");
      out.write("    </a>\n");
      out.write("    <span class=\"tooltip\">Configuraciones</span>\n");
      out.write("  </li>\n");
      out.write("  <li>\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/main/logout\">\n");
      out.write("      <i class='bx bx-log-out'></i>\n");
      out.write("      <span class=\"nav-item\">Cerrar SesiÃ³n</span>\n");
      out.write("    </a>\n");
      out.write("    <span class=\"tooltip\">Cerrar SesiÃ³n</span>\n");
      out.write("  </li>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"main-content\">\n");
      out.write("        <div class=\"container-scroller\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, (java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null), out, false);
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        const btn = document.querySelector(\"#btn\");\n");
      out.write("        const sidebar = document.querySelector(\".sidebar\");\n");
      out.write("\n");
      out.write("        btn.onclick = function() {\n");
      out.write("            sidebar.classList.toggle(\"active\");\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new jakarta.servlet.ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
