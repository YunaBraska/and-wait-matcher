# AndWait Matcher
*Hamcrest matcher which is waiting (with a timeout) for the expected value* 

[![Build][build_shield]][build_link]
[![Maintainable][maintainable_shield]][maintainable_link]
[![Coverage][coverage_shield]][coverage_link]
[![Issues][issues_shield]][issues_link]
[![Commit][commit_shield]][commit_link]
[![Dependencies][dependency_shield]][dependency_link]
[![License][license_shield]][license_link]
[![Central][central_shield]][central_link]
[![Tag][tag_shield]][tag_link]
[![Javadoc][javadoc_shield]][javadoc_link]
[![Size][size_shield]][size_shield]
![Label][label_shield]

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
* Only one AssertionError description instead of having two descriptions - first is a timeout and second is mismatch

![andwait](andwait.jpg "andwait")

[build_shield]: https://github.com/YunaBraska/and-wait-matcher/workflows/JAVA_CI/badge.svg
[build_link]: https://github.com/YunaBraska/and-wait-matcher/actions?query=workflow%3AJAVA_CI
[maintainable_shield]: https://img.shields.io/codeclimate/maintainability/YunaBraska/and-wait-matcher?style=flat-square
[maintainable_link]: https://codeclimate.com/github/YunaBraska/and-wait-matcher/maintainability
[coverage_shield]: https://img.shields.io/codeclimate/coverage/YunaBraska/and-wait-matcher?style=flat-square
[coverage_link]: https://codeclimate.com/github/YunaBraska/and-wait-matcher/test_coverage
[issues_shield]: https://img.shields.io/github/issues/YunaBraska/and-wait-matcher?style=flat-square
[issues_link]: https://github.com/YunaBraska/and-wait-matcher/commits/master
[commit_shield]: https://img.shields.io/github/last-commit/YunaBraska/and-wait-matcher?style=flat-square
[commit_link]: https://github.com/YunaBraska/and-wait-matcher/issues
[license_shield]: https://img.shields.io/github/license/YunaBraska/and-wait-matcher?style=flat-square
[license_link]: https://github.com/YunaBraska/and-wait-matcher/blob/master/LICENSE
[dependency_shield]: https://img.shields.io/librariesio/github/YunaBraska/and-wait-matcher?style=flat-square
[dependency_link]: https://libraries.io/github/YunaBraska/and-wait-matcher
[central_shield]: https://img.shields.io/maven-central/v/berlin.yuna/and-wait-matcher?style=flat-square
[central_link]:https://search.maven.org/artifact/berlin.yuna/and-wait-matcher
[tag_shield]: https://img.shields.io/github/v/tag/YunaBraska/and-wait-matcher?style=flat-square
[tag_link]: https://github.com/YunaBraska/and-wait-matcher/releases
[javadoc_shield]: https://javadoc.io/badge2/berlin.yuna/and-wait-matcher/javadoc.svg?style=flat-square
[javadoc_link]: https://javadoc.io/doc/berlin.yuna/and-wait-matcher
[size_shield]: https://img.shields.io/github/repo-size/YunaBraska/and-wait-matcher?style=flat-square
[label_shield]: https://img.shields.io/badge/Yuna-QueenInside-blueviolet?style=flat-square
[gitter_shield]: https://img.shields.io/gitter/room/YunaBraska/nats-streaming-server-embedded?style=flat-square
[gitter_link]: https://gitter.im/nats-streaming-server-embedded/Lobby