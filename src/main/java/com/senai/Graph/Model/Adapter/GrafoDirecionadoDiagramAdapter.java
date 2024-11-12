package com.senai.Graph.Model.Adapter;

import com.senai.Graph.Model.Entities.GrafoDirecionado;
import org.primefaces.component.diagram.Diagram;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.FlowChartConnector;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrafoDirecionadoDiagramAdapter {


    public static DefaultDiagramModel adapt(GrafoDirecionado gd){

        StraightConnector connector = new StraightConnector();
        connector.setPaintStyle("{stroke:'#404a4e', strokeWidth:3}");
        connector.setHoverPaintStyle("{stroke:'#20282b'}");
        Random random = new Random();

        DefaultDiagramModel model = new DefaultDiagramModel();
        model.getDefaultConnectionOverlays().add(new ArrowOverlay(20, 20, 1, 1)); // seta para grafos direcionados

        if(gd.getVertices() <  0){
            return null;
        }
        else{

            for (int i = 0; i < gd.getVertices(); i++) {

                Element vertice = new Element("V" + (i+1),random.nextInt((800-20)+1)+20+"px", random.nextInt((800-20)+1)+20 +"px");
                model.addElement(vertice);
                vertice.addEndPoint(new DotEndPoint(EndPointAnchor.AUTO_DEFAULT));
                vertice.addEndPoint(new DotEndPoint(EndPointAnchor.AUTO_DEFAULT));

            }

            int loop = 0;

            for (List<Integer> list : gd.getArestas()){

                    for (Integer integer : list){

                        Connection connection = new Connection(model.getElements().get(loop).getEndPoints().get(0), model.getElements().get(integer).getEndPoints().get(1),connector);
                        connection.setConnector(new StraightConnector());
                        model.connect(connection);

                    }
                loop = loop + 1;
            }

        }

        return model;

    }


}
