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
        if ("list".equals(action)) {
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
	       String nome = request.getParameter("nome");
	       String email = request.getParameter("email");
	       String cpf = request.getParameter("cpf");
	       String rg = request.getParameter("rg");
	       String telefone = request.getParameter("telefone");
	       
	       Cliente Cliente = new Cliente(nome, email, cpf, rg, telefone);
	       
	       DAO.Inserir(Cliente); 
	       
	       response.sendRedirect("ManCliente?action=list");	      
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DAO.Deletar(id);
	    response.sendRedirect("ManCliente?action=list");	 
	}
	
	protected void doPut (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		
	    String email = request.getParameter("email");
	    String cpf = request.getParameter("cpf");
	    String rg = request.getParameter("rg");
	    String telefone = request.getParameter("telefone");
	    
	    Cliente ClienteAtualizado = new Cliente(id, nome, email, cpf, rg, telefone);
		
	    DAO.Atualizar(ClienteAtualizado);//Era pra ser antes de atualizar a lista pra evitar ambiguidade se der bug, mas agr n vou mudar isso...	
		

	    response.sendRedirect("ManCliente?action=list");	 

	}

}
