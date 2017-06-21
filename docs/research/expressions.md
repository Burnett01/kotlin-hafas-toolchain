
### Eckdaten:

#### Dates:

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

#### Linien Attribute + Richtungverlauf:

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

        match { 
            whitespace()
            quantity(Q.ZERO_OR_ONE)
        }

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