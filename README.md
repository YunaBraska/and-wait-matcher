# AndWait Matcher
*Hamcrest matcher which is waiting (with timeout) for the expected value* 

![Build][Build-shield] 
![[Maintainable][Maintainable-image]][Maintainable-Url]
![Coverage][Coverage-shield]
![Central][Central-shield] 
![Tag][Tag-shield]
![Issues][Issues-shield] 
![Commit][Commit-shield] 
![Size][Size-shield] 
![Dependency][Dependency-shield]
![License][License-shield]
![Label][Label-shield]

[License-Url]: https://www.apache.org/licenses/LICENSE-2.0
[Build-Status-Url]: https://travis-ci.org/YunaBraska/and-wait-matcher
[Build-Status-Image]: https://travis-ci.org/YunaBraska/and-wait-matcher.svg?branch=master
[Coverage-Url]: https://codecov.io/gh/YunaBraska/and-wait-matcher?branch=master
[Coverage-image]: https://img.shields.io/codecov/c/github/YunaBraska/and-wait-matcher?style=flat-square
[Maintainable-Url]: https://codeclimate.com/github/YunaBraska/and-wait-matcher/maintainability
[Maintainable-image]: https://img.shields.io/codeclimate/maintainability/YunaBraska/and-wait-matcher?style=flat-square
[Javadoc-url]: http://javadoc.io/doc/berlin.yuna/and-wait-matcher
[Javadoc-image]: http://javadoc.io/badge/berlin.yuna/and-wait-matcher.svg
[Gitter-Url]: https://gitter.im/nats-streaming-server-embedded/Lobby
[Gitter-image]: https://img.shields.io/badge/gitter-join%20chat%20%E2%86%92-brightgreen.svg

[Dependency-shield]: https://img.shields.io/librariesio/github/YunaBraska/and-wait-matcher?style=flat-square
[Tag-shield]: https://img.shields.io/github/v/tag/YunaBraska/and-wait-matcher?style=flat-square
[Central-shield]: https://img.shields.io/maven-central/v/berlin.yuna/and-wait-matcher?style=flat-square
[Size-shield]: https://img.shields.io/github/repo-size/YunaBraska/and-wait-matcher?style=flat-square
[Issues-shield]: https://img.shields.io/github/issues/YunaBraska/and-wait-matcher?style=flat-square
[Coverage-shield]: https://img.shields.io/codecov/c/github/YunaBraska/and-wait-matcher?style=flat-square
[License-shield]: https://img.shields.io/github/license/YunaBraska/and-wait-matcher?style=flat-square
[Commit-shield]: https://img.shields.io/github/last-commit/YunaBraska/and-wait-matcher?style=flat-square
[Label-shield]: https://img.shields.io/badge/Yuna-QueenInside-blueviolet?style=flat-square
[Build-shield]: https://img.shields.io/travis/YunaBraska/and-wait-matcher/master?style=flat-square

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