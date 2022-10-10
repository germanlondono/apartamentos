
package servelts;

import controller.ApartamentosController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet( urlPatterns = {"/ServletIngresoListar"})
public class ServletIngresosListar extends HttpServlet {
    
    private static final long serialVersioUID = 1L;
 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartamentosController Ingreso = new ApartamentosController();
        
        boolean ordenar = Boolean.parseBoolean(request.getParameter("ordenar"));
        String orden = request.getParameter("orden");
        
        String ingresoStr = Ingreso.listar(ordenar, orden);
        response.setContentType("text-html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println(ingresoStr);
        out.flush();
        out.close();
       
    }

 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          doGet(request, response);
        
    }

    
    
}
