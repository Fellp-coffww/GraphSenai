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
}
