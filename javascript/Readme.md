## 1. What is hoisting?

Hoisting occurs in two steps: declaration and initialization. When you declare a variable or function in your code, Javascript will hoist the declaration to the top of the current scope during compilation. However, the initialization (assigning a value to a variable or defining the function) remains in place where we have written it in the code.

**Variables:** When a variable is hoisted, it gets declared but isn't assigned a value yet. So if we try to access the variable before assigning a value to it, we won't get an error, but the value will be undefined.

Unlike var, let and const are also hoisted but have a temporal dead zone (TDZ) where accessing them before declaration results in a Reference Error.

**Functions:** Function declarations are also hoisted, so you can call a function before it's defined int the code. This is because the entire function, including its body, is hoisted to the top.

## 2. Temporal Dead Zone?

The let and const variables are not accessible before they are initialized with some value and the phase between the starting of the execution of block in which the let or const variable is declared till that variable is being initialized is called Temporal dead zone for the variable and during this zone javascript will always through a reference error if we try to access those variable.

**_Example 1:_**

```javascript
console.log(x); // throws reference error
let x = 10;
```

**_Example 2:_**

```javascript
let x;
console.log(x); // prints undefined
x = 10;
```

## 3. What is Closure?

A closure in javascript is a function that has access to variables from its outer scope even after the outer function has finished executing.

Closures are created when a function is defined inside another function and references variables from the outer function.

**_Example:_**

```javascript
function outerFunc() {
  let a = 10;
  function innerFunc() {
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

**_Example:_**

```javascript
let ob1 = {
  name: "sajal",
  age: "24",
};
let obj2 = obj1;
obj2.age = 26;
console.log(obj1); //output: {name: “sajal”, age: 26}
console.log(obj2); //output: {name: “sajal”, age: 26}
```

**Deep Copy:** t makes a copy of all the members of old object, allocates a separate memory location for the new object and then assign the copied members the new object. In this way both the objects are independent of each other and in case of any modification to either one, the other one is not affected.

To make deep copy we use JSON parse and stringify methods

**_Example:_**

```javascript
let ob1 = {
  name: "sajal",
  age: "24",
};
let obj2 = JSON.parse(JSON.stringify(obj1));
obj2.age = 26;
console.log(obj1); //output: {name: “sajal”, age: 24}
console.log(obj2); //output: {name: “sajal”, age: 26}
```

**Note: 1.** Deep copy can also be created by Object.assign() method and spread operator but the problem is if the object properties contains another object then for the inner objects shallow copy will be created. So it is recommended to use JSON methods for deep copy.

**Note: 2.** This method is useful when the object is small and has serializable properties. But if the object is very large and contains certain non-serializable properties then there is a risk of data loss. Especially if an object contains methods then JSON.stringify() will fail as methods are non-serializable. There are better ways to a deep clone of which one is Lodash which allows cloning methods as well. Lodash is a JavaScript library that provides multiple utility functions and one of the most commonly used functions of the Lodash library is the cloneDeep() method. This method helps in the deep cloning of an object and also clones the non-serializable properties which were a limitation in the JSON.stringify() approach.

**_Example:_**

```javascript
let lodash = require(“lodash”);
let objCopy = lodash.cloneDeep(originalObj);
```

## 6. Function Statement and Function Expressions?

**Function Statement:** When a function gets created using the function keyword it is called function statement.

**_Example:_**

```javascript
function hello() {
  console.log("Welcome to javascript interview prep");
}
```

**Function Expressions:** When we assign a function to a variable it is called function expression.

**_Example:_**

```javascript
let hello = function () {
  console.log("Welcome to javascript interview prep");
};
```

## 7. Anonymous function

It is a function that does not have any name associated with it. Normally we use the function keyword before the function name to define a function in JavaScript, however, in anonymous functions in JavaScript, we use only the function keyword without the function name.
An anonymous function is not accessible after its initial creation, it can only be accessed by a variable it is stored in as a function as a value. We can pass anonymous function as an argument in another function or return an anonymous function as value from any function.

## 8. First Class Function

When we assign a function as value to a variable or pass a function as an argument to other functions or return them from another function that function is called Fist class function. So the ability to use a function as values is called first class function. They are also called First class citizens.

## 9. First Order Function

A function that does not take another function as an argument or does not return a function as result is called first order function.

## 10. Higher Order Function

A function that can accept a function as an argument or return a function as result is called Higher order function.

## 11. Pure Functions

A function that always returns the same result if the same arguments are passed. It does not depend on any state or data change during a program execution rather it only depends on its input arguments.

## 12. Event Bubbling

Event bubbling in Javascript refers to the behavior where an event occurring on a nested element will also trigger the same event on its parent elements all the way up to the root element. It’s like a ripple effect, where the event spreads outwards from the original target element to its ancestors

Event bubbling is a way that events spread from the element where they occur to its parent elements, and so on.

For example: let’s say we have a button inside a div. If we click on the button, the onClick event will be called first on the button element, then on the div element and then on the document element.

This can be useful if we want to handle an event on all of the elements in a hierarchy. But it can also be a problem if we only want to handle the event on a specific element.

To prevent an event from bubbling. We can use the stopPropagation() method. This will stop the event from propagating to any of the ancestor elements.

## 13. Debouncing

It is a technique used to control the rate at which a function is executed. It’s particularly useful when handling events that may trigger frequently, such as scroll or keyboards inputs. Debouncing ensures that the function is called only after a certain period of inactivity since the last event occurrence.

“In the debouncing technique no matter how many times user fires the event the attached function will be executed only after the specified time once the user stops firing the event”

To implement debouncing we use a timer to delay the execution of the function. If the event occurs again before the timer expires, the previous timer is canceled and a new one is set. This way the function is executed only after a predefined period of silence or “debounce time”.

## 14. Throttling

Throttling is a technique in which no matter how many times the user fires the event the attached function will be executed only once in a given time interval.

## 15. Phases of Javascript Event

- Capturing Phase

- Target Phase

- Bubbling Phase

## 16. Event Delegation

Event delegation is a technique in javascript where you add an event listener to a parent element instead of individual child elements, allowing you to handle events that occur on the child elements.
When having multiple elements handled similarly you don’t have to assign a handler for each of them. Instead you can put a single handler on their common ancestor.

**_Example_**

```javascript
function ButtonList({ items }) {
  const handleClick = (event) => {
    if (event.target.tagName !== "BUTTON") return;

    const id = event.target.dataset.id;
    const name = event.target.dataset.name;
    alert(`Clicked: ${name} (id: ${id})`);
  };

  return (
    <div onClick={handleClick}>
      {items.map((item) => (
        <button key={item.id} data-id={item.id} data-name={item.name}>
          {item.name}
        </button>
      ))}
    </div>
  );
}
```

## 17. Memoization

It is a technique that saves calculated results to improve a function’s efficiency. The arguments given to the function serve as the cache object’s key. If a key is present, the function return the result immediately. Otherwise the function computes the result, saves it in the cache and returns it.

## 18. Ways to create function

- Function Declaration
- Function Expression
- Arrow Function
- Generator Function

## 19. Arrow functions advantages

- Allows us to write shorter function syntax.

```javascript
// Traditional Function
function myFunc1() {
  return "Hello, World!";
}
console.log(myFunc1());

