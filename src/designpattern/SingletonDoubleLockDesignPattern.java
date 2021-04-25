package designpattern;

public class SingletonDoubleLockDesignPattern {

  private SingletonDoubleLockDesignPattern singletonDoubleLockDesignPattern;

  private SingletonDoubleLockDesignPattern() {}

  @Override
  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  public SingletonDoubleLockDesignPattern getSingletonDoubleLockDesignPattern() {
    if (singletonDoubleLockDesignPattern == null) {
      synchronized (SingletonDoubleLockDesignPattern.class) {
        if (singletonDoubleLockDesignPattern == null) {
          singletonDoubleLockDesignPattern = new SingletonDoubleLockDesignPattern();
        }
      }
    }
    return this.singletonDoubleLockDesignPattern;
  }
}
