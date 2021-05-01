package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerReentrantLock {

  public static void main(String[] args) {
    //
    ProducerConsumerReentrantLock producerConsumerReentrantLock =
        new ProducerConsumerReentrantLock();
    producerConsumerReentrantLock.runner();
  }

  public void runner() {
    Items items = new Items();
    Thread thread1 = new Thread(new Consumer(items));
    Thread thread2 = new Thread(new Producer(items));
    thread2.start();
    thread1.start();
  }

  class Items {
    int count = 0;
    int capacity = 10;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition1 = reentrantLock.newCondition();
    Condition condition2 = reentrantLock.newCondition();

    public void produce() {
      reentrantLock.lock();
      while (capacity == 0) {
        try {
          condition1.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      capacity--;
      System.out.println(++count);
      condition2.signal();
      reentrantLock.unlock();
    }

    public void consume() {
      reentrantLock.lock();
      while (capacity == 10) {
        try {
          condition2.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      capacity++;
      System.out.println(count);
      condition1.signal();
      reentrantLock.unlock();
    }
  }

  class Producer implements Runnable {

    Items items;

    public Producer(Items items) {
      this.items = items;
    }

    @Override
    public void run() {
      while (true) {
        items.produce();
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  class Consumer implements Runnable {

    Items items;

    public Consumer(Items items) {
      this.items = items;
    }

    @Override
    public void run() {
      while (true) {
        items.consume();
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
