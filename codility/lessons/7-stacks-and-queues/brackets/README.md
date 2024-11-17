# Brackets (Easy)

## Task Description

> Reference: [click here](https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/)

A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

* S is empty;
* S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
* S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

`class Solution { public int solution(String S); }`

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..200,000];
* string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.

## Solution #1

```java
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        if (S.length() <= 0) {
            return 1;
        }
        
        int N = S.length();


        Stack<Character> openned = new Stack<>();
        for (int i=0; i<N; i++) {
            char c = S.charAt(i);
            if (isOpen(c)) {
                openned.push(c);
                continue;
            }
            
            if (openned.isEmpty()) {
                return 0;
            }

            if (isClose(c)) {
                boolean foundOpen  = false;
                while (! openned.isEmpty() && ! foundOpen) {
                    char open = openned.pop();
                    if (getOpen(c) == open) {
                        foundOpen = true;
                    }
                }

                if (! foundOpen) {
                    return 0;
                }
            }
        }

        return openned.isEmpty() ? 1 : 0;
    }

    private boolean isOpen(char c) {
        return c == '{' || c == '(' || c == '[';
    }

    private boolean isClose(char c) {
        return c == '}' || c == ')' || c == ']';
    }

    private char getOpen(char c) {
        switch (c) {
            case '}': return '{';
            case ')': return '(';
            case ']': return '[';
            default: return '-';
        }
    }
}
```

## Solution #2

```java
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
      // Edge case: empty string is properly nested
      if (S.isEmpty()) {
        return 1;
      }
    
      // Use a stack to track unmatched opening brackets
      Stack<Character> stack = new Stack<>();
    
      for (char ch : S.toCharArray()) {
        // Push opening brackets onto the stack
        if (ch == '(' || ch == '[' || ch == '{') {
          stack.push(ch);
        } else {
          // If stack is empty or brackets don't match, return 0
          if (stack.isEmpty()) {
            return 0;
          }
          char top = stack.pop();
          if (!isMatchingPair(top, ch)) {
            return 0;
          }
        }
      }
    
      // If stack is empty, all brackets were matched
      return stack.isEmpty() ? 1 : 0;
    }

    // Helper method to check if brackets match
    private boolean isMatchingPair(char open, char close) {
    return (open == '(' && close == ')') ||
            (open == '[' && close == ']') ||
            (open == '{' && close == '}');
    }
}
```
