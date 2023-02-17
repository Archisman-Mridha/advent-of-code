data Record= Record {
        character :: Char,
        minMaxRepeatationCounts :: (Int, Int),
        password :: String
    }

removeHeadSubString :: [a] -> [a]
removeHeadSubString [ ] = [ ]
removeHeadSubString (_:remainingSubStrings)= remainingSubStrings

-- f(delimiter, string) -> list of separated substrings
-- `Eq a =>` here means that the type variable a must staisfy the Eq interface. This is a type constraint.
splitStringOn :: Eq a => a -> [a] -> [[a]]
splitStringOn _ [ ]= [ ]
splitStringOn delimiter input=
    headSubString:splitStringOn delimiter (removeHeadSubString remainingSubStrings)
        where
            (headSubString, remainingSubStrings)= span (/= delimiter) input

constructRecordFromString :: String -> Record
constructRecordFromString input=
    Record character (read minRepeatationCount, read maxRepeatationCount) password
        where
            [policy, password]= splitStringOn ':' input
            [minMaxRepeatationCounts, character:_]= splitStringOn ' ' policy
            [minRepeatationCount, maxRepeatationCount]= splitStringOn '-' minMaxRepeatationCounts

isValidPassword :: Record -> Bool
isValidPassword (Record character (minRepeatationCount, maxRepeatationCount) password) =
    repeatationCount >= minRepeatationCount && repeatationCount <= maxRepeatationCount
        where
            repeatationCount= length $ filter (== character) password

-- the IO type indicates that this function will produce side effects
main :: IO( )
main= undefined