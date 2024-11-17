# Nesting (Easy)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/)

A string S consisting of N characters is called properly nested if:

* S is empty;
* S has the form "(U)" where U is a properly nested string;
* S has the form "VW" where V and W are properly nested strings.

For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

`class Solution { public int solution(String S); }`

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..1,000,000];
* string S is made only of the characters '(' and/or ')'.

## Solution

```java
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        int N = S.length();

        Stack<Character> opens = new Stack<>();
        for (int i=0; i<N; i++) {
            char c = S.charAt(i);
            if (c == '(') {
                opens.push(c);
                continue;
            }

            if (opens.isEmpty()) {
                return 0;
            }

            while (!opens.isEmpty()) {
                char open = opens.pop();
                if (open == '(') {
                    break;
                }
            }
        } 

        return opens.isEmpty() ? 1 : 0;
    }
}
```