# Haskell review

Features I noticed and am impressed with -

- Default `currying` which enables Haskell to turn on `Lazy evaluation` by default.
- Easy `Polymorphic functions` and `Type Variables` making it better.

## Type Variables

`Type Variables` are placeholders for types that can be used in functions, types and data declarations.

They are used to `make a function polymorphic`. For example, a function that adds two numbers can be defined to work with any numeric type by using a type variable. Here's an example of a function that adds two values of a type variable a, where a represents any numeric type -

```hs
add :: Num a => a -> a -> a
add x y = x + y
```

Using type variables allows Haskell to be more generic and reusable, since functions and data structures can be defined to work with any type that satisfies certain `type constraints`. Type variables are denoted by a single lowercase letter, such as a, b, c, and so on.

## Lazy Evaluation

Lazy evaluation is a technique that **delays the evaluation of expressions until their values are actually needed**. This is in contrast to strict (or eager) evaluation, which evaluates expressions as soon as they are bound to a variable or passed as an argument to a function. In Haskell, lazy evaluation is **enabled by default**.

Advantages -

- `Improved performance` - Since Haskell only evaluates expressions when their values are required, it can avoid unnecessary computations and save memory by not storing intermediate values that are not needed.

- `Infinite data structures` - Lazy evaluation allows for the creation of infinite data structures, such as an infinite list. These data structures are evaluated only as much as necessary to produce the required result, and can be used to represent computations that would not be possible with strict evaluation.

Disadvantages -

- `Space leaks` - In some cases, lazy evaluation can lead to memory leaks or inefficiencies, since it can cause unevaluated expressions to accumulate and consume memory.

- `Time complexity` - Lazy evaluation can sometimes lead to higher time complexity than strict evaluation, since it can require more time to evaluate expressions when they are actually needed.