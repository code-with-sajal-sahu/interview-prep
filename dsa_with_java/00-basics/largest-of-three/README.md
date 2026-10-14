# Largest of Three Integers

## Problem Description

Write a Java program that takes three integers as input from the user and determines the largest among them.

The program should compare all three numbers and display the largest value. If two or more numbers have the same maximum value, the program should still display that value correctly.

## Input Format
- The first line contains an integer `a`.
- The second line contains an integer `b`.
- The third line contains an integer `c`.

## Output Format
Print the largest of the three integers.

## Example 1

**Input**
```text
Enter first number: 10
Enter second number: 25
Enter third number: 15
```

**Output**
```text
Largest number: 25
```

## Example 2

**Input**
```text
Enter first number: 30
Enter second number: 30
Enter third number: 20
```

**Output**
```text
Largest number: 30
```

## Example 3

**Input**
```text
Enter first number: -10
Enter second number: -5
Enter third number: -20
```

**Output**
```text
Largest number: -5
```

## Expected Approach
1. Read three integers from the user.
2. Compare the first number with the other two numbers.
3. If the first number is greater than or equal to both, it is the largest.
4. Otherwise, compare the second number with the third number.
5. Display the largest value.

## Concepts Covered
- User input using `Scanner`
- Conditional statements (`if-else if-else`)
- Comparison operators (`>`, `<`, `>=`, `<=`)
- Logical operators (`&&`)
- Handling equal values

## Time Complexity
O(1)

## Space Complexity
O(1)
