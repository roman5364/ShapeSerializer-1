package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

public class CircleJsonSerializer implements Serializer {

  @Override
  public void serialize(Shape shape, OutputStream outputStream) throws IOException {
    Circle circle = (Circle) shape;
    int x = circle.getX();
    int y = circle.getY();
    int radius = circle.getRadius();
    String out = String.format("{\"nameOfShape\": \"Circle\",\"properties\": {\"x\": %d,\"y\": %d,\"radius\": %d}}", x, y,radius);
    outputStream.write(out.getBytes());
  }
}
