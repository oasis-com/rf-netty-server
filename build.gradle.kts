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
    implementation("org.jboss.marshalling:jboss-marshalling:2.0.12.Final")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    testImplementation("org.jboss.marshalling:jboss-marshalling-serial:2.0.12.Final")

//    implementation("org.slf4j:slf4j-api:1.7.32")
//    implementation("ch.qos.logback:logback-core:1.2.10")
//    testImplementation("ch.qos.logback:logback-classic:1.2.10")

}