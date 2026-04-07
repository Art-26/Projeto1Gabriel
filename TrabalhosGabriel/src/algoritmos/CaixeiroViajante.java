package algoritmos;

import java.util.Random;

public class CaixeiroViajante {

    public static double[][] gerarMatriz(int tamanho) {
        double[][] matriz = new double[tamanho][tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (i == j) matriz[i][j] = 0;
                else matriz[i][j] = 1 + random.nextDouble() * 100;
            }
        }
        return matriz;
    }

    public static double resolver(double[][] matriz) {
        int n = matriz.length;
        boolean[] visitados = new boolean[n];
        int atual = 0;
        visitados[0] = true;
        double custoTotal = 0;

        for (int i = 0; i < n - 1; i++) {
            int proximo = -1;
            double menorDist = Double.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visitados[j] && matriz[atual][j] < menorDist) {
                    menorDist = matriz[atual][j];
                    proximo = j;
                }
            }

            visitados[proximo] = true;
            custoTotal += menorDist;
            atual = proximo;
        }

        custoTotal += matriz[atual][0];
        return custoTotal;
    }

    public static void executarExperimento(int tamanho) {
        double somaTempos = 0;
        int repeticoes = 30;

        for (int i = 0; i < repeticoes; i++) {
            double[][] matriz = gerarMatriz(tamanho);
            long inicio = System.nanoTime();
            resolver(matriz);
            long fim = System.nanoTime();
            somaTempos += (fim - inicio) / 1_000_000.0;
        }

        System.out.println("Tamanho: " + tamanho + " | Media de tempo (ms): " + (somaTempos / repeticoes));
    }
}
