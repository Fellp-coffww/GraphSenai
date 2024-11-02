package com.senai.Graph.Model.Entities;

import java.util.ArrayList;
import java.util.Scanner;

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

