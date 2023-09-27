## Установка Docker

[Get Docker](https://docs.docker.com/get-docker/)

## Регистрация на Docker Hub

[Docker Hub Container Image Library | App Containerization](https://hub.docker.com/)

## Ссылки

- [установка Docker в Ubuntu 22.04](https://www.ionos.com/digitalguide/server/configuration/install-docker-on-ubuntu-2204/)

## Базовые компоненты любого проекта

- `FE` интерфейс
- `BE` бизнес-логика
- `DB` хранилище
- `Deployment` развертывание (напр., с помощью **Docker**)

## Что такое Docker

- прикладное ПО  (приложение) - появилось в 2013
- представляет собой платформу для контейнеризации приложений

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/c87aed40-1b0d-4044-bd39-88ed32118c4c/Untitled.png)

## Основные термины

- **Образ (image)** - выполняемый пакет, который включает все необходимое для запуска приложения, ключая код приложения, среду выполнения и зависимости
- **Контейнер (container)** - экземпляр образа (процесс), который выполняется в изолированной среде
    - обеспечивает уровень изоляции от других приложений и основной системы
- **`Dockerfile`** - текстовый файл, содержащий инструкции для построения **Docker-образа**
    - определяет код и зависимости (состав), которые должны быть включены в образ
- **Docker Hub** - самый распространенный реестр образов
    - позволяет делиться собственными образами и хранит базовые (стандартные) образы
- **Docker CLI** - командный интерфейс работы с Docker
- **Docker Desktop** - GUI-интерфейс работы с Docker

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/fe4647ef-c393-49a6-be26-da0d48787b62/Untitled.png)

## Решение проблем (ОС Windows)

- открыть `cmd` (командный интерфейс)
- `wsl --update`

## Основные команды

для пользователей Windows: команды необходимо запускать в **PowerShell**

- `docker login` авторизация на **Docker Hub** (и проверка)
- `docker version` просмотр версии
- `docker run hello-world` запуск тестового контейнера
- `docker run -it ubuntu bash` запуск оболочки `bash` в режиме песочницы
- `docker build -t flask-app .` создать (создать) образ на основе **Dockerfile** из текущего каталога
    - `**docker build -t flask-app:1.0.0 .**`
- `docker run flask-app` запуск образа
    - `docker run -p host_port:container_port image_name`
    - `**docker run -p 5000:5000 flask-app**`
    - **`docker run -p 5000:5000 flask-app:1.0.0`**
- `docker tag image_name docker_hub_username/image_name` привязка к репо на **Docker Hub**
    - `**docker tag flask-app:1.0.1 andreibakhtinov/python-web:1.0.1**`
- `docker push docker_hub_username/image_name:version`  выгрузить на `Docker Hub`
    - `**docker push andreibakhtinov/python-web:1.0.1**`
- `docker images` просмотр имеющихся образов
- `docker rmi -f image_id` удалить образ
- `docker tag старое_название новое_название` переименовать образ

## Базовый порядок с Docker

1. Открыть имеющийся проект (или создать новый)
2. Создать `Dockerfile`
3. Создать образ (на основе `Dockerfile`)
4. Запуск контейнера на основе образа

## Тестовый проект #1 (на Python)

```python
## файл app.py

from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello():
    return 'Hello, ANDREI!'

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
```

```docker
## Dockerfile

# Указываем базовый образ
FROM python:3.8-slim

# Устанавливаем зависимости
RUN pip install --no-cache-dir flask

# Копируем файлы в рабочую директорию контейнера
COPY . /app
WORKDIR /app

# Указываем команду, которая будет выполняться при запуске контейнера
CMD ["python", "app.py"]
```

## Запуск `flask-app`

- открыть в браузере ссылку

```docker
http://127.0.0.1:5000/
```

## Семантическое версионирование (`SemVer`)

- Методология (де-факто пром/стандарт) нумерации версий проекта (версионирование)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/293c3040-7f23-4a82-9038-5e58cf6e40ac/Untitled.png)

### v`MAJOR`.`MINOR`.`PATCH`

`PATCH` - исправление багов, прочие мелкие правки

`MINOR` - улучшения (без нарушения обратной совместимости)

`MAJOR` - координальные изменения (с нарушением обратной совместимости)

**Контрольные вопросы по `SemVer`**

1. Какой будет след/версия, если был добавлен новый функционал?
    
    **`v3.9.44`  → `v3.10.0`**
    
2. Какой будет след/версия, если было исправлено три бага?
**`v8.2.0` → `v8.2.1`**
3. Какой будет след/версия, если приложение было полностью переработано?
**`v5.2.2` → `v6.0.0`**

## Тестовый проект #2 (на Java)

`git clone https://github.com/spring-projects/spring-petclinic.git`

```docker
## Dockerfile

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
```

**Запуск проекта `petclinic` (проект #2)**

```docker
docker run -p 8080:8080 petclinic
```

**Открыть в браузере проект #2**

```docker
http://127.0.0.1:8080/
```