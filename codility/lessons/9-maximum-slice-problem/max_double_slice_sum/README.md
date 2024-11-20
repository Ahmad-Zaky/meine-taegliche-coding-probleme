# Max Double Slice Sum (Medium)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/)

A non-empty array A consisting of N integers is given.

A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

For example, array A such that:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
contains the following example double slices:

* double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
* double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
* double slice (3, 4, 5), sum is 0.

The goal is to find the maximal sum of any double slice.

Write a function:

`class Solution { public int solution(int[] A); }`

that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.

For example, given:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
the function should return 17, because no double slice of array A has a sum of greater than 17.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [3..100,000];
* each element of array A is an integer within the range [−10,000..10,000].

## Solution #1

```java
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int N = A.length;

        int[] maxStarting = new int[N];
        int[] maxEnding = new int[N];

        // Compute max sums ending at each position (ignore boundries)
        for (int i=1; i<N; i++) {
            maxEnding[i] = Math.max(0, maxEnding[i-1] + A[i]);
        }

        // Compute max sums starting at each position (ignore boundries)
        for (int i=N-2; i>0; i--) {
            maxStarting[i] = Math.max(0, maxStarting[i+1] + A[i]);
        }

        int maxDoubleSlice = 0;
        for (int i=1; i<N-1; i++) {
            maxDoubleSlice = Math.max(maxDoubleSlice, maxEnding[i-1] + maxStarting[i+1]);
        }

        return maxDoubleSlice;
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
        int N = A.length;

        int[] maxStarting = new int[N];
        int[] maxEnding = new int[N];

        int startIdx = 1;
        int endIdx = N-2;
        while (startIdx<N && endIdx>0) {
            // Compute max sums ending at each position (ignore boundries)
            maxEnding[startIdx] = Math.max(0, maxEnding[startIdx-1] + A[startIdx]);
            startIdx++;

            // Compute max sums starting at each position (ignore boundries)
            maxStarting[endIdx] = Math.max(0, maxStarting[endIdx+1] + A[endIdx]);
            endIdx--;
        }

        int maxDoubleSlice = 0;
        for (int i=1; i<N-1; i++) {
            maxDoubleSlice = Math.max(maxDoubleSlice, maxEnding[i-1] + maxStarting[i+1]);
        }

        return maxDoubleSlice;
    }
}
```