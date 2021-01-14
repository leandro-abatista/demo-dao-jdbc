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
		
		System.out.println("\n=== Teste 4: product insert ======");
		Product produto = new Product(null, "cd leandro borges Deus e eu", 200.00, 300.00, 20);
		productDao.insert(produto);
		System.out.println("Producto inserido com sucesso!\nId inserido: " + produto.getId());
		
		System.out.println("\n=== Teste 5: product update ======");
		pro = productDao.findById(5L);
		pro.setDescription("roupa velha");
		pro.setPriceSale(50.00);
		productDao.update(pro);
		System.out.println("Update completed!\nId atualizado: " + pro.getId());
		
	}

}
