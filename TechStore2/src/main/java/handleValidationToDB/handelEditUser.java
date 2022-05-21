package handleValidationToDB;

import database.UserManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "handelEditUser", value = "/handelEditUser")
public class handelEditUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int creditlimit = Integer.parseInt(request.getParameter("creditlimit"));
        UserManager.editUser(creditlimit, id);
        response.sendRedirect("admin/dispalyUsers.jsp");
    }
}
