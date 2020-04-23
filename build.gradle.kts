/**
 * This module contains the Gradle Configuration Gradle plugin.
 */

plugins {
    `maven-publish`
    `java-library`
}

repositories {
	mavenLocal()
	jcenter()
}

group = "com.twitter.gradle.test"
val publicationVersion: String by project
version = publicationVersion

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}

val processor by configurations.creating

dependencies {
    val recursiveDependency: String? by project
    if (recursiveDependency != null) {
        processor("com.twitter.gradle.test:recursive-dependency:0.0.1")
    }
}
