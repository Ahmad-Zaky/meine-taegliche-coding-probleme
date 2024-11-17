# Distinct (Easy)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/6-sorting/distinct/)

Write a function

`class Solution { public int solution(int[] A); }`

that, given an array A consisting of N integers, returns the number of distinct values in array A.

For example, given array A consisting of six elements such that:

A[0] = 2    A[1] = 1    A[2] = 1   
A[3] = 2    A[4] = 3    A[5] = 1   

the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..100,000];
* each element of array A is an integer within the range [−1,000,000..1,000,000].

## Solution #1

```java
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  public int solution(int[] A) {
    if (A.length == 0) {
      return 0; // No elements, so no distinct values
    }

    // Sort the array
    Arrays.sort(A);

    // Count distinct elements
    int distinctCount = 1; // At least one distinct element
    for (int i = 1; i < A.length; i++) {
      if (A[i] != A[i - 1]) {
        distinctCount++;
      }
    }

    return distinctCount;
  }
}
```

## Solution #2

```java
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Use a HashSet to store unique values
        HashSet<Integer> distinctValues = new HashSet<>();
        
        // Add each element to the set
        for (int value : A) {
            distinctValues.add(value);
        }
        
        // The size of the set is the number of distinct values
        return distinctValues.size();
    }
}
```