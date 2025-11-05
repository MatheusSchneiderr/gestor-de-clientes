package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {
	String DB;
	protected Connection con;
    protected PreparedStatement pstm;
    protected ResultSet rs;
    
	public Conexao(String DB) {
		this.DB = DB;
	}
	
	protected void AbrirConexao() {
		try {
			con = AcessoDB.conectar(this.DB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void FecharConexao() {
		try {
			AcessoDB.desconectar(con,pstm,rs);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
