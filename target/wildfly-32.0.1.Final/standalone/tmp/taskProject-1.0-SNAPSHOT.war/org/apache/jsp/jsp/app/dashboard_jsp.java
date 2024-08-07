/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: WildFly Full 32.0.1.Final (WildFly Core 24.0.1.Final) - 2.3.13.Final
 * Generated at: 2024-07-30 20:33:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.app;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      response.setContentType("text/html");
      response.addHeader("X-Powered-By", "JSP/3.1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("    <div class=\"container-scroller\">\n");
      out.write("      <!-- partial:../../partials/_navbar.html -->\n");
      out.write("            <!-- partial -->\n");
      out.write("      <div class=\"container-fluid page-body-wrapper\">\n");
      out.write("        <!-- partial:../../partials/_sidebar.html -->\n");
      out.write("               <!-- partial -->\n");
      out.write("        <div class=\"main-panel\">\n");
      out.write("          <div class=\"content-wrapper\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-md-12 grid-margin\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"p-4 border-bottom bg-light\">\n");
      out.write("                    <h4 class=\"card-title mb-0\">Mixed Chart</h4>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                    <canvas id=\"mixed-chart\" height=\"100\"></canvas>\n");
      out.write("                    <div class=\"mr-5\" id=\"mixed-chart-legend\"></div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-lg-6 grid-margin stretch-card\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"p-4 border-bottom bg-light\">\n");
      out.write("                    <h4 class=\"card-title mb-0\">Line Chart</h4>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                    <div class=\"d-flex justify-content-between align-items-center pb-4\">\n");
      out.write("                      <h4 class=\"card-title mb-0\">Sales Performance</h4>\n");
      out.write("                      <div id=\"line-traffic-legend\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                      <div class=\"col-md-4\">\n");
      out.write("                        <h2 class=\"mb-0 font-weight-medium\">$5,341</h2>\n");
      out.write("                        <p class=\"mb-5 text-muted\">Sales</p>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-md-3\">\n");
      out.write("                        <h2 class=\"mb-0 font-weight-medium\">$1,334</h2>\n");
      out.write("                        <p class=\"mb-5 text-muted\">Profits</p>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <canvas id=\"lineChart\" style=\"height:250px\"></canvas>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-lg-6 grid-margin stretch-card\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"p-4 border-bottom bg-light\">\n");
      out.write("                    <h4 class=\"card-title mb-0\">Area Chart</h4>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                    <div class=\"d-flex justify-content-between align-items-center pb-4\">\n");
      out.write("                      <h4 class=\"card-title mb-0\">Site Traffic</h4>\n");
      out.write("                      <div id=\"area-traffic-legend\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                      <div class=\"col-md-4\">\n");
      out.write("                        <h2 class=\"mb-0 font-weight-medium\">3,245</h2>\n");
      out.write("                        <p class=\"mb-5 text-muted\">Users</p>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-md-4\">\n");
      out.write("                        <h2 class=\"mb-0 font-weight-medium\">12.54%</h2>\n");
      out.write("                        <p class=\"mb-5 text-muted\">Bounce Rate</p>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <canvas id=\"areaChart\" style=\"height:250px\"></canvas>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-lg-6 grid-margin stretch-card\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"p-4 border-bottom bg-light\">\n");
      out.write("                    <h4 class=\"card-title mb-0\">Bar Chart</h4>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                    <div class=\"d-flex justify-content-between align-items-center pb-4\">\n");
      out.write("                      <h4 class=\"card-title mb-0\">Sales Revenue</h4>\n");
      out.write("                      <div id=\"bar-traffic-legend\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <p class=\"mb-4\">17% increase in sales than last week</p>\n");
      out.write("                    <canvas id=\"barChart\" style=\"height:250px\"></canvas>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-lg-6 grid-margin stretch-card\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"p-4 border-bottom bg-light\">\n");
      out.write("                    <h4 class=\"card-title mb-0\">Stacked Bar chart</h4>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                    <div class=\"d-flex justify-content-between align-items-center pb-4\">\n");
      out.write("                      <h4 class=\"card-title mb-0\">Users by Device</h4>\n");
      out.write("                      <div id=\"stacked-bar-traffic-legend\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <p class=\"mb-4\">25% more traffic than previous week</p>\n");
      out.write("                    <canvas id=\"stackedbarChart\" style=\"height:250px\"></canvas>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-lg-6 grid-margin stretch-card\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"p-4 pr-5 border-bottom bg-light d-flex justify-content-between\">\n");
      out.write("                    <h4 class=\"card-title mb-0\">Radar chart</h4>\n");
      out.write("                    <div id=\"radar-chart-legend\"></div>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                    <canvas class=\"mt-4\" id=\"radarChart\" style=\"height:250px\"></canvas>\n");
      out.write("                    <div class=\"d-flex mt-5 py-3 border-top\">\n");
      out.write("                      <p class=\"mb-0 font-weight-semibold\"><span class=\"dot-indicator bg-success\"></span> Student A </p>\n");
      out.write("                      <p class=\"mb-0 ml-auto text-primary\">56%</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"d-flex pt-3 border-top\">\n");
      out.write("                      <p class=\"mb-0 font-weight-semibold\"><span class=\"dot-indicator bg-success\"></span> Student B</p>\n");
      out.write("                      <p class=\"mb-0 ml-auto text-primary\">34%</p>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-lg-6 grid-margin stretch-card\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"p-4 pr-5 border-bottom bg-light d-flex justify-content-between\">\n");
      out.write("                    <h4 class=\"card-title mb-0\">Doughnut chart</h4>\n");
      out.write("                    <div id=\"doughnut-chart-legend\" class=\"mr-4\"></div>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"card-body d-flex flex-column\">\n");
      out.write("                    <canvas class=\"my-auto\" id=\"doughnutChart\" height=\"200\"></canvas>\n");
      out.write("                    <div class=\"d-flex mt-5 py-3 border-top\">\n");
      out.write("                      <p class=\"mb-0 font-weight-semibold\"><span class=\"dot-indicator bg-success\"></span> Product Sales </p>\n");
      out.write("                      <p class=\"mb-0 ml-auto text-primary\">$2,464</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"d-flex pt-3 border-top\">\n");
      out.write("                      <p class=\"mb-0 font-weight-semibold\"><span class=\"dot-indicator bg-success\"></span>Profit Attained </p>\n");
      out.write("                      <p class=\"mb-0 ml-auto text-primary\">$1,325</p>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-lg-6 grid-margin stretch-card\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"p-4 pr-5 border-bottom bg-light d-flex justify-content-between\">\n");
      out.write("                    <h4 class=\"card-title mb-0\">Pie chart</h4>\n");
      out.write("                    <id id=\"pie-chart-legend\" class=\"mr-4\"></id>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"card-body d-flex\">\n");
      out.write("                    <canvas class=\"my-auto\" id=\"pieChart\" height=\"130\"></canvas>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"col-lg-6 grid-margin stretch-card\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"p-4 pr-5 border-bottom bg-light d-flex justify-content-between\">\n");
      out.write("                    <h4 class=\"card-title mb-0\">Scatter chart</h4>\n");
      out.write("                    <id id=\"scatter-chart-legend\"></id>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                    <canvas id=\"scatterChart\" style=\"height:250px\"></canvas>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <!-- content-wrapper ends -->\n");
      out.write("          <!-- partial:../../partials/_footer.html -->\n");
      out.write("          <footer class=\"footer\">\n");
      out.write("            <div class=\"container-fluid clearfix\">\n");
      out.write("              <span class=\"text-muted d-block text-center text-sm-left d-sm-inline-block\">Copyright Â© bootstrapdash.com 2020</span>\n");
      out.write("              <span class=\"float-none float-sm-right d-block mt-1 mt-sm-0 text-center\"> Free <a href=\"https://www.bootstrapdash.com/bootstrap-admin-template/\" target=\"_blank\">Bootstrap admin templates</a> from Bootstrapdash.com</span>\n");
      out.write("            </div>\n");
      out.write("          </footer>\n");
      out.write("          <!-- partial -->\n");
      out.write("        </div>\n");
      out.write("        <!-- main-panel ends -->\n");
      out.write("      </div>\n");
      out.write("      <!-- page-body-wrapper ends -->\n");
      out.write("    </div>\n");
      out.write("    <!-- container-scroller -->\n");
      out.write("    <!-- plugins:js -->\n");
      out.write("    <script src=\"../../assets/vendors/js/vendor.bundle.base.js\"></script>\n");
      out.write("    <script src=\"../../assets/vendors/js/vendor.bundle.addons.js\"></script>\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Plugin js for this page-->\n");
      out.write("    <!-- End plugin js for this page-->\n");
      out.write("    <!-- inject:js -->\n");
      out.write("    <script src=\"../../assets/js/shared/off-canvas.js\"></script>\n");
      out.write("    <script src=\"../../assets/js/shared/misc.js\"></script>\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Custom js for this page-->\n");
      out.write("    <script src=\"../../assets/js/shared/chart.js\"></script>\n");
      out.write("    <!-- End custom js for this page-->\n");
      out.write("    <script src=\"../../assets/js/shared/jquery.cookie.js\" type=\"text/javascript\"></script>\n");
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
