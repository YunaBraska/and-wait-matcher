# AndWait Matcher #

Small hamcrest matcher which is waiting (with timeout) for the expected value 

### how it works
```java
    assertThat(this::receiveMessage, andWait(is(equalTo("Howdy"))));
```
* use a hamcrest assertThat
* first parameter will be a function to call until the expected value is present or timeout
* you can even define your own timeout with a second parameter in the "andWait" matcher definition 
```java
    assertThat(this::receiveMessage, andWait(is(equalTo("Howdy")), 500));
```

#### Matcher assertionError example
```text
    Expected:
         but: [Timeout]
    "Expected: is "unknown message"
         but: was "other message"
```

### known issues
* AssertionError is having two descriptions, first is timeout and second is mismatch

![andwait](andwait.jpg "andwait")
