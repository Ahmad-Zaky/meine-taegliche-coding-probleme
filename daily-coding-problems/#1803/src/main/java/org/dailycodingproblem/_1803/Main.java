package org.dailycodingproblem._1803;

public class Main {
  public static void main(String[] args) {
    DualSingleton instance1 = DualSingleton.getInstance();
    DualSingleton instance2 = DualSingleton.getInstance();
    DualSingleton instance3 = DualSingleton.getInstance();

    System.out.println(instance1 == instance2);
    System.out.println(instance1 == instance3);
  }
}