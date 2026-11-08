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

## 38. ## What Is the `this` Keyword in JavaScript?

The `this` keyword in JavaScript refers to the execution context of a function. Its value depends on how a function is called.

In simple terms, `this` refers to the object associated with the current function call.

For regular functions, the value of `this` is determined dynamically at runtime based on how the function is invoked.

Arrow functions are different because they do not have their own `this`. They inherit it from their surrounding lexical scope.

### One-Line Definition (Interview Ready)

> The `this` keyword in JavaScript refers to the object associated with the current function execution. Its value depends on how the function is called, except for arrow functions, which inherit `this` from their surrounding scope.

### 1. Global Context

When `this` is used in the global execution context:

- In a browser, it refers to the global `window` object.
- In Node.js CommonJS modules, top-level `this` refers to `module.exports`, not the global object.
- In JavaScript ES modules, top-level `this` is `undefined`.

#### Example (Browser)

```javascript
var a = 10;

console.log(a);        // 10
console.log(this.a);   // 10
console.log(window.a); // 10
```

Here, `var` declared at the top level of a classic browser script becomes a property of the global `window` object.

**Important:** Variables declared using `let` and `const` at the top level of a browser script do not become properties of `window`.

```javascript
let a = 10;
const b = 20;

console.log(a);        // 10
console.log(this.a);   // undefined
console.log(window.a); // undefined
```

### 2. Function Context

In a regular function, the value of `this` depends on how the function is called.

#### A. Regular Function (Non-Strict Mode)

When a regular function is called without an explicit object, `this` refers to the global object in non-strict mode.

```javascript
function myFunc() {
  console.log(this);
}

myFunc();

// In a browser's non-strict classic script:
// Output: Window object
```

#### B. Regular Function (Strict Mode)

In strict mode, when a regular function is called without an explicit object, `this` is `undefined`.

```javascript
"use strict";

function myFunc() {
  console.log(this);
}

myFunc();

// Output: undefined
```

**Note:** JavaScript modules automatically run in strict mode.

### 3. Object Method

When a regular function is called as an object method, `this` refers to the object before the dot in the method call.

#### Example

```javascript
const person = {
  name: "Sajal",

  myFunc: function () {
    console.log(this.name);
  }
};

person.myFunc();

// Output: Sajal
```

Here, `this` refers to the `person` object because the function is called using `person.myFunc()`.

**Important:** The object that calls the method determines `this`, not necessarily the object where the function was originally defined.

### 4. Constructor Function

When a function is called using the `new` keyword, `this` refers to the newly created object.

#### Example

```javascript
function Animal(name) {
  this.name = name;
}

const cat = new Animal("Tom");

console.log(cat.name);

// Output: Tom
```

Here:
1. The `new` keyword creates a new object.
2. `this` refers to that newly created object.
3. The `name` property is assigned to the new object.
4. The newly created object is returned automatically.

### 5. Arrow Functions

Arrow functions do not have their own `this` binding. They inherit `this` from their surrounding lexical scope.

This behavior is called **lexical `this`**.

#### Example

```javascript
const person = {
  name: "Sajal",

  myFunc: () => {
    console.log(this.name);
  }
};

person.myFunc();

// In a browser's non-strict classic script,
// Output: undefined (assuming no global name property)
```

Here, the arrow function does not get `this` from the `person` object. It inherits `this` from the surrounding scope.

#### Correct Way: Regular Method with Arrow Function

```javascript
const person = {
  name: "Sajal",

  myFunc: function () {
    const innerFunc = () => {
      console.log(this.name);
    };

    innerFunc();
  }
};

person.myFunc();

// Output: Sajal
```

Here, the arrow function inherits `this` from `myFunc()`, where `this` refers to the `person` object.

### 6. Explicit Binding: call(), apply(), and bind()

JavaScript provides three methods to explicitly control the value of `this`.

#### A. call()

The `call()` method invokes a function immediately and allows us to specify the value of `this` by passing an object as the first argument.

```javascript
const person1 = {
  name: "Sajal"
};

function greet(city) {
  console.log(`Hello ${this.name} from ${city}`);
}

greet.call(person1, "Indore");

// Output: Hello Sajal from Indore
```

