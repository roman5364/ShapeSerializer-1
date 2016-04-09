package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Square;

import java.io.IOException;
import java.io.OutputStream;

public class SquareJsonSerializer implements Serializer {

  @Override
  public void serialize(Shape shape, OutputStream outputStream) throws IOException {
    Square square = (Square) shape;
    int x = square.getX();
    int y = square.getY();
    int side = square.getSide();
    String out = String.format("{\"nameOfShape\": \"Square\",\"parameters\": {\"x\": %d,\"y\": %d,\"side\": %d}}", x, y,side);
    outputStream.write(out.getBytes());
  }
}
