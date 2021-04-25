package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class Shop {
  int maxCapacity;
  int noOfCustomerAtTheTime = 0;
  int customerNo = 0;
  ReentrantLock lock = new ReentrantLock();
  List<Integer> queue = new ArrayList<>();

  public Shop(int maxCapacity) {
    this.maxCapacity = maxCapacity;
  }

  public void getHaircut() throws InterruptedException {
    lock.lock();
    if (noOfCustomerAtTheTime > 0) {
      int t = queue.remove(0);
      noOfCustomerAtTheTime--;
      System.out.println(t + "done with haircut");
    }
    lock.unlock();
  }

  public void getInQueueForHaircut() throws InterruptedException {
    lock.lock();
    customerNo++;
    if (noOfCustomerAtTheTime == maxCapacity) {
      System.out.println("Customer no " + customerNo + "turned away");
      lock.unlock();
      return;
    }
    System.out.println(customerNo + " added to queue" + ++noOfCustomerAtTheTime);
    queue.add(customerNo);
    lock.unlock();
  }
}

class PersonBarberShop implements Runnable {

  Shop shop;

  public PersonBarberShop(Shop shop) {
    this.shop = shop;
  }

  @Override
  public void run() {
    try {
      while (true) {
        shop.getInQueueForHaircut();
        Thread.sleep((int) ((Math.random() * (4000 - 1000)) + 1000));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class PersonBarberShop1 implements Runnable {

  Shop shop;

  public PersonBarberShop1(Shop shop) {
    this.shop = shop;
  }

  @Override
  public void run() {
    try {
      while (true) {
        shop.getHaircut();
        Thread.sleep((int) ((Math.random() * (2000 - 1000)) + 1000));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

public class BarberShop {

  public static void main(String[] args) {

    Shop shop = new Shop(5);

    for (int i = 0; i < 5; i++) {
      new Thread(new PersonBarberShop(shop)).start();
    }

    new Thread(new PersonBarberShop1(shop)).start();
  }
}
