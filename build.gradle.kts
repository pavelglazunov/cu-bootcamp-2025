plugins {
    kotlin("jvm") version "2.1.20"
    kotlin("plugin.serialization") version "2.1.20"
    application
}

group = "org.bootcamp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    // Ktor client (alternatives for aiohttp, httpx, httpcore, requests, urllib3)
    implementation("io.ktor:ktor-client-core:2.3.7")
    implementation("io.ktor:ktor-client-cio:2.3.7")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.7")

    // Ktor server
    implementation("io.ktor:ktor-server-core:2.3.7")
    implementation("io.ktor:ktor-server-netty:2.3.7")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.7")

    // JSON serialization
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.4.14")

    // Coroutines (alternative for async I/O: aiofiles, aiohappyeyeballs, aiosignal, anyio)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    // File operations (alternative for aiofiles)
    implementation("org.jetbrains.kotlinx:kotlinx-io-jvm:0.1.16")

    // Telegram Bot API (alternative for aiogram)
    implementation("dev.inmo:tgbotapi:9.2.1")

    // Data validation (alternative for pydantic, annotated-types)
    implementation("io.konform:konform-jvm:0.4.0")
    implementation("org.valiktor:valiktor-core:0.12.0")

    // Cryptography (alternative for cryptography, PyJWT)
    implementation("org.bouncycastle:bcprov-jdk18on:1.77")
    implementation("com.auth0:java-jwt:4.4.0")

    // Environment variables (alternative for python-dotenv)
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    // Image processing (alternative for pillow)
    implementation("org.imgscalr:imgscalr-lib:4.2")
    implementation("com.sksamuel.scrimage:scrimage-core:4.1.1")

    // gRPC (alternative for grpcio, grpcio-tools, protobuf)
    implementation("io.grpc:grpc-protobuf:1.60.0")
    implementation("io.grpc:grpc-stub:1.60.0")
    implementation("io.grpc:grpc-kotlin-stub:1.4.1")

    // Annotations and reflection (alternative for get-annotations, attrs)
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // HTTP utilities (alternative for certifi, idna)
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    // Caching (alternative for propcache)
    implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")

    // Utility libraries (alternative for six, typing_extensions, wrapt, deprecated)
    implementation("com.google.guava:guava:32.1.3-jre")
    implementation("org.apache.commons:commons-lang3:3.14.0")

    // Yandex Cloud SDK (alternative for yandex-cloud-ml-sdk, yandexcloud)
    implementation("com.yandex.cloud:java-sdk-services:2.5.2")
    implementation("com.yandex.cloud:java-sdk-auth:2.5.2")

    // Testing
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("io.ktor:ktor-server-test-host:2.3.7")
}

application {
    mainClass.set("org.bootcamp.MainKt")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
