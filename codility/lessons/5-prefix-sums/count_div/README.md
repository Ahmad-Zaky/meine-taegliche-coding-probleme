# Count Div (Medium)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/)

Write a function:

`class Solution { public int solution(int A, int B, int K); }`

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

`{ i : A ≤ i ≤ B, i mod K = 0 }`

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

* A and B are integers within the range [0..2,000,000,000];
* K is an integer within the range [1..2,000,000,000];
* A ≤ B.

## Solution

```java
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int A, int B, int K) {
        int countUpToB = B / K; // Count of multiples of K up to B
        int countUpToA = (A > 0) ? (A - 1) / K : -1; // Count of multiples of K below A
        
        return countUpToB - countUpToA;
    }
}
```