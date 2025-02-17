# Weather Application

Это приложение позволяет получать текущую погоду по названию города, используя внешний API OpenWeatherMap. Оно состоит из двух частей:
- **Backend**: Spring Boot приложение, которое обрабатывает запросы и взаимодействует с OpenWeatherMap API.
- **Frondend**: Vue.js приложение, которое предоставляет интерфейс для ввода города и отображения погоды.

---

## Требования

- **Java 17** (для бэкенда)
- **Node.js** (для фронтенда)
- **PostgreSQL** (для хранения истории запросов)
- **API-ключ OpenWeatherMap** (получить можно [здесь](https://openweathermap.org/api))

---

## Настройка проекта

### Backend

1. **Клонируйте репозиторий**:
   ```bash
   git clone [https://github.com/your-repo/weather-app.git](https://github.com/OtakuDocotor/Weather_By_City.git)
2. **Настройте базу данных**:
   Убедитесь, что PostgreSQL установлен и запущен.
   Импортировать базу данных в **PostgreSQL** с помощью **pgAdmin 4** или консоли:
   ```sh
   psql -U postgres -d postgres -f Weather_History.sql
   ```
3. **Настройка API ключа**:
   Зарегистрируйтесь на OpenWeatherMap и получите API-ключ.
   Запишите свой Api ключ в файле
   Weather_By_City\weather_backend\src\main\resources\application.properties в поле api.key

   
4. Запуск Backend
   ```sh
    cd ../weather_backend
    mvn clean install
    mvn spring-boot:run
   ```
5. Запуск Frontend
   ```sh
    cd ../weather_frontend
    npm install
    npm run dev
   ```
6. Запуск в браузере
  После успешного запуска **backend** и **frontend**, откройте браузер и перейдите по адресу:
   ```
     http://localhost:5173
   ```
