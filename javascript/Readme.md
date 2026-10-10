## 1. What is hoisting?

Hoisting occurs in two steps: declaration and initialization. When you declare a variable or function in your code, Javascript will hoist the declaration to the top of the current scope during compilation. However, the initialization (assigning a value to a variable or defining the function) remains in place where we have written it in the code.

**Variables:** When a variable is hoisted, it gets declared but isn't assigned a value yet. So if we try to access the variable before assigning a value to it, we won't get an error, but the value will be undefined.

Unlike var, let and const are also hoisted but have a temporal dead zone (TDZ) where accessing them before declaration results in a Reference Error.

**Functions:** Function declarations are also hoisted, so you can call a function before it's defined int the code. This is because the entire function, including its body, is hoisted to the top.


## 2. Temporal Dead Zone?

The let and const variables are not accessible before they are initialized with some value and the phase between the starting of the execution of block in which the let or const variable is declared till that variable is being initialized is called Temporal dead zone for the variable and during this zone javascript will always through a reference error if we try to access those variable.

**Example 1:**

```javascript
console.log(x); // throws reference error
let x = 10;
```

**Example 2:**

```javascript
let x;
console.log(x); // prints undefined
x=10;
```

## 3, What is Closure?

A closure in javascript is a function that has access to variables from its outer scope even after the outer function has finished executing.

Closures are created when a function is defined inside another function and references variables from the outer function.

**Example:**
```javascript
function outerFunc(){
    let a = 10;
    function innerFunc(){
        console.log(a);
    }
    return innerFunc;
}
```