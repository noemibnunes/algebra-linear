package algebra_linear;

import java.util.Scanner;

public class CriptografiaHillMain {
	
	private static final Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		
		boolean pararExecucao = false;
		
		while(pararExecucao == false) {
			System.out.println("-----------------------------------------------");
			System.out.println("Criptografia de Hill (26 letras)");
			
			String mensagem;
			
			System.out.println("-----------------------------------------------");
			System.out.print("Escreva a mensagem que você deseja criptografar: ");
			mensagem = TECLADO.nextLine();
			
			System.out.println();
			System.out.println();
			
			CriptografiaHill.Criptografar(mensagem);

			System.out.println();
			
			System.out.print("Deseja criptografar uma nova mensagem? S - Sim, N - Não ");
			String stop = TECLADO.nextLine();
			
			System.out.println();
			
			if(stop.equals("S") || stop.equals("s")) {
				pararExecucao = false;
			} else {
				break;
			}

			
		}

	}

}