#### B. apply()

The `apply()` method works similarly to `call()`, but arguments are passed as an array.

```javascript
const person1 = {
  name: "Sajal"
};

function greet(city, country) {
  console.log(`Hello ${this.name} from ${city}, ${country}`);
}

greet.apply(person1, ["Indore", "India"]);

// Output: Hello Sajal from Indore, India
```

#### C. bind()

The `bind()` method returns a new function with a permanently bound `this` value. It does not execute the function immediately.

```javascript
const person1 = {
  name: "Sajal"
};

function greet() {
  console.log(`Hello ${this.name}`);
}

const newFunc = greet.bind(person1);

newFunc();

// Output: Hello Sajal
```

### 7. Event Handlers and `this`

In traditional DOM event handlers, `this` refers to the DOM element on which the event handler is registered.

#### Example

```javascript
const button = document.querySelector("button");

button.addEventListener("click", function () {
  console.log(this);
});
```

Here, `this` refers to the button element.

However, arrow functions do not receive their own `this` from the event handler.

```javascript
button.addEventListener("click", () => {
  console.log(this);
});
```

Here, `this` is inherited from the surrounding lexical scope, not the button element.

### 8. Difference Between Regular and Arrow Function `this`

| Feature | Regular Function | Arrow Function |
|---|---|---|
| Own `this` | Yes | No |
| How `this` is determined | Depends on how it is called | Inherited from lexical scope |
| Can use `call()` to change `this` | Yes | No |
| Can use `apply()` to change `this` | Yes | No |
| Can use `bind()` to change `this` | Yes | No |
| Constructor function | Yes | No |
| Used as object method | Yes | Usually not suitable when needing the object as `this` |

### 9. Common Interview Follow-Up Questions

**Q1. Is `this` determined by where a function is defined or where it is called?**

For regular functions, `this` is generally determined by how the function is called, not where it is defined. Arrow functions are an exception because they inherit `this` from their surrounding lexical scope.

**Q2. What is the difference between `this` in regular and arrow functions?**

Regular functions have their own `this` binding, which depends on the invocation. Arrow functions do not have their own `this`; they inherit it from their surrounding scope.

**Q3. Can we change the value of `this` in an arrow function using call(), apply(), or bind()?**

No. These methods cannot change the lexical `this` of an arrow function.

**Q4. What happens to `this` in strict mode?**

When a regular function is called without an explicit object, `this` is `undefined` in strict mode. In non-strict mode, it generally refers to the global object.

**Q5. What does `this` refer to inside a constructor function?**

When a constructor function is invoked using `new`, `this` refers to the newly created instance.

**Q6. What is the difference between call(), apply(), and bind()?**

- `call()` invokes a function immediately with arguments passed individually.
- `apply()` invokes a function immediately with arguments passed as an array.
- `bind()` returns a new function with a bound `this` value and does not invoke it immediately.

**Q7. Why should we avoid arrow functions as object methods when we need `this` to refer to the object?**

Because arrow functions do not create their own `this` binding. They inherit `this` from the surrounding scope instead of taking it from the object method invocation.

**Q8. What is lexical `this`?**

Lexical `this` means an arrow function inherits the `this` value from the scope in which it was defined rather than determining it from how the function is called.

### Quick Revision

- **Global context:** `window` in browser scripts; different behavior in Node.js and ES modules.
- **Regular function:** `this` depends on how the function is called.
- **Strict mode:** A regular function called without an object has `this` as `undefined`.
- **Object method:** `this` refers to the object used to invoke the method.
- **Constructor function:** `this` refers to the newly created instance when called with `new`.
- **Arrow function:** Does not have its own `this`; inherits it lexically.
- **`call()`:** Invokes a function with a specified `this` and individual arguments.
- **`apply()`:** Invokes a function with a specified `this` and an array of arguments.
- **`bind()`:** Returns a new function with a specified `this` binding.

## 39. ## What Are Synchronous and Asynchronous Functions in JavaScript?

JavaScript supports both synchronous and asynchronous operations.