// Arrow Function
const myFunc2 = () => {
  return "Hello, World!";
};

console.log(myFunc2());
```

- If a function has only one statement and the statement returns a value, we can remove the brackets and the return keyword.

```javascript
// Traditional arrow function
const add = (a, b) => {
  return a + b;
};

// Shorter arrow function
const addNumbers = (a, b) => a + b;

console.log(addNumbers(10, 20)); // 30
```

- If we have only one parameter, we can skip the parentheses as well.

```javascript
// With parentheses
const square = (num) => num * num;

// Without parentheses
const squareNumber = (num) => num * num;

console.log(squareNumber(5)); // 25
```

- We can use the arrow function as a callback function.

```javascript
const numbers = [1, 2, 3, 4, 5];

const squares = numbers.map((num) => num * num);

console.log(squares);
// [1, 4, 9, 16, 25]
```

## 20. What is function currying?

Function currying is a process in which we convert a function with multiple parameters to a chain of functions with a single parameter.

**_Example:_**

```javascript
//Normal function
function sum(a, b) {
  return a + b;
}

//curried function
function currySum(a) {
  return function (b) {
    return a + b;
  };
}
console.log(sum(1, 2)); // 3
console.log(currySum(1)(2)); // 3
```

We simply wrap a function inside a function, which means we are going to return a function from another function to obtain this kind of translation. The parent function takes the first provided argument and returns the function that takes the next argument and this keeps on repeating till the number of arguments ends. Hopefully, the function that receives the last argument returns the expected result.

Use:

- It helps us to create a higher-order function.
- It reduces the chances of error in our function by dividing it into multiple smaller functions that can handle one responsibility.

## 21. Prototype Chaining

**Prototype:** A prototype is an object from which another object is inherited. We can say a prototype as a blueprint or a template. Every object in javascript has an associated prototype, which defines the common properties and methods shared by objects of the same type or class.
**Prototype Chaining:** It is like a family tree of objects. When we try to access a property or a method on an object, javascript looks in the object itself first. If it doesn’t find it, it looks in the object’s prototype. If it still doesn't find it, it keeps going up the chain until it either finds the property / method or reaches the end of the chain.

## 22. Strict Mode

EcmaScript 5 introduced a strict mode that executed the programs and functions strictly. To use strict mode, we write “use strict”; on the top of our javascript file

## 23. Scope

A scope is a code section allowing us to access specific variables and functions. It determines the visibility of variables and functions. Variables and functions declared within a particular scope cannot be accessible outside the scope.

## 24. Local storage vs Session storage

Local storage persists the data even when we close the browser while session storage removes the data when we close the browser tab.

## 25. Callback hell

Callback hell is a pattern that consists of multiple nested callback functions.
Callback hell, also known as the `“pyramid of doom”` is a term used to describe a situation in javascript programming where there are multiple nested callbacks within callbacks, leading to code that becomes hard to read, understand, and maintain.
It typically occurs when working with asynchronous operations that depend on each other or have complex dependencies.
To address the issue of callback hell, various techniques have emerged in js such using Promises, async/await syntax, to handle asynchronous operations more elegantly.

## 26. call(), apply() and bind() methods or ‘function borrowing’

Function borrowing is a technique in JavaScript that allows you to use a method from one object on another object, even if the latter object does not have its own implementation of that method. It is mostly done by setting the “this” keyword to the object on which the method is being used.

## 27. Cookies

Cookies are small data packets that the server sends to the client, the client stores the cookie inside the browser and sends it to the server on each future request.

## 28. let, var and const

In JavaScript, `var`, `let`, and `const` are used to declare variables, but they differ in scope, hoisting behavior, and whether they can be redeclared or reassigned.

- **`var`** is function-scoped, can be redeclared and reassigned, and is initialized with `undefined` during hoisting.
- **`let`** is block-scoped, can be reassigned but cannot be redeclared in the same scope. It is hoisted but remains in the Temporal Dead Zone until its declaration is initialized.
- **`const`** is also block-scoped. It cannot be redeclared or reassigned, and it must be initialized when declared.

In modern JavaScript, I prefer `const` by default and use `let` when a variable needs reassignment. I avoid `var` because its function-scoping behavior can lead to unexpected bugs.

| Feature                        | var             | let          | const        |
| ------------------------------ | --------------- | ------------ | ------------ |
| Scope                          | Function-scoped | Block-scoped | Block-scoped |
| Redeclaration in same scope    | Yes             | No           | No           |
| Reassignment                   | Yes             | Yes          | No           |
| Hoisted                        | Yes             | Yes          | Yes          |
| Initialized during hoisting    | undefined       | No           | No           |
| Temporal Dead Zone             | No              | Yes          | Yes          |
| Must initialize at declaration | No              | No           | Yes          |

## 29. Data Types

- `Primitive:` Number, String, Boolean, Null, undefined and symbol
- `Non-primitive:` Object

## 30. Event Loop

## 31. Browser Object Model

- Provides a way to interact with browsers using a window object.
- It is not the object of javascript
- alert(), confirm(), prompt(), open(), close(), setTimeout() are some important methods of window object.

## 32. Generator functions

A generator-function is defined like a normal function, but whenever it needs to generate a value, it does so with the yield keyword rather than return. The yield statement suspends the function’s execution and sends a value back to the caller, but retains enough state to enable the function to resume where it is left off. When resumed, the function continues execution immediately after the last yield run. 

It is declared using `function*` and returns a Generator object when called.

***Example***
```javascript 
function* generateNumbers() {
  console.log("Start");

  yield 1;
  yield 2;
  yield 3;

  console.log("End");
}

