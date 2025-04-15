
## 1️⃣ Установка JDK

1. Открой терминал.
2. Проверь, установлен ли Java:

```sh
java --version
```

1. Если Java **не установлена** или версия ниже 17, установи её:
    - **Ubuntu/Debian**:
        
        ```sh
        sudo apt update && sudo apt install -y openjdk-17-jdk
        ```
        
    - **Arch Linux**:
        
        ```sh
        sudo pacman -Syu jdk17-openjdk
        ```
        
    - **Fedora**:
        
        ```sh
        sudo dnf install java-17-openjdk-devel
        ```
        
4. Проверь успешную установку:

```sh
java --version
```

Если видишь версию `17.x.x` или выше – всё ок! 🎉

---

## 2️⃣ Установка Git и клонирование репозитория

1. Проверь, установлен ли Git:

```sh
git --version
```

1. Если Git **не установлен**, установи его:
    - **Ubuntu/Debian**:
        
        ```sh
        sudo apt install -y git
        ```
        
    - **Arch Linux**:
        
        ```sh
        sudo pacman -S git
        ```
        
    - **Fedora**:
        
        ```sh
        sudo dnf install git
        ```
        
3. Перейди в нужную директорию:

```sh
cd your_dir
```

1. Склонируй репозиторий:

```sh
git clone https://github.com/pavelglazunov/cu-bootcamp-2025.git
```

1. Перейди в папку проекта:

```sh
cd cu-bootcamp-2025
```


## 3️⃣ Установка IntelliJ IDEA Community Edition

1. Скачай IntelliJ IDEA Community Edition с [официального сайта](https://www.jetbrains.com/idea/download/).
2. Установи его, следуя инструкциям для своего дистрибутива:
   - **Ubuntu/Debian**:
     - Распакуй скачанный архив: `tar -xzf ideaIC-*.tar.gz`
     - Перейди в распакованную директорию: `cd idea-IC-*/bin`
     - Запусти установщик: `./idea.sh`
   - **Arch Linux**:
     - Установи из AUR: `yay -S intellij-idea-community-edition`
   - **Fedora**:
     - Установи из репозитория: `sudo dnf install intellij-idea-community`
3. Запусти IntelliJ IDEA и открой в нем папку с клонированным репозиторием.

---

## 4️⃣ Настройка JDK в IntelliJ IDEA

1. Открой IntelliJ IDEA и выбери проект.
2. Перейди в **File** → **Project Structure** (или нажми Ctrl+Alt+Shift+S).
3. В разделе **Project** убедись, что выбран JDK 17 или выше.
   - Если JDK не настроен, нажми на выпадающий список **SDK** и выбери **Add SDK** → **JDK**.
   - Укажи путь до установленного JDK (обычно `/usr/lib/jvm/java-17-openjdk-amd64` для Ubuntu/Debian).
4. Убедись, что **Language level** соответствует твоей версии JDK.
5. Нажми **Apply** и **OK**.

Если IntelliJ IDEA предложит импортировать проект как Gradle проект, согласись с этим.

---

## 5️⃣ Настройка Gradle

1. Открой терминал в IntelliJ IDEA (**View** → **Tool Windows** → **Terminal**) или используй системный терминал.
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
2. Нажми на зеленый треугольник рядом с функцией `main()` или используй сочетание клавиш **Shift+F10**.

Или:

1. Нажми на конфигурацию запуска в верхней части IDE и выбери **Edit Configurations**.
2. Нажми **+** и выбери **Gradle**.
3. В поле **Run** введи `run`.
4. Нажми **OK** и запусти конфигурацию.

Если программа **НЕ** вывела

`[ok] УРА! Все работает, ждем тебя на буткемпе!`

иди к следующему пункту.

---

## 8️⃣ Ошибки

|Ошибка|Как решить|
|---|---|
|версия Java должна быть минимум 17|Установи JDK 17 или выше с [Adoptium](https://adoptium.net/)|
|Ошибка при сборке Gradle|Выполни `./gradlew clean build --refresh-dependencies`|
|Ошибка "Permission denied" при запуске gradlew|Выполни `chmod +x ./gradlew`|
|Ошибка "Could not find or load main class"|Проверь, что правильно импортировал проект как Gradle проект|

Если у тебя другая ошибка, обратись в чат!