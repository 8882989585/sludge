package multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

enum Gender {
  MALE,
  FEMALE
}

class Bathroom {

  int noOfPerson = 0;
  Gender gender = Gender.MALE;

  ReentrantLock lock = new ReentrantLock();
  Condition condition1 = lock.newCondition();
  Condition condition2 = lock.newCondition();
  Semaphore peopleLock = new Semaphore(3);

  public void useWashRoom(Gender gender) throws InterruptedException {
    lock.lock();
    while (this.gender != gender && noOfPerson != 0) {
      condition1.await();
    }
    this.gender = gender;
    if (noOfPerson < 3) {
      peopleLock.acquire();
      noOfPerson++;
      System.out.println("doing pee pee!!! " + noOfPerson + "-" + gender);
      peopleLock.release();
    }
    if (noOfPerson == 0) {
      condition1.signal();
    }
    lock.unlock();
  }

  public void donePeeing() throws InterruptedException {
    lock.lock();
    while (noOfPerson == 0) {
      condition2.await();
    }
    System.out.println("done peeing " + noOfPerson--);
    lock.unlock();
  }
}

class People implements Runnable {

  Bathroom bathroom;

  public People(Bathroom bathroom) {
    this.bathroom = bathroom;
  }

  @Override
  public void run() {
    try {
      while (true) {
        bathroom.useWashRoom((int) (Math.random() + 0.5) == 0 ? Gender.MALE : Gender.FEMALE);
        Thread.sleep(5000);
        bathroom.donePeeing();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

public class UnisexBathroomProblem {

  public static void main(String[] args) throws InterruptedException {
    //
    Bathroom bathroom = new Bathroom();
    for (int i = 0; i < 2; i++) {
      new Thread(new People(bathroom)).start();
    }
  }
}
