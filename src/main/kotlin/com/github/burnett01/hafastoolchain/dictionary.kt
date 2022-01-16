/*
* The MIT License (MIT)
*
* Product:      Kotlin Hafas Toolchain
* Description:  Allows you to parse and process some raw HAFAS data.
*
* Copyright (c) 2017-2022 Steven Agyekum <agyekum@posteo.de>
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

/**
 * The dictionary class
 *
 * @constructor None
 */
class Dictionary() {

    /**
     * Translates codes into human-readable text
     *
     * @return HashMap of strings
     */
    public val codes: HashMap<String, String> = hashMapOf(
          "Z"       to "Fahrtnummer"
        , "L"       to "Linie"
        , "G"       to "Geraeteklasse"
        , "R"       to "Richtung"
        , "A"       to "Attribute"
        , "BV"      to "Bus-Verstärker"
        , "NX"      to "National Express"
        , "NFB"     to "Niederflur Bus"
        , "ALT"     to "Anruf-Linien-Taxi"
        , "BUS"     to "Bus"
        , "RFB"     to "Rufbus"
        , "NET"     to "Netliner"
        , "SEV"     to "Schienen-Ersatz-Verkehr"
        , "ASE"     to "ASEAG"
        , "ASEAG"   to "ASEAG"
        , "AVV"     to "Aachener Verkehrsverbund"
        , "DPN"     to "Nahreisezug"
        , "ABR"     to "ABELLIO Rail"
        , "AR"      to "ABELLIO Rail"
        , "ARRE"    to "ABELLIO Rail"
        , "ARRRX"   to "ABELLIO Rail"
        , "RTB"     to "Rurtalbahn"
        , "RVE"     to "DB Bahn Rheinlandbus"
        , "SKB"     to "Selfkantbahn"
        , "TA"      to "TAETER"
        , "VIA"     to "VIAS"
        , "WES"     to "WestVerkehr"
        , "DB"      to "Staatsbahnen"
        , "DBAG"    to "Staatsbahnen"
    )

}
