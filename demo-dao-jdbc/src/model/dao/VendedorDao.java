package model.dao;

import java.util.List;

import model.entities.Departamento;
import model.entities.Vendedor;

public interface VendedorDao {
	
public void insert(Vendedor obj);
	
	public void update(Vendedor obj);
	
	public void deleteById(Long id);
	
	public Vendedor findById(Long id);
	
	List<Vendedor> findAll();
	
	List<Vendedor> findByDepartment(Departamento departamento);

}
