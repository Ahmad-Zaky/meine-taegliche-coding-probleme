# Stone Wall (Easy)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/)

You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

`class Solution { public int solution(int[] H); }`

that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:

    H[0] = 8    H[1] = 8    H[2] = 5
    H[3] = 7    H[4] = 9    H[5] = 8
    H[6] = 7    H[7] = 4    H[8] = 8

the function should return 7. The figure shows one possible arrangement of seven blocks.

![img.png](img.png)

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* each element of array H is an integer within the range [1..1,000,000,000].

## Solution

```java
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blockCount = 0;

        for (int height : H) {
            // Remove heights that are greater than the current one
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }

            // If the current height is not already in the stack
            if (stack.isEmpty() || stack.peek() != height) {
                stack.push(height); // Add the new height
                blockCount++;       // Increment block count
            }
        }

        return blockCount;
    }
}
```