
## 1️⃣ Установка JDK

### Ubuntu/Debian

```sh
sudo apt update && sudo apt install -y openjdk-17-jdk
```

### Arch Linux

```sh
sudo pacman -Syu jdk17-openjdk
```

### Fedora

```sh
sudo dnf install -y java-17-openjdk-devel
```

Проверить успешную установку можно командой:

```sh
java --version
```

Если видишь версию `17.x.x` или выше – всё ок! 🎉


---

## 2️⃣ Установка Git и клонирование репозитория

### Ubuntu/Debian

```sh
sudo apt install -y git
```

### Arch Linux

```sh
sudo pacman -Syu git
```

### Fedora

```sh
sudo dnf install -y git
```

Проверить установку:

```sh
git --version
```

Клонирование репозитория:

```sh
cd your_dir
git clone https://github.com/pavelglazunov/cu-bootcamp-2025.git
cd cu-bootcamp-2025
```


---

## 3️⃣ Установка VS Code

### Ubuntu/Debian

```sh
sudo apt install -y wget gpg
wget -qO- https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor | sudo tee /usr/share/keyrings/packages.microsoft.gpg > /dev/null
echo "deb [arch=amd64 signed-by=/usr/share/keyrings/packages.microsoft.gpg] https://packages.microsoft.com/repos/code stable main" | sudo tee /etc/apt/sources.list.d/vscode.list > /dev/null
sudo apt update && sudo apt install -y code
```

### Arch Linux

```sh
sudo pacman -Syu code
```

### Fedora

```sh
sudo rpm --import https://packages.microsoft.com/keys/microsoft.asc
dnf config-manager --add-repo https://packages.microsoft.com/yumrepos/vscode
dnf install -y code
```

Запусти VS Code:

```sh
code
```


---

## 4️⃣ Установка расширений для Kotlin в VS Code

1. Открой **VS Code**.
2. Перейди в **Extensions** (Ctrl+Shift+X).
3. Найди и установи **Kotlin** от mathiasfrohlich.
4. Найди и установи **Kotlin Language** от mathiasfrohlich.
5. Найди и установи **Gradle for Java** от Microsoft (опционально).

![extensions](https://github.com/pavelglazunov/cu-bootcamp-2025/blob/main/docs/static/extansions.png)


---

## 5️⃣ Настройка Gradle

1. Открой VS Code и выбери папку проекта (**File** → **Open Folder...** → выбери `cu-bootcamp-2025`).
2. Открой **Терминал** (**Terminal** → **New Terminal** или `Ctrl+`` ).
3. Проверь, что Gradle wrapper работает:

```sh
./gradlew --version
```

4. Если возникает ошибка с правами доступа, выполни:

```sh
chmod +x ./gradlew
```

5. Gradle автоматически загрузит все необходимые зависимости для проекта.

---

## 6️⃣ Управление зависимостями через Gradle

В Kotlin проектах зависимости управляются через Gradle. Все необходимые зависимости уже определены в файле `build.gradle.kts`.

1. Открой файл `build.gradle.kts` в VS Code, чтобы увидеть список зависимостей.
2. Если нужно добавить новую зависимость, добавь её в раздел `dependencies` и обнови проект:

```kotlin
dependencies {
    implementation("org.example:library:1.0.0")
}
```

3. После изменения `build.gradle.kts`, обнови зависимости Gradle:

```sh
./gradlew --refresh-dependencies
```

---

## 7️⃣ Запуск Kotlin приложения

Запусти приложение одним из способов:

### Через Gradle:

```sh
./gradlew run
```

### Через VS Code:

1. Установи расширение **Code Runner** (если еще не установлено).
2. Открой файл `src/main/kotlin/org/bootcamp/Main.kt`.
3. Нажми правой кнопкой мыши и выбери **Run Code** или используй сочетание клавиш **Ctrl+Alt+N**.

Или настрой задачу запуска:

1. Нажми **Ctrl+Shift+P**, введи "Tasks: Configure Task" и выбери "Create tasks.json file from template".
2. Выбери "Others" для создания пустого шаблона.
3. Замени содержимое файла на:

```json
{
    "version": "2.0.0",
    "tasks": [
        {
            "label": "Run Kotlin App",
            "type": "shell",
            "command": "./gradlew run",
            "group": {
                "kind": "build",
                "isDefault": true
            }
        }
    ]
}
```

4. Сохрани файл и запусти задачу через **Terminal** → **Run Task**.

Если программа **НЕ** вывела

`[ok] УРА! Все работает, ждем тебя на буткемпе!`

иди к следующему пункту.

---

## 8️⃣ Ошибки

|Ошибка|Как решить|
|---|---|
|версия Java должна быть минимум 17|Установи JDK 17 или выше с [Adoptium](https://adoptium.net/) или через пакетный менеджер|
|Ошибка при сборке Gradle|Выполни `./gradlew clean build --refresh-dependencies`|
|Ошибка "Permission denied" при запуске gradlew|Выполни `chmod +x ./gradlew`|
|Ошибка "Could not find or load main class"|Проверь, что правильно импортировал проект и что файл `build.gradle.kts` корректно настроен|

Если у тебя другая ошибка, обратись в чат!
