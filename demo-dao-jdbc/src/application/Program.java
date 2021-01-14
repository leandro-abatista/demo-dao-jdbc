package application;

import java.util.Date;
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
		Departamento dep = new Departamento(4L, null);
		List<Vendedor> list = vendedorDao.findByDepartment(dep);
		
		for (Vendedor vend : list) {
			System.out.println(vend);
		}
		
		System.out.println("\n=== Teste 3: Seller findAll ======");
		List<Vendedor> lista = vendedorDao.findAll();
		
		for (Vendedor vend : lista) {
			System.out.println(vend);
		}
		
		System.out.println("\n=== Teste 4: Seller insert ======");
		Vendedor vend = new Vendedor(null, "Jane Vendedor Teste", "karla@teste.com.br", new Date(), 4500.0, dep);
		vendedorDao.insert(vend);
		System.out.println("Inserido com sucesso!\nId inserido: " + vend.getId());
		
		System.out.println("\n=== Teste 5: Seller update ======");
		vend = vendedorDao.findById(7L);
		vend.setNome("Willian Nobre");
		vendedorDao.update(vend);
		System.out.println("Update Completed!");
	}

}
