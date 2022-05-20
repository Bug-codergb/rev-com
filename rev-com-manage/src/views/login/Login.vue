<template>
  <div class="login">
    <bgc />
    <div class="login-inner">
      <div class="sys-name">Rev-Com</div>
      <div class="user-name-outer">
        <span>用户名:</span>
        <input v-model="account.userName" placeholder="请输入用户名" />
      </div>
      <div class="password-outer">
        <span>密码:</span>
        <input v-model="account.password" placeholder="请输入密码" />
      </div>
      <button class="login-btn" @click="homeRouter">登录</button>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive } from "vue"

import { useRouter } from "vue-router"
import { ElMessage } from "element-plus"
import { useStore } from "vuex"
import Bgc from "@/views/login/childCpn/bgc/Bgc.vue"
export default defineComponent({
  name: "Login",
  components: {
    Bgc
  },
  setup() {
    const router = useRouter()
    const store = useStore()
    const account = reactive({
      userName: "",
      password: ""
    })
    const homeRouter = () => {
      if (account.userName.trim().length === 0) {
        ElMessage({
          message: "请输入用户名",
          type: "warning"
        })
      } else if (account.password.trim().length === 0) {
        ElMessage({
          message: "请输入密码",
          type: "warning"
        })
      } else {
        store
          .dispatch({
            type: "login/loginAction",
            userName: account.userName,
            password: account.password
          })
          .then(() => {
            router.push({
              path: "/Home"
            })
          })
      }
    }
    return {
      account,
      homeRouter
    }
  }
})
</script>

<style scoped lang="less">
.login {
  height: 100%;
  width: 100%;
  position: relative;
  .login-inner {
    background-color: #fff;
    position: absolute;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
    padding: 50px 40px;
    left: 60%;
    top: 50%;
    border-radius: 10px;
    transform: translate(0, -60%);
    .sys-name {
      font-size: 40px;
      font-weight: bolder;
      margin: 0 0 40px 0;
      text-align: center;
    }
    .user-name-outer,
    .password-outer {
      margin: 0 0 30px 0;
      & > span {
        width: 70px;
        display: inline-block;
      }
      & > input {
        border: 1px solid #00a1d6;
        padding: 15px 15px;
        width: 270px;
        border-radius: 4px;
      }
    }
    .login-btn {
      background-color: #00a1d6;
      font-size: 16px;
      color: #fff;
      padding: 15px;
      display: inline-block;
      width: 340px;
      margin: 30px 0 0 0;
      border-radius: 5px;
      cursor: pointer;
    }
  }
}
</style>
