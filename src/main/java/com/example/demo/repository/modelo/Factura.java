package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
	
	@GeneratedValue(generator = "seq_factura",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_factura",sequenceName ="seq_factura",allocationSize = 1 )
	@Id
	@Column(name = "fact_id")
	private Integer id;
	@Column(name = "fact_cedula_cliente")
	private String cedulaCliente;
	@Column(name = "fact_total")
	private BigDecimal totalFactura;
	
	@OneToOne(mappedBy = "idFactura",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private DetalleFactura idDetalleFactura;

	//SETS Y GETS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(BigDecimal totalFactura) {
		this.totalFactura = totalFactura;
	}

	public DetalleFactura getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(DetalleFactura idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}
	
	
}
