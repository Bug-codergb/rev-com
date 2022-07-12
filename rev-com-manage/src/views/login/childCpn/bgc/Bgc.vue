<template>
  <div class="page">
    <div class="container">
      <div class="photo-container">
        <div class="photo-cont-item animation-1">
          <div class="photo-item photo-1"></div>
          <div class="photo-item photo-2"></div>
          <div class="photo-item photo-3"></div>
          <div class="photo-item photo-4"></div>
          <div class="photo-item photo-5"></div>
          <div class="photo-item photo-6"></div>

          <div class="photo-item photo-1"></div>
          <div class="photo-item photo-2"></div>
          <div class="photo-item photo-3"></div>
          <div class="photo-item photo-4"></div>
          <div class="photo-item photo-5"></div>
          <div class="photo-item photo-6"></div>
        </div>

        <div class="photo-cont-item animation-2">
          <div class="photo-item photo-7"></div>
          <div class="photo-item photo-8"></div>
          <div class="photo-item photo-9"></div>
          <div class="photo-item photo-10"></div>
          <div class="photo-item photo-11"></div>
          <div class="photo-item photo-12"></div>

          <div class="photo-item photo-7"></div>
          <div class="photo-item photo-8"></div>
          <div class="photo-item photo-9"></div>
          <div class="photo-item photo-10"></div>
          <div class="photo-item photo-11"></div>
          <div class="photo-item photo-12"></div>
        </div>

        <div class="photo-cont-item animation-3">
          <div class="photo-item photo-13"></div>
          <div class="photo-item photo-14"></div>
          <div class="photo-item photo-15"></div>
          <div class="photo-item photo-16"></div>
          <div class="photo-item photo-17"></div>
          <div class="photo-item photo-18"></div>

          <div class="photo-item photo-13"></div>
          <div class="photo-item photo-14"></div>
          <div class="photo-item photo-15"></div>
          <div class="photo-item photo-16"></div>
          <div class="photo-item photo-17"></div>
          <div class="photo-item photo-18"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

export default defineComponent({
  name: "Bgc"
});
</script>

<style scoped lang="less">
.page {
  display: flex;
  max-width: 1900px;
  background-color: #fff;
  height: 100vh;
}
// Start here
.container {
  width: 100%;
  height: 100vh;
  background: #f3f4f5;

  overflow: hidden;
}
.photo-container {
  position: relative;
  top: -90px; // Adjust
  left: -120px; // Adjust
  transform: rotate(10deg);
}
.photo-cont-item {
  display: flex;
  width: calc(380px * 6); // 320px + 60px margin
  .photo-item {
    width: 320px;
    height: 200px;
    margin-right: 60px;
    margin-bottom: 60px;
    border-radius: 16px;
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
    box-shadow: 0px 2px 40px rgba(0, 0, 0, 0.15);
  }
}

// Every row
.animation-1 {
  animation: scroller 40s linear infinite;
  display: flex;
  width: calc(380px * 12);
}
.animation-2 {
  margin-left: 150px;
  animation: scroller 30s linear infinite;
  display: flex;
  width: calc(380px * 12);
}
.animation-3 {
  animation: scroller 50s linear infinite;
  display: flex;
  width: calc(380px * 12);
}

// Animations
@keyframes scroller {
  0% {
    transform: translateX(0);
  }
  100% {
    transform: translateX(calc(-380px * 6)); // 320px + 60px margin
  }
}

// All selected images
.photo-1 {
  background-image: url(${artist2});
}
.photo-2 {
  background-image: url(${artist3});
}
.photo-3 {
  background-image: url(${artist4});
}
.photo-4 {
  background-image: url(${artist5});
}
.photo-5 {
  background-image: url(${artist6});
}
.photo-6 {
  background-image: url(${artist7});
}
.photo-7 {
  background-image: url(${mv1});
}
.photo-8 {
  background-image: url(${mv2});
}
.photo-9 {
  background-image: url(${mv3});
}
.photo-10 {
  background-image: url(${mv4});
}
.photo-11 {
  background-image: url(${mv5});
}
.photo-12 {
  background-image: url(${mv6});
}
.photo-13 {
  background-image: url("../../../../assets/img/bgc/movie/1.jpg");
}
.photo-14 {
  background-image: url("../../../../assets/img/bgc/movie/2.jpg");
}
.photo-15 {
  background-image: url("../../../../assets/img/bgc/movie/3.jpg");
}
.photo-16 {
  background-image: url("../../../../assets/img/bgc/movie/4.jpg");
}
.photo-17 {
  background-image: url("../../../../assets/img/bgc/movie/5.jpg");
}
.photo-18 {
  background-image: url("../../../../assets/img/bgc/movie/6.jpg");
}
</style>
