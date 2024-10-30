package com.senai.Tree.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GrafoDirecionado {
    private final int vertices;
    private final List<List<Integer>> arestas;

    // Construtor para inicializar o grafo com um número de vértices
    public GrafoDirecionado(int vertices) {
        this.vertices = vertices;
        arestas = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
        	// É adiciondo uma lista em cada aresta
        	arestas.add(new ArrayList<>());
        }
    }

    // Método para adicionar uma aresta direcionada de origem para destino
    public void adicionarAresta(int origem, int destino) {
    	arestas.get(origem).add(destino);
    }

    // Método para imprimir a representação do grafo
    public void imprimirGrafo() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vértice " + i + " -> ");
            for (int destino : arestas.get(i)) {
                System.out.print(destino + " ");
            }
            System.out.println();
        }
    }


	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	
	    // Leitura do número de vértices (tamanho da matriz)
	    System.out.print("Digite o número de vértices: ");
	    int vertices = scanner.nextInt();
	
	    // Criação do grafo
	    GrafoDirecionado grafo = new GrafoDirecionado(vertices);
	
	    // Leitura da matriz de adjacências
	    System.out.println("Digite a matriz de adjacências:");
	    for (int i = 0; i < vertices; i++) {
	        for (int j = 0; j < vertices; j++) {
	        	System.out.println("Digite o elemento ["+i+"]["+j+"]: ");
	            int valor = scanner.nextInt();
	            if (valor == 1) { // se valor for 1, há uma aresta de i para j
	                grafo.adicionarAresta(i, j);
	            }
	        }
	    }
	
	    // Imprime o grafo criado
	    System.out.println("Representação do Grafo Direcionado:");
	    grafo.imprimirGrafo();
	    
	    scanner.close();
	}
	
}	
