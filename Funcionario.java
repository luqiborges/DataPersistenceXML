package AtividadeFerias;

import java.util.ArrayList;

public class Funcionario {
	
	String cpf;
	String nome;
	int idade;
	double salario;
	String cargo;
	ArrayList<String> habilidades;
	
	public Funcionario(String cpf, String nome, int idade, double salario, String cargo, ArrayList<String> habilidades) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
		this.cargo = cargo;
		this.habilidades = habilidades;
	}
	
}
