package ua.codegym.serializer.xml.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;

import java.io.IOException;
import java.io.OutputStream;

public class XmlSerializer implements Serializer {

    public void serialize(Shape shape, OutputStream outputStream) throws IOException {

      String type = shape.getType();
      if(type.equals(Square.class.getCanonicalName())){
        Square square = (Square) shape;
        int x = square.getX();
        int y = square.getY();
        int side = square.getSide();
        String out = String.format("<square x=\"%d\" y=\"%d\" side=\"%d\"></square>",x,y,side);
        outputStream.write(out.getBytes());
      }
      if(type.equals(Circle.class.getCanonicalName())){
        Circle circle = (Circle) shape;
        int x;
        x = circle.getX();
        int y;
        y = circle.getY();
        int radius = circle.getRadius();
        String out = String.format("<circle x=\"%d\" y=\"%d\" radius=\"%d\"></circle>",x,y,radius);
        outputStream.write(out.getBytes());
      }

    }
}
