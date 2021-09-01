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

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        register<MavenPublication>("mavenSources") {
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}