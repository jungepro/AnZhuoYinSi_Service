import request from '@/utils/request'

// 查询通讯录记录列表
export function listTongxunlu(query) {
  return request({
    url: '/shuai/tongxunlu/list',
    method: 'get',
    params: query
  })
}

// 查询通讯录记录详细
export function getTongxunlu(id) {
  return request({
    url: '/shuai/tongxunlu/' + id,
    method: 'get'
  })
}

// 新增通讯录记录
export function addTongxunlu(data) {
  return request({
    url: '/shuai/tongxunlu',
    method: 'post',
    data: data
  })
}

// 修改通讯录记录
export function updateTongxunlu(data) {
  return request({
    url: '/shuai/tongxunlu',
    method: 'put',
    data: data
  })
}

// 删除通讯录记录
export function delTongxunlu(id) {
  return request({
    url: '/shuai/tongxunlu/' + id,
    method: 'delete'
  })
}

// 导出通讯录记录
export function exportTongxunlu(query) {
  return request({
    url: '/shuai/tongxunlu/export',
    method: 'get',
    params: query
  })
}