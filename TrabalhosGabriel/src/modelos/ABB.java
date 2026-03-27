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
			return buscarResponsivo(raiz, valor);
		}
		
		private boolean buscarRecursivo(No no, T valor) {
			
			if (no == null) return false;
			if (valor.equals(no.valor)) return true;
			return valor.compareTo(no.valor) < 0 ? buscarRecursivo(no.esquerdo, valor) : buscarRecursivo(no.direito, valor);
		}
}
