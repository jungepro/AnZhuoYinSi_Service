import request from '@/utils/request'

// 查询案件管理列表
export function listAnjian(query) {
  return request({
    url: '/shuai/anjian/list',
    method: 'get',
    params: query
  })
}

// 查询案件管理详细
export function getAnjian(id) {
  return request({
    url: '/shuai/anjian/' + id,
    method: 'get'
  })
}

// 新增案件管理
export function addAnjian(data) {
  return request({
    url: '/shuai/anjian',
    method: 'post',
    data: data
  })
}

// 修改案件管理
export function updateAnjian(data) {
  return request({
    url: '/shuai/anjian',
    method: 'put',
    data: data
  })
}

// 删除案件管理
export function delAnjian(id) {
  return request({
    url: '/shuai/anjian/' + id,
    method: 'delete'
  })
}

// 导出案件管理
export function exportAnjian(query) {
  return request({
    url: '/shuai/anjian/export',
    method: 'get',
    params: query
  })
}