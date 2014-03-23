import java.util.Scanner;


/**
 * Atividade:
 * 1.	Execute o programa abaixo e entenda o seu propósito
 * 2.   Analise o código fonte para entender como cada coisa foi feita. Para isso,
 *      comente o programa e renomeie variáveis afim de documentar seu entendimento.
 * 3	Refatore o programa para promover melhoria de código e geração de código limpo (clean code). 
 * 
 *      ATENÇÃO! O programa refatorado deve contiuar com mesma interface de usuário que o anterior. 
 *      Apenas o código vai mudar, o usuário final não irá perceber nenhuma mudança!
 * 
 * 	Sugestões: 		
 * 		- Criação de classes de modelo à partir de análise
 * 		- Extração de métodos
 * 		- Extração de classes
 * 		- Aumento da coesão
 * 		- Diminuição do acoplamento entre as classes geradas
 * 		- Oportunidade de capturar/levantar exceções para situações de erro
 * 		- Aderência a padrões Java de nomenclatura (CamelCase)
 * 		- Oportunidade de seguir a convenção JavaBeans nas classes do modelo
 * 		- Oportunidade de usar Coleções (Listas e/ou Conjuntos)
 * 		- Documentação seguindo o padrão JavaDoc
 *              - Aplicação de Padrões de Projetos
 *              - Entre outros...
 */
public class Meu_programa2 {
	
	public static void main(String[] args) {

		int n=0,i;
		String pla;
		String cor;		
		int ano;
		int op;
		
		String [] arr_pla= new String[100];
		String [] arr_cor = new String[100];		
		int [] arr_ano = new int[100];	
		
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("======================");
			System.out.println("   MENU DE OPÇÕES");
			System.out.println("======================");
			System.out.println("1. Cadastrar carro");
			System.out.println("2. Listar carros");			
			System.out.println("3. Sair");
			System.out.println("======================");
			System.out.print("Digite a opção (1/2/3): ");
			op = sc.nextInt();
			
			if(op == 1){
				
				if(n > 100){
					System.out.println("ERRO: memória cheia.");
					break;
				}
				
				System.out.println("\n\n=== Cadastrar carro ===");				
				System.out.print("Placa (Ex: AAA-0000): ");
				pla = sc.next();
				System.out.print("Cor: ");
				cor = sc.next();
				System.out.println("Ano: ");
				ano = sc.nextInt();
				if(ano < 1900 && ano > 2012){
					System.out.println("ERRO: ano inválido! Cadastre o carro novamente.");
					break;
				}
				
				arr_pla[n] = pla;
				arr_ano[n] = ano;
				arr_cor[n] = cor;
				
				n++;
				
				System.out.println("=== Cadastro concluído. ===\n\n");
			}
			
			if(op == 2){				
				System.out.println("\n\n=== Listar carros ===");
				for(i=0; i<n; i++){
					System.out.println("Placa="+arr_pla[i]+", Cor="+arr_cor[i]+", Ano="+arr_ano[i]);
				}
				if(n==0){
					System.out.println("(vazio)");
				}
				System.out.println("=== Listagem concluída. ===\n\n");
			}
			
			if(op == 3){
				break;
			}
		}
		
		System.out.println("=== Fim ===");
	}
}
