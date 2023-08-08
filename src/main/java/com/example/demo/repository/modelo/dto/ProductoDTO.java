package com.example.demo.repository.modelo.dto;

public class ProductoDTO {
	private String codBarras;
	private Integer stock;
	
	public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}
	public ProductoDTO(String codBarras, Integer stock) {
		super();
		this.codBarras = codBarras;
		this.stock = stock;
	}
	
	//SETS Y GETS
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
