package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Product;

public class program3 {

	public static void main(String[] args) {
		
		ProductDao productDao = DaoFactory.createProductDao();
		
		System.out.println("=== Teste 1: product findById ======");
		Product pro = productDao.findById(5L);
		System.out.println(pro);
		
		System.out.println("\n=== Teste 2: product findAll ======");
		List<Product> list = productDao.findAll();
		
		for (Product product : list) {
			System.out.println(product);
		}
		
		System.out.println("\n=== Teste 3: product findAllPrice ======");
		list = productDao.findAllPrice();
		
		for (Product product : list) {
			System.out.println(product);
		}
	}

}
