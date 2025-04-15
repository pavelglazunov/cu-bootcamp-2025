
## 1️⃣ Установка JDK

1. Перейди на [сайт Adoptium](https://adoptium.net/).
2. Скачай JDK версии 17 или новее для Windows.
3. Запусти установщик и следуй инструкциям.
4. **Обязательно** поставь галочку ✅ "Add to PATH" для добавления Java в переменные среды.

5. Дождись завершения установки.
6. (может потребоваться перезапустить компьютер)

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

3. Перейди в нужную директорию

```bash
cd your_dir
```

4. Склонируй нужный репозиторий:

```sh
git clone https://github.com/pavelglazunov/cu-bootcamp-2025.git
```

5. Перейди в папку с проектом:

```sh
cd cu-bootcamp-2025
```

---

## 3️⃣ Установка IntelliJ IDEA Community Edition

1. Скачай IntelliJ IDEA Community Edition с [официального сайта](https://www.jetbrains.com/idea/download/).
2. Запусти установщик и следуй инструкциям.
3. Запусти IntelliJ IDEA и открой в нем папку с клонированным репозиторием.

---

## 4️⃣ Настройка JDK в IntelliJ IDEA

1. Открой IntelliJ IDEA и выбери проект.
2. Перейди в **File** → **Project Structure** (или нажми Ctrl+Alt+Shift+S).
3. В разделе **Project** убедись, что выбран JDK 17 или выше.
   - Если JDK не настроен, нажми на выпадающий список **SDK** и выбери **Add SDK** → **JDK**.
   - Укажи путь до установленного JDK (обычно `C:\Program Files\Eclipse Adoptium\jdk-17.x.x.x-hotspot`).
4. Убедись, что **Language level** соответствует твоей версии JDK.
5. Нажми **Apply** и **OK**.

Если IntelliJ IDEA предложит импортировать проект как Gradle проект, согласись с этим.

---

## 5️⃣ Настройка Gradle

Открой терминал в IntelliJ IDEA (Terminal внизу IDE) или используй PowerShell/Command Prompt:

![terminal](https://github.com/pavelglazunov/cu-bootcamp-2025/blob/main/docs/static/venv.png)

Проверь, что Gradle wrapper работает:

```sh
.\gradlew.bat --version
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

Теперь запусти приложение одним из способов:

### Через Gradle:

```sh
.\gradlew.bat run
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

Переходи к следующему пункту 

## 8️⃣ Ошибки

Допустимые ошибки:

| Ошибка                                    | Как решить                                                                             |
| ----------------------------------------- | -------------------------------------------------------------------------------------- |
| версия Java должна быть минимум 17        | Скачай нужную версию с [сайта Adoptium](https://adoptium.net/)                         |
| Ошибка при сборке Gradle                  | Выполни `.\gradlew.bat clean build --refresh-dependencies`                             |
| Ошибка "Could not find or load main class"| Проверь, что правильно импортировал проект как Gradle проект                           |

Если у тебя другая ошибка, обратись с этим в чат