## hafas-toolchain

hafas-toolchain is a collection of expressions, dictionary and a parser. <br />
You can use these tools to parse and process raw HAFAS files.

**What is HAFAS?**

HAFAS is a system used by hundreds of transportation companies world-wide.<br>
In order to make raw HAFAS data more accessible,
this project includes all the tools that are necessary.

--

#### Dictionary:

The dictionary translates all codes into human readable text.

Docs: [Here](../master/docs/research/dictionary.md)

#### Expressions:

Expressions do collect and chunk raw data.

[kotlin-expression-builder](https://github.com/Burnett01/kotlin-expression-builder) assists in managing complex expressions.

Read my vision as to why I wrote that builder: [Here](https://burnett01.blogspot.de/2017/06/developers-should-ease-code-readability.html)

Docs: [Here](../master/docs/research/expressions.md)

#### Parser:

The parser compiles raw data by using the dictionary and expressions.

Docs: [Here](../master/docs/research/parser.md)

--

### Build:

Clone this repo and install the submodules.

```
git clone https://github.com/Burnett01/kotlin-hafas-toolchain.git
cd kotlin-hafas-toolchain

git submodule init
git submodule update
```

After that, run the kotlin compiler (kotlinc JVM) to build the binary:

```
kotlinc src kotlin-expression-builder/src/main -include-runtime -d main.jar
```

Tested with: Kotlin Compiler (JVM) version ``1.0.4``, ``1.3.61`` ``1.5.20``

--

### Run - (parse ``.LIN`` file):

A .LIN file contains various vehicle attributes, routes and stops.<br>
If you don't have any HAFAS .LIN files, simply use the [AVV HAFAS records](../master/docs/research/HAFAS%20records.md)<br><br>
Start parsing by using the following cmd:

```
java -jar main.jar PATH_TO_FILE.LIN
```

Output:

<img src="http://i.imgur.com/lL6NwGO.png" />

---

## Contributing

You're very welcome and free to contribute. Thank you.

---

## License

[MIT](LICENSE)
