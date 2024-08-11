import request from '@/utils/request'

// 查询短信记录列表
export function listDuanxin(query) {
  return request({
    url: '/shuai/duanxin/list',
    method: 'get',
    params: query
  })
}

// 查询短信记录详细
export function getDuanxin(id) {
  return request({
    url: '/shuai/duanxin/' + id,
    method: 'get'
  })
}

// 新增短信记录
export function addDuanxin(data) {
  return request({
    url: '/shuai/duanxin',
    method: 'post',
    data: data
  })
}

// 修改短信记录
export function updateDuanxin(data) {
  return request({
    url: '/shuai/duanxin',
    method: 'put',
    data: data
  })
}

// 删除短信记录
export function delDuanxin(id) {
  return request({
    url: '/shuai/duanxin/' + id,
    method: 'delete'
  })
}

// 导出短信记录
export function exportDuanxin(query) {
  return request({
    url: '/shuai/duanxin/export',
    method: 'get',
    params: query
  })
}

export function doScan(query) {
  return request({
    url: '/shuai/duanxin/doScan',
    method: 'get',
    params: query
  })
}
