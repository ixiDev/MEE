plugins {
    kotlin("jvm")
    `maven-publish`
}


group = "com.github.ixidev"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}