package com.senai.Graph.View;

import com.senai.Graph.Model.Adapter.GrafoDirecionadoComPesoAdapter;
import com.senai.Graph.Model.Adapter.GrafoDirecionadoDiagramAdapter;
import com.senai.Graph.Model.Adapter.GrafoNaoDirecionadoAdapter;
import com.senai.Graph.Model.Entities.GrafoDirecionado;
import com.senai.Graph.Model.Entities.GrafoNaoDirecionado;
import com.senai.Graph.Model.Entities.Graph;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("graphView")
@ViewScoped
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GraphView implements Serializable {

    private DefaultDiagramModel model;
    private DefaultDiagramModel model1;
    private DefaultDiagramModel model2;

    private boolean direcionado; // define o tipo do grafo

    @PostConstruct
    public void init() {

        model = new DefaultDiagramModel();
        model.setMaxConnections(-1); // número ilimitado de conexões


        Graph graph = new Graph(4);
        graph.addEdge(0,1, 10);
        graph.addEdge(1,2, 30);
        graph.addEdge(2,0,40);
        model2 = GrafoDirecionadoComPesoAdapter.adapt(graph);

        GrafoDirecionado grafo = new GrafoDirecionado(3);
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 0);

        model1 = GrafoDirecionadoDiagramAdapter.adapt(grafo);

        GrafoNaoDirecionado grafoNaoDirecionado = new GrafoNaoDirecionado(4);
        grafoNaoDirecionado.adicionarAresta(0, 1);
        grafoNaoDirecionado.adicionarAresta(1, 2);
        grafoNaoDirecionado.adicionarAresta(2, 1);

        model = GrafoNaoDirecionadoAdapter.adapt(grafoNaoDirecionado);


        }

}