- **Synchronous execution:** Code executes sequentially, and the next operation waits until the current operation completes.
- **Asynchronous execution:** Certain operations can be started without blocking the main JavaScript thread while waiting for their completion. JavaScript can continue executing other code in the meantime.

### One-Line Difference (Interview Ready)

> **Synchronous:** Code executes sequentially, and each operation must complete before the next operation proceeds.
>
> **Asynchronous:** Code can continue executing other operations without waiting for an asynchronous task to complete.

### 1. Synchronous Functions

A synchronous function executes its statements sequentially. The next statement executes only after the current function finishes.

If a synchronous operation takes a long time, it can block the JavaScript thread and delay other operations.

#### Example

```javascript
function first() {
  console.log("First function");
}

function second() {
  console.log("Second function");
}

function third() {
  console.log("Third function");
}

first();
second();
third();

console.log("End");

// Output:
// First function
// Second function
// Third function
// End
```

#### How It Works

1. JavaScript executes `first()`.
2. After `first()` completes, it executes `second()`.
3. After `second()` completes, it executes `third()`.
4. Finally, it executes the last `console.log()` statement.

Each function completes before the next statement proceeds.

### 2. Asynchronous Functions

An asynchronous operation allows JavaScript to continue executing other code while waiting for an operation to complete.

JavaScript commonly uses asynchronous operations for tasks such as:
- API requests.
- Database operations.
- File system operations.
- Timers.
- Network communication.

#### Example

```javascript
console.log("Start");

setTimeout(() => {
  console.log("Inside setTimeout");
}, 2000);

console.log("End");

// Output:
// Start
// End
// Inside setTimeout
```

#### How It Works

1. JavaScript executes `console.log("Start")`.
2. `setTimeout()` schedules a callback to execute after approximately 2 seconds.
3. JavaScript continues executing without waiting for the timer.
4. `console.log("End")` executes.
5. Once the timer expires and the callback is eligible to run, the callback is placed in the task queue.
6. The Event Loop schedules the callback when the call stack is empty.

### 3. Difference Between Synchronous and Asynchronous Functions

| Feature | Synchronous | Asynchronous |
|---|---|---|
| Execution | Sequential | Allows other code to execute while waiting |
| Blocking | Can block the main thread | Non-blocking when implemented using asynchronous APIs |
| Execution flow | Next operation waits for the current operation | Other operations can continue |
| Handling | Direct execution | Callbacks, Promises, async/await |
| Examples | Normal function calls, CPU-intensive calculations | API requests, timers, asynchronous file operations |
| Use case | Simple calculations and sequential operations | Network requests and I/O operations |

### 4. How Does JavaScript Handle Asynchronous Operations?

JavaScript is single-threaded in its main execution model, meaning JavaScript code in a particular execution context runs one task at a time.

However, JavaScript can handle asynchronous operations using the Event Loop and runtime-provided APIs.

The important components are:

**1. Call Stack**

The Call Stack keeps track of currently executing functions. JavaScript executes synchronous code using the Call Stack.

**2. Web APIs / Runtime APIs**

The browser provides APIs such as `setTimeout()`, `fetch()`, and DOM event handling.

Node.js provides runtime capabilities for timers, file system operations, networking, and other asynchronous tasks.

**3. Callback Queue (Task Queue)**

Callbacks from tasks such as timers and DOM events can be queued for execution when they are ready.

**4. Microtask Queue**

Promises' `.then()`, `.catch()`, and `.finally()` callbacks, along with `queueMicrotask()`, are scheduled as microtasks.

Microtasks are processed before the next task is taken from the task queue.

**5. Event Loop**

The Event Loop coordinates execution by checking whether the Call Stack is empty and scheduling eligible queued callbacks.

### 5. Example: Understanding the Event Loop

```javascript
console.log("Start");

setTimeout(() => {
  console.log("setTimeout callback");
}, 0);

Promise.resolve().then(() => {
  console.log("Promise callback");
});

console.log("End");

// Output:
// Start
// End
// Promise callback
// setTimeout callback
```

#### Explanation

1. `Start` is printed because it is synchronous code.
2. `setTimeout()` schedules a timer callback.
3. `Promise.resolve().then()` schedules a microtask.
4. `End` is printed because synchronous execution continues.
5. The Call Stack becomes empty.
6. The Promise microtask executes.
7. The timer callback executes in a subsequent task.

