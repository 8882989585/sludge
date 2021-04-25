package designpattern;

interface Drivable {
  void drives();
}

interface Driftable {
  void drifts();
}

class DriverDDP implements Drivable {
  String name;

  public DriverDDP(String name) {
    this.name = name;
  }

  @Override
  public void drives() {
    System.out.println(this.name + " drives at 100kmph");
  }
}

class DriverDDPDecorator implements Driftable, Drivable {

  DriverDDP driverDDP;

  public DriverDDPDecorator(DriverDDP driverDDP) {
    this.driverDDP = driverDDP;
  }

  @Override
  public void drifts() {
    System.out.println(driverDDP.name + " can also drift it.");
  }

  @Override
  public void drives() {
    driverDDP.drives();
  }
}

public class DecoratorDesignPattern {

  public static void main(String[] args) {
    //
    DriverDDPDecorator driverDDPDecorator = new DriverDDPDecorator(new DriverDDP("Abhishek"));
    ((Drivable) driverDDPDecorator).drives();
    ((Driftable) driverDDPDecorator).drifts();
  }
}
