# Padding cars (Easey)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/)

A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

* 0 represents a car traveling east,
* 1 represents a car traveling west.

The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

For example, consider array A such that:

A[0] = 0    
A[1] = 1    
A[2] = 0    
A[3] = 1    
A[4] = 1    

We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

Write a function:

`class Solution { public int solution(int[] A); }`

that, given a non-empty array A of N integers, returns the number of pairs of passing cars.

The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

For example, given:

A[0] = 0    
A[1] = 1    
A[2] = 0    
A[3] = 1    
A[4] = 1    

the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* each element of array A is an integer that can have one of the following values: 0, 1.

## Solution #1

```java
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  public int solution(int[] A) {
    int starterDirection = A[0];

    int counter=0;
    int sameDirectionCount=1;
    int totalSum=0;
    int i=1;
    for (; i<A.length; i++) {
      if (starterDirection == 1) {
        starterDirection=A[i];
        continue;
      }


      if (starterDirection != A[i]) {
        counter++;
        continue;
      }

      if (starterDirection == A[i]) {
        totalSum+=(counter*sameDirectionCount);
        sameDirectionCount++;
        counter=0;
      }
    }

    // For last iteration
    if (starterDirection != A[i-1]) {
      totalSum+=(counter*sameDirectionCount);
    }

    return Math.abs(totalSum) > 1000000000 ? -1 : totalSum;
  }
}
```

## Solution #2

```java
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int eastCars = 0;  // Count of cars going east
        int passingCars = 0;  // Count of passing pairs
        
        for (int car : A) {
            if (car == 0) {
                // Car going east
                eastCars++;
            } else {
                // Car going west
                passingCars += eastCars;
                
                // Check if passingCars exceeds the limit
                if (passingCars > 1_000_000_000) {
                    return -1;
                }
            }
        }
        
        return passingCars;
    }
}
```
