
### Eckdaten:

#### Dates:

This expression extracts a date (eg. 04.05.2020)

> (\\d{2}.\\d{2}.\\d{4})

```kotlin
capture {
    digit { exact(2) }
    literal('.')
    digit { exact(2) }
    literal('.')
    digit { exact(4) }
}
```

---

### LIN:

#### Linien Attribute + Richtungverlauf (Routes):

This expression captures the keys (Z L A R G) and their corresponding values.
The keys are translated into human readable language by using the [Dictionary](../master/docs/research/dictionary.md).

See a full explanation here: [Click](https://burnett01.blogspot.de/2017/06/developers-should-ease-code-readability.html)

> ^(?:\\*([ZLARG])[ ](\\d+|\\w{1,3})[ ]?(R\\d{6})?|(^\\d{7}))

```kotlin

val options: Set<RegexOption> = setOf(RegexOption.MULTILINE)

expression({
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
```