# React.js Interview Questions

## 1. What is React?

React is a front-end and open-source javascript library which is useful in developing single-page user interfaces. Under the hood, react uses virtual dom.

It follows the component-based approach. Components make the code more predictable and easier to debug.

It lets us build complex UIs from small and reusable pieces of code called "components".

React can efficiently update and render just the right components when the data changes

## 2. What is DOM (Document Object Model)?

**DOM (Document Object Model):**
Think of the DOM as a tree-like structure that represents the elements of a web page. Each element, like headings, paragraphs, images, and buttons, is a node in this tree. The DOM allows scripts (like JavaScript) to interact with and manipulate these elements, changing their content, style, and behavior dynamically. It's like a blueprint of our web page that scripts can use to update what users see.

- `Real DOM:` The Real DOM is the actual tree structure that browsers create when a web page is loaded. It's a representation of the web page's structure and content as it exists in the browser's memory. When we change something on a web page using JavaScript, we are actually manipulating the Real DOM. However, updating the Real DOM can be slow and resource-intensive, especially for complex web pages.

- `Virtual DOM:` The Virtual DOM is a concept introduced to make web applications more efficient. It's a lightweight copy of the Real DOM that's maintained by libraries like React. When we want to update something on a web page, React first updates the Virtual DOM, which is much faster than updating the Real DOM. Then, React compares the changes made to the Virtual DOM with the current Real DOM. It figures out the most efficient way to update the Real DOM based on these changes and applies only the necessary updates. This process is often much faster than directly manipulating the Real DOM for every change, making your web app more responsive.

| Comparison           | Real DOM                               | Virtual DOM                          |
| -------------------- | -------------------------------------- | ------------------------------------ |
| **Speed**            | Slow                                   | Faster                               |
| **Memory**           | Too much memory wasted                 | No memory wastage                    |
| **DOM Manipulation** | Very expensive                         | Very easy                            |
| **Updation**         | Can directly update HTML               | Can’t directly update HTML           |
| **Creation**         | Creates a new DOM if elements updates. | Updates the JSX if elements updates. |

## 3. What Are Pure Components in React?

A **Pure Component** in React is a component that uses shallow comparison of its previous and new props and state to determine whether an update can be skipped.

React provides `React.PureComponent` for class components. It implements a default `shouldComponentUpdate()` behavior based on shallow comparison, helping avoid unnecessary rendering work.

For functional components, `React.memo()` provides a similar optimization based on props.

### Interview answer

A Pure Component in React is a class component that extends `React.PureComponent`. It performs a shallow comparison of previous and new props and state to determine whether a component update can be skipped.

Unlike a regular class component, which normally re-renders when its parent renders, a Pure Component can avoid unnecessary re-renders when its props and state remain shallowly equal.

For functional components, `React.memo()` provides similar prop-based render optimization, while `useMemo()` caches the result of a calculation.

Pure Components are useful for performance optimization, but they work best when we follow immutable data-update practices and use memoization only where it provides a meaningful benefit.

### One-Line Difference (Interview Ready)

> **PureComponent** → Uses shallow comparison of props and state to decide whether a class component should update.
>
> **React.memo()** → Uses prop comparison to decide whether a functional component can skip rendering.

### 1. Pure Components in Class Components

A class component can extend `React.PureComponent` instead of `React.Component`.

React shallowly compares the previous and next props and state. If they are shallowly equal, React can skip the component's update.

#### Example

```jsx
import React from "react";

class Greeting extends React.PureComponent {
  render() {
    console.log("Greeting rendered");

    return <h1>Hello, {this.props.name}!</h1>;
  }
}

export default Greeting;
```

#### How It Works

1. `Greeting` extends `React.PureComponent`.
2. React compares the previous and next props and state using shallow comparison.
3. If the comparison finds no changes, React can skip the component's update.
4. If a prop or state value changes according to the comparison, React proceeds with the update.

**Important:** A Pure Component can still render when its own state changes or when context it consumes changes. Shallow comparison is not a guarantee that the component will never render again.

### 2. What Is Shallow Comparison?

Shallow comparison checks top-level values rather than recursively comparing nested objects and arrays.

#### Example: Same Primitive Values

```jsx
const previousProps = {
  name: "Sajal",
  age: 25,
};

const nextProps = {
  name: "Sajal",
  age: 25,
};
```

