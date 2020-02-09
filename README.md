# AndWait Matcher
*Manually way/library to generate config metadata for spring boot*

![Build][Build-shield] 
[![Maintainable][Maintainable-image]][Maintainable-Url]
[![Coverage][Coverage-image]][Coverage-Url]
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
[Coverage-image]: https://img.shields.io/codecov/c/github/YunaBraska/config-metadata-generator?style=flat-square
[Maintainable-Url]: https://codeclimate.com/github/YunaBraska/config-metadata-generator/maintainability
[Maintainable-image]: https://img.shields.io/codeclimate/maintainability/YunaBraska/config-metadata-generator?style=flat-square
[Javadoc-url]: http://javadoc.io/doc/berlin.yuna/and-wait-matcher
[Javadoc-image]: http://javadoc.io/badge/berlin.yuna/and-wait-matcher.svg
[Gitter-Url]: https://gitter.im/nats-streaming-server-embedded/Lobby
[Gitter-image]: https://img.shields.io/badge/gitter-join%20chat%20%E2%86%92-brightgreen.svg

[Dependency-shield]: https://img.shields.io/librariesio/github/YunaBraska/and-wait-matcher?style=flat-square
[Tag-shield]: https://img.shields.io/github/v/tag/YunaBraska/and-wait-matcher?style=flat-square
[Central-shield]: https://img.shields.io/maven-central/v/berlin.yuna/and-wait-matcher?style=flat-square
[Size-shield]: https://img.shields.io/github/repo-size/YunaBraska/and-wait-matcher?style=flat-square
[Issues-shield]: https://img.shields.io/github/issues/YunaBraska/and-wait-matcher?style=flat-square
[License-shield]: https://img.shields.io/github/license/YunaBraska/and-wait-matcher?style=flat-square
[Commit-shield]: https://img.shields.io/github/last-commit/YunaBraska/and-wait-matcher?style=flat-square
[Label-shield]: https://img.shields.io/badge/Yuna-QueenInside-blueviolet?style=flat-square
[Build-shield]: https://img.shields.io/travis/YunaBraska/and-wait-matcher/master?style=flat-square

### Information
 * [Spring boot configuration-metadata](https://docs.spring.io/spring-boot/docs/current/reference/html/configuration-metadata.html)

### Usage auto configuration classes
* You could generate auto configuration classes out of a test like this
```java
@Test
public void generateAutoConfigMetadata() throws IOException {
    AutoConfigurationClass classList = new AutoConfigurationClass(Groups.class, Hints.class);
    classList.newAutoConfigClass(Values.class, Properties.class);

    Path generated = classList.generate();

}
```
* Output from example:
```properties
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
berlin.yuna.configmetadata.model.Groups
berlin.yuna.configmetadata.model.Hints
berlin.yuna.configmetadata.model.Values
berlin.yuna.configmetadata.model.Properties
```

### Usage Configuration Metadata
* You could generate metadata out of a test like this
```java
public class ConfigMetadataGeneratorTest {

	@Test
    public void generateMetadataFromEnum() throws IOException {
        ConfigurationMetadata metadata = new ConfigurationMetadata("my.group", ExampleEnumConfig.class);

        for (ExampleEnumConfig c : ExampleEnumConfig.values()) {
            Class type = c.getDefaultValue().getClass();
            metadata.newProperties().name(c.name().toLowerCase()).description(c.getDescription()).type(type);
        }

        metadata.generate();
    }
}
```
* Test config enum class behind the scenes
```java
public enum ExampleEnumConfig {

    CLUSTER_ID("test-cluster", "Cluster ID (default: test-cluster)"),
    PORT(4222, "Use port for clients (default: 4222)"),
    MAX_BYTES(0L, "Max messages total size per channel (0 for unlimited)"),
    INFO(true, "Enable info output"),
    DEBUG(false, "Debug the raw protocol");

    private final Object defaultValue;
    private final String description;

    ExampleEnumConfig(Object defaultValue, String description) {
        this.defaultValue = defaultValue;
        this.description = description;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public String getDescription() {
        return description;
    }
}
```
* output from example:
```json
{
  "hints" : [ ],
  "groups" : [ {
    "name" : "my.group",
    "type" : "berlin.yuna.configmetadata.model.ExampleEnumConfig",
    "sourceType" : "berlin.yuna.configmetadata.model.ExampleEnumConfig"
  } ],
  "properties" : [ {
    "name" : "my.group.cluster_id",
    "type" : "java.lang.String",
    "description" : "Cluster ID (default: test-cluster)",
    "sourceType" : "berlin.yuna.configmetadata.model.ExampleEnumConfig"
  }, {
    "name" : "my.group.port",
    "type" : "java.lang.Integer",
    "description" : "Use port for clients (default: 4222)",
    "sourceType" : "berlin.yuna.configmetadata.model.ExampleEnumConfig"
  }, {
    "name" : "my.group.max_bytes",
    "type" : "java.lang.Long",
    "description" : "Max messages total size per channel (0 for unlimited)",
    "sourceType" : "berlin.yuna.configmetadata.model.ExampleEnumConfig"
  }, {
    "name" : "my.group.info",
    "type" : "java.lang.Boolean",
    "description" : "Enable info output",
    "sourceType" : "berlin.yuna.configmetadata.model.ExampleEnumConfig"
  }, {
    "name" : "my.group.debug",
    "type" : "java.lang.Boolean",
    "description" : "Debug the raw protocol",
    "sourceType" : "berlin.yuna.configmetadata.model.ExampleEnumConfig"
  } ]
}
```

![Config-Metadata-Generator](src/main/resources/banner.png "Config-Metadata-Generator")