package br.com.fiap.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.exception.ResponseException;
import br.com.fiap.repository.EmpresaRepository;
import br.com.fiap.to.Empresa;

public class View {

	private static EmpresaRepository rep = new EmpresaRepository(); 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("0 - sair");
		System.out.println("1 - Listar");
		System.out.println("2 - Buscar");
		System.out.println("3 - Cadastrar");
		System.out.println("4 - Atualizar");
		System.out.println("5 - Deletar");
		listar();
		int opcao = sc.nextInt();
		
		switch (opcao) {
		case 1:
			listar();
			break;
		case 2:
			System.out.println("Digite o código: ");
			int codigo = sc.nextInt();
			buscar(codigo);
			break;
		case 3:
			cadastrar(sc);
			break;
		case 4:
			atualizar(sc);
			break;
		case 5:
			System.out.println("Deletado o codigo: ");
			int codigo1 = sc.nextInt();
			deletar(codigo1);
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
		
		sc.close();
	}

	private static void deletar(int codigo1) {
		try {
			rep.deletar(codigo1);
			System.out.println("Empresa deletada!");
		} catch (ResponseException e) {
			e.printStackTrace();
		}		
	}

	private static void cadastrar(Scanner sc) {
		Empresa empresa = new Empresa();
		
		System.out.println("Diite o nome: ");
		empresa.setNome(sc.next() + sc.nextLine());
		
		System.out.println("Faturamento: ");
		empresa.setFaturamento(sc.nextDouble());
		
		System.out.println("Multinacional: ");
		empresa.setMultinacional(sc.nextBoolean());
		
		try {
			rep.cadastrar(empresa);
			System.out.println("Empresa cadastrada com sucesso!");
		} catch (ResponseException e) {
			e.printStackTrace();
		}
	}

	private static void atualizar(Scanner sc) {
		Empresa empresa;
		empresa = new Empresa();
		
		System.out.println("Diite o código: ");
		empresa.setCodigo(sc.nextInt());
		
		System.out.println("Diite o nome: ");
		empresa.setNome(sc.next() + sc.nextLine());
		
		System.out.println("Faturamento: ");
		empresa.setFaturamento(sc.nextDouble());
		
		System.out.println("Multinacional: ");
		empresa.setMultinacional(sc.nextBoolean());
		
		try {
			rep.atualizar(empresa);
			System.out.println("Atualizado com sucesso!");
		} catch (ResponseException e) {
			e.printStackTrace();
		}
		
	}

	private static void buscar(int codigo) {
		
		try {
			Empresa empresa = rep.pesquisa(codigo);
			System.out.println("Empresa: " + empresa.getNome());
			System.out.println("Fauramento: " + empresa.getFaturamento());
			System.out.println("Multinacional: " + empresa.isMultinacional());
			System.out.println("**********************************");
		} catch (ResponseException e) {
			e.printStackTrace();
		}
		
	}

	public static void listar() {
		
		EmpresaRepository rep = new EmpresaRepository();
		
		try {
			List<Empresa> lista = rep.listar();
			
			for(Empresa empresa : lista) {
				System.out.println("Empresa: " + empresa.getNome());
				System.out.println("Fauramento: " + empresa.getFaturamento());
				System.out.println("Multinacional: " + empresa.isMultinacional());
				System.out.println("**********************************");
			}
		} catch (ResponseException e) {
			e.printStackTrace();
		}
		
	}
	
}
