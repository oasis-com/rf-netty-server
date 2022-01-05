plugins {
    kotlin("jvm") version "1.6.10"
}

group = "com.oasis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.netty:netty-all:4.1.72.Final")
    implementation("com.google.protobuf:protobuf-java:3.19.1")
//    implementation("org.slf4j:slf4j-api:1.7.32")
//    implementation("ch.qos.logback:logback-core:1.2.10")
//    testImplementation("ch.qos.logback:logback-classic:1.2.10")

}