The corresponding top-level values are equal, so these props are shallowly equal.

#### Example: Different Object References

```jsx
const previousProps = {
  user: { name: "Sajal" },
};

const nextProps = {
  user: { name: "Sajal" },
};
```

Although both nested objects contain the same data, they are different object references. Therefore, the `user` property is considered changed by a shallow comparison.

**Key takeaway:** Pure Components work best when state and props are updated immutably.

### 3. Pure Components in Functional Components

Functional components cannot extend `React.PureComponent`. Instead, React provides `React.memo()` for optimizing component rendering and `useMemo()` for caching calculation results.

#### A. React.memo()

`React.memo()` is a higher-order component that allows React to skip rendering a functional component when its props have not changed according to the comparison.

##### Example

```jsx
import React from "react";

const Greeting = React.memo(function Greeting({ name }) {
  console.log("Greeting rendered");

  return <h1>Hello, {name}!</h1>;
});

export default Greeting;
```

##### How It Works

1. `React.memo()` wraps the `Greeting` component.
2. React compares the previous and next props using `Object.is` for each prop by default.
3. If the props are unchanged, React can skip rendering the component.
4. If the props change, React renders the component again.

**Note:** `React.memo()` does not prevent re-renders caused by the component's own state updates or context changes.

#### B. useMemo()

`useMemo()` is a React Hook that caches the result of a calculation between renders until its dependencies change.

##### Example

```jsx
import { useMemo } from "react";

function ProductList({ products }) {
  const totalPrice = useMemo(() => {
    return products.reduce((total, product) => total + product.price, 0);
  }, [products]);

  return <h2>Total Price: {totalPrice}</h2>;
}

export default ProductList;
```

##### How It Works

1. React calculates the total price and caches the result.
2. If the `products` dependency remains unchanged according to `Object.is`, React can reuse the cached result.
3. If the dependency changes, React recalculates the total.

**Important:** `useMemo()` does not prevent the component from rendering. It memoizes the calculation result, not the component itself.

### 4. PureComponent vs React.memo vs useMemo

| Feature                       | PureComponent                         | React.memo                                  | useMemo                                  |
| ----------------------------- | ------------------------------------- | ------------------------------------------- | ---------------------------------------- |
| Used with                     | Class components                      | Functional components                       | Functional components                    |
| Main purpose                  | Optimize component updates            | Optimize component rendering                | Cache calculation results                |
| Comparison                    | Shallow comparison of props and state | Props compared using `Object.is` by default | Dependencies compared using `Object.is`  |
| Can skip component rendering? | Yes, based on its comparison          | Yes, based on its comparison                | No, not by itself                        |
| Typical use case              | Class component optimization          | Avoiding unnecessary child renders          | Avoiding repeated expensive calculations |

### 5. Advantages of Pure Components

1. **Performance optimization:** Can reduce unnecessary component rendering work.
2. **Less boilerplate:** No need to implement the same shallow-comparison logic manually in `shouldComponentUpdate()`.
3. **Cleaner code:** Separates common update optimization behavior from rendering logic.
4. **Useful for repeated renders:** Can help when a component frequently receives unchanged props and state.

### 6. Limitations of Pure Components

1. **Shallow comparison only:** Nested objects and arrays are not compared recursively.
2. **Mutation problems:** Mutating an object or array without changing its reference may prevent React from detecting a change.
3. **Comparison overhead:** Shallow comparison has a cost and may not improve every component's performance.
4. **Not a universal solution:** State updates, context changes, and other factors can still cause renders.
5. **Immutable updates matter:** Creating new references when data changes helps React detect updates correctly.

### 7. When Should We Use Pure Components?

Use `React.PureComponent` when:

- You are working with a class component.
- The component frequently receives the same props and state.
- Shallow comparison is appropriate for the component's data.
- Avoiding unnecessary rendering work provides a measurable benefit.

For functional components, consider `React.memo()` when prop-based render optimization is useful. Use `useMemo()` when caching an expensive calculation is beneficial.

Avoid adding memoization everywhere without a reason. Measure performance and optimize where necessary.

### 8. Common Interview Follow-Up Questions

**Q1. What is the difference between `React.Component` and `React.PureComponent`?**

`React.Component` does not automatically use shallow comparison to skip updates. `React.PureComponent` implements a default `shouldComponentUpdate()` behavior based on shallow comparison of props and state.

