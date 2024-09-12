import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

class Faturamento {
    public int dia;
    public double faturamento;
}

public class Distribuidora {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = Distribuidora.class.getClassLoader().getResourceAsStream("faturamento.json");
            if (inputStream == null) {
                System.out.println("Arquivo faturamento.json não encontrado!");
                return;
            }

            List<Faturamento> faturamentos = objectMapper.readValue(inputStream, new TypeReference<List<Faturamento>>() {});

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;

            for (Faturamento faturamento : faturamentos) {
                if (faturamento.faturamento > 0) {
                    if (faturamento.faturamento < menorFaturamento) {
                        menorFaturamento = faturamento.faturamento;
                    }
                    if (faturamento.faturamento > maiorFaturamento) {
                        maiorFaturamento = faturamento.faturamento;
                    }
                    somaFaturamento += faturamento.faturamento;
                    diasComFaturamento++;
                }
            }

            double mediaMensal = somaFaturamento / diasComFaturamento;

            int diasAcimaDaMedia = 0;
            for (Faturamento faturamento : faturamentos) {
                if (faturamento.faturamento > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.println("Menor faturamento: " + menorFaturamento);
            System.out.println("Maior faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
