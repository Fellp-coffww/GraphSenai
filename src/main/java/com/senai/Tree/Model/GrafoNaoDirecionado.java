package com.senai.Tree.Model;

public class GrafoNaoDirecionado {
    private int[][] matrizAdjacencia;
    private int numVertices;

    // Construtor do grafo
    public GrafoNaoDirecionado(int numVertices) {
        this.numVertices = numVertices;
        matrizAdjacencia = new int[numVertices][numVertices];
    }

    // Método para adicionar uma aresta entre dois vértices
    public void adicionarAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = 1;
        matrizAdjacencia[destino][origem] = 1; // Aresta para grafo não direcionado
    }

    // Método para exibir a matriz de adjacências
    public void mostrarMatrizAdjacencias() {
        System.out.println("Matriz de Adjacências:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para exibir o grafo com as arestas
    public void mostrarGrafo() {
        System.out.println("\nMostrar todas as Arestas do Grafo:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdjacencia[i][j] == 1) {
                    System.out.println(" > Vértice " + i + " está conectado ao vértice " + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Cria um grafo com 5 vértices
        GrafoNaoDirecionado grafo = new GrafoNaoDirecionado(5);

        // Adiciona algumas arestas
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 4);

        // Mostra a matriz de adjacências e as conexões do grafo
        grafo.mostrarMatrizAdjacencias();
        grafo.mostrarGrafo();
    }
}