**Q2. Does PureComponent perform a deep comparison?**

No. It performs a shallow comparison of props and state.

**Q3. Can PureComponent be used with functional components?**

No. `React.PureComponent` is a base class for class components. For functional components, `React.memo()` provides similar prop-based rendering optimization.

**Q4. Does React.memo prevent all re-renders?**

No. It can skip rendering when props are unchanged, but the component can still re-render because of its own state updates or context changes.

**Q5. Does useMemo prevent component re-renders?**

No. `useMemo()` caches a calculation result. It does not prevent the component from rendering.

**Q6. What happens if we mutate an object inside a Pure Component?**

If the object reference remains the same, a shallow comparison may not detect the nested change. This can cause the UI to become inconsistent with the mutated data.

**Q7. Should we use PureComponent everywhere?**

No. Use it when shallow comparison can avoid meaningful rendering work. Unnecessary memoization can add complexity and comparison overhead.

### Quick Revision

- **`React.PureComponent`** → Class component optimization using shallow comparison of props and state.
- **`React.memo()`** → Functional component rendering optimization based on props.
- **`useMemo()`** → Caches a calculation result.
- **Shallow comparison** → Compares top-level values and references rather than nested structures recursively.
- **Immutable updates** → Help React detect changes correctly.
- **Performance tip** → Optimize components when there is a meaningful performance benefit.

## 4. What Are Controlled and Uncontrolled Components in React?

Controlled and uncontrolled components are two approaches to managing form input data in React.

- **Controlled Components:** Form data is managed by React state.
- **Uncontrolled Components:** Form data is managed by the DOM, and React can access it using a ref when needed.

### One-Line Difference (Interview Ready)

> **Controlled Component** → Form data is controlled by React state.
>
> **Uncontrolled Component** → Form data is maintained by the DOM itself.

### 1. Controlled Components

A controlled component is a form element whose value is controlled by React state.

React state acts as the single source of truth for the input value. Whenever the user changes the input, an event handler updates the state, and React renders the updated value.

#### Example

```jsx
import { useState } from "react";

function ControlledForm() {
  const [name, setName] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log("Name:", name);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="name">Name:</label>

      <input
        id="name"
        type="text"
        value={name}
        onChange={(event) => setName(event.target.value)}
      />

      <button type="submit">Submit</button>
    </form>
  );
}

export default ControlledForm;
```

#### How It Works

1. `useState("")` initializes the input value.
2. The `value` prop binds the input to React state.
3. The `onChange` handler updates the state whenever the user types.
4. React renders the input with the updated state value.
5. On form submission, the current value is available in the `name` state variable.

#### Advantages

- Provides complete control over form values through React state.
- Makes real-time validation easier.
- Supports conditional rendering based on input values.
- Makes it easier to manage dependent fields and dynamic forms.
- Keeps the form data readily available for API requests.

#### Limitations

- Requires state and event handlers for inputs.
- Frequent state updates can cause additional rendering work.
- Large forms may require more code unless reusable components or form libraries are used.

### 2. Uncontrolled Components

An uncontrolled component is a form element whose value is managed by the DOM rather than being synchronized with React state on every change.

React can access the current input value through a ref, typically when the form is submitted.

#### Example

```jsx
import { useRef } from "react";

function UncontrolledForm() {
  const nameRef = useRef(null);

  const handleSubmit = (event) => {
    event.preventDefault();

    console.log("Name:", nameRef.current.value);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="name">Name:</label>

      <input id="name" type="text" ref={nameRef} defaultValue="" />

      <button type="submit">Submit</button>
    </form>
  );
}

export default UncontrolledForm;
```

#### How It Works

1. `useRef(null)` creates a ref to access the DOM input element.
2. The `ref` prop connects the ref to the input.
3. The DOM maintains the current input value as the user types.
4. `defaultValue` provides the initial value without controlling subsequent changes.
5. When the form is submitted, `nameRef.current.value` retrieves the current input value.

#### Advantages

- Requires less state-management code for simple forms.
- Useful when input values are needed only during form submission.
- Works naturally with certain native HTML form behaviors.
- Useful for file inputs, whose values cannot be controlled like ordinary text inputs.

#### Limitations

