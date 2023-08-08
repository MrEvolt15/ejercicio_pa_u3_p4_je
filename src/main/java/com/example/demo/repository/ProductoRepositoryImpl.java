package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.dto.ProductoDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ProductoRepositoryImpl implements IProductoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Producto encontrado = this.seleccionarPorId(id);
		this.entityManager.remove(encontrado);	
	}

	@Override
	public Producto seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public Producto seleccionaProductoPorCodigoBarras(String codigoBarras) {
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codBarras=:DatoCodBarras",Producto.class);
		myQuery.setParameter("DatoCodBarras", codigoBarras);
		return myQuery.getSingleResult();
	}

	@Override
	public ProductoDTO seleccionarProductoDTO(String codBarras) {
		TypedQuery<ProductoDTO> myQuery=this.entityManager.createQuery("SELECT NEW com.example.demo.repository.modelo.ProductoDTO(e.codBarras,p.stock) FROM Producto p WHERE p.codBarras =:DatoCodBarras",ProductoDTO.class);
		myQuery.setParameter("DatoCodBarras", codBarras);
		return myQuery.getSingleResult();
	}

}
