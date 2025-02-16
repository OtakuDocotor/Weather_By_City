<script setup>

</script>

<template>
  <body>
    <div class="wrapper">
        <h1>Погода</h1>
        <p> Погода в вашем городе</p> 
        <input type="text" placeholder="Введите название города">
        <br>
        <button>Получить погоду</button>
        <button name="btn2">Jytn</button>
    </div>
  </body>
</template>

<style scoped>
.wrapper {
  width: 900px;
  height: 500px;
  border-radius: 50px;
  padding: 20px;
  background: rgb(39, 39, 39);
  text-align: center;
  color: whitesmoke;
}

.wrapper h1{
  margin-top: 5px;
  font-size: 50px;
}

.wrapper p{
  margin-top: 15px;
  font-size: 30px;
}

.wrapper input{
  margin-top: 30px;
  width: 325px;
  background:  transparent;
  color:  white;
  font-size: 25px;
  padding: 5px 8px;
  outline: none;
}
.wrapper input:focus{
  border-color: rgba(148,187,233,1);
}
.wrapper button{
  margin-top: 20px;
  display: inline-block;
  padding: 15px 25px;
  font-size: 15px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background: rgb(63,94,251);
  background: radial-gradient(circle, rgba(63,94,251,1) 0%, rgba(252,70,107,1) 100%);
  border: none;
  border-radius: 15px;
  transition: transform 500ms ease;
}
.wrapper button:hover {
  transform: scale(1.1) translateY(-5px);
}
</style>
