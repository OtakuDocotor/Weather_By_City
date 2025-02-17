<template>
  <div class="weather-app">
    <h1>Weather in the city</h1>
    <div class="input-section">
      <input v-model="city" placeholder="Enter the city" />
      <button @click="getWeather">Get Weather</button>
    </div>

    <div v-if="weatherData" class="weather-info">
      <h2>Current weather in  {{ weatherData._City }}</h2>
      <p>Temperature: {{ weatherData._Temperature }}°C</p>
      <p>Description: {{ weatherData._Description }}</p>
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
    this.fetchHistory(); 
  },
  methods: {
    getWeather() {
      if (!this.city) {
        alert('Введите название города');
        return;
      }
      axios.get(`http://localhost:8080/weather/current?city=${this.city}`)
        .then(res => {
          this.weatherData = res.data; 
          this.fetchHistory(); 
          this.city = ''; 
        })
        .catch(err => {
          console.error('Ошибка получения погодных данных:', err);
          alert('Не удалось получить данные о погоде. Пожалуйста, проверьте название города.');
        });
    },

    fetchHistory() {
      axios.get(`http://localhost:8080/weather/history`)
        .then(res => {
          this.history = res.data;
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
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); 
}

.input-section {
  margin-bottom: 20px;
}

input {
  padding: 10px;
  font-size: 16px;
  margin-right: 10px;
  border: 1px solid #ccc; 
  border-radius: 4px; 
}

input:focus {
  border-color: #007bff; 
  outline: none;
}

button {
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
  border: none; 
  background-color: #007bff; 
  color: white; 
  border-radius: 4px; 
}

button:hover {
  background-color: #0056b3;
}

.weather-info {
  margin-bottom: 20px;
  padding: 15px; 
  background-color: white; 
  border-radius: 8px;
  
  box-shadow: 0 1px 5px rgba(0, 0, 0, 0.1);
}

.history-section {
  margin-top: 20px;
  background-color: white; 
  border-radius: 8px; 
  box-shadow: 0 1px 5px rgba(0, 0, 0, 0.1); 
}

.history-title {
  padding-top: 20px;
  margin-top: 10px; 
  padding-left: 15px; 
}

.history-container {
  max-height: 200px; 
  overflow-y: auto; 
}

ul {
  list-style-type: none; 
  padding: 0; 
}

li {
  background: #f9f9f9; 
  margin: 5px 0; 
  padding: 10px; 
  border: 1px solid #ddd; 
  border-radius: 4px; 
}
</style>
