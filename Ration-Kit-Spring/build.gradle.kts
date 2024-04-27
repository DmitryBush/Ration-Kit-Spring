plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework:spring-context:6.1.6")
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("org.springframework:spring-aop:6.1.6")
    implementation("org.springframework:spring-core: 6.1.6")
    implementation("org.springframework:spring-beans: 6.1.6")

    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")

    implementation("org.aspectj:aspectjrt:1.9.22")
    implementation("org.aspectj:aspectjweaver:1.9.22")
}

tasks.test {
    useJUnitPlatform()
}