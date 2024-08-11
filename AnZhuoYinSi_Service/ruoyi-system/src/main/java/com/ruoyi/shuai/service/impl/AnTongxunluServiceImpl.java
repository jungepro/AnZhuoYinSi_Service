package com.ruoyi.shuai.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shuai.mapper.AnTongxunluMapper;
import com.ruoyi.shuai.domain.AnTongxunlu;
import com.ruoyi.shuai.service.IAnTongxunluService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 通讯录记录Service业务层处理
 * 
 * @author XiaoShuai
 * @date 2023-05-27
 */
@Service
public class AnTongxunluServiceImpl extends ServiceImpl<AnTongxunluMapper, AnTongxunlu> implements IAnTongxunluService
{
    @Autowired
    private AnTongxunluMapper anTongxunluMapper;

    /**
     * 查询通讯录记录
     * 
     * @param id 通讯录记录ID
     * @return 通讯录记录
     */
    @Override
    public AnTongxunlu selectAnTongxunluById(Long id)
    {
        return anTongxunluMapper.selectAnTongxunluById(id);
    }

    /**
     * 查询通讯录记录列表
     * 
     * @param anTongxunlu 通讯录记录
     * @return 通讯录记录
     */
    @Override
    public List<AnTongxunlu> selectAnTongxunluList(AnTongxunlu anTongxunlu)
    {
        return anTongxunluMapper.selectAnTongxunluList(anTongxunlu);
    }

    /**
     * 新增通讯录记录
     * 
     * @param anTongxunlu 通讯录记录
     * @return 结果
     */
    @Override
    public int insertAnTongxunlu(AnTongxunlu anTongxunlu)
    {
        anTongxunlu.setCreateTime(DateUtils.getNowDate());
        return anTongxunluMapper.insertAnTongxunlu(anTongxunlu);
    }

    /**
     * 修改通讯录记录
     * 
     * @param anTongxunlu 通讯录记录
     * @return 结果
     */
    @Override
    public int updateAnTongxunlu(AnTongxunlu anTongxunlu)
    {
        anTongxunlu.setUpdateTime(DateUtils.getNowDate());
        return anTongxunluMapper.updateAnTongxunlu(anTongxunlu);
    }

    /**
     * 批量删除通讯录记录
     * 
     * @param ids 需要删除的通讯录记录ID
     * @return 结果
     */
    @Override
    public int deleteAnTongxunluByIds(Long[] ids)
    {
        return anTongxunluMapper.deleteAnTongxunluByIds(ids);
    }

    /**
     * 删除通讯录记录信息
     * 
     * @param id 通讯录记录ID
     * @return 结果
     */
    @Override
    public int deleteAnTongxunluById(Long id)
    {
        return anTongxunluMapper.deleteAnTongxunluById(id);
    }
}
