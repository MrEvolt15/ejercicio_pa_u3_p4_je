package com.example.demo.repository;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.dto.ProductoDTO;

public interface IProductoRepository {
	public void insertar(Producto producto);
	public void eliminar(Integer id);
	public Producto seleccionarPorId(Integer id);
	public void actualizar(Producto producto);
	
	public Producto seleccionaProductoPorCodigoBarras(String codigoBarras);
	public ProductoDTO seleccionarProductoDTO(String codBarras);
	
}
