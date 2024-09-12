import java.util.Scanner;


public class Ex5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma string para inverter: ");
        String input = sc.nextLine();

        char[] caracteres = input.toCharArray();

        int inicio = 0;
        int fim = caracteres.length - 1;

        while (inicio < fim) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;

            inicio++;
            fim--;
        }

        String invertida = new String(caracteres);

        System.out.println("String invertida: " + invertida);

        sc.close();
    }

}
