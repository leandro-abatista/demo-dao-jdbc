package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class Program2 {

	public static void main(String[] args) {
		
		DepartamentoDao departamentoDao = DaoFactory.createDepartamentoDao();
		
		System.out.println("=== Teste 1: Department findById ======");
		Departamento depart = departamentoDao.findById(4L);
		System.out.println(depart);
		
		System.out.println("\n=== Teste 2: Department findAll ======");
		List<Departamento> list = departamentoDao.findAll();
		
		for (Departamento departamento : list) {
			System.out.println(departamento);
		}
	}

}
