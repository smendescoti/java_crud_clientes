package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteController {

	public void cadastrarCliente() {

		System.out.println("\n*** CADASTRO DE CLIENTES ***\n");
		Scanner scanner = new Scanner(System.in);

		Cliente cliente = new Cliente();

		System.out.print("NOME DO CLIENTE....: ");
		cliente.setNome(scanner.nextLine());

		System.out.print("EMAIL..............: ");
		cliente.setEmail(scanner.nextLine());

		System.out.print("TELEFONE...........: ");
		cliente.setTelefone(scanner.nextLine());

		System.out.print("CPF................: ");
		cliente.setCpf(scanner.nextLine());

		ClienteRepository clienteRepository = new ClienteRepository();

		try {

			clienteRepository.create(cliente);
			System.out.println("\nCLIENTE CADASTRADO COM SUCESSO!");

		} catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR CLIENTE!");
			e.printStackTrace(); // imprimir log do erro
		}
	}
	
	public void atualizarCliente() {
		
		System.out.println("\n*** ATUALIZAÇÃO DE CLIENTES ***\n");
		Scanner scanner = new Scanner(System.in);

		Cliente cliente = new Cliente();
		
		System.out.print("ID DO CLIENTE......: ");
		cliente.setIdCliente(Integer.parseInt(scanner.nextLine()));

		System.out.print("NOME DO CLIENTE....: ");
		cliente.setNome(scanner.nextLine());

		System.out.print("EMAIL..............: ");
		cliente.setEmail(scanner.nextLine());

		System.out.print("TELEFONE...........: ");
		cliente.setTelefone(scanner.nextLine());

		System.out.print("CPF................: ");
		cliente.setCpf(scanner.nextLine());

		ClienteRepository clienteRepository = new ClienteRepository();
		
		try {
			
			clienteRepository.update(cliente);
			System.out.println("\nCLIENTE ATUALIZADO COM SUCESSO!");
		}
		catch(Exception e) {
			System.out.println("\nFALHA AO ATUALIZAR CLIENTE!");
			e.printStackTrace(); // imprimir log do erro
		}
	}
	
	public void excluirCliente() {
		
		System.out.println("\n*** EXCLUSÃO DE CLIENTES ***\n");
		Scanner scanner = new Scanner(System.in);

		Cliente cliente = new Cliente();
		
		System.out.print("ID DO CLIENTE......: ");
		cliente.setIdCliente(Integer.parseInt(scanner.nextLine()));
		
		ClienteRepository clienteRepository = new ClienteRepository();
		
		try {
			
			clienteRepository.delete(cliente);
			System.out.println("\nCLIENTE EXCLUÍDO COM SUCESSO!");
		}
		catch(Exception e) {
			System.out.println("\nFALHA AO EXCLUIR CLIENTE!");
			e.printStackTrace(); // imprimir log do erro
		}
	}
	
	public void consultarClientes() {
		
		System.out.println("\n*** CONSULTA DE CLIENTES ***\n");
		
		ClienteRepository clienteRepository = new ClienteRepository();
		
		try {
			
			List<Cliente> lista = clienteRepository.findAll();
			
			for(Cliente cliente : lista) { //foreach
				
				System.out.println("ID DO CLIENTE...: " + cliente.getIdCliente());
				System.out.println("NOME............: " + cliente.getNome());
				System.out.println("EMAIL...........: " + cliente.getEmail());
				System.out.println("TELEFONE........: " + cliente.getTelefone());
				System.out.println("CPF.............: " + cliente.getCpf());
				System.out.println("...");
			}			
		}
		catch(Exception e) {
			System.out.println("\nFALHA AO CONSULTAR CLIENTES!");
			e.printStackTrace(); // imprimir log do erro
		}
	}
	
}









