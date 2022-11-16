package algebra_linear;

import java.util.ArrayList;
import java.util.Scanner;

public class CriptografiaHill {
	
	private static final Scanner TECLADO = new Scanner(System.in);

	public static int[][] getMatriz() {
		int[][] matrizCodigo = new int[2][2];

		System.out.println("Insira os valores da matriz cÛdigo *Modelo a ser seguido*:");
		System.out.println();

		System.out.println("| a  b |");
		System.out.println("| c  d |");
		System.out.println();
		
		System.out.print("Insira o valor da posiÁ„o a: ");
		matrizCodigo[0][0] = TECLADO.nextInt();
		System.out.print("Insira o valor da posiÁ„o b: ");
		matrizCodigo[0][1] = TECLADO.nextInt();
		System.out.print("Insira o valor da posiÁ„o c: ");
		matrizCodigo[1][0] = TECLADO.nextInt();
		System.out.print("Insira o valor da posiÁ„o d: ");
		matrizCodigo[1][1] = TECLADO.nextInt();

		return matrizCodigo;
	}
	
	public static String tratarMensagem(String mensagem) {
		mensagem = mensagem.replaceAll(" ", "");
		mensagem = mensagem.replaceAll("[·¡‚¬„√]", "A");
		mensagem = mensagem.replaceAll("[È…Í ]", "E");
		mensagem = mensagem.replaceAll("[ÌÕÓŒ]", "I");
		mensagem = mensagem.replaceAll("[Û”Ù‘ı’]", "O");
		mensagem = mensagem.replaceAll("[˙⁄˚€]", "U");
		
		if (mensagem.length() % 2 != 0) {
			String ultimaLetra = mensagem.substring(mensagem.length() - 1);
			mensagem += ultimaLetra;
			mensagem = mensagem.toUpperCase();
		} else {
			mensagem = mensagem.toUpperCase();
		}
		
		return mensagem;
	}
	
    public static void Criptografar(String mensagem) {
        int i;
        int add = 0;
        int[][] matrizCodigo;
        ArrayList<Integer> numeroDaMensagem = new ArrayList<>();
        ArrayList<Integer> msgCripto = new ArrayList<>();

        mensagem = tratarMensagem(mensagem);

        matrizCodigo = getMatriz();

        for(i=0; i < mensagem.length(); i++) {
            numeroDaMensagem.add(mensagem.charAt(i) - (64 + add));
        }

        for(i=0; i < numeroDaMensagem.size(); i += 2) {
            int letra1 = (matrizCodigo[0][0] * numeroDaMensagem.get(i) + matrizCodigo[0][1] * numeroDaMensagem.get(i+1)) % 26; // (i+1) para ele pegar o outro num do par
            int letra2 = (matrizCodigo[1][0] * numeroDaMensagem.get(i) + matrizCodigo[1][1] * numeroDaMensagem.get(i+1)) % 26;
            msgCripto.add(letra1 == 0 ? 26 : letra1);
            msgCripto.add(letra2 == 0 ? 26 : letra2);
        }
       
        System.out.println();
		System.out.print("Criptografando a mensagem ... ");
        System.out.println();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println();
        resultado("A mensagem criptografada È: ", add, msgCripto);
    }
    
    private static void resultado(String rotulo, int add, ArrayList<Integer> mensagem) {
        int i;
        System.out.print(rotulo);

        for(i=0; i < mensagem.size(); i += 2) {
            System.out.print(Character.toChars(mensagem.get(i) + (64 + add)));
            System.out.print(Character.toChars(mensagem.get(i+1) + (64 + add)));
        }
        System.out.println();
    }

}
