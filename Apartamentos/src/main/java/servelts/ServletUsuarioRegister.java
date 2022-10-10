
package servelts;

import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletUsuarioRegister", urlPatterns = {"/ServletUsuarioRegister"})
public class ServletUsuarioRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletUsuarioRegister() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioController usuarios = new UsuarioController();
        String username = request.getParameter("username");
        String contrasena = request.getParameter("contrasena");
        String numero_de_apartamento = request.getParameter("numero_de_apartamento");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String genero = request.getParameter("genero");
        String email = request.getParameter("email");

        String result = usuarios.register(username, contrasena, numero_de_apartamento,
                nombre, apellidos, genero, email);

        response.setContentType("text-html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
