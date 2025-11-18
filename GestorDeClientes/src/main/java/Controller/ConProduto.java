package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;

import DAL.ProdutoDAO;
import Model.Produto;

/**
 * Servlet implementation class ConProduto
 */
@WebServlet("/ConProduto")
public class ConProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProdutoDAO DAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConProduto() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Produto produto = DAO.Buscar(codigo);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(produto);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
	}
}
