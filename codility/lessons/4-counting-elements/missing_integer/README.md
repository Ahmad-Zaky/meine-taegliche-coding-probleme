# Missing Integer (Medium)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/)

This is a demo task.

Write a function:

`class Solution { public int solution(int[] A); }`

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* each element of array A is an integer within the range [−1,000,000..1,000,000].

## Solution

```java
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        boolean[] present = new boolean[N + 1];

        for (int num : A) {
            if (num > 0 && num <= N) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return N + 1;
    }
}
```