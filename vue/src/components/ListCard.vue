<template>
        <router-link
    v-bind:to="{ name: 'list-details', params: { listID: list.listId, groupID: list.groupId } }">
            <div class="card">
             <img src="@/assets/lord.png" alt="not working">
          <div class="info">
            <h4>{{list.listName}}</h4>
          </div>
        </div>
        </router-link>
</template>

<script>
export default {
  name: "list-card",
  props: ["list"],
  data() {
    return {
    images: ['1.png', '2.png', '3.png', '4.png', '5.png', '6.png', '7.png'],
    resultImage: ''
  }
  },
  created() {

  },
  methods: {
  randomImage() {
      const random = Math.floor(Math.random() * this.images.length)
      this.resultImage = this.images[random];
  }
}
}
</script>
<style scoped>
.list-card{
  background-color: blanchedalmond;
  text-decoration-line: none;
  height: 150px;
  width: 200px;
  border-radius: 4px;
}
.wrap {
  width: 25vh;
  height: 40vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(240, 128, 128, 0.05);
}
.card {
  width: 260px;
  min-height: 200px;
  background: #0ead69;
  box-shadow:0px 2px 1px 2px blanchedalmond;
  border-radius: 4px;
  padding: 8px;
  font-family:    'Courier New', Courier, monospace;
  font-size: 16pt;
  animation-name: x;
  animation-duration: 5000s;
  animation-iteration-count: infinite;
  animation-timing-function: ease;
  transition: all;
}
.card img {
  width: 100%;
}
.info h4{
  color: blanchedalmond;
  text-decoration-line: none;
  padding: 0 10px;
}

@keyframes x {
  0% {transform: rotateY(0deg) skewX(0deg);}
  25% {transform: rotateY(-0deg) skewX(-90deg);}
  50% {transform: rotateY(0deg) skewX(0deg);}
  75% {transform: rotateY(30deg) skewX(4deg);}
  100% {transform: rotateY(0deg) skewX(0deg);}

}
.wrap {
  width: 25vh;
  height: 40vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(240, 128, 128, 0.5);
}
</style>
