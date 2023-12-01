plugins {
    kotlin("jvm") version "1.8.20"
    application
    idea
}

group = "org.itavgur"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

repositories {
    mavenCentral()
    google()
}

dependencies {

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.7.10")
//    implementation("org.springframework:spring-webflux:5.3.25")
//    implementation("org.springframework:spring-web:6.0.7")
//    implementation("org.springframework.boot:spring-boot-starter-webflux:3.0.5")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.reflections:reflections:0.10.2")
    implementation(kotlin("stdlib-jdk8"))

//    implementation 'org.springframework.boot:spring-boot-starter'
//    developmentOnly 'org.springframework.boot:spring-boot-devtools'
//    testImplementation 'org.springframework.boot:spring-boot-starter-test'

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
