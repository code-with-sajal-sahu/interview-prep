# Check Even or Odd

## Problem Description

Write a Java program that takes an integer as input from the user and determines whether the number is even or odd.

A number is considered **even** if it is completely divisible by 2, leaving a remainder of 0. Otherwise, the number is **odd**.

## Input Format
- The input contains a single integer `n`.

## Output Format
Print `Even` if the number is even; otherwise, print `Odd`.

## Example 1

**Input**
```text
Enter an integer: 10
```

**Output**
```text
10 is Even
```

## Example 2

**Input**
```text
Enter an integer: 7
```

**Output**
```text
7 is Odd
```

## Example 3

**Input**
```text
Enter an integer: -4
```

**Output**
```text
-4 is Even
```

## Expected Approach
1. Read an integer from the user.
2. Calculate the remainder when the integer is divided by 2 using the modulo (`%`) operator.
3. If the remainder is `0`, the number is even.
4. Otherwise, the number is odd.
5. Display the result.

## Concepts Covered
- User input using `Scanner`
- Conditional statements (`if-else`)
- Arithmetic operators
- Modulo (`%`) operator

## Time Complexity
O(1)

## Space Complexity
O(1)
