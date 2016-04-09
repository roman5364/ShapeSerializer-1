package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.ListOfShapes;
import ua.codegym.serializer.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

public class GroupJsonSerializer implements Serializer {

  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    Group group = (Group) shape;
    int num = group.getShapes().size();
    int count = 0;
    os.write("{\"group\": [".getBytes());
    for (Shape innerShape: group.getShapes()) {
      String type = innerShape.getType() + "JSON";
      Serializer serializer = ListOfShapes.getShapesMap().get(type);
      serializer.serialize(innerShape,os);
      count++;
      if (count < num) os.write(",".getBytes());
    }
    os.write("]}".getBytes());

  }
}

