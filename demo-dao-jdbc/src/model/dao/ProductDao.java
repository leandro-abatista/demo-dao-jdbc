package model.dao;

import java.util.List;

import model.entities.Product;

public interface ProductDao {

	public void insert(Product obj);

	public void update(Product obj);

	public void deleteById(Long id);

	public Product findById(Long id);

	List<Product> findAll();
	
	List<Product> findAllPrice();
}
