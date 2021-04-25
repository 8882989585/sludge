package designpattern;

class PropertyProxy<T> {

  private final String name;
  private T value;

  public PropertyProxy(String name) {
    this.name = name;
  }

  public T getValue() {
      System.out.println(this.name + " has value " + this.value.toString());
    return value;
  }

  public PropertyProxy<T> setValue(T value) {
    System.out.println(this.name + " being set to " + value.toString());
    this.value = value;
    return this;
  }
}

public class PropertyProxyDesignPattern {
  public static void main(String[] args) {
    //
      PropertyProxy<String> driverName = new PropertyProxy<>("driverName");
      driverName.setValue("Akash");
      driverName.setValue("Vipin");
      driverName.getValue();
  }
}
