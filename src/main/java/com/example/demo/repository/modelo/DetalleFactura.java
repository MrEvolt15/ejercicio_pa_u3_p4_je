package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {
	
	@GeneratedValue(generator = "seq_detalle_factura",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_detalle_factura",sequenceName ="seq_detalle_factura",allocationSize = 1 )
	@Id
	@Column(name = "dtfc_id")
	private Integer id;
	@Column(name = "dtfc_precio_unitario")
	private BigDecimal precioUnitario;
	@Column(name = "dtfc_subtotal")
	private BigDecimal subtotal;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dtfc_fact_id")
	private Factura idFactura;
	

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Producto> idProductos;

	public List<Producto> getIdProductos() {
		return idProductos;
	}


	public void setIdProductos(List<Producto> idProductos) {
		this.idProductos = idProductos;
	}


	// SETS Y GETS
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public BigDecimal getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}


	public Factura getIdFactura() {
		return idFactura;
	}


	public void setIdFactura(Factura idFactura) {
		this.idFactura = idFactura;
	}


	
	
}
