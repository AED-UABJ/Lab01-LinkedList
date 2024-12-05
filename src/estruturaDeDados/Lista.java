package estruturaDeDados;

public class Lista {

    // Classe interna para representar um nó da lista
    private class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No inicio; // Primeiro elemento da lista
    private int tamanho; // Quantidade de elementos na lista

    public Lista() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // Insere um elemento no início da lista
    public void insereInicio(int i) {
        No novo = new No(i);
        novo.proximo = inicio;
        inicio = novo;
        tamanho++;
    }

    // Insere um elemento no final da lista
    public void insereFim(int i) {
        No novo = new No(i);
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    // Busca se um elemento está na lista
    public boolean buscaElemento(int i) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor == i) {
                return true; // Elemento encontrado
            }
            atual = atual.proximo;
        }
        return false; // Elemento não encontrado
    }

    // Busca o elemento pelo índice
    public Object buscaIndice(int i) {
        if (i < 0 || i >= tamanho) {
            return null; // Índice inválido
        }
        No atual = inicio;
        for (int pos = 0; pos < i; pos++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    // Remove o primeiro elemento da lista
    public void removeInicio() {
        if (inicio != null) {
            inicio = inicio.proximo;
            tamanho--;
        }
    }

    // Remove o último elemento da lista
    public void removeFim() {
        if (inicio == null) {
            return; // Lista vazia
        }
        if (inicio.proximo == null) {
            inicio = null; // Apenas um elemento
        } else {
            No atual = inicio;
            while (atual.proximo.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = null;
        }
        tamanho--;
    }

    // Remove um elemento em um índice específico
    public void removeIndice(int i) {
        if (i < 0 || i >= tamanho) {
            return; // Índice inválido
        }
        if (i == 0) {
            removeInicio();
            return;
        }
        No atual = inicio;
        for (int pos = 0; pos < i - 1; pos++) {
            atual = atual.proximo;
        }
        atual.proximo = atual.proximo.proximo;
        tamanho--;
    }

    // Insere um elemento em uma posição específica
    public void insereElementoPosicao(int i, int j) {
        if (j < 0 || j > tamanho) {
            return; // Índice inválido
        }
        if (j == 0) {
            insereInicio(i);
            return;
        }
        No novo = new No(i);
        No atual = inicio;
        for (int pos = 0; pos < j - 1; pos++) {
            atual = atual.proximo;
        }
        novo.proximo = atual.proximo;
        atual.proximo = novo;
        tamanho++;
    }
}
