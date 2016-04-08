package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Triangle;

import java.io.IOException;
import java.io.OutputStream;

public class TriangleJsonSerializer implements Serializer {

  @Override
  public void serialize(Shape shape, OutputStream outputStream) throws IOException {
    Triangle triangle = (Triangle) shape;
    int xA;
    xA = triangle.getxA();
    int yA;
    yA = triangle.getyA();
    int xB;
    xB = triangle.getxB();
    int yB;
    yB = triangle.getyB();
    int xC;
    xC = triangle.getxC();
    int yC;
    yC = triangle.getyC();

    String out = String.format("{\"nameOfShape\": \"Triangle\",\"properties\": {\"xA\": %d,\"yA\": %d,\"xB\": %d,\"yB\": %d,\"xC\": %d,\"yC\": %d}}", xA, yA, xB, yB, xC, yC);
    outputStream.write(out.getBytes());
  }

}
