package DAL;

import java.util.ArrayList;
import java.util.List;

import Model.Cliente;


public class ClienteDAO extends Conexao{
	public ClienteDAO(String DB) {
		super(DB);
	}
  
    private final String SELECT = "select * from CLIENTES";
    private final String INSERT=" INSERT INTO CLIENTES (NOME, CPF, RG, TELEFONE, EMAIL) VALUES (?,?,?,?,?) ";
    private final String UPDATE=" UPDATE CLIENTES SET NOME=?, CPF=?, RG=?, TELEFONE=?, EMAIL=? WHERE CODIGO=?";
    private final String DELETE=" DELETE FROM CLIENTES WHERE CODIGO=? ";
    
    public void Inserir(Cliente cliente) {
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(INSERT);
    		pstm.setString(1, cliente.getNome());
    		pstm.setString(2, cliente.getCpf());
    		pstm.setString(3, cliente.getRg());
    		pstm.setString(4, cliente.getTelefone());
    		pstm.setString(5, cliente.getEmail());
    		pstm.executeUpdate();		
		}
    	catch (Exception ex){
    		System.out.println("Erro ao inserir aluno: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
		}
    }
    public List<Cliente> Listar(){
		List<Cliente> Clientes = new ArrayList<Cliente>();
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(SELECT);
    		rs = pstm.executeQuery();
    		
    		while(rs.next()) {
    			Cliente c = new Cliente(
    					rs.getInt("CODIGO"), 
    					rs.getString("NOME"),
    					rs.getString("CPF"),
    					rs.getString("RG"),
    					rs.getString("TELEFONE"),
    					rs.getString("EMAIL"));
    			Clientes.add(c);
    		}   		
		}
    	catch (Exception ex){
    		System.out.println("Erro ao inserir aluno: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
		}
    	return Clientes;
    }
    public void Atualizar(Cliente cliente) {
    	try {
    		AbrirConexao();
    		pstm = con.prepareStatement(UPDATE);
    		pstm.setString(1, cliente.getNome());
    		pstm.setString(2, cliente.getCpf());
    		pstm.setString(3, cliente.getRg());
    		pstm.setString(4, cliente.getTelefone());
    		pstm.setString(5, cliente.getEmail());
    		pstm.setInt(6, cliente.getCodigo());
    		pstm.executeUpdate();
		}
    	catch (Exception ex){
    		System.out.println("Erro ao inserir aluno: " + ex.getMessage());
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
    		System.out.println("Erro ao inserir aluno: " + ex.getMessage());
    		ex.getStackTrace();
    	}
    	finally {
    		FecharConexao();
		}
    }


	
}
