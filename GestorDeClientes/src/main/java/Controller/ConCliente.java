package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;

import DAL.ClienteDAO;
import Model.Cliente;
import Model.Produto;

/**
 * Servlet implementation class ConCliente
 */
@WebServlet("/ConCliente")
public class ConCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO DAO;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
   	   DAO = new ClienteDAO("ClientesJDBC");
     }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Cliente cliente = DAO.Buscar(codigo);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(cliente);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