- Does not provide automatic synchronization between input values and React state.
- Real-time validation and conditional UI updates require additional logic.
- Reading and managing multiple input values can become less convenient for complex forms.

### 3. Controlled vs Uncontrolled Components

| Feature              | Controlled                          | Uncontrolled                         |
| -------------------- | ----------------------------------- | ------------------------------------ |
| Source of truth      | React state                         | DOM                                  |
| Input value          | `value`                             | Usually accessed using a ref         |
| Initial value        | `useState()`                        | `defaultValue`                       |
| Updating data        | State update through event handlers | DOM updates the input value          |
| Real-time validation | Easier                              | Requires additional logic            |
| Conditional UI       | Easier to implement                 | Less convenient                      |
| Best suited for      | Dynamic and complex forms           | Simple forms and DOM-oriented inputs |

### 4. When Should We Use Each Approach?

**Use controlled components when:**

- You need real-time validation.
- The UI depends on input values.
- You need to enable or disable buttons based on form data.
- You need to manage dependent fields or dynamic forms.
- You want to keep form data synchronized with React state.

**Use uncontrolled components when:**

- You need to read values only when submitting a form.
- The form is simple and does not require continuous state synchronization.
- You are working with file inputs or integrating with APIs that rely on DOM elements.

### 5. Common Interview Follow-Up Questions

**Q1. What is the main difference between controlled and uncontrolled components?**

Controlled components use React state to manage input values, whereas uncontrolled components let the DOM maintain the current values.

**Q2. What is the difference between `value` and `defaultValue`?**

`value` sets the current value of a controlled input. `defaultValue` specifies the initial value of an uncontrolled input.

**Q3. Can we use refs with controlled components?**

Yes. Refs can be used to focus inputs, select text, or access DOM properties. However, the input's value is still controlled by React state.

**Q4. Which approach is better?**

Neither is universally better. Controlled components are generally more convenient for complex forms, validation, and dynamic interfaces. Uncontrolled components can be simpler for basic forms.

**Q5. Are uncontrolled components the same as components without state?**

Not necessarily. An uncontrolled input's value is maintained by the DOM, but the React component may still use state for other purposes.

**Q6. Why is `defaultValue` used instead of `value` in an uncontrolled input?**

`defaultValue` initializes the input without forcing React state to control its current value. Using `value` without an appropriate update handler can make an input effectively read-only.

### Quick Revision

- **Controlled:** React state manages the current input value.
- **Uncontrolled:** The DOM manages the current input value.
- **`value`:** Used to control the current value.
- **`defaultValue`:** Used to set the initial value.
- **`onChange`:** Commonly used to update controlled input state.
- **`useRef()`:** Commonly used to read uncontrolled input values.
- **File inputs:** Typically handled as uncontrolled inputs in React.

## 5. What Is the React Component Lifecycle?

The **React Component Lifecycle** refers to the different stages a component goes through from its creation to its removal from the UI.

In class components, React provides lifecycle methods that allow us to execute code at specific stages. In functional components, Hooks such as `useEffect()` are commonly used to synchronize with external systems and perform side effects.

### One-Line Definition (Interview Ready)

> The React component lifecycle is the sequence of stages a component goes through, including mounting, updating, and unmounting, during which React allows us to perform specific operations.

### 1. Stages of the React Component Lifecycle

A class component lifecycle is commonly explained using three main phases:

1. **Mounting:** The component is created and added to the DOM.
2. **Updating:** The component re-renders when its props or state change.
3. **Unmounting:** The component is removed from the DOM.

An additional concept is **error handling**, which covers lifecycle methods used to handle errors in descendant components.

Initialization is also commonly discussed as the stage in which initial props and state are established.

### 2. Mounting Phase

The mounting phase occurs when a component is created and inserted into the DOM for the first time.

The main class component lifecycle methods are:

| Method                              | Description                                         |
| ----------------------------------- | --------------------------------------------------- |
| `constructor()`                     | Initializes state and binds methods when needed.    |
| `static getDerivedStateFromProps()` | Updates state based on props in specific use cases. |
| `render()`                          | Returns the JSX or other React elements to display. |
| `componentDidMount()`               | Runs after the component has been mounted.          |

#### Example

```jsx
import React from "react";

class UserProfile extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      name: "Sajal",
    };
  }

  componentDidMount() {
    console.log("Component mounted");
  }

  render() {
    return <h1>Hello, {this.state.name}!</h1>;
  }
}

export default UserProfile;
```

