package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DAL.ClienteDAO;
import DAL.ProdutoDAO;
import DAL.VendaDAO;
import Model.ItemVenda;
import Model.Venda;

/**
 * Servlet implementation class ManVenda
 */
@WebServlet("/ManVenda")
public class ManVenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private VendaDAO DAO;
	private ProdutoDAO PDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManVenda() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
   	   DAO = new VendaDAO("ClientesJDBC");
   	   PDAO = new ProdutoDAO("ClientesJDBC");
     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if("view".equals(action)) {
			int Codigo = Integer.parseInt(request.getParameter("cod"));
			request.setAttribute("venda", DAO.Buscar(Codigo));
			request.setAttribute("produtos", PDAO.Listar());
			request.setAttribute("pageSafe", "venda/form");
		}
		else if ("list".equals(action)) {
            request.setAttribute("vendas", DAO.Listar());
            request.setAttribute("clientes", new ClienteDAO("ClientesJDBC").Listar());
            request.setAttribute("pageSafe", "venda/list");
        } else {
            request.setAttribute("pageSafe", "venda/form");
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
			Gson gson = new Gson();
		    int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		    String json = request.getParameter("itens");		    
		    List<ItemVenda> itens = gson.fromJson(json, new TypeToken<List<ItemVenda>>() {}.getType());
		    	    
		    for(ItemVenda i : itens) {
		    	System.out.println(i.getQuantidade());
		    }
		    
		    Venda venda = new Venda(idCliente, itens);
		    DAO.Inserir(venda);
		}       
		//CRIAR TABELAS E TESTAR!
	    response.sendRedirect("ManVenda?action=list");	      
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		DAO.Deletar(codigo);
	}
	
	protected void doPut (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		Gson gson = new Gson();
	    int idCliente = Integer.parseInt(request.getParameter("idCliente"));
	    String json = request.getParameter("itens");
	    List<ItemVenda> itens = gson.fromJson(json, new TypeToken<List<ItemVenda>>() {}.getType());
	    
	    for(ItemVenda i : itens) {
	    	System.out.println(i.getQuantidade());
	    }
	    
	    Venda vendaAtualizada = new Venda(codigo ,idCliente, itens);
	    
	    System.out.println(vendaAtualizada.getProdutos());
	    System.out.println("ID VENDA = " + vendaAtualizada.getIdVenda());
	    
		
	    DAO.Atualizar(vendaAtualizada);	 
	}

}
