package AtividadeFerias;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;

public class Principal {

	public static void main(String args[]) {
		
		String novoCpf;
		String novoNome;
		int novaIdade;
		double novoSalario;
		String novoCargo;
		String novaHabilidade;
		ArrayList<String> novasHabilidades = new ArrayList<String>();
		
		 Scanner leitura = new Scanner(System.in);
		 
		 System.out.println("Informe o cpf do funcionario: ");
		 novoCpf = leitura.nextLine();
		 
		 System.out.println("Informe o nome do funcionario: ");
		 novoNome = leitura.nextLine();
		 
		 System.out.println("Informe a idade do funcionario: ");
		 novaIdade = leitura.nextInt();
		 leitura.nextLine();
		 		 
		 System.out.println("Informe o salario do funcionario: ");
		 novoSalario = leitura.nextDouble();
		 leitura.nextLine();
		 
		 System.out.println("Informe o cargo do funcionario: ");
		 novoCargo = leitura.nextLine();
		 
		 System.out.println("Informe as habilidades do funcionario: ");
		 novaHabilidade = leitura.nextLine();
		 while(!novaHabilidade.equals("-1")) {
			 novasHabilidades.add(novaHabilidade);
			 novaHabilidade = leitura.nextLine();
		 }
		 
		 Funcionario novoFuncionario = new Funcionario(novoCpf, novoNome, novaIdade, novoSalario, novoCargo, novasHabilidades);
		 
		 XStream xstream = new XStream();
		 xstream.alias("funcionario",Funcionario.class);
		 xstream.useAttributeFor(Funcionario.class, "habilidades");
		 String xmlGerado = xstream.toXML(novoFuncionario);
		 System.out.println(xmlGerado);
		 
		 //Criar o arquivo XML
		 try {
            PrintWriter writer = new PrintWriter(novoCpf + ".xml");
            writer.write(xmlGerado);
            writer.close();
	            
	     } catch (Exception ex) {
            ex.getMessage();
	     }
		
	}
	
}
