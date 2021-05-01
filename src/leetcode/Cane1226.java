package leetcode;

import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Cane1226 {

  HashMap<Integer, Semaphore> map;
  ReentrantLock reentrantLock = new ReentrantLock();
  Condition condition = reentrantLock.newCondition();

  public Cane1226() {
    map = new HashMap<>(5);
    for (int i = 0; i < 5; i++) {
      map.put(i, new Semaphore(1));
    }
  }

  public void wantsToEat(
      int philosopher,
      Runnable pickLeftFork,
      Runnable pickRightFork,
      Runnable eat,
      Runnable putLeftFork,
      Runnable putRightFork)
      throws InterruptedException {
    reentrantLock.lock();
    Semaphore semaphore1;
    Semaphore semaphore2;
    if (philosopher == 0) {
      semaphore1 = map.get(4);
    } else {
      semaphore1 = map.get(philosopher - 1);
    }
    semaphore2 = map.get(philosopher);
    while (semaphore1.availablePermits() == 0 || semaphore2.availablePermits() == 0) {
      condition.await();
    }
    semaphore1.acquire();
    semaphore2.acquire();
    pickRightFork.run();
    pickLeftFork.run();
    eat.run();
    putRightFork.run();
    putLeftFork.run();
    condition.signal();
    semaphore2.release();
    semaphore1.release();
    reentrantLock.unlock();
  }
}
