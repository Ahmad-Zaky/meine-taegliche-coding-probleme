# Dominator (Easy)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/8-leader/dominator/)

An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

    A[0] = 3    A[1] = 4    A[2] =  3
    A[3] = 2    A[4] = 3    A[5] = -1
    A[6] = 3    A[7] = 3

The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

`class Solution { public int solution(int[] A); }`

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that

    A[0] = 3    A[1] = 4    A[2] =  3
    A[3] = 2    A[4] = 3    A[5] = -1
    A[6] = 3    A[7] = 3

the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..100,000];
* each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

## Solution

```java
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        if (A.length == 0) {
            return -1;
        }

        int lastValue = A[0];
        int size = 0;
        for (int a : A) {
            if (size == 0) {
                lastValue = a;
                size++;
                continue;
            }

            if (lastValue == a) {
                size++;
                continue;
            }

            size--;
        }

        int candiate = -1;
        if (size > 0) {
            candiate = lastValue;
        }

        int leader = -1;
        int counter = 0;
        for (int i=0; i<A.length; i++) {
            if (A[i] == candiate) {
                leader = i;
                counter++;
            }

            if (A.length / 2 < counter) {
                return leader;
            }
        }


        return -1;
    }
}
```