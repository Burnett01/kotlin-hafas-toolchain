
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