package Controller.cliente;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAL.ClienteDAO;
import Model.Cliente;

/**
 * Servlet implementation class ManCliente
 */
@WebServlet("/ManCliente")
public class ManCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO DAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManCliente() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
  	   DAO = new ClienteDAO("ClientesJDBC");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if("view".equals(action)) {
			int Codigo = Integer.parseInt(request.getParameter("cod"));
			request.setAttribute("cliente", DAO.Buscar(Codigo));
			request.setAttribute("pageSafe", "cliente/form");
		}
		else if ("list".equals(action)) {
            request.setAttribute("clientes", DAO.Listar());
            request.setAttribute("pageSafe", "cliente/list");
        } else {
            request.setAttribute("pageSafe", "cliente/form");
        }
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
	       
	       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("codigo") != null && !request.getParameter("codigo").isEmpty()) {
			doPut(request, response);
		}
		else {
		    String nome = request.getParameter("nome");
		    String email = request.getParameter("email");
		    String cpf = request.getParameter("cpf");
		    String rg = request.getParameter("rg");
		    String telefone = request.getParameter("telefone");
		    
		    Cliente Cliente = new Cliente(nome, cpf, rg, telefone,email);
		     
		    DAO.Inserir(Cliente); 
		}       
	    response.sendRedirect("ManCliente?action=list");	      
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		DAO.Deletar(codigo);
	    response.sendRedirect("ManCliente?action=list");
	}
	
	protected void doPut (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");	
	    String email = request.getParameter("email");
	    String cpf = request.getParameter("cpf");
	    String rg = request.getParameter("rg");
	    String telefone = request.getParameter("telefone");
	    
	    Cliente ClienteAtualizado = new Cliente(codigo, nome, cpf, rg, telefone, email);
		
	    DAO.Atualizar(ClienteAtualizado);	 
	}
}
