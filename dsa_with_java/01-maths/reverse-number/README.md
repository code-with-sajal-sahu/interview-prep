# Reverse a Number

## Problem Description

Write a Java program that takes an integer as input from the user and reverses its digits.

The program should extract each digit from the given number, construct the reversed number, and display the result.

For this problem, if the input is a negative integer, preserve its negative sign in the reversed result. Any leading zeros in the reversed number should not be displayed.

## Input Format
- The input contains a single integer `n`.

## Output Format
Print the reversed integer.

## Example 1

**Input**
```text
Enter an integer: 1234
```

**Output**
```text
Reversed number: 4321
```

## Example 2

**Input**
```text
Enter an integer: 1200
```

**Output**
```text
Reversed number: 21
```

## Example 3

**Input**
```text
Enter an integer: -567
```

**Output**
```text
Reversed number: -765
```

## Example 4

**Input**
```text
Enter an integer: 7
```

**Output**
```text
Reversed number: 7
```

## Concepts Covered
- User input using `Scanner`
- `while` loops
- Modulo (`%`) operator
- Integer division (`/`)
- Arithmetic operations
- Digit extraction and number manipulation

## Time Complexity
O(d), where `d` is the number of digits in the input.

## Space Complexity
O(1)

## Edge Cases
- Single-digit numbers
- Numbers ending in zeros
- Negative integers
- Zero as input
- Integer overflow when reversing very large numbers
