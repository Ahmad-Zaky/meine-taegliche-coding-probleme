# Triangle (Easy)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/6-sorting/triangle/)

An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

* A[P] + A[Q] > A[R],
* A[Q] + A[R] > A[P],
* A[R] + A[P] > A[Q].

For example, consider array A such that:

A[0] = 10    A[1] = 2    A[2] = 5        
A[3] = 1     A[4] = 8    A[5] = 20      

Triplet (0, 2, 4) is triangular.

Write a function:

`class Solution { public int solution(int[] A); }`

that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:

A[0] = 10    A[1] = 2    A[2] = 5
A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:

A[0] = 10    A[1] = 50    A[2] = 5    
A[3] = 1    

the function should return 0.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..100,000];
* each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

## Solution

```java
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  public int solution(int[] A) {
    int N = A.length;
    if (N < 3) {
      return 0;
    }

    Arrays.sort(A);

    int left = 0;
    int right = N-1;
    while (left < right) {

      long firstLeftSum = (long) A[left] + (long) A[left+1];
      long secondLeftSum = (long) A[left+1] + (long) A[left+2];
      long thirdLeftSum = (long) A[left] + (long) A[left+2];

      if (
              firstLeftSum > A[left+2] &&
                      secondLeftSum > A[left] &&
                      thirdLeftSum > A[left+1]
      ) {
        return 1;
      }

      long firstRightSum = (long) A[right] + (long) A[right-1];
      long secondRightSum = (long) A[right-1] + (long) A[right-2];
      long thirdRightSum = (long) A[right] + (long) A[right-2];

      if (
              firstRightSum > A[right-2] &&
                      secondRightSum > A[right] &&
                      thirdRightSum > A[right-1]
      ) {
        return 1;
      }

      left++;
      right--;
    }

    return 0;
  }
}
```