**Important:** Even with `setTimeout(..., 0)`, its callback does not execute immediately.

### 6. Ways to Handle Asynchronous Operations in JavaScript

JavaScript provides different approaches to handle asynchronous operations.

#### A. Callbacks

A callback is a function passed as an argument to another function and executed later.

```javascript
function getData(callback) {
  setTimeout(() => {
    callback("Data received");
  }, 1000);
}

getData((result) => {
  console.log(result);
});

// Output after approximately 1 second:
// Data received
```

**Limitation:** Deeply nested callbacks can create Callback Hell, making code difficult to maintain.

#### B. Promises

A Promise represents the eventual completion or failure of an asynchronous operation.

A Promise has three states:

- Pending
- Fulfilled
- Rejected

```javascript
const getData = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve("Data received");
  }, 1000);
});

getData
  .then((result) => {
    console.log(result);
  })
  .catch((error) => {
    console.log(error);
  });

// Output after approximately 1 second:
// Data received
```

#### C. Async/Await

`async/await` provides a cleaner way to write Promise-based asynchronous code.

- An `async` function always returns a Promise.
- `await` pauses the execution of the surrounding async function until the Promise settles.
- It does not block the JavaScript main thread while waiting for the Promise.

```javascript
function getData() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve("Data received");
    }, 1000);
  });
}

async function fetchData() {
  console.log("Start");

  const result = await getData();

  console.log(result);
  console.log("End");
}

fetchData();

// Output:
// Start
// Data received (after approximately 1 second)
// End
```

### 7. Common Interview Follow-Up Questions

**Q1. Is JavaScript synchronous or asynchronous?**

JavaScript executes code synchronously on its main execution thread by default. However, it supports asynchronous operations through runtime APIs, Promises, callbacks, and the Event Loop.

**Q2. Is JavaScript single-threaded?**

JavaScript's main execution model is single-threaded, meaning one JavaScript task executes at a time on a particular thread. However, browsers and Node.js use additional runtime capabilities and threads to handle certain operations.

**Q3. What is the Event Loop?**

The Event Loop is responsible for coordinating synchronous execution and scheduling asynchronous callbacks when the Call Stack is available.

**Q4. What is Callback Hell?**

Callback Hell occurs when multiple asynchronous operations are nested inside one another, making code difficult to read, debug, and maintain.

**Q5. What is the difference between a Promise and async/await?**

Promises represent the eventual result of an asynchronous operation. `async/await` provides a cleaner syntax for working with Promises.

**Q6. Does await block the JavaScript main thread?**

No. `await` pauses the execution of the surrounding async function until the Promise settles. Other JavaScript code can continue executing.

**Q7. What is the difference between the Microtask Queue and Callback Queue?**

The Microtask Queue contains Promise reaction callbacks and other microtasks. The Callback Queue, commonly called the Task Queue, contains callbacks from tasks such as timers and browser events. Microtasks are processed before the next task is executed.

**Q8. Does setTimeout(fn, 0) execute immediately?**

No. It schedules a callback that becomes eligible after the specified delay. It executes only when the JavaScript runtime can process the scheduled task.

### Quick Revision

- **Synchronous:** Executes sequentially; the next statement waits for the current operation.
- **Asynchronous:** Allows other work to continue while waiting for an operation.
- **Call Stack:** Tracks currently executing functions.
- **Event Loop:** Coordinates execution and scheduling of queued callbacks.
- **Microtask Queue:** Handles Promise callbacks and other microtasks.
- **Callback:** Function passed to another function for later execution.
- **Promise:** Represents the eventual result of an asynchronous operation.
- **Async/Await:** Cleaner syntax for handling Promises.
- **JavaScript:** Synchronous execution model with asynchronous capabilities.

## 40. ## What Is IIFE (Immediately Invoked Function Expression) in JavaScript?

IIFE stands for **Immediately Invoked Function Expression**.

An IIFE is a JavaScript function that is defined and executed immediately after its creation.

It is commonly used to create a private scope, avoid polluting the global namespace, and encapsulate variables that should not be accessible from outside the function.

