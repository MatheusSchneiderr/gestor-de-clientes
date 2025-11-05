package Model;

public class Cliente {
	private int codigo;

	 private String nome ;

	 private String cpf ;

	 private String rg ;

	 private String telefone ;

	 private String email ;


	 public Cliente(String nome, String cpf, String rg, String telefone, String email) {
		 this.nome = nome;
		 this.cpf = cpf;
		 this.rg = rg;
		 this.telefone = telefone;
		 this.email = email;
	 }
	 public Cliente(int codigo, String nome, String cpf, String rg, String telefone, String email) {
		 this.codigo = codigo;
		 this.nome = nome;
		 this.cpf = cpf;
		 this.rg = rg;
		 this.telefone = telefone;
		 this.email = email;
	 }


	 public int getCodigo() {
		 return codigo;
	 }


	 public void setCodigo(int codigo) {
		 this.codigo = codigo;
	 }


	 public String getNome() {
		 return nome;
	 }


	 public void setNome(String nome) {
		 this.nome = nome;
	 }


	 public String getCpf() {
		 return cpf;
	 }


	 public void setCpf(String cpf) {
		 this.cpf = cpf;
	 }


	 public String getRg() {
		 return rg;
	 }


	 public void setRg(String rg) {
		 this.rg = rg;
	 }


	 public String getTelefone() {
		 return telefone;
	 }


	 public void setTelefone(String telefone) {
		 this.telefone = telefone;
	 }


	 public String getEmail() {
		 return email;
	 }


	 public void setEmail(String email) {
		 this.email = email;
	 }

}
