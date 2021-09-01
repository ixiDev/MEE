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
tasks {
//    val sourcesJar by creating(Jar::class) {
//        archiveClassifier.set("sources")
//        from(sourceSets.getByName("main").java.srcDirs)
//    }

    artifacts {
        archives(jar)
        archives(javadoc)
    }
}