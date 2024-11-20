# Equi Leader (Easy)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/8-leader/equi_leader/)

A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2

we can find two equi leaders:

* 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
* 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.

The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2

the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].

## Solution

```java
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
int n = A.length;
        if (n == 1) {
            return 0; // No equi leaders possible for a single element
        }

        // Step 1: Find the candidate for the leader using Boyer-Moore Voting Algorithm
        int candidate = 0, count = 0;
        for (int num : A) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Validate the candidate
        int leaderCount = 0;
        for (int num : A) {
            if (num == candidate) {
                leaderCount++;
            }
        }
        if (leaderCount <= n / 2) {
            return 0; // No leader, so no equi leaders
        }

        // Step 3: Count equi leaders
        int equiLeaders = 0;
        int leftLeaderCount = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] == candidate) {
                leftLeaderCount++;
            }

            int leftSize = i + 1;
            int rightSize = n - leftSize;

            if (leftLeaderCount > leftSize / 2 && 
                (leaderCount - leftLeaderCount) > rightSize / 2) {
                equiLeaders++;
            }
        }

        return equiLeaders;
    }
}
```