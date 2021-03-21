package multithreading;

public class ProducerConsumerWaitNotify {

  public static void main(String[] args) {
    //
    ProducerConsumerWaitNotify producerConsumerWaitNotify = new ProducerConsumerWaitNotify();
    producerConsumerWaitNotify.runner();
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

    public synchronized void produce() {
      while (capacity == 0) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      capacity--;
      System.out.println(++count);
      notifyAll();
    }

    public synchronized void consume() {
      while (capacity == 10) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      capacity++;
      System.out.println(count);
      notifyAll();
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
