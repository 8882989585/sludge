package multithreading;

import java.util.concurrent.Semaphore;

public class ProducerConsumerSemaphore {

  public static void main(String[] args) {
    //
    ProducerConsumerSemaphore producerConsumerSemaphore = new ProducerConsumerSemaphore();
    producerConsumerSemaphore.runner();
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
    Semaphore semaphore = new Semaphore(1);

    public void produce() {
      try {
        if (capacity > 0) {
          semaphore.acquire();
          capacity--;
          System.out.println(++count);
          semaphore.release();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    public void consume() {

      try {
        if (capacity < 10) {
          semaphore.acquire();
          capacity++;
          System.out.println(count);
          semaphore.release();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
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
