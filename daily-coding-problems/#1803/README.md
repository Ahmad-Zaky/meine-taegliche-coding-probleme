# This problem was asked by Microsoft.

## Description

Implement the singleton pattern with a twist. First, instead of storing one instance, store two instances. And in every even call of `getInstance()`, return the first instance and in every odd call of `getInstance()`, return the second instance.

## Solution

```java
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

public class Main {
  public static void main(String[] args) {
    DualSingleton instance1 = DualSingleton.getInstance();
    DualSingleton instance2 = DualSingleton.getInstance();
    DualSingleton instance3 = DualSingleton.getInstance();

    System.out.println(instance1 == instance2);
    System.out.println(instance1 == instance3);
  }
}
```