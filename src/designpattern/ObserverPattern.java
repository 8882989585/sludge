package designpattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class Event<T> {
  private final Map<Integer, Consumer<T>> map = new HashMap<>();
  private int count = 1;

  public Subscription subscribe(Consumer<T> consumer) {
    map.put(count, consumer);
    return new Subscription(this, count++);
  }

  public void broadCastEvent(T obj) {
    map.values().forEach(consumer -> consumer.accept(obj));
  }

  class Subscription implements AutoCloseable {
    Event<T> event;
    int id;

    public Subscription(Event<T> event, int id) {
      this.event = event;
      this.id = id;
    }

    @Override
    public void close() throws Exception {
      map.remove(id);
    }
  }
}

class PropertiesChangeEvent {
  Object value;
  String propertyName;

  public PropertiesChangeEvent(Object value, String propertyName) {
    this.value = value;
    this.propertyName = propertyName;
  }
}

class Person {

  int age;
  Event<PropertiesChangeEvent> propertyChangeEvent;

  public Person(int age, Event<PropertiesChangeEvent> propertyChangeEventEvent) {
    this.age = age;
    this.propertyChangeEvent = propertyChangeEventEvent;
  }

  public int getAge() {
    return age;
  }

  public Person setAge(int age) {
    this.age = age;
    propertyChangeEvent.broadCastEvent(new PropertiesChangeEvent(age, "age"));
    return this;
  }
}

public class ObserverPattern {

  public static void main(String[] args) {
    Event<PropertiesChangeEvent> event = new Event<>();
    Person person = new Person(10, event);
    event.subscribe(x -> System.out.println(x.value));
    person.setAge(10);
    person.setAge(89);
  }
}
