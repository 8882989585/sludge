package multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

  public static void main(String[] args) {
    //
    Meeting meeting = new Meeting(5);
    for (int i = 0; i < 2; i++) {
      new Thread(new Philosophers(meeting)).start();
    }
  }
}

class Meeting {
  Semaphore[] forkLocks;
  ReentrantLock lock = new ReentrantLock();
  Condition condition = lock.newCondition();

  public Meeting(int noOfPhilosophers) {
    this.forkLocks = new Semaphore[noOfPhilosophers];
    for (int i = 0; i < noOfPhilosophers; i++) {
      this.forkLocks[i] = new Semaphore(1);
    }
  }

  public void eatFood(int philosopherNo) throws InterruptedException {
    lock.lock();
    Semaphore semaphore1 = forkLocks[philosopherNo == 0 ? forkLocks.length - 1 : philosopherNo - 1];
    Semaphore semaphore2 = forkLocks[philosopherNo == forkLocks.length - 1 ? 0 : philosopherNo + 1];
    while (semaphore1.availablePermits() == 0 || semaphore2.availablePermits() == 0) {
      condition.await();
    }
    semaphore1.acquire();
    semaphore2.acquire();
    System.out.println("Philosopher no " + philosopherNo + " eating");
    condition.signal();
    lock.unlock();
  }

  public void contemplate(int philosopherNo) {
    lock.lock();
    Semaphore semaphore1 = forkLocks[philosopherNo == 0 ? forkLocks.length - 1 : philosopherNo - 1];
    Semaphore semaphore2 = forkLocks[philosopherNo == forkLocks.length - 1 ? 0 : philosopherNo + 1];
    if (semaphore1.availablePermits() == 0 && semaphore1.availablePermits() == 0) {
      System.out.println("Philosopher no " + philosopherNo + " contemplating");
      semaphore1.release();
      semaphore2.release();
    }
    lock.unlock();
  }
}

class Philosophers implements Runnable {

  Meeting meeting;

  public Philosophers(Meeting meeting) {
    this.meeting = meeting;
  }

  @Override
  public void run() {
    try {
      while (true) {
        int n = (int) ((Math.random() * (5 - 1)) + 1);
        meeting.eatFood(n);
        Thread.sleep(5000);
        meeting.contemplate(n);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
