plugins {
    kotlin("jvm")
    `maven-publish`
}


group = "com.github.ixidev"
version = "0.0.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}