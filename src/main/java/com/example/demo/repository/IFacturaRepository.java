package com.example.demo.repository;

import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Producto;


public interface IFacturaRepository {
	public void insertar(Factura factura);
	public void eliminar(Integer id);
	public Factura seleccionarPorId(Integer id);
	public void actualizar(Factura factura);
	
	
}
