package com.ruoyi.shuai.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.shuai.domain.AnTongxunlu;

/**
 * 通讯录记录Service接口
 *
 * @author XiaoShuai
 * @date 2023-05-27
 */
public interface IAnTongxunluService extends IService<AnTongxunlu>
{
    /**
     * 查询通讯录记录
     *
     * @param id 通讯录记录ID
     * @return 通讯录记录
     */
    public AnTongxunlu selectAnTongxunluById(Long id);

    /**
     * 查询通讯录记录列表
     *
     * @param anTongxunlu 通讯录记录
     * @return 通讯录记录集合
     */
    public List<AnTongxunlu> selectAnTongxunluList(AnTongxunlu anTongxunlu);

    /**
     * 新增通讯录记录
     *
     * @param anTongxunlu 通讯录记录
     * @return 结果
     */
    public int insertAnTongxunlu(AnTongxunlu anTongxunlu);

    /**
     * 修改通讯录记录
     *
     * @param anTongxunlu 通讯录记录
     * @return 结果
     */
    public int updateAnTongxunlu(AnTongxunlu anTongxunlu);

    /**
     * 批量删除通讯录记录
     *
     * @param ids 需要删除的通讯录记录ID
     * @return 结果
     */
    public int deleteAnTongxunluByIds(Long[] ids);

    /**
     * 删除通讯录记录信息
     *
     * @param id 通讯录记录ID
     * @return 结果
     */
    public int deleteAnTongxunluById(Long id);
}
