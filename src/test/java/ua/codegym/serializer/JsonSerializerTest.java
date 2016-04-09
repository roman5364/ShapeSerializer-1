package ua.codegym.serializer;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ua.codegym.serializer.shape.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class JsonSerializerTest {

  @Test
  public void serializeSquareToJsonTest() throws IOException {
    //given
    Shape shape = new Square(2, 3, 5);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    Assert.assertEquals("{\"nameOfShape\": \"Square\",\"properties\": {\"x\": 2,\"y\": 3,\"size\": 5}}", output);
  }

  @Test
  public void serializeCircleToJsonTest() throws IOException {
    //given
    Shape shape = new Circle(2, 3, 5);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    Assert.assertEquals("{\"nameOfShape\": \"Circle\",\"properties\": {\"x\": 0,\"y\": 1,\"radius\": 5}}", output);
  }

  @Test
  public void serializeTriangleToJsonTest() throws IOException {
    //given
    Shape shape = new Triangle(2, 2, 3, 3, 4, 4);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(shape, out);

    //then
    String output = new String(out.toByteArray());
    Assert.assertEquals("{\"nameOfShape\": \"Triangle\",\"properties\": {\"xA\": 2,\"yA\": 2,\"xB\": 3,\"yB\": 3,\"xC\": 4,\"yC\": 4}}", output);
  }

  @Ignore
  @Test
  public void serializeGroupToJsonTest() throws IOException {
    //given
    Group shape = new Group();
    shape.add(new Triangle(2, 2, 3, 3, 4, 4));
    shape.add(new Circle(0, 1, 5));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(shape, out);

    //then
    String output = new String(out.toByteArray());
    Assert.assertEquals("{\"group\": [{\"nameOfShape\": \"Triangle\",\"properties\": {\"xA\": 2,\"yA\": 2,\"xB\": 3,\"yB\": 3,\"xC\": 4,\"yC\": 4}},{\"nameOfShape\": \"Circle\",\"properties\": {\"x\": 0,\"y\": 1,\"radius\": 5}}]}", output);
  }

}
