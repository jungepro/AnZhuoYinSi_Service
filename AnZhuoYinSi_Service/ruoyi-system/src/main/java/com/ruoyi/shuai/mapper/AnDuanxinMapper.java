package com.ruoyi.shuai.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.shuai.domain.AnDuanxin;

/**
 * 短信记录Mapper接口
 *
 * @author XiaoShuai
 * @date 2023-05-27
 */
public interface AnDuanxinMapper extends BaseMapper<AnDuanxin>
{
    /**
     * 查询短信记录
     *
     * @param id 短信记录ID
     * @return 短信记录
     */
    public AnDuanxin selectAnDuanxinById(Long id);

    /**
     * 查询短信记录列表
     *
     * @param anDuanxin 短信记录
     * @return 短信记录集合
     */
    public List<AnDuanxin> selectAnDuanxinList(AnDuanxin anDuanxin);

    /**
     * 新增短信记录
     *
     * @param anDuanxin 短信记录
     * @return 结果
     */
    public int insertAnDuanxin(AnDuanxin anDuanxin);

    /**
     * 修改短信记录
     *
     * @param anDuanxin 短信记录
     * @return 结果
     */
    public int updateAnDuanxin(AnDuanxin anDuanxin);

    /**
     * 删除短信记录
     *
     * @param id 短信记录ID
     * @return 结果
     */
    public int deleteAnDuanxinById(Long id);

    /**
     * 批量删除短信记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAnDuanxinByIds(Long[] ids);
}