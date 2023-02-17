package solution

import java.io.File
import java.io.FileNotFoundException
import java.util.StringTokenizer

enum class TokenTypes {

    OpenParanthesis,
    CloseParanthesis,
    Add,
    Multiply,
    Number
}

data class Token(
    val type: TokenTypes, val stringRepresentation: String)

fun String.parse( ): List<Token> {

    return buildList {
        // this@parse denotes the `receiver object` on which the `parse` method is invoked
        var input= this@parse.trimStart( )

        while(
            input.isNotEmpty( ) // ignoring whitespaces
        ) {

            val token: Token= when(input.first( )) {

                '(' -> Token(TokenTypes.OpenParanthesis, "(")
                ')' -> Token(TokenTypes.CloseParanthesis, ")")

                '+' -> Token(TokenTypes.Add, "+")
                '*' -> Token(TokenTypes.Multiply, "*")

                else -> Token(
                                        // keep taking the continuous series of digits - representing a number, eg: `420`
                    TokenTypes.Number, input.takeWhile(Char::isDigit))
            }
            add(token)

            input= input.drop(token.stringRepresentation.length).trimStart( )
        }
    }
}

object PartOne {

    fun evaluateLiteralOrParanthesizedExpression(tokens: List<Token>): Pair<Int, List<Token>> {
        when(tokens.first( ).type) {
    
            TokenTypes.Number -> {
                val value= tokens.first( ).stringRepresentation.toInt( )
    
                return Pair(value, tokens.drop(1))
            }
    
            TokenTypes.OpenParanthesis -> {
                // evaluating the expression inside the paranthesis
                val evaluationResult= this.evaluateTokens(tokens.drop(1))
 
                val remainingTokens= evaluationResult.second
                if(remainingTokens.first( ).type != TokenTypes.CloseParanthesis)
                    throw Exception("closing paranthesis not found for paranthesized expression")
    
                return Pair(evaluationResult.first, remainingTokens.drop(1))
            }
    
            else -> throw Exception("exception occured at `evaluateLiteralOrParanthesizedExpression( )`")
        }
    }
    
    fun evaluateTokens(tokens: List<Token>)
        /*
            The whole sequence of tokens is not evaluated. In the Pair, there is :
    
            * 1. Int: representing the result from evaluation of a part from the provided sequnce of tokens
            * 2. List<Token>: remaining sequence of tokens in the list
        */
        : Pair<Int, List<Token>>
    {
        var evaluationResult= this.evaluateLiteralOrParanthesizedExpression(tokens)
    
        var answer= evaluationResult.first
        var remainingTokens= evaluationResult.second
    
        while(remainingTokens.isNotEmpty( ) && remainingTokens.first( ).type != TokenTypes.CloseParanthesis) {
            // while check passes, that means there is a binary operator
            val binaryOperatorToken= remainingTokens.first( )
    
            // evaluating right hand side of the binary operation
            evaluationResult= this.evaluateLiteralOrParanthesizedExpression(remainingTokens.drop(1))
            remainingTokens= evaluationResult.second
    
            when(binaryOperatorToken.type) {
    
                TokenTypes.Add ->
                    answer += evaluationResult.first
    
                TokenTypes.Multiply ->
                    answer *= evaluationResult.first
    
                else -> throw Exception("exception occured at `evaluateTokens( )`")
            }
        }
    
        return Pair(answer, remainingTokens)
    }
    
    fun evaluateLine(line: String): Int {
        val tokens= line.parse( )
    
        return (this.evaluateTokens(tokens)).first
    }
}

object PartTwo {

    fun evaluateLiteralOrParanthesizedExpression(tokens: List<Token>): Pair<Int, List<Token>> {
        when(tokens.first( ).type) {
    
            TokenTypes.Number -> TODO( )

            TokenTypes.OpenParanthesis -> TODO( )

            else -> throw Exception("exception occured at `evaluateLiteralOrParanthesizedExpression( )`")
        }

        TODO( )
    }

    fun EvaluateAdditions( ) { }

    fun EvaluateMultiplications( ) { }

    fun evaluateLine(line: String): Int {
        val tokens= line.parse( )

        TODO( )
    }
}

fun main( ) {

    val inputFile= File("src/main/resources", "inputs.txt")

    if(!inputFile.exists( ))
        throw FileNotFoundException("inputs.txt file not found")

    inputFile.forEachLine( ) {
        println("Part 1 : ${it}= ${PartOne.evaluateLine(it)}")
        println("Part 2 : ${it}= ${PartTwo.evaluateLine(it)}")
    }

}