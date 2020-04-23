# Recursive Dependency

This is a repro for an issue where a binary dependency in a configuration is replaced with a project dependency. It doesn't look like this behavior is configurable.

First, publish the project to a local Maven repository:

```
$ ./gradlew :publishToMavenLocal -PpublicationVersion=0.0.1
```

Then run these commands to see how the binary dependency is resolved differently based on the version of the project:

```
# resolve to the binary dependency
./gradlew :dependencyInsight -PpublicationVersion=0.0.0 -PrecursiveDependency --configuration processor --dependency com.twitter.gradle.test:recursive-dependency
# resolve to the root project
./gradlew :dependencyInsight -PpublicationVersion=0.0.2 -PrecursiveDependency --configuration processor --dependency com.twitter.gradle.test:recursive-dependency
```
