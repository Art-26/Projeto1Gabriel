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
