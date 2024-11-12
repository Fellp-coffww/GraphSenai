package com.senai.Graph.Model.Adapter;

import com.senai.Graph.Model.Entities.GrafoNaoDirecionado;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

import java.util.Random;

public class GrafoNaoDirecionadoAdapter {

    public static DefaultDiagramModel adapt(GrafoNaoDirecionado gd){

        StraightConnector connector = new StraightConnector();
        connector.setPaintStyle("{stroke:'#404a4e', strokeWidth:3}");
        connector.setHoverPaintStyle("{stroke:'#20282b'}");
        Random random = new Random();


        DefaultDiagramModel model = new DefaultDiagramModel();
        model.setMaxConnections(-1);

        for (int i = 0; i < gd.getNumVertices(); i++) {
            Element vertice = new Element("V" + (i+1),random.nextInt((800-20)+1)+20+"px", random.nextInt((800-20)+1)+20 +"px");
            model.addElement(vertice);
            vertice.addEndPoint(new DotEndPoint(EndPointAnchor.AUTO_DEFAULT));
            vertice.addEndPoint(new DotEndPoint(EndPointAnchor.AUTO_DEFAULT));
            vertice.addEndPoint(new DotEndPoint(EndPointAnchor.AUTO_DEFAULT));
            vertice.addEndPoint(new DotEndPoint(EndPointAnchor.AUTO_DEFAULT));
            vertice.addEndPoint(new DotEndPoint(EndPointAnchor.AUTO_DEFAULT));

        }

        for (int i = 0; i < gd.getMatrizAdjacencia().length; i++) {

            for (int j = 0; j < gd.getMatrizAdjacencia()[i].length; j++) {

                if (gd.getMatrizAdjacencia()[i][j] > 0) {

                    Connection connection = new Connection(model.getElements().get(i).getEndPoints().get(0),
                            model.getElements().get(j).getEndPoints().get(0),connector);
                    connection.setConnector(new StraightConnector());
                    model.connect(connection);



                }

            }

        }

        return model;

    }

}
