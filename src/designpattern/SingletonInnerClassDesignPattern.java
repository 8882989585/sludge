package designpattern;

public class SingletonInnerClassDesignPattern {

  private SingletonInnerClassDesignPattern() {}

  static class InnerClass {
    SingletonInnerClassDesignPattern singletonInnerClassDesignPattern =
        new SingletonInnerClassDesignPattern();

    public SingletonInnerClassDesignPattern getSingletonInnerClassDesignPattern() {
      return singletonInnerClassDesignPattern;
    }
  }
}
