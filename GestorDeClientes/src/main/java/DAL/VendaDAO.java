package DAL;

import java.sql.Date;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.ItemVenda;
import Model.Venda;


public class VendaDAO extends Conexao{
	public VendaDAO(String DB) {
		super(DB);
	}
  
    private final String SELECT = "select * from VENDAS";
    private final String SELECT_ITENS = "select * from ITEM_VENDA WHERE ID_VENDA=?";
    private final String INSERT=" INSERT INTO VENDAS (ID_CLIENTE, DT_VENDA) VALUES (?,?) ";
    private final String INSERT_ITENS=" INSERT INTO ITEM_VENDA (ID_VENDA, ID_PRODUTO, QUANTIDADE, VALOR_UN) VALUES (?,?,?,?) ";
    private final String UPDATE=" UPDATE VENDAS SET ID_CLIENTE=? WHERE ID_VENDA=?";
    private final String DELETE=" DELETE FROM VENDAS WHERE ID_VENDA=? ";
    private final String DELETE_ITENS="DELETE FROM ITEM_VENDA WHERE ID_VENDA=? ";
    
    public void Inserir(Venda venda) {
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
    		pstm.setInt(1, venda.getIdCliente());
    		pstm.setDate(2, Date.valueOf(LocalDate.now()));
    		pstm.executeUpdate();
    		
    		rs = pstm.getGeneratedKeys();
    		if (rs.next()) {
    			venda.setIdVenda(rs.getInt(1));
    		}
		}
    	catch (Exception ex){
    		System.out.println("Erro ao inserir venda: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
    		InserirItens(venda);
		}
    }
    
    public void InserirItens(Venda venda) {
    	venda.getProdutos().forEach(p -> InserirItemVenda(venda.getIdVenda(), p));
    }
    
    public void InserirItemVenda(int idVenda, ItemVenda i) {
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(INSERT_ITENS);
    		pstm.setInt(1, idVenda);
    		pstm.setInt(2, i.idProduto);
    		pstm.setInt(3, i.quantidade);
    		pstm.setBigDecimal(4, i.valorUn);
    		
    		pstm.executeUpdate();
		}
    	catch (Exception ex){
    		System.out.println("Erro ao inserir item da venda: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
		}
    }
    public Venda Buscar(int codigo) {
    	Venda venda = null;
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(SELECT + " WHERE ID_VENDA=?");
    		pstm.setInt(1, codigo);
    		rs = pstm.executeQuery();
    		
    		if(rs.next()) {
    			Date dt = rs.getDate("DT_VENDA");
    			venda = new Venda(
    					rs.getInt("ID_VENDA"),
    					rs.getInt("ID_CLIENTE"),
    					dt.toLocalDate());
    		}   
			
		} catch (Exception ex) {
    		System.out.println("Erro buscar venda: " + ex.getMessage());
    		ex.getStackTrace();
		}
    	finally {
    		FecharConexao();
    		venda.setProdutos(ListarItensVenda(venda.getIdVenda()));
		}
    	return venda;
    }
    public List<Venda> Listar(){
		List<Venda> Vendas = new ArrayList<Venda>();
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(SELECT);
    		rs = pstm.executeQuery();
    		
    		while(rs.next()) {
    			Date dt = rs.getDate("DT_VENDA");
    			Venda v = new Venda(
    					rs.getInt("ID_VENDA"),
    					rs.getInt("ID_CLIENTE"),
    					dt.toLocalDate());
    			Vendas.add(v);
    		}   		
		}
    	catch (Exception ex){
    		System.out.println("Erro ao inserir venda: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
    		Vendas.forEach(t -> t.setProdutos(ListarItensVenda(t.getIdVenda())));
		}
    	return Vendas;
    }
    public void Atualizar(Venda venda) {
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(UPDATE);
    		pstm.setInt(1, venda.getIdCliente());
    		pstm.setInt(2, venda.getIdVenda());
    		pstm.executeUpdate();
		}
    	catch (Exception ex){
    		System.out.println("Erro ao inserir venda: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
    		ExcluirItemVenda(venda.getIdVenda());
    		InserirItens(venda);	
		}
    }
    public void Deletar(int Codigo) {
    	ExcluirItemVenda(Codigo);
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(DELETE);
    		pstm.setInt(1, Codigo);
    		pstm.executeUpdate();
		}
    	catch (Exception ex){
    		System.out.println("Erro ao excluir venda: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
		}
    }
    
    public void ExcluirItemVenda(int codigo) {
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(DELETE_ITENS);
    		pstm.setInt(1, codigo);
    		pstm.executeUpdate();
		}
    	catch (Exception ex){
    		System.out.println("Erro ao excluir itens da venda: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
		}
    }
    
    public List<ItemVenda> ListarItensVenda(int codigo){
    	List<ItemVenda> Produtos = new ArrayList<ItemVenda>();
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(SELECT_ITENS);
    		pstm.setInt(1, codigo);
    		rs = pstm.executeQuery();
    		
    		while(rs.next()) {
    			ItemVenda p = new ItemVenda(
    					rs.getInt("ID_VENDA"), 
    					rs.getInt("ID_PRODUTO"),
    					rs.getInt("QUANTIDADE"),
    					rs.getBigDecimal("VALOR_UN"));
    			Produtos.add(p);
    		}   		
		}
    	catch (Exception ex){
    		System.out.println("Erro ao inserir produto: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
		}
    	return Produtos;
    }


	
}