**How it works:**

1. `constructor()` initializes the component state.
2. `render()` describes the UI.
3. React commits the rendered output to the DOM.
4. `componentDidMount()` runs after the component is mounted.

**Common use cases of `componentDidMount()`:**

- Fetching data from an API.
- Setting up subscriptions.
- Connecting to external systems.
- Setting up timers or event listeners, with appropriate cleanup later.

### 3. Updating Phase

The updating phase occurs when a component re-renders because of changes to its props, state, or relevant context.

The main class component lifecycle methods are:

| Method                              | Description                                                        |
| ----------------------------------- | ------------------------------------------------------------------ |
| `static getDerivedStateFromProps()` | Can update state based on incoming props.                          |
| `shouldComponentUpdate()`           | Determines whether React should proceed with rendering the update. |
| `render()`                          | Returns the updated UI description.                                |
| `getSnapshotBeforeUpdate()`         | Captures information from the DOM before React applies an update.  |
| `componentDidUpdate()`              | Runs after an update has been committed to the DOM.                |

#### Example

```jsx
import React from "react";

class Counter extends React.Component {
  state = {
    count: 0,
  };

  componentDidUpdate(prevProps, prevState) {
    if (prevState.count !== this.state.count) {
      console.log("Count updated:", this.state.count);
    }
  }

  render() {
    return (
      <div>
        <h2>Count: {this.state.count}</h2>

        <button
          onClick={() =>
            this.setState(({ count }) => ({
              count: count + 1,
            }))
          }
        >
          Increment
        </button>
      </div>
    );
  }
}

export default Counter;
```

**How it works:**

1. The user clicks the Increment button.
2. `setState()` requests a state update.
3. React renders the updated UI and commits the change.
4. `componentDidUpdate()` runs after the update is committed.

**Important:** `setState()` is a state-update method, not a lifecycle method.

### 4. Unmounting Phase

The unmounting phase occurs when a component is removed from the DOM.

The main class lifecycle method is:

| Method                   | Description                                                  |
| ------------------------ | ------------------------------------------------------------ |
| `componentWillUnmount()` | Runs immediately before a component is removed from the DOM. |

#### Example

```jsx
import React from "react";

class Timer extends React.Component {
  componentDidMount() {
    this.timerId = setInterval(() => {
      console.log("Timer running");
    }, 1000);
  }

  componentWillUnmount() {
    clearInterval(this.timerId);
    console.log("Timer stopped");
  }

  render() {
    return <h2>Timer Component</h2>;
  }
}

export default Timer;
```

**How it works:**

1. `componentDidMount()` starts the timer.
2. The timer continues while the component is mounted.
3. When the component is removed, `componentWillUnmount()` clears the timer.

**Common use cases of `componentWillUnmount()`:**

- Clearing timers and intervals.
- Removing event listeners.
- Unsubscribing from external systems.
- Cleaning up resources to prevent leaks.

### 5. Error Handling Phase

React class components also provide lifecycle methods for handling errors in descendant components.

| Method                              | Description                                                          |
| ----------------------------------- | -------------------------------------------------------------------- |
| `static getDerivedStateFromError()` | Updates state so the error boundary can display fallback UI.         |
| `componentDidCatch()`               | Can log information about an error caught in a descendant component. |

These methods are used to implement **Error Boundaries**.

Error boundaries generally do not catch errors in event handlers, asynchronous callbacks, or errors thrown by the boundary itself.

### 6. Deprecated Lifecycle Methods

Some lifecycle methods from older React versions should generally not be used in new code.

| Deprecated method             | Modern alternative or guidance                                                          |
| ----------------------------- | --------------------------------------------------------------------------------------- |
| `componentWillMount()`        | Use `componentDidMount()` for post-mount side effects.                                  |
| `componentWillReceiveProps()` | Consider deriving state only when necessary, or use other state-management approaches.  |
| `componentWillUpdate()`       | Use `getSnapshotBeforeUpdate()` or `componentDidUpdate()` according to the requirement. |

These legacy methods were renamed with an `UNSAFE_` prefix in modern React versions because their behavior can be problematic, especially with concurrent rendering.

For example:

