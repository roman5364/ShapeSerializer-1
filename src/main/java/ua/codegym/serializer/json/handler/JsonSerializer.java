package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.Circle;
import ua.codegym.serializer.shape.Group;
import ua.codegym.serializer.shape.Shape;
import ua.codegym.serializer.shape.Triangle;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer implements Serializer {

  Map<String, Serializer> objects = new HashMap<>();

  public JsonSerializer() {
    objects.put(Triangle.class.getCanonicalName(), new TriangleJsonSerializer());
    objects.put(Circle.class.getCanonicalName(), new CircleJsonSerializer());
    objects.put(Group.class.getCanonicalName(), new GroupJsonSerializer());
  }

  public void serialize(Shape shape, OutputStream outputStream) throws IOException {
    Serializer triangleJsonSerializer = new TriangleJsonSerializer();
    triangleJsonSerializer.serialize(shape, outputStream);
  }

}
