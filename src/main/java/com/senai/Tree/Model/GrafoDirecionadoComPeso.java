package com.senai.Tree.Model;

import java.util.ArrayList;
import java.util.Scanner;

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "De " + source + " para " + destination + " (Peso: " + weight + ")";
    }
}

class Graph {
    ArrayList<ArrayList<Edge>> edgesList;

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
}

public class GrafoDirecionadoComPeso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre com o número de vértices: ");
        int vertices = scanner.nextInt();

        Graph graph = new Graph(vertices);

        System.out.println("Entre com os pesos: ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                int weight = scanner.nextInt();
                if (weight != 0) {
                    graph.addEdge(i, j, weight);
                }
            }
        }

        System.out.println("\nRepresentação dos Grafos:");
        graph.displayGraph();
        
        scanner.close();
    }
}

