import request from '@/request'

export function login(account, password){
  const data={
    account,
    password
  }
  return request({
    url: '/login',
    method: 'post',
    data
  })
}

export function getUserInfo() {
  return request({
    url: '/users/currentUser',
    method: 'get'
  })
}
export function logout() {
  return request({
    url: '/logout',
    method: 'get'
  })
}

export function register(account, nickName, password) {
  const data = {
    account,
    nickName,
    password
  }
  return request({
    url: '/register',
    method: 'post',
    data
  })
}

