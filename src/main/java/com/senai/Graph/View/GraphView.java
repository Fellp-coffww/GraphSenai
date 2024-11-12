package com.senai.Graph.View;


import com.senai.Graph.Model.Adapter.GrafoDirecionadoComPesoAdapter;
import com.senai.Graph.Model.Adapter.GrafoDirecionadoDiagramAdapter;
import com.senai.Graph.Model.Adapter.GrafoNaoDirecionadoAdapter;
import com.senai.Graph.Model.Entities.GrafoDirecionado;
import com.senai.Graph.Model.Entities.GrafoDirecionadoComPeso;
import com.senai.Graph.Model.Entities.GrafoNaoDirecionado;
import com.senai.Graph.Model.Entities.Graph;
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
import javax.print.attribute.standard.PrintQuality;
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
    private GrafoNaoDirecionado grafoNaoDirecionado;
    private Graph grafoDirecionadoComPeso;
    private DefaultDiagramModel model;
    private DefaultDiagramModel model1;
    private DefaultDiagramModel model2;
    private Integer qtdVertices;
    private Element verticeSelecionado;
    private List<String> buttons;
    private String verticeDestino;
    public Integer pesoVertice = 0;
    private String largeTextData;
    private int grauAtual;


    private boolean direcionado; // define o tipo do grafo
    private boolean comPeso; // define o tipo do grafo

    @PostConstruct
    public void init() {
        qtdVertices = 0; // Inicializar o valor para evitar nulos, caso necessário
        verticeSelecionado = new Element();
        buttons = new ArrayList<>();

        }

    public void actionBotaoNewGraph() {

        if(direcionado && comPeso){

            grafoDirecionadoComPeso = new Graph(qtdVertices);
            model = GrafoDirecionadoComPesoAdapter.adapt(grafoDirecionadoComPeso);

        }else if(direcionado && !comPeso){
            grafoDirecionado = new GrafoDirecionado(qtdVertices);
            model = GrafoDirecionadoDiagramAdapter.adapt(grafoDirecionado);

        }else if(!comPeso && !direcionado){

            grafoNaoDirecionado = new GrafoNaoDirecionado(qtdVertices);
            model = GrafoNaoDirecionadoAdapter.adapt(grafoNaoDirecionado);
        }
        buttons.clear();
        for (int i = 0; i < qtdVertices; i++) {
            buttons.add(String.valueOf("V" + (i+1)));
        }
    }

    public void selecionarVertice(Element vertice) {
        this.verticeSelecionado = vertice;
        int oringemInt = Integer.parseInt(verticeSelecionado.getData().toString().replaceAll("V", ""))-1;
        if(direcionado && comPeso){

            grauAtual = grafoDirecionadoComPeso.calcularGrauVertice(oringemInt);

        }else if(direcionado && !comPeso){

            grauAtual = grafoDirecionado.calcularGrauEntrada(oringemInt);

        }else if(!comPeso && !direcionado){

            grauAtual = grafoNaoDirecionado.calcularGrauVertice(oringemInt);
        }
        PrimeFaces.current().executeScript("PF('vtc').show()");
    }

    public void addConnection() {

            int oringemInt = Integer.parseInt(verticeSelecionado.getData().toString().replaceAll("V", ""))-1;
            int destinoInt = Integer.parseInt(verticeDestino.replaceAll("V", ""))-1;
           // PrimeFaces.current().ajax().update(":form2:diagram"); // Atualiza o diagrama após a conexão

            if(direcionado && comPeso){

                grafoDirecionadoComPeso.addEdge(oringemInt, destinoInt, pesoVertice);
                model = GrafoDirecionadoComPesoAdapter.adapt(grafoDirecionadoComPeso);
                largeTextData = grafoDirecionadoComPeso.getMatrizAdjacencia();


            }else if(direcionado && !comPeso){

                grafoDirecionado.adicionarAresta(oringemInt, destinoInt);
                model = GrafoDirecionadoDiagramAdapter.adapt(grafoDirecionado);
                largeTextData = grafoDirecionado.gerarMatrizDeConexoes();

            }else if(!comPeso && !direcionado){

                grafoNaoDirecionado.adicionarAresta(oringemInt, destinoInt, 1);
                model = GrafoNaoDirecionadoAdapter.adapt(grafoNaoDirecionado);
                largeTextData = grafoNaoDirecionado.getMatrizAdjacenciaBiuld();
            }

            System.out.println("Conexão adicionada entre " + verticeSelecionado.getData() + " e " + verticeDestino);

    }

    public void btnMatrizAction(){



    }


}