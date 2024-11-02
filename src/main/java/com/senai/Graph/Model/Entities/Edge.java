package com.senai.Graph.Model.Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Edge {
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
