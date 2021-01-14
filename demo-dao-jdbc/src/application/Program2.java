package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartamentoDao departamentoDao = DaoFactory.createDepartamentoDao();
		
		System.out.println("=== Teste 1: Department findById ======");
		Departamento depart = departamentoDao.findById(4L);
		System.out.println(depart);
		
		System.out.println("\n=== Teste 2: Department findAll ======");
		List<Departamento> list = departamentoDao.findAll();
		
		for (Departamento departamento : list) {
			System.out.println(departamento);
		}
		
		System.out.println("\n=== Teste 3: Department insert ======");
		Departamento departamento = new Departamento(null, "Calçados");
		departamentoDao.insert(departamento);
		System.out.println("Departamento inserido com sucesso!\nId inserido: " + departamento.getId());
		
		System.out.println("\n=== Teste 4: Department update ======");
		departamento = departamentoDao.findById(9L);
		departamento.setNome("Drogaria");
		departamentoDao.update(departamento);
		System.out.println("Update Completed!\nId de atualização: " + departamento.getId());
		
		System.out.println("\n=== Teste 5: Department delete ======");
		System.out.println("Informe um id para deletar: ");
		Long id = sc.nextLong();
		departamentoDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
