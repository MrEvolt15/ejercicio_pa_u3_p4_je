package com.example.demo.service;

import com.example.demo.repository.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

public interface IProductoService {
	
	@Transactional(value = TxType.MANDATORY)
	public void ingresarProducto(Producto prdoucto, Integer stock);
}
