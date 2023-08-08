package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	@GeneratedValue(generator = "seq_producto",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_producto",sequenceName ="seq_producto",allocationSize = 1 )
	@Id
	@Column(name = "prod_id")
	private Integer id;
	@Column(name = "prod_codigo_barras")
	private String codBarras;
	@Column(name = "prod_nombre")
	private String nombre;
	@Column(name = "prod_categoria")
	private String categoria;
	@Column(name = "prod_stock")
	private Integer strock;
	@Column(name = "prod_precio")
	private BigDecimal precio;
	
	@ManyToMany(mappedBy = "productos",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<DetalleFactura> idDetalleFacturas;

	//SETS Y GETS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStrock() {
		return strock;
	}

	public void setStrock(Integer strock) {
		this.strock = strock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getIdDetalleFacturas() {
		return idDetalleFacturas;
	}

	public void setIdDetalleFacturas(List<DetalleFactura> idDetalleFacturas) {
		this.idDetalleFacturas = idDetalleFacturas;
	}


	
	
}
