package org.dailycodingproblem._1803;

public class DualSingleton {
  private DualSingleton() {}

  private static DualSingleton firstInstance = null;
  private static DualSingleton secondInstance = null;
  private static Integer callCount = 0;

  public static DualSingleton getInstance() {
    callCount++;

    if (callCount % 2 == 0) {
      return getFirstInstance();
    }

    return getSecondInstance();
  }

  private static DualSingleton getFirstInstance() {
    if (firstInstance == null) {
      firstInstance = new DualSingleton();
    }

    return firstInstance;
  }

  private static DualSingleton getSecondInstance() {
    if (secondInstance == null) {
      secondInstance = new DualSingleton();
    }

    return secondInstance;
  }

  public static void resetCallCount() {
    callCount = 0;
  }
}
