# Count Factors (Easy)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/)

A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

Write a function:

`class Solution { public int solution(int N); }`

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..2,147,483,647].

## Solution

```java
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  public int solution(int N) {
    int sqrtN = (int) Math.sqrt(N);
    int factorsCount = 0;
    for (int i=1; i <= sqrtN; i++) {
      if (N % i == 0) {
        factorsCount+= i != (N/i) ? 2 : 1;
      }
    }

    return factorsCount;
  }
}
```