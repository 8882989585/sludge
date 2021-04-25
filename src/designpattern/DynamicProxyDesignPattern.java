package designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

interface Human {
  void talk();

  void walk();
}

class Person implements Human {

  @Override
  public void talk() {
    System.out.println("I am talking");
  }

  @Override
  public void walk() {
    System.out.println("I am walking");
  }
}

class loggingHandler implements InvocationHandler {

  Object target;
  Map<String, Integer> counter = new HashMap<>();

  public loggingHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
    String methodName = method.getName();
    if (methodName.contains("toString")) {
      System.out.println(counter.toString());
    }
    counter.merge(methodName, 1, Integer::sum);
    return method.invoke(target, objects);
  }
}

public class DynamicProxyDesignPattern {

  public static void main(String[] args) {
    //
      DynamicProxyDesignPattern dynamicProxyDesignPattern = new DynamicProxyDesignPattern();
      Person person = new Person();
      Human human = dynamicProxyDesignPattern.getProxy(person, Human.class);
      human.talk();
      human.talk();
      human.walk();
      human.toString();
  }

  public <T> T getProxy(Object target, Class<T> tClass) {
    return (T)
        Proxy.newProxyInstance(
            tClass.getClassLoader(), new Class<?>[] {tClass}, new loggingHandler(target));
  }
}
