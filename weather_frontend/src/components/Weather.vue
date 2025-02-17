<template>
  <div class="weather-app">
    <h1>Погода в городе</h1>
    <div class="input-section">
      <input v-model="city" placeholder="Введите город" />
      <button @click="getWeather">Получить погоду</button>
    </div>

    <div v-if="weatherData" class="weather-info">
      <h2>Текущая погода в {{ weatherData._City }}</h2>
      <p>Температура: {{ weatherData._Temperature }}°C</p>
      <p>Описание: {{ weatherData._Description }}</p>
      <p>Запрошено: {{ weatherData.requestedAt }}</p>
    </div>

    <div class="history-section">
      <h2 class="history-title">История запросов</h2>
      <div class="history-container">
        <ul>
          <li v-for="(item, index) in history" :key="index">
            {{ item._City }}: {{ item._Temperature }}°C ({{ item.requestedAt }})
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      city: '',
      weatherData: null,
      history: [],
    };
  },
  mounted() {
    this.fetchHistory(); // Загружаем историю при монтировании компонента
  },
  methods: {
    getWeather() {
      if (!this.city) {
        alert('Введите название города');
        return;
      }
      axios.get(`http://localhost:8080/weather/current?city=${this.city}`)
        .then(res => {
          this.weatherData = res.data; // Сохраняем данные о погоде
          this.fetchHistory(); // Загружаем историю
          this.city = ''; // Очищаем поле ввода
        })
        .catch(err => {
          console.error('Ошибка получения погодных данных:', err);
          alert('Не удалось получить данные о погоде. Пожалуйста, проверьте название города.');
        });
    },

    fetchHistory() {
      axios.get(`http://localhost:8080/weather/history`)
        .then(res => {
          this.history = res.data; // Устанавливаем историю из ответа сервера
        })
        .catch(err => {
          console.error('Ошибка получения истории запросов:', err);
        });
    }
  }
};
</script>

<style>
.weather-app {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  font-family: Arial, sans-serif;
  background-color: #f4f4f4; 
  border-radius: 8px; 
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Добавляем тень */
}

.input-section {
  margin-bottom: 20px;
}

input {
  padding: 10px;
  font-size: 16px;
  margin-right: 10px;
  border: 1px solid #ccc; /* Добавляем границу */
  border-radius: 4px; /* Скругление углов */
}

input:focus {
  border-color: #007bff; /* Синие границы при активном фокусе */
  outline: none; /* Убираем стандартное обводку при фокусе */
}

button {
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
  border: none; /* Убираем стандартные границы */
  background-color: #007bff; /* Основной цвет кнопки */
  color: white; /* Цвет текста кнопки */
  border-radius: 4px; /* Скругляем углы кнопки */
}

button:hover {
  background-color: #0056b3; /* Тёмно-синий цвет при наведении */
}

.weather-info {
  margin-bottom: 20px;
  padding: 15px; /* Отступ внутри блока с информацией о погоде */
  background-color: white; /* Фон для блока с информацией о погоде */
  border-radius: 8px; /* Скругление углов */
  
  box-shadow: 0 1px 5px rgba(0, 0, 0, 0.1); /* Добавляем тень */
}

.history-section {
  margin-top: 20px;
  background-color: white; /* Фон для блока с историей запросов */
  border-radius: 8px; /* Скругление углов */
  box-shadow: 0 1px 5px rgba(0, 0, 0, 0.1); /* Добавляем тень */
}

.history-title {
  padding-top: 20px;
  margin-top: 10px; /* Отступ сверху, чтобы текст был ниже */
  padding-left: 15px; /* Отступ слева для выравнивания */
}

.history-container {
  max-height: 200px; /* Устанавливаем максимальную высоту для прокрутки */
  overflow-y: auto; /* Добавляем вертикальную прокрутку */
}

ul {
  list-style-type: none; /* Убираем маркеры списка */
  padding: 0; /* Убираем отступы */
}

li {
  background: #f9f9f9; /* Цвет фона элемента списка */
  margin: 5px 0; /* Отступы между элементами списка */
  padding: 10px; /* Отступ внутри элемента списка */
  border: 1px solid #ddd; /* Граница вокруг элемента списка */
  border-radius: 4px; /* Скругление углов элементов списка */
}
</style>
