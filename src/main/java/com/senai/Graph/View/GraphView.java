package com.senai.Graph.View;


import com.senai.Graph.Model.Adapter.GrafoDirecionadoDiagramAdapter;
import com.senai.Graph.Model.Entities.GrafoDirecionado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("graphView")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ViewScoped
public class GraphView implements Serializable {

    private GrafoDirecionado grafoDirecionado;
    private DefaultDiagramModel model;
    private DefaultDiagramModel model1;
    private DefaultDiagramModel model2;
    private Integer qtdVertices;
    private Element verticeSelecionado;
    private List<String> buttons;
    private String verticeDestino;


    private boolean direcionado; // define o tipo do grafo
    private boolean comPeso; // define o tipo do grafo

    @PostConstruct
    public void init() {
        qtdVertices = 0; // Inicializar o valor para evitar nulos, caso necessário
        verticeSelecionado = new Element();
        buttons = new ArrayList<>();

        }

    public void actionBotaoNewGraph() {

        grafoDirecionado = new GrafoDirecionado(qtdVertices);
        model = GrafoDirecionadoDiagramAdapter.adapt(grafoDirecionado);
        for (int i = 0; i < qtdVertices; i++) {
            buttons.add(String.valueOf("V" + (i+1)));
        }


    }

    public void selecionarVertice(Element vertice) {
        this.verticeSelecionado = vertice;
        PrimeFaces.current().executeScript("PF('vtc').show()");
    }

    public void addConnection() {

            int oringemInt = Integer.parseInt(verticeSelecionado.getData().toString().replaceAll("V", ""))-1;
            int destinoInt = Integer.parseInt(verticeDestino.replaceAll("V", ""))-1;
            PrimeFaces.current().ajax().update(":form2:diagram"); // Atualiza o diagrama após a conexão
            grafoDirecionado.adicionarAresta(oringemInt, destinoInt);
            model = GrafoDirecionadoDiagramAdapter.adapt(grafoDirecionado);
            System.out.println("Conexão adicionada entre " + verticeSelecionado.getData() + " e " + verticeDestino);

    }


}