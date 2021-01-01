/*
* The MIT License (MIT)
*
* Product:      Kotlin Hafas Toolchain
* Description:  Allows you to parse and process some raw HAFAS data.
*
* Copyright (c) 2017-2021 Steven Agyekum <agyekum@posteo.de>
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
import java.io.*

/**
 * The parser class
 *
 * @constructor Creates a parser
 * @param expr the expression
 * @param path the file path
 */
class Parser(val expr: Expression?, val path: String) {

    /**
     * Runs the parsing process
     *
     * @return none
     */
    fun parse() {

        println("Reading file into stream buffer: ${path}");

        File(path).inputStream().buffered().reader().use { reader ->
        
            val text = reader.readText()

            expr!!.compile().findAll(text).forEach() {

                val group1 = it.groups[1]?.value
                val group2 = it.groups[2]?.value
                val group3 = it.groups[3]?.value
                val group4 = it.groups[4]?.value

                val dict1 = Dictionary().codes[group1]
                val dict2 = Dictionary().codes[group2]

                println(
                    when { 
                        group1 is String -> """
                            [${group1}] ${dict1}: ${if(dict2 != null) dict2 else group2} - ${group3}
                        """.trim()

                        else -> "Halt: " + group4
                    }
                )

            }

            expr.debug()
        }

    }
}
