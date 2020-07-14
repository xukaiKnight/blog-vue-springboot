import Vuex from 'vuex'
import Vue from 'vue'

import {getToken, setToken, removeToken} from '@/request/token'
import {login, getUserInfo, logout, register} from '@/api/login'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    id: '',
    account: '',
    name: '',
    avatar: '',
    token: getToken(),
  },
  //回调函数 通过commit('SET_TOKEN', data.data['Oauth-Token'])方法调用
  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token;
    },
    SET_ACCOUNT: (state, account) => {
      state.account = account
    },
    SET_NAME: (state, name) => {
      state.name = name
    },
    SET_AVATAR: (state, avatar) => {
      state.avatar = avatar
    },
    SET_ID: (state, id) => {
      state.id = id
    }
  },
  actions: {
    login({commit}, user) {
      console.info(user.account)
      return new Promise((resolve, reject) => {
        login(user.account, user.password).then(data => {
          //设置token,作为用户已登陆的前端标识,存在cookie中
          commit('SET_TOKEN', data.data['Oauth-Token'])
          setToken(data.data['Oauth-Token'])
          resolve()
        }).catch(error => {
          //登陆失败 回传信息
          reject(error)
        })
      })
    },
    //获取用户信息,在router生效前调用
    getUserInfo({commit, state}) {
      let that = this
      return new Promise((resolve, reject) => {
        getUserInfo().then(data => {
          if (data.data) {
            commit('SET_ACCOUNT', data.data.account)
            commit('SET_NAME', data.data.nickName)
            commit('SET_AVATAR', data.data.avatar)
            commit('SET_ID', data.data.id)
          } else {
            commit('SET_ACCOUNT', '')
            commit('SET_NAME', '')
            commit('SET_AVATAR', '')
            commit('SET_ID', '')
            removeToken()
          }
          resolve(data)
        }).catch(error => {
          reject(error)
        })
      })
    },
    logout({commit, state}) {
      return new Promise((resolve, reject) => {
        logout().then(data => {

          commit('SET_TOKEN', '')
          commit('SET_ACCOUNT', '')
          commit('SET_NAME', '')
          commit('SET_AVATAR', '')
          commit('SET_ID', '')
          removeToken()
          resolve()

        }).catch(error => {
          reject(error)
        })
      })
    },
    register({commit}, user) {
      console.info(user.nickName)
      return new Promise((resolve, reject) => {
        register(user.account, user.nickName, user.password).then((data) => {
          commit('SET_TOKEN', data.data['Oauth-Token'])
          setToken(data.data['Oauth-Token'])
          resolve()
        }).catch((error) => {
          reject(error)
        })
      })
    },
  }
})