- `UNSAFE_componentWillMount()`
- `UNSAFE_componentWillReceiveProps()`
- `UNSAFE_componentWillUpdate()`

**Interview tip:** Avoid saying `componentWillMount()` is a recommended modern lifecycle method. It is deprecated for ordinary use and is not called in the same way as modern post-mount lifecycle methods.

### 7. Component Lifecycle in Functional Components

Functional components do not have class lifecycle methods such as `componentDidMount()` or `componentWillUnmount()`.

Instead, `useEffect()` allows a component to synchronize with external systems, such as APIs, timers, subscriptions, and event listeners.

#### Example

```jsx
import { useEffect } from "react";

function Timer() {
  useEffect(() => {
    const timerId = setInterval(() => {
      console.log("Timer running");
    }, 1000);

    return () => {
      clearInterval(timerId);
      console.log("Timer cleaned up");
    };
  }, []);

  return <h2>Timer Component</h2>;
}

export default Timer;
```

**How it works:**

1. After the component commits, the Effect sets up the timer.
2. The timer runs while the Effect remains active.
3. When the component unmounts, React runs the cleanup function.
4. The cleanup function clears the timer.

The empty dependency array means the Effect does not re-synchronize because of changing reactive dependencies. In development Strict Mode, React may run an additional setup-and-cleanup cycle to help identify bugs.

### 8. Class Lifecycle Methods vs Functional Components

| Class component           | Functional component equivalent or approach                              |
| ------------------------- | ------------------------------------------------------------------------ |
| `componentDidMount()`     | Often implemented with `useEffect()`, depending on the requirement.      |
| `componentDidUpdate()`    | Often implemented with `useEffect()` and dependencies.                   |
| `componentWillUnmount()`  | Effect cleanup function.                                                 |
| `constructor()`           | Initialize state with `useState()` or other Hooks as needed.             |
| `shouldComponentUpdate()` | Consider `React.memo()` for prop-based render optimization.              |
| `componentDidCatch()`     | Error Boundaries still require a class component in standard React APIs. |

**Note:** These are conceptual comparisons, not exact one-to-one replacements. For example, an Effect is intended to synchronize with external systems, not simply reproduce every class lifecycle method.

### 9. Common Interview Follow-Up Questions

**Q1. What are the main phases of the React component lifecycle?**

The main phases are mounting, updating, and unmounting. Error handling is another lifecycle-related concept.

**Q2. What is the difference between `componentDidMount()` and `componentDidUpdate()`?**

`componentDidMount()` runs after the component is initially mounted. `componentDidUpdate()` runs after a subsequent update has been committed.

**Q3. What is the purpose of `componentWillUnmount()`?**

It performs cleanup before a component is removed, such as clearing timers, removing listeners, and unsubscribing from external systems.

**Q4. Is `setState()` a lifecycle method?**

No. `setState()` requests a state update in a class component. React may then render and commit an update.

**Q5. What is the difference between `useEffect()` and `componentDidMount()`?**

`componentDidMount()` runs after a class component mounts. `useEffect()` synchronizes a functional component with external systems and can run after mounting and again when dependencies change. Its cleanup runs before the Effect re-synchronizes and when it is removed.

**Q6. Why should we clean up Effects?**

Cleanup prevents resources such as timers, subscriptions, and event listeners from remaining active when they are no longer needed.

**Q7. Does `componentDidMount()` always execute exactly once?**

In normal production mounting, it runs after each mount. In development Strict Mode, React may perform an extra mount-and-cleanup cycle to help detect problems. Remounting also causes it to run again.

**Q8. What are Error Boundaries?**

Error Boundaries are components that catch certain errors in their descendant component trees and display fallback UI instead of allowing the affected part of the UI to crash without recovery.

### Quick Revision

- **Mounting:** Component is added to the DOM.
- **Updating:** Component updates because of changes to props, state, or context.
- **Unmounting:** Component is removed from the DOM.
- **`componentDidMount()`:** Runs after mounting.
- **`componentDidUpdate()`:** Runs after an update is committed.
- **`componentWillUnmount()`:** Used for cleanup.
- **`useEffect()`:** Synchronizes functional components with external systems.
- **`setState()`:** Requests a state update; it is not a lifecycle method.
- **Deprecated methods:** Avoid legacy `componentWillMount()`, `componentWillReceiveProps()`, and `componentWillUpdate()` in new code.
