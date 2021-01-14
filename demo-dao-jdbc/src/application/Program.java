package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		
		System.out.println("=== Teste 1: Seller findById ======");
		Vendedor vendedor = vendedorDao.findById(3L);
		System.out.println(vendedor);
		
		System.out.println("\n=== Teste 2: Seller findByDepartment ======");
		Departamento dep = new Departamento(2L, null);
		List<Vendedor> list = vendedorDao.findByDepartment(dep);
		
		for (Vendedor vend : list) {
			System.out.println(vend);
		}
		
		System.out.println("\n=== Teste 3: Seller findAll ======");
		List<Vendedor> lista = vendedorDao.findAll();
		
		for (Vendedor vend : lista) {
			System.out.println(vend);
		}
		
	}

}
