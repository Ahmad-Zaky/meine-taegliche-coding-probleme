# Minimum watertanks placement

## Task Description

Today our world is approaching an ecological crisis. Due to global warming, the sea level is rising. At the same time, the amount of drinkable water is decreasing. One idea about preventing the loss of drinkable water is the propagation of rainwater storage, in other words, equipping houses with a water tank for rainwater.

You are given a string S describing a street, in which 'H' denotes a house and '-' denotes an empty plot. You may place water tanks in empty plots to collect rainwater from nearby houses. A house can collect its own rainwater if there is a tank next to it (on either the left or the right side).

Your task is to find the minimum number of water tanks needed to collect rainwater from all of the houses.

For example, given S = "-H-H--", you can collect rainwater from all three houses by using two water tanks. You can position one water tank between the first and second houses and the other after the third house. This placement of water tanks can be represented as "-HHTH-", where T denotes a water tank.

Write a function:
class Solution { public int solution(String S); }
that, given a string S of length N, returns the minimum number of water tanks needed.

If there is no solution, return -1.

Examples:
1. Given S = "-H-H--", the function should return 2, as explained above.
2. Given S = "H", the function should return -1. There is no available plot on which to place a water tank.
3. Given S = "H-H-H", the function should return 1. There is only one plot to put a water tank, and it is impossible to collect rainwater from the first and last houses.
4. Given S = "-H-H-H-H-", the function should return 3. One possible way of placing water tanks is "-HHTHTH-".

Assume that:
- N is an integer within the range [1,100,000];
- string S is made only of the characters '-' and/or 'H'.

In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

## Solution

```java
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        char[] street = S.toCharArray();
        int tanks = 0;
        char tank = 'T';
        char house = 'H';
        char emptyPlot = '-';

        for (int i = 0; i < street.length; i++) {
            if (isHouse(i, street, house) && hasNoTanks(i, street)) {
                // check right side firstly
                if (i < street.length - 1 && street[i + 1] == emptyPlot) {
                    street[i + 1] = tank; // Place tank
                    tanks++;
                    continue;
                }

                // check left side secondly
                if (i > 0 && street[i - 1] == emptyPlot) {
                    street[i - 1] = tank; // Place tank
                    tanks++;
                    continue;
                }

                if (hasNoTanks(i, street)) {
                    return -1;
                }            
            }
        }

        return tanks;
    }

    public boolean isHouse(int index, char[] street, char house) {
        return street[index] == house;
    }

    public boolean hasNoTanks(int index, char[] street) {
        return (
            index <= 0 || street[index - 1] != 'T'
        ) && (
            index >= street.length-1 || street[index + 1] != 'T'
        );
    }
}
```