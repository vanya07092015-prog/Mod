# Как собрать JAR мод

## Вариант 1: Автосборка через GitHub (рекомендуется)

1. Зайди на https://github.com/vanya07092015-prog/Mod/actions
2. Нажми **"Run workflow"** (если доступно)
3. После завершения сборки скачай артефакт `mymod-jar`

## Вариант 2: Локальная сборка (Windows / Linux / Mac)

### Шаг 1: Установи JDK 8
- Скачай: https://adoptium.net/temurin/releases/?version=8
- Установи и добавь в PATH

### Шаг 2: Склони репозиторий
```bash
git clone https://github.com/vanya07092015-prog/Mod.git
cd Mod
git checkout arena/01a01997-mod
```

### Шаг 3: Собери мод
```bash
chmod +x gradlew
./gradlew build --no-daemon
```

### Шаг 4: Готовый файл
Файл появится здесь:
```
build/libs/mymod-1.0.jar
```

---

## Вариант 3: Быстрая сборка (только если есть Gradle)

```bash
gradle build
```

---

**Примечание:**  
Если хочешь, чтобы GitHub Actions работал, нужно зайти в настройки репозитория → **Actions** → разрешить workflow.