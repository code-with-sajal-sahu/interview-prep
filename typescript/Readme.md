# 1. What is TypeScript, and why do we use it?

TypeScript is a **statically typed superset of JavaScript developed by Microsoft**. It adds features like type annotations, interfaces, type aliases, and generics to JavaScript.

We use TypeScript mainly to improve code quality, catch errors during development, and make applications easier to maintain and scale.

For example, in JavaScript, a variable can hold values of different types, which may lead to unexpected errors. TypeScript allows us to define the expected data types and identify many such mistakes before running the application.

TypeScript code is compiled into JavaScript, so it can run in JavaScript environments like browsers and Node.js.

As a MERN Stack Developer, I can use TypeScript with React on the frontend and Node.js with Express on the backend to ensure better type safety, improve code readability, and make collaboration easier in large projects.

**_Example:_**

- JavaScript

```javascript
function add(a, b) {
  return a + b;
}

add(10, "20"); // Returns "1020", JavaScript allows this operation because one argument is a number and the other is a string.
```

- TypeScript

```typescript
function add(a: number, b: number): number {
  return a + b;
}

add(10, 20); // Valid
add(10, "20"); // Type error
```

Here:

- a: number specifies that a must be a number.
- b: number specifies that b must be a number.
- : number after the parentheses specifies the return type.
  TypeScript reports an error for the second function call during type checking, helping us catch the mistake before execution.

# 2. What is the difference between JavaScript and TypeScript?

JavaScript is a dynamically typed programming language, whereas TypeScript is a statically typed superset of JavaScript that adds features such as type annotations, interfaces, and generics.
JavaScript checks many type-related problems at runtime, while TypeScript can detect many of these problems during development through static type checking.
| JavaScript | TypeScript |
|------------|------------|
| Dynamically typed | Supports static type checking |
| No built-in compile-time type checking | Detects many type errors before execution |
| Runs directly in supported JavaScript environments | Usually compiled or transpiled to JavaScript |
| Less type-related boilerplate | Explicit types can improve maintainability |
| Supports modern JavaScript features | Adds types and other development features |

# 3. What is static typing?

Static typing means checking the types of values and expressions during development or compilation rather than relying only on runtime behavior.

TypeScript uses static type checking to identify errors such as passing a string where a number is expected.

***Example***
```typescript
let age: number = 25;

age = 30;      // Valid
age = "thirty"; // Type error
```
TypeScript reports an error because the variable age is declared as a number.

We can also use type inference, where TypeScript determines the type automatically.
***Example***
```typescript
let city = "Indore";

city = "Pune"; // Valid
city = 100;    // Type error
```
Here, TypeScript infers that city is a string without requiring an explicit annotation.

# 4. Does TypeScript catch all runtime errors?

No, TypeScript does not catch all runtime errors. It mainly detects type-related errors through static analysis before execution.

Errors caused by invalid API responses, network failures, incorrect business logic, database failures, or unexpected runtime conditions can still occur.

# 5. What happens when TypeScript is compiled into JavaScript?

When TypeScript is compiled, the TypeScript compiler (tsc) checks the code according to its configuration and transforms TypeScript syntax into JavaScript. Type annotations and interfaces are removed because they do not exist at runtime.

The generated JavaScript can then run in browsers, Node.js, or other compatible JavaScript environments.

***Example***
Typescript

```typescript
function add(a: number, b: number): number {
  return a + b;
}
```

Generated JavaScript:

```javascript
function add(a, b) {
  return a + b;
}
```