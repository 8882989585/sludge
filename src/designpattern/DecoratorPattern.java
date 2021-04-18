package designpattern;

public class DecoratorPattern {

  interface volume {
    int calculate();
  }

  class _2DObject implements volume {
    int l;
    int b;

    @Override
    public int calculate() {
      return l * b;
    }
  }

  class _3DObject implements volume {
    _2DObject _2dObject;
    int h;

    @Override
    public int calculate() {
      return _2dObject.calculate() * h;
    }
  }
}
