package AtividadeFerias;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class InstanciaFuncionario {

	
	public static void main(String args[]) {
		Scanner leitura = new Scanner(System.in);
		
		System.out.println("Informe o cpf do funcionario: ");
		String novoCpf = leitura.nextLine();
		
		try {
			
            FileReader arqXml = new FileReader("C:\\Users\\lsq\\eclipse-workspace\\AtividadeFerias\\" + novoCpf + ".xml");
            BufferedReader lerArq = new BufferedReader(arqXml);

            String xmlContent = "";
            String linha = lerArq.readLine();
            while(linha != null) {
            	if(xmlContent.equals("")) {
            		xmlContent = xmlContent + linha;
            	}
            	else {
            		xmlContent = xmlContent + "\n" + linha;
            	}
                linha = lerArq.readLine();
            }

            
            XStream xstream = new XStream();
            xstream.addPermission(AnyTypePermission.ANY);
            xstream.alias("funcionario", Funcionario.class);
            Funcionario funcionario = (Funcionario)xstream.fromXML(xmlContent);
          
            
            System.out.println("Funcionario -> Cpf: " + funcionario.cpf);
            System.out.println("Nome: " + funcionario.nome);
            System.out.println("Idade: " + funcionario.idade);
            System.out.println("Salario: " + funcionario.salario);
            System.out.println("Cargo: " + funcionario.cargo);
            System.out.println("Habilidades: ");
           for(int i=0; i< funcionario.habilidades.size(); i++) {
        	   System.out.println(funcionario.habilidades.get(i));
           }
            
            
        }catch (IOException e){
            System.err.println("Não existe o CPF informado!");
        }
		 
	}

	
	 
}
