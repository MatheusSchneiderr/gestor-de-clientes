package Model;

import java.math.BigDecimal;

public class ItemVenda {
	public int idVenda;
	public int idProduto;
	public int quantidade;
	public BigDecimal valorUn;
	
	public ItemVenda(int idVenda, int idProduto, int quantidade) {
		super();
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}
	public ItemVenda(int idProduto, int quantidade, BigDecimal valorUn) {
		super();
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}
	public ItemVenda(int idVenda, int idProduto, int quantidade, BigDecimal valorUn) {
		super();
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.valorUn = valorUn;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValorUn() {
		return valorUn;
	}
	public void setValorUn(BigDecimal valor_un) {
		this.valorUn = valor_un;
	}
	
	
}
