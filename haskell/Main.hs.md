## 1

```hs
splitStringByWhitespaces delimiter input=
    headSubString:splitStringByWhitespaces delimiter (removeHeadSubString remainingSubStrings)
        where(headSubString, remainingSubStrings)= span (/= delimiter) input
```

- Definition of `span` function -
    ```hs
    span :: (a -> Bool) -> [a] -> ([a], [a])
    ```

    **Definiton** - is used to split a list into two parts based on a predicate. It takes a predicate function and a list as arguments, and returns a tuple of two lists.

    **Example** -
    ```hs
    span (< 3) [1,2,3,4,1,2,3,4] -- output is ([1,2],[3,4,1,2,3,4])
    ```

- ```hs
    headSubString:splitStringByWhitespaces delimiter (removeHeadSubString remainingSubStrings)
    ```

    This means a list is constructed like this -
    [headSubString, headSubString for 2nd level recursion, ...headSubString for last level recursion].

    Here `:` means concatenation

- What is `where` -
    It is used to define local bindings (variables or nested funcitons) in a function. It allows you to define a set of names and values that are only available within the scope of a specific expression or function.

    Example -
    ```hs
    demoFunction x = f (g x)
        where
            f y = y + 1
            g z = z * 2
    ```

    Here is the basic syntax -
    ```hs
    functionName argument = expression where
        binding = value
        -- more bindings as necessary
    ```

## 2

```hs
constructRecordFromString :: String -> Record
constructRecordFromString input=
    Record character (read minRepeatationCount, read maxRepeatationCount) password
        where
            [policy, password]= splitStringOn ':' input
            [minMaxRepeatationCounts, character:_]= splitStringOn ' ' policy
            [minRepeatationCount, maxRepeatationCount]= splitStringOn '-' minMaxRepeatationCounts
```

- The `read` function -
    In Haskell, the read function is a standard library function that is used to convert a string into a value of any other data type. It takes a string as an argument and returns a value of the desired type.

    The read function can read a string from a tuple of strings, as long as the input string represents a valid value of the desired data type.

- The `function application opeartor ($)` -
    It is used to simplify funciton invokation. Here is an example -

    ```hs
    f (g (h x)) -- can be simplified to
    f $ g $ h x
    ```