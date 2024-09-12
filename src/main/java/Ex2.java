import java.util.Scanner;

public class Ex2 {

    public static boolean isFibonacci (int num) {
        if (num == 0 || num == 1){
            return true;
        }

        int prev = 0;
        int curr = 1;
        int next = prev + curr;

        while (next <= num){
            if(next == num) {
                return true;
            }

            prev = curr;
            curr = next;
            next = prev + curr;
        }

        return false;
    }
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Informar um numero: ");
        int num = sc.nextInt();


        if(isFibonacci(num)) {
            System.out.println(num + " pertence a sequencia Fibonacci");
        }
        else {
            System.out.println(num + " Nao pertence a sequencia Fibonacci");
        }

        sc.close();
    }

}
