package com.senai.Graph.Model.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Graph {
    public ArrayList<ArrayList<Edge>> edgesList;

    public Graph(int vertices) {
    	edgesList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
        	edgesList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
    	edgesList.get(source).add(new Edge(source, destination, weight));
    }

    public void displayGraph() {
        for (int i = 0; i < edgesList.size(); i++) {
            System.out.println("Vértice " + i + " Arestas:");
            for (Edge edge : edgesList.get(i)) {
                System.out.println(edge);
            }
        }
    }

    public String getMatrizAdjacencia() {
        int numVertices = edgesList.size();
        int[][] matrizAdjacencia = new int[numVertices][numVertices];

        // Inicializa a matriz com zeros (ou outro valor para representar ausência de aresta)
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrizAdjacencia[i][j] = 0;
            }
        }

        // Preenche a matriz com os pesos das arestas
        for (int i = 0; i < numVertices; i++) {
            for (Edge edge : edgesList.get(i)) {
                matrizAdjacencia[edge.source][edge.destination] = edge.weight;
            }
        }

        // Constrói a string da matriz
        StringBuilder sb = new StringBuilder("Matriz de Adjacência:\n");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                sb.append(matrizAdjacencia[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int calcularGrauVertice(int vertice) {
        return edgesList.get(vertice).size();
    }
}
