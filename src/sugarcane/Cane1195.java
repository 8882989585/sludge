package sugarcane;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class cane1195 {
  private int n;
  Semaphore sem1 = new Semaphore(0);
  Semaphore sem2 = new Semaphore(0);
  Semaphore sem3 = new Semaphore(0);
  Semaphore sem4 = new Semaphore(1);

  public cane1195(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    for(int i=3;i<=n;i=i+3) {
      if(i%5!=0) {
        sem1.acquire();
        printFizz.run();
        sem4.release();
      }
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    for(int i=5;i<=n;i=i+5) {
      if(i%3!=0) {
        sem2.acquire();
        printBuzz.run();
        sem4.release();
      }
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    for(int i=15;i<=n;i=i+15) {
      sem3.acquire();
      printFizzBuzz.run();
      sem4.release();
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    for(int i=1;i<=n;i=i+1) {
      sem4.acquire();
      if(i%15==0) {
        sem3.release();
      } else if(i%5==0) {
        sem2.release();
      } else if(i%3==0) {
        sem1.release();
      } else {
        printNumber.accept(i);
        sem4.release();
      }
    }
  }
}
