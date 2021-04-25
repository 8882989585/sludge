package designpattern;

interface BirdADP {
  void fly();

  void makeNoise();
}

interface ToyADP {
  void squeak();
}

class SparrowADP implements BirdADP {

  @Override
  public void fly() {
    System.out.println("fly at low speed");
  }

  @Override
  public void makeNoise() {
    System.out.println("Singing in melodious voice");
  }
}

class ToyADPBirdAdapter implements ToyADP {

  BirdADP birdADP;

  public ToyADPBirdAdapter(BirdADP birdADP) {
    this.birdADP = birdADP;
  }

  @Override
  public void squeak() {
    birdADP.makeNoise();
  }
}

public class AdapterDesignPattern {
  public static void main(String[] args) {
    ToyADP toyADP = new ToyADPBirdAdapter(new SparrowADP());
    toyADP.squeak();
  }
}
