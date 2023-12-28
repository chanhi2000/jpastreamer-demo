import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project
val kotlinVersion: String = "1.9.10"

plugins {
    id("io.quarkus") version "3.5.0"
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.allopen") version "1.9.10"
    kotlin("kapt") version "1.9.10"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

sourceSets {
    main {
        java {
            setSrcDirs(
                listOf("src/main/java",
                    "build/generated/source/kapt/main"
                )
            )
        }
    }
}


dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation("io.quarkus:quarkus-hibernate-orm-panache-kotlin")
    implementation("io.quarkiverse.jpastreamer:quarkus-jpastreamer:3.0.3.Final")
//    kapt("com.speedment.jpastreamer:fieldgenerator-standard:3.0.4")
    implementation("io.quarkus:quarkus-smallrye-openapi")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-jdbc-mysql")
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-hibernate-orm")
    implementation("io.quarkus:quarkus-resteasy-reactive")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    testImplementation("io.quarkus:quarkus-junit5")
//    testImplementation("org.hamcrest:hamcrest:2.1")
    testImplementation("io.rest-assured:rest-assured")
}

group = "com.example.markiiimark"
version = "0.0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
allOpen {
    annotation("jakarta.ws.rs.Path")
    annotation("jakarta.enterprise.context.ApplicationScoped")
    annotation("jakarta.persistence.Entity")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "${JavaVersion.VERSION_11}"
//        freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
        javaParameters = true
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    // options.compilerArgs.add("-parameters")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    filter {
        isFailOnNoMatchingTests = false
    }
    testLogging {
        showExceptions = true
        showStandardStreams = true
        events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED)
        exceptionFormat = TestExceptionFormat.FULL
    }
}

//project.afterEvaluate {
//    getTasksByName("quarkusGenerateCode", true).forEach { task ->
//        task.setDependsOn(task.dependsOn.filterIsInstance<Provider<Task>>().filter { it.get().name != "processResources" })
//    }
//    getTasksByName("quarkusGenerateCodeDev", true).forEach { task ->
//        task.setDependsOn(task.dependsOn.filterIsInstance<Provider<Task>>().filter { it.get().name != "processResources" })
//    }
//}