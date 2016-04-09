package ua.codegym.serializer.json.handler;

import ua.codegym.serializer.Serializer;
import ua.codegym.serializer.shape.*;

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
    objects.put(Square.class.getCanonicalName(),new SquareJsonSerializer());
  }

  public void serialize(Shape shape, OutputStream outputStream) throws IOException {
    Serializer triangleJsonSerializer = new TriangleJsonSerializer();
    triangleJsonSerializer.serialize(shape, outputStream);

    Serializer circleJsonSerializer = new CircleJsonSerializer();
    circleJsonSerializer.serialize(shape,outputStream);
    
    Serializer groupJsonSerializer = new GroupJsonSerializer();
    groupJsonSerializer.serialize(shape,outputStream);
    
    Serializer squareJsonSerializer = new SquareJsonSerializer();
    squareJsonSerializer.serialize(shape,outputStream);
  }

}
