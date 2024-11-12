package com.senai.Graph.Model.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrafoNaoDirecionado {
    private int[][] matrizAdjacencia;
    private int numVertices;

    // Construtor do grafo
    public GrafoNaoDirecionado(int numVertices) {
        this.numVertices = numVertices;
        matrizAdjacencia = new int[numVertices][numVertices];
    }

    // Método para adicionar uma aresta entre dois vértices
    public void adicionarAresta(int origem, int destino, int peso) {
        matrizAdjacencia[origem][destino] = peso;
        //matrizAdjacencia[destino][origem] = 1; // Aresta para grafo não direcionado
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

    public String getMatrizAdjacenciaBiuld() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                sb.append(matrizAdjacencia[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int calcularGrauVertice(int vertice) {
        int grau = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdjacencia[vertice][i] != 0) {
                grau++;
            }
        }
        return grau;
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
        grafo.adicionarAresta(0, 1,1);
        grafo.adicionarAresta(0, 2,1);
        grafo.adicionarAresta(1, 3,1);
        grafo.adicionarAresta(2, 4,1);

        // Mostra a matriz de adjacências e as conexões do grafo
        grafo.mostrarMatrizAdjacencias();
        grafo.mostrarGrafo();
    }
}


