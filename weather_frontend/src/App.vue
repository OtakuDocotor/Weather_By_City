<template>
  <div id="app">
    <Weather />
  </div>
</template>

<script>
import Weather from './components/Weather.vue';

export default {
  name: 'App',
  components: {
    Weather,
  },
};
</script>

<style>
#app {
  font-family: Arial, sans-serif;
  text-align: center;
  margin-top: 20px;
}
</style>