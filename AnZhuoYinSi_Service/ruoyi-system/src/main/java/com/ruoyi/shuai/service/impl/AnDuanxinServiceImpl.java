package com.ruoyi.shuai.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shuai.mapper.AnDuanxinMapper;
import com.ruoyi.shuai.domain.AnDuanxin;
import com.ruoyi.shuai.service.IAnDuanxinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 短信记录Service业务层处理
 * 
 * @author XiaoShuai
 * @date 2023-05-27
 */
@Service
public class AnDuanxinServiceImpl extends ServiceImpl<AnDuanxinMapper, AnDuanxin> implements IAnDuanxinService
{
    @Autowired
    private AnDuanxinMapper anDuanxinMapper;

    /**
     * 查询短信记录
     * 
     * @param id 短信记录ID
     * @return 短信记录
     */
    @Override
    public AnDuanxin selectAnDuanxinById(Long id)
    {
        return anDuanxinMapper.selectAnDuanxinById(id);
    }

    /**
     * 查询短信记录列表
     * 
     * @param anDuanxin 短信记录
     * @return 短信记录
     */
    @Override
    public List<AnDuanxin> selectAnDuanxinList(AnDuanxin anDuanxin)
    {
        return anDuanxinMapper.selectAnDuanxinList(anDuanxin);
    }

    /**
     * 新增短信记录
     * 
     * @param anDuanxin 短信记录
     * @return 结果
     */
    @Override
    public int insertAnDuanxin(AnDuanxin anDuanxin)
    {
        anDuanxin.setCreateTime(DateUtils.getNowDate());
        return anDuanxinMapper.insertAnDuanxin(anDuanxin);
    }

    /**
     * 修改短信记录
     * 
     * @param anDuanxin 短信记录
     * @return 结果
     */
    @Override
    public int updateAnDuanxin(AnDuanxin anDuanxin)
    {
        anDuanxin.setUpdateTime(DateUtils.getNowDate());
        return anDuanxinMapper.updateAnDuanxin(anDuanxin);
    }

    /**
     * 批量删除短信记录
     * 
     * @param ids 需要删除的短信记录ID
     * @return 结果
     */
    @Override
    public int deleteAnDuanxinByIds(Long[] ids)
    {
        return anDuanxinMapper.deleteAnDuanxinByIds(ids);
    }

    /**
     * 删除短信记录信息
     * 
     * @param id 短信记录ID
     * @return 结果
     */
    @Override
    public int deleteAnDuanxinById(Long id)
    {
        return anDuanxinMapper.deleteAnDuanxinById(id);
    }
}
