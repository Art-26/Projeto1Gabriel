package principal;

import modelos.*;
import algoritmos.CaixeiroViajante;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int[] tamanhos = {1500, 6500, 15000};
		Random rand = new Random();
		
		System.out.println("  Experimentos: Árvores (com média de 30 execuções)   ");
		System.out.println("Tamanho\t| Árvore\t| Inserção (ms)\t| Busca (ms)\t| Altura Final");
		System.out.println("-----------------------------------------------------");
		
		for (int n : tamanhos) {
			double tempoABB = 0, tempoAVL = 0, tempoARN = 0;
			double buscaABB = 0, buscaAVL = 0, buscaARN = 0;
			int alturaABB = 0, alturaAVL = 0, alturaARN = 0;
			
			for (int i = 0; i < 30; i++) {
				ABB<Integer> abb = new ABB<>();
				ArvoreAVL<Integer> avl = new ArvoreAVL<>();
				ArvoreRubroNegra<Integer> arn = new ArvoreRubroNegra<>();
				
				int[] dados = new int[n];
				for (int j = 0; j < n; j++) dados[j] = rand.nextInt(n * 10);
				
				int valorBusca = dados[rand.nextInt(n)];
				
				long inicio = System.nanoTime();
				for (int d : dados) abb.inserir(d);
				tempoABB += (System.nanoTime() - inicio) / 1_000_000.0;
				
				long inicioB = System.nanoTime();
				abb.buscar(valorBusca);
				buscaABB += (System.nanoTime() - inicioB) / 1_000_000.0;
				alturaABB += abb.obterAltura();
				
				inicio = System.nanoTime();
				for (int d : dados) avl.inserir(d);
				tempoAVL += (System.nanoTime() - inicio) / 1_000_000.0;
				
				inicioB = System.nanoTime();
				avl.buscar(valorBusca);
				buscaAVL += (System.nanoTime() - inicioB) / 1_000_000.0;
				alturaAVL += avl.obterAltura();
				
				inicio = System.nanoTime();
				for (int d : dados) arn.inserir(d);
				tempoARN += (System.nanoTime() - inicio) / 1_000_000.0;
				
				inicioB = System.nanoTime();
				arn.buscar(valorBusca);
				buscaARN += (System.nanoTime() - inicioB) / 1_000_000.0;
				alturaARN += arn.obterAltura();
			}
			
			imprimirLinha(n, "ABB (BST)", tempoABB / 30, buscaABB / 30, alturaABB / 30);
			imprimirLinha(n, "AVL", tempoAVL / 30, buscaAVL / 30, alturaAVL / 30);
			imprimirLinha(n, "ARN", tempoARN / 30, buscaARN / 30, alturaARN / 30);
			System.out.println("-----------------------------------------------------");
		}
		
		System.out.println("   Experimento do Caixeiro Viajante   ");
		int [] tamanhosTSP = {10, 20, 30};
		for (int n : tamanhosTSP) {
			executarTSP(n);
		}
	}
	
	private static void imprimirLinha(int n, String tipo, double tempoI, double tempoB, int altura) {
		System.out.printf("%d\t| %s\t| %.4f ms\t| %.4f ms\t| %d\n", n, tipo, tempoI, tempoB, altura);
	}
	
	private static void executarTSP(int n) {
		double somaTempo = 0;
		for (int i = 0; i < 30; i++) {
			double[][] matriz = gerarMatriz(n);
			long inicio = System.nanoTime();
			CaixeiroViajante.resolver(matriz);
			somaTempo += (System.nanoTime() - inicio) / 1_000_000.0;
		}
		System.out.printf("TSP Tamanho %d | Tempo Médio: %.4f ms\n", n, somaTempo / 30);
	}
	
	private static double [][] gerarMatriz(int n) {
		double [][] matriz = new double[n][n];
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) matriz[i][j] = 0;
				else matriz[i][j] = 1 + rand.nextDouble() * 100;
			}
		}
		return matriz;
	}
}
