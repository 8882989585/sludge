package designpattern;

public class PropertyProxy {


  public static void main(String[] args) {
  }

  class Impl {
      private Property<String> s;

      public Impl(Property<String> s) {
          this.s = s;
      }
  }

  class Property<T> {
    private T property;

    public Property(T property) {
        System.out.println("property value initialised");
      this.property = property;
    }

    public T getProperty() {
      return property;
    }

    public Property<T> setProperty(T property) {
      System.out.println("property value is getting change");
      this.property = property;
      return this;
    }
  }
}
