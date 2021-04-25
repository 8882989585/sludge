package designpattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class EventODP<T> {

  int count = 0;
  Map<Integer, Consumer<T>> subscribers = new HashMap<>();

  public Subscription subscribe(Consumer<T> consumer) {
    subscribers.put(count, consumer);
    return new Subscription(count++);
  }

  public void broadcast(T eventODP) {
    subscribers.values().forEach(x -> x.accept(eventODP));
  }

  class Subscription implements AutoCloseable {
    int counter;

    public Subscription(int counter) {
      this.counter = counter;
    }

    @Override
    public void close() throws Exception {
      subscribers.remove(counter);
    }
  }
}

class PropertyChangeEventODP {
    String name;
    Object value;

    public PropertyChangeEventODP(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "PropertyChangeEventODP{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}

class PersonODP {

    EventODP<PropertyChangeEventODP> propertiesChangeEventEvent = new EventODP<>();

    String name;
    String age;

    public String getName() {
        return name;
    }

    public PersonODP setName(String name) {
        this.name = name;
        propertiesChangeEventEvent.broadcast(new PropertyChangeEventODP("name", name));
        return this;
    }

    public String getAge() {
        return age;
    }

    public PersonODP setAge(String age) {
        this.age = age;
        propertiesChangeEventEvent.broadcast(new PropertyChangeEventODP("age", age));
        return this;
    }
}

public class ObserverDesignPattern {

  public static void main(String[] args) {
    //
      PersonODP personODP = new PersonODP();
      personODP.setAge("19");
      personODP.propertiesChangeEventEvent.subscribe(propertiesChangeEvent -> System.out.println(propertiesChangeEvent.toString()));
      personODP.setAge("67");
      personODP.setAge("89");
      personODP.setName("granny");
  }
}
