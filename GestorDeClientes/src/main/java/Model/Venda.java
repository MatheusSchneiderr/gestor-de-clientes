package Model;

import java.time.LocalDate;
import java.util.List;

public class Venda {
	private int idVenda;
	private int idCliente;
	private List<ItemVenda> produtos;
	private LocalDate dataVenda;
	
	public Venda(int idCliente, List<ItemVenda> produtos) {
		super();
		this.idCliente = idCliente;
		this.produtos = produtos;
	}
	public Venda(int idVenda, int idCliente, List<ItemVenda> produtos) {
		super();
		this.idVenda = idVenda;
		this.idCliente = idCliente;
		this.produtos = produtos;
	}	
	public Venda(int idVenda, int idCliente, LocalDate dataVenda) {
		super();
		this.idVenda = idVenda;
		this.idCliente = idCliente;
		this.dataVenda = dataVenda;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public List<ItemVenda> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<ItemVenda> produtos) {
		this.produtos = produtos;
	}
	public LocalDate getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public String getNomeCliente(List<Cliente> clientes) {
	    return clientes.stream()
	        .filter(c -> c.getCodigo() == this.getIdCliente())
	        .map(Cliente::getNome)
	        .findAny()
	        .orElse("Desconhecido");
	}
	
	public double getValorTotal() {
		double tot = 0.00;
		for(ItemVenda i : this.getProdutos()) {
			String val = i.getValorUn().toString();
			tot += Double.valueOf(val) * i.getQuantidade();
		}
		return tot;
	}
}