### One-Line Definition (Interview Ready)

> IIFE (Immediately Invoked Function Expression) is a function that executes immediately after it is defined. It is commonly used to create a private scope and avoid global variable pollution.

### 1. Syntax of IIFE

```javascript
(function () {
  // Function body
})();
```

The first pair of parentheses converts the function declaration into a function expression, and the second pair of parentheses immediately invokes it.

### 2. Example of IIFE

```javascript
(function () {
  console.log("Hello, IIFE!");
})();

// Output:
// Hello, IIFE!
```

**How It Works:**

1. The function is wrapped inside parentheses, making it a function expression.
2. The second pair of parentheses `()` immediately invokes the function.
3. The function executes without needing to be called separately.

### 3. Different Ways to Write an IIFE

#### A. Named or Anonymous Function IIFE

Anonymous IIFE:

```javascript
(function () {
  console.log("Anonymous IIFE");
})();
```

Named IIFE:

```javascript
(function greet() {
  console.log("Named IIFE");
})();
```

#### B. Arrow Function IIFE

IIFEs can also be written using arrow functions.

```javascript
(() => {
  console.log("Arrow Function IIFE");
})();
```

#### C. IIFE with Parameters

We can pass arguments to an IIFE just like a normal function.

```javascript
(function (name) {
  console.log(`Hello, ${name}!`);
})("Babu");

// Output:
// Hello, Babu!
```

#### D. IIFE with Return Value

An IIFE can also return a value.

```javascript
const result = (function (a, b) {
  return a + b;
})(10, 20);

console.log(result);

// Output:
// 30
```

### 4. Why Do We Use IIFE?

**1. Avoid Global Namespace Pollution**

Variables declared inside an IIFE using `var`, `let`, or `const` are scoped to the function and do not become global variables.

```javascript
(function () {
  var message = "Private Message";
  console.log(message);
})();

console.log(typeof message);

// Output:
// Private Message
// undefined
```

**2. Create a Private Scope**

Variables declared inside an IIFE cannot be directly accessed from outside it.

```javascript
(function () {
  const secret = "My Secret Data";

  console.log(secret);
})();

// Output:
// My Secret Data

// console.log(secret); // ReferenceError
```

**3. Data Encapsulation**

IIFEs can be used to encapsulate data and expose only the functionality we want.

```javascript
const counter = (function () {
  let count = 0;

  return {
    increment: function () {
      count++;
    },

    getCount: function () {
      return count;
    }
  };
})();

counter.increment();
counter.increment();

console.log(counter.getCount());

// Output:
// 2
```

Here, the `count` variable cannot be accessed directly from outside the IIFE. It can only be modified through the exposed methods.

### 5. IIFE vs Normal Function

| Feature | Normal Function | IIFE |
|---|---|---|
| Execution | Called explicitly | Invoked immediately after definition |
| Syntax | Function declaration or expression | Function expression followed by invocation |
| Scope | Function scope | Function scope |
| Reusability | Can be called multiple times | Usually executed once |
| Common use | Reusable functionality | Encapsulation and initialization |

### 6. Common Interview Follow-Up Questions

**Q1. Why do we wrap an IIFE inside parentheses?**

JavaScript treats a function declaration differently from a function expression. Wrapping the function in parentheses makes it a function expression, allowing it to be invoked immediately.

**Q2. Can we pass parameters to an IIFE?**

Yes. We can pass arguments just like a normal function.

```javascript
(function (a, b) {
  console.log(a + b);
})(10, 20);

// Output: 30
```

**Q3. Can an IIFE return a value?**

Yes. An IIFE can return a value, and we can store that value in a variable.

**Q4. Does an IIFE create a new scope?**

Yes. An IIFE creates a function scope. Variables declared inside it are not directly accessible outside the function.

**Q5. Can we use arrow functions as IIFEs?**

Yes. Arrow functions can also be immediately invoked.

```javascript
(() => {
  console.log("IIFE using arrow function");
})();
```

**Q6. Is IIFE still used in modern JavaScript?**

Yes, but its usage has decreased because modern JavaScript provides block scope through `let` and `const`, ES modules, and other ways to encapsulate code.

