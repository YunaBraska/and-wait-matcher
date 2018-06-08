# AndWait Matcher

[![License][License-Image]][License-Url]
[![Build][Build-Status-Image]][Build-Status-Url] 
[![Coverage][Coverage-image]][Coverage-Url] 
[![Maintainable][Maintainable-image]][Maintainable-Url] 
[![Central][Central-image]][Central-Url] 
[![Javadoc][javadoc-image]][javadoc-Url]
[![Gitter][Gitter-image]][Gitter-Url] 

### Description
Hamcrest matcher which is waiting (with timeout) for the expected value 

### Usage
```java
    assertThat(this::receiveMessage, andWait(is(equalTo("Howdy"))));
```
* this matcher works with the default hamcrest "assertThat"
* first parameter receives a function that will be called until the expected value is present (Success) or timeout (Exception) is received
* you can define a custom timeout by using the second optional parameter of the "andWait" matcher 
```java
    assertThat(this::receiveMessage, andWait(is(equalTo("Howdy")), 500));
```

#### Matcher assertionError example
```text
    Expected:
         but: [Timeout]
    Expected: is "unknown message"
         but: was "other message"
```

### TODO
* Feature instead of Thread.sleep(XY)
* Only one AssertionError description instead of having two descriptions - first is timeout and second is mismatch

![andwait](andwait.jpg "andwait")

[License-Url]: https://www.apache.org/licenses/LICENSE-2.0
[License-Image]: https://img.shields.io/badge/License-Apache2-blue.svg
[github-release]: https://github.com/YunaBraska/and-wait-matcher
[Build-Status-Url]: https://travis-ci.org/YunaBraska/and-wait-matcher
[Build-Status-Image]: https://travis-ci.org/YunaBraska/and-wait-matcher.svg?branch=master
[Coverage-Url]: https://codecov.io/gh/YunaBraska/and-wait-matcher?branch=master
[Coverage-image]: https://codecov.io/gh/YunaBraska/and-wait-matcher/branch/master/graphs/badge.svg
[Version-url]: https://github.com/YunaBraska/and-wait-matcher
[Version-image]: https://badge.fury.io/gh/YunaBraska%2Fand-wait-matcher.svg
[Central-url]: https://search.maven.org/#search%7Cga%7C1%7Ca%3A%22and-wait-matcher%22
[Central-image]: https://maven-badges.herokuapp.com/maven-central/berlin.yuna/and-wait-matcher/badge.svg
[Maintainable-Url]: https://codeclimate.com/github/YunaBraska/and-wait-matcher
[Maintainable-image]: https://codeclimate.com/github/YunaBraska/and-wait-matcher.svg
[Gitter-Url]: https://gitter.im/nats-streaming-server-embedded/Lobby
[Gitter-image]: https://img.shields.io/badge/gitter-join%20chat%20%E2%86%92-brightgreen.svg
[Javadoc-url]: http://javadoc.io/doc/berlin.yuna/and-wait-matcher
[Javadoc-image]: http://javadoc.io/badge/berlin.yuna/and-wait-matcher.svg