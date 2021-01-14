package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface DepartamentoDao {
	
	public void insert(Departamento obj);
	
	public void update(Departamento obj);
	
	public void deleteById(Long id);
	
	public Departamento findById(Long id);
	
	List<Departamento> findAll();
	
}