IIFEs are still useful in certain situations, especially when we need an immediately executed function scope.

**Q7. What is the difference between IIFE and a normal function expression?**

A normal function expression is defined and stored in a variable or passed somewhere for later execution. An IIFE is invoked immediately after its definition.

### Quick Revision

- **IIFE:** Immediately Invoked Function Expression.
- **Execution:** Executes immediately after definition.
- **Syntax:** `(function(){})()`.
- **Scope:** Creates a private function scope.
- **Purpose:** Avoids global namespace pollution and helps encapsulate variables.
- **Parameters:** Supports arguments like normal functions.
- **Return value:** Can return values.
- **Modern usage:** Less common due to ES modules and block-scoped variables, but still useful.

## 41. ## Pass by Value vs Pass by Reference in JavaScript

In JavaScript, arguments are passed to functions by value. However, the behavior differs depending on whether the value is a primitive or an object reference.

### 1. What Is Pass by Value?

**Pass by Value** means a copy of the variable's value is passed to a function.

Any changes made to the parameter inside the function do not affect the original variable.

**Example:**

```javascript
let num = 10;

function updateValue(value) {
    value = 20;
    console.log("Inside function:", value);
}

updateValue(num);

console.log("Outside function:", num);
```

**Output:**

```text
Inside function: 20
Outside function: 10
```

**Explanation:**

1. `num` contains the value `10`.
2. When `num` is passed to `updateValue()`, its value is copied into `value`.
3. Changing `value` to `20` does not change the original `num`.
4. Therefore, `num` remains `10`.

This happens with primitive data types such as:

- Number
- String
- Boolean
- Undefined
- Null
- BigInt
- Symbol

### 2. What Is Pass by Reference?

In traditional pass-by-reference languages, a function receives a reference to the original variable itself.

Changes made through that reference can affect the original variable.

JavaScript does **not** use traditional pass-by-reference when passing function arguments.

However, objects can produce similar-looking behavior because the value being copied is an object reference.

### 3. How JavaScript Handles Objects

When an object is passed to a function, JavaScript copies the reference value.

Both the original variable and the function parameter initially refer to the same object.

**Example:**

```javascript
let user = {
    name: "Rahul",
    age: 25
};

function updateUser(obj) {
    obj.age = 30;
}

updateUser(user);

console.log(user);
```

**Output:**

```javascript
{
    name: "Rahul",
    age: 30
}
```

**Explanation:**

1. `user` stores a reference to an object.
2. When passed to `updateUser()`, that reference value is copied into `obj`.
3. Both `user` and `obj` refer to the same object.
4. Updating `obj.age` modifies that shared object.
5. Therefore, the change is visible through `user`.

### 4. Important Difference: Reassigning an Object

Now, let's try something different.

```javascript
let user = {
    name: "Rahul",
    age: 25
};

function updateUser(obj) {
    obj = {
        name: "Amit",
        age: 30
    };
}

updateUser(user);

console.log(user);
```

**Output:**

```javascript
{
    name: "Rahul",
    age: 25
}
```

**Why?**

- Initially, `obj` and `user` refer to the same object.
- Inside the function, `obj` is reassigned to a completely new object.
- This only changes the local parameter `obj`.
- The original `user` variable still refers to the original object.

This proves that JavaScript passes the object reference **by value**, not by traditional reference.

### 5. Comparison: Primitive vs Object

| Feature | Primitive Values | Objects |
|---|---|---|
| What gets copied? | Primitive value | Object reference value |
| Can function modify original data? | No, by reassignment | Yes, by modifying object properties |
| Can reassignment affect original variable? | No | No |
| Examples | Number, String, Boolean | Object, Array, Function |

### 6. How to Avoid Modifying the Original Object?

If you don't want a function to modify the original object, create a copy.

**Using the Spread Operator:**

```javascript
let user = {
    name: "Rahul",
    age: 25
};

function updateUser(obj) {
    const copiedUser = { ...obj };
    copiedUser.age = 30;

    console.log("Inside function:", copiedUser);
}

updateUser(user);

console.log("Outside function:", user);
```

**Output:**

