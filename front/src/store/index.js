import { createStore } from 'vuex'

export default createStore({
  state() {
    return{
      authorized: false
    }
  },
  getters: {
    isLogin(state){
      return state.authorized
    }
  },
  mutations: {
    login (state){
      state.authorized = true
    }
  },
  actions: {

  },
  modules: {
  }
})
