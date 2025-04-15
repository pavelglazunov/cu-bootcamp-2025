package org.bootcamp

import kotlin.system.exitProcess

fun main() {
    val errorsCount = checkEnvironment()

    println("[info] всего ошибок: $errorsCount")

    if (errorsCount == 0) {
        println("[ok] УРА! Все работает, ждем тебя на буткемпе!")
        exitProcess(0)
    } else {
        println(
            "Чет многовато ошибок, попробуй еще раз, мы в тебя верим!\n" +
                    "Инструкция: https://github.com/pavelglazunov/cu-bootcamp-2025\n"
        )
        println("Проверь, что у тебя установлены все необходимые зависимости и JDK 17+")
        println("Используй Gradle для сборки проекта: ./gradlew run")
        exitProcess(1)
    }
}

fun checkEnvironment(): Int {
    var errorsCount = 0

    // Check JVM version
    errorsCount += checkJvmVersion()

    return errorsCount
}

/**
 * Checks if the JVM version is compatible with the bootcamp requirements.
 * @return 1 if the JVM version is incompatible, 0 otherwise.
 */
fun checkJvmVersion(): Int {
    val javaVersion = System.getProperty("java.version")
    val majorVersion = javaVersion.split(".")[0].toIntOrNull() ?: 0

    return if (majorVersion < 17) {
        println(
            "[error] версия Java должна быть минимум 17, твоя версия: $javaVersion " +
                    "ссылка на скачивание: https://adoptium.net/"
        )
        1
    } else {
        println("[ok] Java версия: $javaVersion")
        0
    }
}
