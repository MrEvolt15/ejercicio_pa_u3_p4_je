package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository productoRrpository;
	
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void ingresarProducto(Producto producto,Integer stock) {
		String codBarras = producto.getCodBarras();
		
		if(producto == this.productoRrpository.seleccionaProductoPorCodigoBarras(codBarras)) {
			producto.setStrock(stock);
			this.productoRrpository.actualizar(producto);
		}else {
			this.productoRrpository.insertar(producto);
		}
		
		
	}

}
