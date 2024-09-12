public class Ex1 {

    public static void main(String[] args) throws Exception {
        int INDICE = 13;
        int K = 0;
        int SOMA = 0;

        while(K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        System.out.println(SOMA);
    }

}
