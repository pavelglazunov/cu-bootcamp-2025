
## 1️⃣ Установка JDK

1. Открой [Adoptium](https://adoptium.net/) или используй Homebrew.
2. Скачай и установи JDK 17 или новее.
3. Для установки через Homebrew:

```sh
brew install --cask temurin17
```

4. После завершения установки открой **Терминал** и проверь версию Java:

```sh
java --version
```

Если видишь версию `17.x.x` или выше – всё ок! 🎉

---

## 2️⃣ Установка Git и клонирование репозитория

1. Открой **Терминал** и введи команду:

```sh
git --version
```

2. Если Git **не установлен**, скачай его с [официального сайта](https://git-scm.com/downloads) или установи через Homebrew:

```sh
brew install git
```

3. Перейди в нужную директорию:

```sh
cd your_dir
```

4. Склонируй репозиторий:

```sh
git clone https://github.com/pavelglazunov/cu-bootcamp-2025.git
```

5. Перейди в папку проекта:

```sh
cd cu-bootcamp-2025
```


---

## 3️⃣ Установка IntelliJ IDEA Community Edition

1. Скачай IntelliJ IDEA Community Edition с [официального сайта](https://www.jetbrains.com/idea/download/) или установи через Homebrew:

```sh
brew install --cask intellij-idea-ce
```

2. Запусти IntelliJ IDEA и открой в нем папку с клонированным репозиторием.

---

## 4️⃣ Настройка JDK в IntelliJ IDEA

1. Открой IntelliJ IDEA и выбери проект.
2. Перейди в **IntelliJ IDEA** → **Preferences** → **Build, Execution, Deployment** → **Build Tools** → **Gradle**.
3. Убедись, что в поле **Gradle JVM** выбран JDK 17 или выше.
4. Затем перейди в **IntelliJ IDEA** → **Preferences** → **Project Structure** → **Project**.
5. Убедись, что в поле **Project SDK** выбран JDK 17 или выше.
   - Если JDK не настроен, нажми на выпадающий список и выбери **Add SDK** → **JDK**.
   - Укажи путь до установленного JDK (обычно `/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home`).
6. Убедись, что **Project language level** соответствует твоей версии JDK.
7. Нажми **Apply** и **OK**.

Если IntelliJ IDEA предложит импортировать проект как Gradle проект, согласись с этим.

---

## 5️⃣ Настройка Gradle

1. Открой **Терминал** в IntelliJ IDEA или используй встроенный терминал macOS.
2. Проверь, что Gradle wrapper работает:

```sh
./gradlew --version
```

3. Если возникает ошибка с правами доступа, выполни:

```sh
chmod +x ./gradlew
```

4. Обнови зависимости Gradle:

```sh
./gradlew --refresh-dependencies
```

Gradle автоматически загрузит все необходимые зависимости для проекта.

---

## 6️⃣ Управление зависимостями через Gradle

В Kotlin проектах зависимости управляются через Gradle. Все необходимые зависимости уже определены в файле `build.gradle.kts`.

1. Открой файл `build.gradle.kts` в IntelliJ IDEA, чтобы увидеть список зависимостей.
2. Если нужно добавить новую зависимость, добавь её в раздел `dependencies` и обнови проект:

```kotlin
dependencies {
    implementation("org.example:library:1.0.0")
}
```

3. После изменения `build.gradle.kts`, нажми на значок слона (Gradle) в правой части IDE и выбери **Reload All Gradle Projects**.

---

## 7️⃣ Запуск Kotlin приложения

Запусти приложение одним из способов:

### Через Gradle:

```sh
./gradlew run
```

### Через IntelliJ IDEA:

1. Открой файл `src/main/kotlin/org/bootcamp/Main.kt`.
2. Нажми на зеленый треугольник рядом с функцией `main()` или используй сочетание клавиш **Control+R**.

Или:

1. Нажми на конфигурацию запуска в верхней части IDE и выбери **Edit Configurations**.
2. Нажми **+** и выбери **Gradle**.
3. В поле **Run** введи `run`.
4. Нажми **OK** и запусти конфигурацию.

Если программа **НЕ** вывела

`[ok] УРА! Все работает, ждем тебя на буткемпе!`

Переходи к следующему пункту

---

## 8️⃣ Ошибки

|Ошибка|Как решить|
|---|---|
|версия Java должна быть минимум 17|Установи JDK 17 или выше с [Adoptium](https://adoptium.net/) или через `brew install --cask temurin17`|
|Ошибка при сборке Gradle|Выполни `./gradlew clean build --refresh-dependencies`|
|Ошибка "Permission denied" при запуске gradlew|Выполни `chmod +x ./gradlew`|
|Ошибка "Could not find or load main class"|Проверь, что правильно импортировал проект как Gradle проект|

Если у тебя другая ошибка, обратись в чат!