```text
Inside function: { name: "Rahul", age: 30 }
Outside function: { name: "Rahul", age: 25 }
```

**Important:** The spread operator creates a shallow copy. Nested objects are still shared unless you copy them separately or use an appropriate deep-cloning approach.

---

### 7. Common Interview Follow-up Questions

**Q1. Does JavaScript support pass by reference?**

No. JavaScript passes all function arguments by value. For objects, the copied value is a reference to the object.

**Q2. Why can we modify an object inside a function but not a number?**

Because modifying an object's property changes the shared object. Reassigning a primitive parameter only changes the local parameter.

**Q3. Are arrays passed by value or reference in JavaScript?**

Arrays are objects, so their reference values are copied when passed to functions. Both variables can initially refer to the same array.

```javascript
let numbers = [1, 2, 3];

function updateArray(arr) {
    arr.push(4);
}

updateArray(numbers);

console.log(numbers);
```

Output:

```text
[1, 2, 3, 4]
```

**Q4. What is the difference between shallow copy and deep copy?**

- **Shallow Copy:** Copies the top-level properties, but nested objects are still shared.
- **Deep Copy:** Creates independent copies of nested objects as well.

**Q5. What happens when we reassign an object parameter inside a function?**

Only the local parameter gets a new reference. The original variable remains unchanged.

---

### 8. Quick Revision

- JavaScript always passes function arguments by value.
- Primitive values are copied directly.
- For objects and arrays, the object reference value is copied.
- Modifying object properties inside a function can affect the original object.
- Reassigning the function parameter does not affect the original variable.
- Use shallow or deep copying when you need to avoid modifying the original object.

**One-Line Interview Answer:**

JavaScript uses pass by value for all function arguments. For objects and arrays, it copies the reference value, which allows functions to modify the original object's properties, but reassignment of the parameter does not change the original variable.

## 42. Why does removing the disabled attribute in DevTools make a button functional in plain HTML/JS, but not in React?
In plain HTML with JavaScript, when you add an onclick handler directly to a button, the event listener is attached at the DOM level. If you remove the disabled attribute using Chrome DevTools, the button immediately becomes functional because the DOM event handler is still intact.

In React, things work differently. React uses a virtual DOM and a synthetic event system to control how elements behave. When you set disabled={true} in React, React doesn’t just set the DOM attribute — it also ensures that the button’s onClick will not fire while React considers it disabled.

So, even if you manually remove the disabled attribute from the real DOM in DevTools, React’s internal state still says the button is disabled, and React’s synthetic event system prevents the onClick from firing. On the next re-render, React may even put the attribute back.

## 43. Undefined vs Not Defined in JavaScript

In JavaScript, `undefined` and `not defined` are two different concepts.

- **Undefined:** A variable has been declared, but it has not been assigned a value. JavaScript initializes it with `undefined`.
- **Not Defined:** A variable does not exist in the accessible scope. Accessing it results in a `ReferenceError`.

### 1. What Is Undefined?

`undefined` is a primitive data type in JavaScript.

When a variable is declared but no value is assigned, JavaScript initializes it with `undefined`.

**Example:**

```javascript
console.log(a); // undefined

var a = 10;

console.log(a); // 10
```

**Output:**

```text
undefined
10
```

**Explanation:**

1. During the creation phase of the execution context, JavaScript allocates memory for the `var` variable.
2. It initializes the variable with `undefined`.
3. During the execution phase, the assignment `a = 10` takes place.
4. Therefore, the first `console.log()` prints `undefined`, and the second prints `10`.

**Another Example:**

```javascript
let name;

console.log(name); // undefined
```

Here, the variable is declared but no value is assigned.

### 2. What Is Not Defined?

Not defined means JavaScript cannot find the variable in the current scope or any accessible outer scope.

When we try to access such a variable, JavaScript throws a `ReferenceError`.

**Example:**

```javascript
console.log(age);
```

**Output:**

```text
ReferenceError: age is not defined
```

**Explanation:**

1. The variable `age` has not been declared in an accessible scope.
2. JavaScript cannot resolve the identifier.
3. Therefore, it throws a `ReferenceError`.

### 3. Difference Between Undefined and Not Defined

