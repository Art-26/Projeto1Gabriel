package modelos;

public class ABB<T extends Comparable<T>> {
	private No raiz;
	
	private class No {
		T valor;
		No esquerdo, direito;
		
		No (T valor) {
			this.valor = valor;
		}
	}
	
	public void inserir(T valor) {
		raiz = inserirRecursivo(raiz, valor);
		
	}
		
		private No inserirRecursivo(No no, T valor) {
			
			if (no == null) return new No(valor);
			if (valor.compareTo(no.valor) < 0) no.esquerdo = inserirRecursivo(no.esquerdo, valor);
			else if (valor.compareTo(no.valor) > 0) no.direito = inserirRecursivo(no.direito, valor);
			return no;
	}
		
		public boolean buscar(T valor) {
			return buscarRecursivo(raiz, valor);
		}
		
		private boolean buscarRecursivo(No no, T valor) {
			
			if (no == null) return false;
			if (valor.equals(no.valor)) return true;
			return valor.compareTo(no.valor) < 0 ? buscarRecursivo(no.esquerdo, valor) : buscarRecursivo(no.direito, valor);
		}
		
		public void remover(T valor) {
			raiz = removerRecursivo(raiz, valor);
		}
		
		private No removerRecursivo(No no, T valor) {
			
			if (no == null) return null;
			if (valor.compareTo(no.valor) <0) no.esquerdo = removerRecursivo(no.esquerdo, valor);
			else if (valor.compareTo(no.valor) > 0) no.direito = removerRecursivo(no.direito, valor);
			else {
				if(no.esquerdo == null) return no.direito;
				if(no.direito == null) return no.esquerdo;
				no.valor = encontrarMinimo(no.direito);
				no.direito = removerRecursivo(no.direito, no.valor);
			}
			
			return no;
		}
		
		private T encontrarMinimo(No no) {
			T min = no.valor;
			while (no.esquerdo != null) {
				min = no.esquerdo.valor;
				no = no.esquerdo;
			}
			
			return min;
		}
		
		public int obterAltura() {
			return calcularAltura(raiz);
		}
		
		private int calcularAltura(No no) {
			if (no == null) return -1;
			return 1 + Math.max(calcularAltura(no.esquerdo), calcularAltura(no.direito));
		}
}
