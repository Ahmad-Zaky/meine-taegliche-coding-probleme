# Genomic Range Query (Medium)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/)

A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
The answers to these M = 3 queries are as follows:

* The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
* The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
* The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
Write a function:

class Solution { public int[] solution(String S, int[] P, int[] Q); }

that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

Result array should be returned as an array of integers.

For example, given the string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
the function should return the values [2, 4, 1], as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* M is an integer within the range [1..50,000];
* each element of arrays P and Q is an integer within the range [0..N - 1];
* P[K] ≤ Q[K], where 0 ≤ K < M;
* string S consists only of upper-case English letters A, C, G, T.

## Solution

```java
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  public int[] solution(String S, int[] P, int[] Q) {
    int N = S.length();
    int M = P.length;

    // Prefix sum arrays for A, C, G
    int[] prefixA = new int[N + 1];
    int[] prefixC = new int[N + 1];
    int[] prefixG = new int[N + 1];

    // Build prefix sums
    for (int i = 0; i < N; i++) {
      char nucleotide = S.charAt(i);

      prefixA[i + 1] = prefixA[i];
      prefixC[i + 1] = prefixC[i];
      prefixG[i + 1] = prefixG[i];

      if (nucleotide == 'A') {
        prefixA[i + 1]++;
      } else if (nucleotide == 'C') {
        prefixC[i + 1]++;
      } else if (nucleotide == 'G') {
        prefixG[i + 1]++;
      }
    }

    // Result array
    int[] result = new int[M];

    // Process each query
    for (int k = 0; k < M; k++) {
      int start = P[k];
      int end = Q[k] + 1; // Use inclusive range

      if (prefixA[end] - prefixA[start] > 0) {
        result[k] = 1;
      } else if (prefixC[end] - prefixC[start] > 0) {
        result[k] = 2;
      } else if (prefixG[end] - prefixG[start] > 0) {
        result[k] = 3;
      } else {
        result[k] = 4;
      }
    }

    return result;
  }
}
```