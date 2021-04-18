package designpattern;

public class ProtectionProxy {

  interface drivable {
    void drive();
  }

  class Driver {
    int age;

    public Driver(int age) {
      this.age = age;
    }
  }

  class Car implements drivable {

    Driver driver;

    @Override
    public void drive() {
      System.out.println("driver with age " + driver.age);
    }
  }

  class CarProxy extends Car {
    @Override
    public void drive() {
      if (driver.age < 18) {
        System.out.println("no driving allowed");
        return;
      }
      super.drive();
    }
  }

  public static void main(String[] args) {

  }
}
