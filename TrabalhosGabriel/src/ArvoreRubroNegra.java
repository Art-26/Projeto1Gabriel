package modelos;

public class ArvoreRubroNegra<T extends Comparable<T>> {
    private static final boolean RUBRO = true;
    private static final boolean NEGRO = false;

    private No raiz;

    private class No {
        T valor;
        No esquerdo, direito;
        boolean cor;

        No(T valor) {
            this.valor = valor;
            this.cor = RUBRO;
        }
    }

    private boolean ehRubro(No x) {
        if (x == null) return false;
        return x.cor == RUBRO;
    }

    private No rotarEsquerda(No h) {
        No x = h.direito;
        h.direito = x.esquerdo;
        x.esquerdo = h;
        x.cor = h.cor;
        h.cor = RUBRO;
        return x;
    }

    private No rotarDireita(No h) {
        No x = h.esquerdo;
        h.esquerdo = x.direito;
        x.direito = h;
        x.cor = h.cor;
        h.cor = RUBRO;
        return x;
    }

    private void inverterCores(No h) {
        h.cor = RUBRO;
        h.esquerdo.cor = NEGRO;
        h.direito.cor = NEGRO;
    }

    public void inserir(T valor) {
        raiz = inserir(raiz, valor);
        raiz.cor = NEGRO;
    }

    private No inserir(No h, T valor) {
        if (h == null) return new No(valor);

        int cmp = valor.compareTo(h.valor);
        if (cmp < 0) h.esquerdo = inserir(h.esquerdo, valor);
        else if (cmp > 0) h.direito = inserir(h.direito, valor);

        if (ehRubro(h.direito) && !ehRubro(h.esquerdo)) h = rotarEsquerda(h);
        if (ehRubro(h.esquerdo) && ehRubro(h.esquerdo.esquerdo)) h = rotarDireita(h);
        if (ehRubro(h.esquerdo) && ehRubro(h.direito)) inverterCores(h);

        return h;
    }

    public boolean buscar(T valor) {
        No atual = raiz;
        while (atual != null) {
            int cmp = valor.compareTo(atual.valor);
            if (cmp < 0) atual = atual.esquerdo;
            else if (cmp > 0) atual = atual.direito;
            else return true;
        }
        return false;
    }

    public int obterAltura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(No no) {
        if (no == null) return -1;
        return 1 + Math.max(calcularAltura(no.esquerdo), calcularAltura(no.direito));
    }
}
