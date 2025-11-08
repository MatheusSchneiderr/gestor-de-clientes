package DAL;

import java.util.ArrayList;
import java.util.List;

import Model.Produto;

public class ProdutoDAO extends Conexao{
	
	public ProdutoDAO(String DB) {
		super(DB);
		// TODO Auto-generated constructor stub
	}
	private final String SELECT = "select * from PRODUTOS";
    private final String INSERT=" INSERT INTO PRODUTOS (NOME, PRECO) VALUES (?,?) ";
    private final String UPDATE=" UPDATE PRODUTOS SET NOME=?, PRECO=? WHERE CODIGO=?";
    private final String DELETE=" DELETE FROM PRODUTOS WHERE CODIGO=? ";
    
    public void Inserir(Produto produto) {
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(INSERT);
    		pstm.setString(1, produto.getNome());
    		pstm.setDouble(2, produto.getPreco());
    		pstm.executeUpdate();		
		}
    	catch (Exception ex){
    		System.out.println("Erro ao inserir produto: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
		}
    }
    public Produto Buscar(int codigo) {
    	Produto produto = null;
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(SELECT + " WHERE CODIGO=?");
    		pstm.setInt(1, codigo);
    		rs = pstm.executeQuery();
    		
    		if(rs.next()) {
    			produto = new Produto(
    					rs.getInt("CODIGO"), 
    					rs.getString("NOME"),
    					rs.getDouble("PRECO"));
    		}   
			
		} catch (Exception ex) {
    		System.out.println("Erro buscar produto: " + ex.getMessage());
    		ex.getStackTrace();
		}
    	finally {
    		FecharConexao();
		}
    	return produto;
    }
    public List<Produto> Listar(){
		List<Produto> Produtos = new ArrayList<Produto>();
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(SELECT);
    		rs = pstm.executeQuery();
    		
    		while(rs.next()) {
    			Produto p = new Produto(
    					rs.getInt("CODIGO"), 
    					rs.getString("NOME"),
    					rs.getDouble("PRECO"));
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
    public void Atualizar(Produto produto) {
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(UPDATE);
    		pstm.setString(1, produto.getNome());
    		pstm.setDouble(2, produto.getPreco());
    		pstm.setInt(3, produto.getCodigo());
    		pstm.executeUpdate();
		}
    	catch (Exception ex){
    		System.out.println("Erro ao inserir produto: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
		}
    }
    public void Deletar(int Codigo) {
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(DELETE);
    		pstm.setInt(1, Codigo);
    		pstm.executeUpdate();
		}
    	catch (Exception ex){
    		System.out.println("Erro ao inserir produto: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
		}
    }

}
