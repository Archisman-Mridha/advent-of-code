# Advent of Code in Kotlin

Here is the `problem statement` -

You are given some expressions. Each expression contains addition(+), multiplication(*) and parantheses (( )). Just like normal math, the expression inside a paranthesis must be evaluated before it can be used by the surrounding expression. Addition and multiplication still work the same way. However, the rules of `operator precedance have changed`. Multiplication and addition have the same precedance right now and the entire expression is `evaluated from left to right`.

For example :

- 1 + 2 * 3 + 4 * 5 + 6= 71
- 1 + (2 * 3) + (4 * (5 + 6))= 51