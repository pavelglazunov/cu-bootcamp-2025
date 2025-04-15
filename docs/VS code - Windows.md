
## 1️⃣ Установка JDK

1. Перейди на [сайт Adoptium](https://adoptium.net/).
2. Скачай JDK версии 17 или новее для Windows.
3. Запусти установщик и следуй инструкциям.
4. **Обязательно** поставь галочку ✅ "Add to PATH" для добавления Java в переменные среды.

5. Дождись завершения установки.
6. (может потребоваться перезапустить компьютер).

Проверить успешную установку можно командой в терминале (PowerShell или Command Prompt):

```sh
java --version
```

Если видишь версию `17.x.x` или выше – всё ок! 🎉

---

## 2️⃣ Установка Git и клонирование репозитория

1. Скачай и установи Git с [официального сайта](https://git-scm.com/downloads).
2. Проверь установку командой:

```sh
git --version
```

1. Открой **Командную строку** или **PowerShell**, перейди в нужную директорию:

```sh
cd your_dir
```

1. Склонируй репозиторий:

```sh
git clone https://github.com/pavelglazunov/cu-bootcamp-2025.git
```

1. Перейди в папку с проектом:

```sh
cd cu-bootcamp-2025
```


---

## 3️⃣ Установка VS Code

1. Скачай VS Code с [официального сайта](https://code.visualstudio.com/Download).
2. Установи его, оставляя настройки по умолчанию.
3. Открой VS Code и установи расширения для Kotlin:
    - Перейди в **Extensions** (Ctrl+Shift+X).
    - Найди и установи **Kotlin** от mathiasfrohlich.
    - Найди и установи **Kotlin Language** от mathiasfrohlich.
    - Найди и установи **Gradle for Java** от Microsoft (опционально).

![extensions](https://github.com/pavelglazunov/cu-bootcamp-2025/blob/main/docs/static/extansions.png)



---

## 4️⃣ Настройка Gradle

1. Открой VS Code и выбери папку проекта (**File** → **Open Folder...** → выбери `cu-bootcamp-2025`).
2. Открой **Терминал** (**Terminal** → **New Terminal** или `Ctrl+` `).
3. Проверь, что Gradle wrapper работает:

```sh
.\gradlew.bat --version
```

4. Если возникает ошибка с правами доступа, выполни:

```sh
# Это может потребоваться в PowerShell с повышенными правами
Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
```

5. Gradle автоматически загрузит все необходимые зависимости для проекта.



---

## 5️⃣ Управление зависимостями через Gradle

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
.\gradlew.bat --refresh-dependencies
```

---

## 6️⃣ Запуск Kotlin приложения

Запусти приложение одним из способов:

### Через Gradle:

```sh
.\gradlew.bat run
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
            "command": ".\\gradlew.bat run",
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

## 7️⃣ Ошибки

|Ошибка|Как решить|
|---|---|
|версия Java должна быть минимум 17|Установи JDK 17 или выше с [сайта Adoptium](https://adoptium.net/)|
|Ошибка при сборке Gradle|Выполни `.\gradlew.bat clean build --refresh-dependencies`|
|Ошибка "Permission denied" при запуске gradlew|В PowerShell выполни `Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass`|
|Ошибка "Could not find or load main class"|Проверь, что правильно импортировал проект и что файл `build.gradle.kts` корректно настроен|

Если у тебя другая ошибка, обратись в чат!
