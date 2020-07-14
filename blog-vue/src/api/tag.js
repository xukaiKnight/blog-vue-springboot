import request from "@/request"

export function getHotTags(){
  return request({
    url: '/tags/hot',
    method: 'get'
  })
}

export function getAllTags() {
  return request({
    url: '/tags',
    method: 'get',
  })
}