| Feature | Undefined | Not Defined |
|---|---|---|
| Meaning | Variable exists but has no assigned value | Variable cannot be found in the accessible scope |
| Memory | Binding exists | No accessible binding exists |
| Value | `undefined` | No value can be retrieved |
| Error | No error when reading a declared, initialized binding | `ReferenceError` when accessing an unresolved identifier |
| Example | `let a; console.log(a)` | `console.log(b)` when `b` is undeclared |

### 4. Connection With the Execution Context

JavaScript executes code using an execution context.

During the creation phase, JavaScript sets up the environment for variables and functions.

For example:

```javascript
console.log(a);
console.log(b);

var a = 10;
let b = 20;
```

**Output:**

```text
undefined

ReferenceError: Cannot access 'b' before initialization
```

**Why does this happen?**

- `var a` is initialized with `undefined` during the creation phase, so accessing it before its assignment returns `undefined`.
- `let b` is also created during the creation phase, but it remains uninitialized until its declaration is evaluated.
- Accessing `b` before initialization results in a `ReferenceError`.

This period is called the **Temporal Dead Zone (TDZ)**.

### 5. What Is the Temporal Dead Zone (TDZ)?

The Temporal Dead Zone is the time between entering a scope and the point where a `let` or `const` variable is initialized.

During this period, the variable exists in the scope but cannot be accessed.

**Example:**

```javascript
console.log(name);

let name = "Rahul";
```

**Output:**

```text
ReferenceError: Cannot access 'name' before initialization
```

**Important:**

- `var` variables are initialized with `undefined`.
- `let` and `const` variables are uninitialized until their declaration is evaluated.
- Accessing `let` or `const` before initialization throws a `ReferenceError`.

### 6. Is Undefined a Data Type in JavaScript?

Yes. `undefined` is a primitive data type.

```javascript
let value;

console.log(typeof value);     // "undefined"
console.log(typeof undefined); // "undefined"
```

Interestingly:

```javascript
console.log(typeof notDeclared); // "undefined"
```

Even though `notDeclared` does not exist, `typeof` does not throw a `ReferenceError` for an undeclared identifier.

However, this exception does not apply to variables in the Temporal Dead Zone:

```javascript
console.log(typeof name);
let name = "Rahul";
```

This still throws a `ReferenceError`.

### 7. Common Interview Follow-up Questions

**Q1. What is the difference between null and undefined?**

- `undefined` means a variable has not been assigned a value.
- `null` represents the intentional absence of an object value.

```javascript
let a;
let b = null;

console.log(a); // undefined
console.log(b); // null
```

**Q2. What is the output of `typeof null`?**

```javascript
console.log(typeof null);
```

Output:

```text
object
```

This is a historical JavaScript behavior and is not an indication that `null` is an object.

**Q3. Can we explicitly assign undefined to a variable?**

Yes.

```javascript
let name = "Rahul";

name = undefined;

console.log(name); // undefined
```

However, assigning `undefined` explicitly is generally less descriptive than using `null` when intentionally representing the absence of a value.

**Q4. Does `typeof` throw an error for an undeclared variable?**

No, not when checking an unresolved identifier.

```javascript
console.log(typeof userName); // "undefined"
```

But accessing it directly throws a `ReferenceError`.

**Q5. Are `let` and `const` variables allocated memory before execution?**

Yes. Their bindings are created when the scope is instantiated, but they remain uninitialized until execution reaches their declarations. They are in the Temporal Dead Zone before that point.

---

### 8. Quick Revision

- `undefined` means a variable exists but has no assigned value.
- Not defined means JavaScript cannot find the variable in the accessible scope.
- Accessing an undeclared variable throws a `ReferenceError`.
- `var` variables are initialized with `undefined`.
- `let` and `const` are uninitialized until their declarations are evaluated.
- The Temporal Dead Zone applies to `let` and `const`.
- `typeof` on an undeclared identifier returns `"undefined"`.

**One-Line Interview Answer:**

Undefined means a variable has been declared and initialized with the default value `undefined`, but not defined means the variable cannot be found in the accessible scope, and accessing it results in a `ReferenceError`.


## 44. Execution Context?