package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAL.ProdutoDAO;
import Model.Produto;

/**
 * Servlet implementation class ManProduto
 */
@WebServlet("/ManProduto")
public class ManProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProdutoDAO DAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManProduto() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
  	   DAO = new ProdutoDAO("ClientesJDBC");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if("view".equals(action)) {
			int Codigo = Integer.parseInt(request.getParameter("cod"));
			request.setAttribute("produto", DAO.Buscar(Codigo));
			request.setAttribute("pageSafe", "produto/form");
		}
		else if ("list".equals(action)) {
            request.setAttribute("produtos", DAO.Listar());
            request.setAttribute("pageSafe", "produto/list");
        } else {
            request.setAttribute("pageSafe", "produto/form");
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
			String action = request.getParameter("action");
			if("delete".equals(action)) {
				doDelete(request, response);
			}
			else {				
				doPut(request, response);
			}
		}
		else {
		    String nome = request.getParameter("nome");
		    Double preco = Double.parseDouble(request.getParameter("preco"));
		    
		    Produto Produto = new Produto(nome, preco);
		     
		    DAO.Inserir(Produto); 
		}       
	    response.sendRedirect("ManProduto?action=list");	      
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		DAO.Deletar(codigo);
	}
	
	protected void doPut (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");	
	    Double preco = Double.parseDouble(request.getParameter("preco"));
	    
	    
	    Produto ProdutoAtualizado = new Produto(codigo, nome, preco);
		
	    DAO.Atualizar(ProdutoAtualizado);	 
	}

}
