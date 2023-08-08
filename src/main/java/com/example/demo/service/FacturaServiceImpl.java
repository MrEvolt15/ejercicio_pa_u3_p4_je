package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.IFacturaRepository;
import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.DetalleFactura;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.dto.ProductoDTO;

public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;
	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public void generarFactura(List<ProductoDTO> productos, String cedulaCliente) {
			
			List<Producto> products = new ArrayList<>();
			Factura nueva = new Factura();
			DetalleFactura detalleNueva = new DetalleFactura();
			BigDecimal subtotal = new BigDecimal(0);
			for (ProductoDTO p :productos) {
				
				nueva.setCedulaCliente(cedulaCliente);
				nueva.setIdDetalleFactura(detalleNueva);
				Producto prod = this.iProductoRepository.seleccionaProductoPorCodigoBarras(p.getCodBarras());
				
				products.add(prod);
				detalleNueva.setIdFactura(nueva);
				detalleNueva.setPrecioUnitario(prod.getPrecio());
				detalleNueva.setSubtotal(BigDecimal.valueOf(0));
				subtotal.add(prod.getPrecio());
				
				
			}
			detalleNueva.setIdProductos(products);
			nueva.setTotalFactura(null);
			this.facturaRepository.insertar(nueva);
			
		}

}
