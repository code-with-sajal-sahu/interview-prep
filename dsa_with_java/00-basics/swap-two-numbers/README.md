# Swap Two Numbers

## Problem Description

Write a Java program to swap the values of two numbers entered by the user.

The program should take two integers as input, exchange their values, and display the numbers before and after swapping.

## Input Format
- The first line contains an integer `a`.
- The second line contains an integer `b`.

## Output Format
Display the values of both numbers before and after swapping.

## Example 1

**Input**
```text
Enter first number: 10
Enter second number: 20
```

**Output**
```text
Before swapping:
a = 10
b = 20

After swapping:
a = 20
b = 10
```

## Example 2

**Input**
```text
Enter first number: -5
Enter second number: 15
```

**Output**
```text
Before swapping:
a = -5
b = 15

After swapping:
a = 15
b = -5
```

## Expected Approach

1. Read two integers from the user.
2. Store the first number in a temporary variable.
3. Assign the second number to the first variable.
4. Assign the temporary variable to the second variable.
5. Display the swapped values.

## Challenge
Try implementing the solution in two ways:
- **Approach 1:** Using a temporary variable.
- **Approach 2:** Without using a temporary variable.

## Concepts Covered
- Variables and data types
- User input using `Scanner`
- Variable assignment
- Temporary variables
- Basic problem-solving logic

## Time Complexity
O(1)

## Space Complexity
- Using a temporary variable: O(1)
- Without a temporary variable: O(1)