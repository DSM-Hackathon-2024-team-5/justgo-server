plugins {
    id("org.springframework.boot") version "2.7.16"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("plugin.jpa") version "1.9.24"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2023.0.3"

dependencies {
    //orm
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    //security
    implementation("org.springframework.boot:spring-boot-starter-security")

    //validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    //web
    implementation("org.springframework.boot:spring-boot-starter-web")


    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    //kotlin
    compileOnly("org.projectlombok:lombok")

    //db
    runtimeOnly("com.mysql:mysql-connector-j")

    //test
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    //security
    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("io.github.kilmajster:ngrok-spring-boot-starter:0.9.2")

}


kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
