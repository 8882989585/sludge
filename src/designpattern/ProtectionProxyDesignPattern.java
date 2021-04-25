package designpattern;

interface DrivablePPDP {
  void drives();
}

class DriverPPDP implements DrivablePPDP {
  String name;

  public DriverPPDP(String name) {
    this.name = name;
  }

  @Override
  public void drives() {
    System.out.println(name + " drives a SUV.");
  }
}

class DriverPDPPProxy extends DriverPPDP {

  int age;

  public DriverPDPPProxy(int age, String name) {
    super(name);
    this.age = age;
  }

  @Override
  public void drives() {
    if (age > 18) {
      super.drives();
    } else {
      System.out.println("Proxy stopped from driving due to age");
    }
  }
}

public class ProtectionProxyDesignPattern {

    public static void main(String[] args){
        DriverPPDP driverPPDP1 = new DriverPDPPProxy(29, "Abhishek");
        driverPPDP1.drives();
        DriverPPDP driverPPDP2 = new DriverPDPPProxy(17, "Shalu");
        driverPPDP2.drives();
    }

}
