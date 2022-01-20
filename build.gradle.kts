import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("plugin.serialization") version "1.6.10"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}


object Versions {
	const val ktor = "2.0.0-beta-1"
}

object Ktor {
	const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
	const val json = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"

	const val serverContentNegotiation = "io.ktor:ktor-server-content-negotiation:${Versions.ktor}"

	const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
	const val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
	const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
	const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
	const val clientJava = "io.ktor:ktor-client-java:${Versions.ktor}"
}


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation(kotlin("reflect"))
	implementation(kotlin("stdlib-jdk8"))
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation("com.expediagroup:graphql-kotlin-spring-server:5.3.0")
	implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.1")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")

	with (Ktor) {
		implementation(clientCore)
		implementation(clientJson)
		implementation(clientLogging)
		implementation(Build_gradle.Ktor.clientJava)
		implementation(contentNegotiation)
		implementation(json)
	}



	developmentOnly("org.springframework.boot:spring-boot-devtools")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = JavaVersion.VERSION_1_8.toString()
	}
}
