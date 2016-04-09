package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class GroupJsonSerializer implements Serializer {

  private Map<String, Serializer> object = new HashMap<>();

  public GroupJsonSerializer() {
    object.put(Circle.class.getCanonicalName(), new CircleJsonSerializer());
    object.put(Group.class.getCanonicalName(), this);
    object.put(Triangle.class.getCanonicalName(), new TriangleJsonSerializer());
    object.put(Square.class.getCanonicalName(),new SquareJsonSerializer());
  }

  @Override
  public void serialize(Shape shape, OutputStream outputStream) throws IOException {
    Group group = (Group) shape;
    int num = group.getShapes().size();
    int count = 0;
    outputStream.write("{\"group\" : [".getBytes());
    for (Shape innerShape : group.getShapes()) {

      Serializer serializer = object.get(innerShape.getType());
      serializer.serialize(innerShape, outputStream);
      count++;
      if (count < num) outputStream.write(",".getBytes());
    }
    outputStream.write("]}".getBytes());
  }

}

