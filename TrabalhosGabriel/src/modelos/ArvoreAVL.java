
package modelos;

public class ArvoreAVL<T extends Comparable<T>> {
    private No raiz;

    private class No {
        T valor;
        int altura;
        No esquerdo, direito;
        No(T valor) { this.valor = valor; }
    }

    private int altura(No n) { 
        return n == null ? -1 : n.altura; 
    }

    private void atualizarAltura(No n) {
        n.altura = 1 + Math.max(altura(n.esquerdo), altura(n.direito));
    }

    private int fatorBalanceamento(No n) {
        return n == null ? 0 : altura(n.direito) - altura(n.esquerdo);
    }

    private No rotarDireita(No y) {
        No x = y.esquerdo;
        No t2 = x.direito;
        x.direito = y;
        y.esquerdo = t2;
        atualizarAltura(y);
        atualizarAltura(x);
        return x;
    }

    private No rotarEsquerda(No x) {
        No y = x.direito;
        No t2 = y.esquerdo;
        y.esquerdo = x;
        x.direito = t2;
        atualizarAltura(x);
        atualizarAltura(y);
        return y;
    }

    private No balancear(No z) {
        atualizarAltura(z);
        int fb = fatorBalanceamento(z);
        if (fb > 1) {
            if (fatorBalanceamento(z.direito) < 0) z.direito = rotarDireita(z.direito);
            return rotarEsquerda(z);
        } else if (fb < -1) {
            if (fatorBalanceamento(z.esquerdo) > 0) z.esquerdo = rotarEsquerda(z.esquerdo);
            return rotarDireita(z);
        }
        return z;
    }

    public void inserir(T valor) { 
        raiz = inserirRecursivo(raiz, valor); 
    }
    private No inserirRecursivo(No no, T valor) {
        if (no == null) return new No(valor);
        if (valor.compareTo(no.valor) < 0) no.esquerdo = inserirRecursivo(no.esquerdo, valor);
        else if (valor.compareTo(no.valor) > 0) no.direito = inserirRecursivo(no.direito, valor);
        else return no;
        return balancear(no);
    }
    
    public boolean buscar(T valor) {
        No atual = raiz;
        while (atual != null) {
            int cmp = valor.compareTo(atual.valor);
            if (cmp == 0) return true;
            atual = (cmp < 0) ? atual.esquerdo : atual.direito;
        }
        return false;
    }

    public void remover(T valor) { 
        raiz = removerRecursivo(raiz, valor); 
    }
    private No removerRecursivo(No no, T valor) {
        if (no == null) return null;
        if (valor.compareTo(no.valor) < 0) no.esquerdo = removerRecursivo(no.esquerdo, valor);
        else if (valor.compareTo(no.valor) > 0) no.direito = removerRecursivo(no.direito, valor);
        else {
            if (no.esquerdo == null || no.direito == null) {
                no = (no.esquerdo == null) ? no.direito : no.esquerdo;
            } else {
                No temp = encontrarMinimo(no.direito);
                no.valor = temp.valor;
                no.direito = removerRecursivo(no.direito, temp.valor);
            }
        }
        if (no == null) return null;
        return balancear(no);
    }

    private No encontrarMinimo(No no) {
        while (no.esquerdo != null) no = no.esquerdo;
        return no;
    }
    
    public int obterAltura() {
        return altura(raiz);
    }
}
