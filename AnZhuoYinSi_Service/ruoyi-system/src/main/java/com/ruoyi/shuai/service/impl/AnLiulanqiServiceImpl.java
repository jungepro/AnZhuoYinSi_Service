package com.ruoyi.shuai.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shuai.mapper.AnLiulanqiMapper;
import com.ruoyi.shuai.domain.AnLiulanqi;
import com.ruoyi.shuai.service.IAnLiulanqiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 浏览器记录Service业务层处理
 * 
 * @author XiaoShuai
 * @date 2023-05-27
 */
@Service
public class AnLiulanqiServiceImpl extends ServiceImpl<AnLiulanqiMapper, AnLiulanqi> implements IAnLiulanqiService
{
    @Autowired
    private AnLiulanqiMapper anLiulanqiMapper;

    /**
     * 查询浏览器记录
     * 
     * @param id 浏览器记录ID
     * @return 浏览器记录
     */
    @Override
    public AnLiulanqi selectAnLiulanqiById(Long id)
    {
        return anLiulanqiMapper.selectAnLiulanqiById(id);
    }

    /**
     * 查询浏览器记录列表
     * 
     * @param anLiulanqi 浏览器记录
     * @return 浏览器记录
     */
    @Override
    public List<AnLiulanqi> selectAnLiulanqiList(AnLiulanqi anLiulanqi)
    {
        return anLiulanqiMapper.selectAnLiulanqiList(anLiulanqi);
    }

    /**
     * 新增浏览器记录
     * 
     * @param anLiulanqi 浏览器记录
     * @return 结果
     */
    @Override
    public int insertAnLiulanqi(AnLiulanqi anLiulanqi)
    {
        anLiulanqi.setCreateTime(DateUtils.getNowDate());
        return anLiulanqiMapper.insertAnLiulanqi(anLiulanqi);
    }

    /**
     * 修改浏览器记录
     * 
     * @param anLiulanqi 浏览器记录
     * @return 结果
     */
    @Override
    public int updateAnLiulanqi(AnLiulanqi anLiulanqi)
    {
        anLiulanqi.setUpdateTime(DateUtils.getNowDate());
        return anLiulanqiMapper.updateAnLiulanqi(anLiulanqi);
    }

    /**
     * 批量删除浏览器记录
     * 
     * @param ids 需要删除的浏览器记录ID
     * @return 结果
     */
    @Override
    public int deleteAnLiulanqiByIds(Long[] ids)
    {
        return anLiulanqiMapper.deleteAnLiulanqiByIds(ids);
    }

    /**
     * 删除浏览器记录信息
     * 
     * @param id 浏览器记录ID
     * @return 结果
     */
    @Override
    public int deleteAnLiulanqiById(Long id)
    {
        return anLiulanqiMapper.deleteAnLiulanqiById(id);
    }
}
