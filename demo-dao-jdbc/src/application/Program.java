package application;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Departamento obj = new Departamento(1L, "Books");
		Vendedor vendedor = new Vendedor(21L, "Bob", "8399999999", "teste@teste.com.br", new Date(), 3000.0, obj);
		System.out.println(vendedor);

	}

}
