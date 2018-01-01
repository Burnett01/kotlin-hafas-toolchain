/*
* The MIT License (MIT)
*
* Product:      Kotlin Hafas Toolchain
* Description:  Allows you to parse and process some raw HAFAS data.
*
* Copyright (c) 2017-2018 Steven Agyekum <agyekum@posteo.de>
*
* Permission is hereby granted, free of charge, to any person obtaining a copy of this software
* and associated documentation files (the "Software"), to deal in the Software without restriction,
* including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
* and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
* subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all copies
* or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
* TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
* THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
* TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*
*/

package com.github.burnett01.hafastoolchain

import com.github.burnett01.expression.*

/**
 * The expression object
 *
 * This object contains all the expressions
 *
 * @return Object of expressions (ExpressionBuilder)
 */
object EXPR {

    private val options: Set<RegexOption> = setOf(
        RegexOption.MULTILINE
    )
    
    /**
     * A group of 'Eckdaten' expressions
     *
     * @property ECK
     * @return  object
     */
    object ECK {
        
        /**
         * Expression for dates in 'Eckdaten' file
         *
         * @property ECK.DATES
         * @return  Expression (ExpressionBuilder)
         *
         * @see github.com/Burnett01/kotlin-expression-builder
         * @see docs/research/expressions.md
         */
        val DATES: Expression? = expression({
            capture {
                digit { exact(2) }
                literal('.')
                digit { exact(2) }
                literal('.')
                digit { exact(4) }
            }
        })
    }

    /**
     * Expression for 'LIN' files
     *
     * @property LIN
     * @return  Expression (ExpressionBuilder)
     *
     * @see github.com/Burnett01/kotlin-expression-builder
     * @see docs/research/expressions.md
     */
    val LIN: Expression? = expression({
        start()
        nocapture {
            literal('*')
            capture {
                match { string("ZLARG") }
            }
            match { whitespace() }
            capture {
                digit { quantity(Q.ONE_OR_MORE) }
                or()
                word { range(1, 3, ',') }
            }
            match { whitespace() }
            quantity(Q.ZERO_OR_ONE)
            capture {
                char('R')
                digit { exact(6) }
            }
            quantity(Q.ZERO_OR_ONE)
            or()
            capture {
                start()
                digit { exact(7) }
            }
        }
    }, options)
}