const gen = generateNumbers();

console.log(gen.next());
console.log(gen.next());
console.log(gen.next());
console.log(gen.next());
```

***Output***
```
Start
{ value: 1, done: false }
{ value: 2, done: false }
{ value: 3, done: false }
End
{ value: undefined, done: true }
```
How execution works
1. Calling generateNumbers() creates a generator but does not execute its body.
2. The first gen.next() starts execution and pauses at yield 1.
3. The next calls resume execution from where it paused, reaching yield 2 and then yield 3.
4. The final call completes the function and returns done: true.

## 33. Why do we need modules?

Putting all the code in a single file is impractical, especially when working in groups, modules overcome this problem by dividing code into various files known as modules. Using modules facilitates team co-operation since each member may work on a separate module without interfering with the rest of the application.

## 34. Event handling

A user visiting a website may cause numerous events, such as the click event, which occurs when the user clicks someplace on a webpage. Event handling refers to the process of responding to these events.
Event handlers are your own functions that will be triggered in response to interactions like clicking, hovering, focusing form inputs, and so on.

## 35. Window object vs document object

## 36. Accessor Functions

ES5 introduced javascript accessors. The accessor functions get or set properties on an object Setters use the set keyword and getters use the get keyword.

## 37. Shadowing

When a variable declared inside a specific scope shares the same name as a variable declared in an outside scope, variable shadowing occurs. We say that the inner variable shadows the outside variable.

## 38. this keyword in javascript

The ‘this’ keyword in javascript refers to the current execution context or the object that a function is interacting with at a particular time. Its value is dynamically determined based on how and where a function is called, which can lead to different behaviors.
 
1. **Global Context:** When ‘this’ is used in the global scope (outside any function or object), it refers to the global object, which is ‘window’ in a web browser and ‘global’ in Node.js

***Example***
```javascript
var a = 10;
console.log(a);        //output 10
console.log(this.a);   //output 10
console.log(window.a); //output 10
```
`Note: Here if we declare variable a using let or const then the the variable ‘a’ is not added to the global object (‘window’ in a browser) its added to a separate memory location and output will be undefined if we access using this or window keyword.`