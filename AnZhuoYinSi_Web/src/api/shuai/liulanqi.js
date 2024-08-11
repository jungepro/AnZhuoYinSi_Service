import request from '@/utils/request'

// 查询浏览器记录列表
export function listLiulanqi(query) {
  return request({
    url: '/shuai/liulanqi/list',
    method: 'get',
    params: query
  })
}

// 查询浏览器记录详细
export function getLiulanqi(id) {
  return request({
    url: '/shuai/liulanqi/' + id,
    method: 'get'
  })
}

// 新增浏览器记录
export function addLiulanqi(data) {
  return request({
    url: '/shuai/liulanqi',
    method: 'post',
    data: data
  })
}

// 修改浏览器记录
export function updateLiulanqi(data) {
  return request({
    url: '/shuai/liulanqi',
    method: 'put',
    data: data
  })
}

// 删除浏览器记录
export function delLiulanqi(id) {
  return request({
    url: '/shuai/liulanqi/' + id,
    method: 'delete'
  })
}

// 导出浏览器记录
export function exportLiulanqi(query) {
  return request({
    url: '/shuai/liulanqi/export',
    method: 'get',
    params: query
  })
}