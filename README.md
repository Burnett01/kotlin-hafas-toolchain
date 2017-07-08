## hafas-toolchain (WiP - work in progress)

hafas-toolchain is a collection of expressions, dictionary and a parser. <br />With these tools you can parse and process raw HAFAS files.

**What is HAFAS?**

HAFAS is a system used by hundreds of transportation companies world-wide.<br>
In order to make raw HAFAS data more accessible,
this project will provide all the tools that are necessary.

--

#### Dictionary:

The dictionary translates all codes into human readable text.

#### Expressions:

Expressions do collect and chunk raw data.

[kotlin-expression-builder](https://github.com/Burnett01/kotlin-expression-builder) assists in managing complex expressions.

Read my vision: [Here](https://burnett01.blogspot.de/2017/06/developers-should-ease-code-readability.html)

#### Parser:

The parser compiles raw data by using the dictionary and expressions.

--

### How to run (parse ``.LIN`` file):

In order to run the main.jar, simply use the following cmd:

```
java -jar main.jar PATH_TO_LIN_FILE.LIN
```
