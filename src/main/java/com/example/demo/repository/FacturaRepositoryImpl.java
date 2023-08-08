package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class FacturaRepositoryImpl implements IFacturaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Factura encontrado = this.seleccionarPorId(id);
		this.entityManager.remove(encontrado);
	}

	@Override
	public Factura seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

}
