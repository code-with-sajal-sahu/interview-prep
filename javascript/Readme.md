## 1. What is hoisting?

Hoisting occurs in two steps: declaration and initialization. When you declare a variable or function in your code, Javascript will hoist the declaration to the top of the current scope during compilation. However, the initialization (assigning a value to a variable or defining the function) remains in place where we have written it in the code.

**Variables:** When a variable is hoisted, it gets declared but isn't assigned a value yet. So if we try to access the variable before assigning a value to it, we won't get an error, but the value will be undefined.

Unlike var, let and const are also hoisted but have a temporal dead zone (TDZ) where accessing them before declaration results in a Reference Error.

**Functions:** Function declarations are also hoisted, so you can call a function before it's defined int the code. This is because the entire function, including its body, is hoisted to the top.


## 2. Temporal Dead Zone?

The let and const variables are not accessible before they are initialized with some value and the phase between the starting of the execution of block in which the let or const variable is declared till that variable is being initialized is called Temporal dead zone for the variable and during this zone javascript will always through a reference error if we try to access those variable.

***Example 1:***

```javascript
console.log(x); // throws reference error
let x = 10;
```

***Example 2:***

```javascript
let x;
console.log(x); // prints undefined
x=10;
```

## 3. What is Closure?

A closure in javascript is a function that has access to variables from its outer scope even after the outer function has finished executing.

Closures are created when a function is defined inside another function and references variables from the outer function.

***Example:***

```javascript
function outerFunc(){
    let a = 10;
    function innerFunc(){
        console.log(a);
    }
    return innerFunc;

    let test = outerFunc(); // outerFunc is called but innerFunc is returned
    test(); // still logs 10 even though outerFunc has finished executing
}
```

**Explaination:** In this example `innerFunction` is a closure because it retains access to 'a' even after `outerFunc` has completed its execution.

The key point is to remeber that here `outerFunc` is not only returning `innerFunc` it is returning `innerFunc` along with it's lexical environment.

## 4. Lexical Scoping

Lexical scoping is a convention used in many programming languages that sets the scope of a variable so that it may only be called from within the block of code in which it is defined.

During runtime, javascript does two things:

I. Parsing

II. Execution

Lexical scoping takes place during the parsing phase of the js engine.
The ability of a function scope to access variables from the parent scope is called Lexical scope. The child function is lexically bonded to the parent but the opposite is not true; the variables defined inside a function could not be accessed outside that fuction.

## 5. Shallow Copy & Deep Copy

Shallow copy and Deep copy are two ways of creating a copy of an object or array.
**Shallow Copy:** When a reference variable is copied into a new reference variable using assignment operator a shallow copy of the referenced object is created. In simple words a reference variable mainly stores the address of the object it refers to when a new reference variable is assigned the value of the old reference variable the address stored in the old reference variable is copied into the new one this means both the old and new reference variable point to the same object in memory. As a result if the state of the object changes through any of the reference variables it is reflected for both.

***Example:***
```javascript

let ob1 = {
    name: "sajal",
    age: "24"
};
let obj2 = obj1;
obj2.age = 26;
console.log(obj1);	//output: {name: “sajal”, age: 26}
console.log(obj2);	//output: {name: “sajal”, age: 26}

```

**Deep Copy:** t makes a copy of all the members of old object, allocates a separate memory location for the new object and then assign the copied members the new object. In this way both the objects are independent of each other and in case of any modification to either one, the other one is not affected.

To make deep copy we use JSON parse and stringify methods

***Example:***
```javascript

let ob1 = {
    name: "sajal",
    age: "24"
};
let obj2 = JSON.parse(JSON.stringify(obj1));
obj2.age = 26;
console.log(obj1);	//output: {name: “sajal”, age: 24}
console.log(obj2);	//output: {name: “sajal”, age: 26}
```

**Note: 1.** Deep copy can also be created by Object.assign() method and spread operator but the problem is if the object properties contains another object then for the inner objects shallow copy will be created. So it is recommended to use JSON methods for deep copy.

**Note: 2.** This method is useful when the object is small and has serializable properties. But if the object is very large and contains certain non-serializable properties then there is a risk of data loss. Especially if an object contains methods then JSON.stringify() will fail as methods are non-serializable. There are better ways to a deep clone of which one is Lodash which allows cloning methods as well. Lodash is a JavaScript library that provides multiple utility functions and one of the most commonly used functions of the Lodash library is the cloneDeep() method. This method helps in the deep cloning of an object and also clones the non-serializable properties which were a limitation in the JSON.stringify() approach.

***Example:***
```javascript 
let lodash = require(“lodash”);
let objCopy = lodash.cloneDeep(originalObj);
```