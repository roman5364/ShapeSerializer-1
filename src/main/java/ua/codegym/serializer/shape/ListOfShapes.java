package ua.codegym.serializer.shape;

import ua.codegym.serializer.Serializer;

import java.util.HashMap;
import java.util.Map;

public class ListOfShapes {
  private static Map<String, Serializer> serializer = new HashMap<>();

  public static void addToShapesMap(String nameOfClass, Serializer method) {
    serializer.put(nameOfClass, method);
  }

  public static Map<String, Serializer> getShapesMap() {
    return serializer;
  }
}
