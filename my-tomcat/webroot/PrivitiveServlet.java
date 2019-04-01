import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PrivitiveServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("from service...");
        PrintWriter out = servletResponse.getWriter();
        out.println("Hello, Roses are red.");
        out.print("Violets are blue."); //并不会在页面显示 (使用println会显示) why?
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destory...");
    }
}
