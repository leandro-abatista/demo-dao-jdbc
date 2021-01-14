package application;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		
		System.out.println("=== Teste 1: Seller findById ======");
		Vendedor vendedor = vendedorDao.findById(3L);
		System.out.println(vendedor);

	}

}
