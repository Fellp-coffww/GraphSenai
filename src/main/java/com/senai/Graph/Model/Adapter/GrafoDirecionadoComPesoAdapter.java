package com.senai.Graph.Model.Adapter;

import com.senai.Graph.Model.Entities.Edge;
import com.senai.Graph.Model.Entities.GrafoDirecionadoComPeso;
import com.senai.Graph.Model.Entities.Graph;
import org.primefaces.component.diagram.Diagram;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;

import java.util.List;
import java.util.Random;

public class GrafoDirecionadoComPesoAdapter {

    public static DefaultDiagramModel adapt(Graph gd){

        DefaultDiagramModel model = new DefaultDiagramModel();
        Random random = new Random();
        model.getDefaultConnectionOverlays().add(new ArrowOverlay(20, 20, 1, 1));

        if(gd.getEdgesList().size() <  0){
            return null;
        }
        else{

            for (int i = 0; i < gd.getEdgesList().size(); i++) {

                Element vertice = new Element("V" + (i+1),random.nextInt((800-20)+1)+20+"px", random.nextInt((800-20)+1)+20 +"px");
                model.addElement(vertice);
                vertice.addEndPoint(new DotEndPoint(EndPointAnchor.AUTO_DEFAULT));
                vertice.addEndPoint(new DotEndPoint(EndPointAnchor.AUTO_DEFAULT));

            }

            for (int i = 0; i < gd.getEdgesList().size(); i++) {

                for (Edge edge : gd.getEdgesList().get(i)) {

                    Connection connection = new Connection(model.getElements().get(edge.getSource()).getEndPoints().get(0), model.getElements().get(edge.getDestination()).getEndPoints().get(1));
                    connection.getOverlays().add(new LabelOverlay(String.valueOf(edge.getWeight()), "flow-label", 0.5));
                    connection.setConnector(new StraightConnector());
                    model.connect(connection);


                }
            }
        }

        return model;
    }


}
