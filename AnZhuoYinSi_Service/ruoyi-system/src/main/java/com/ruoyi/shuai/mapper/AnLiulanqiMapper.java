package com.ruoyi.shuai.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.shuai.domain.AnLiulanqi;

/**
 * 浏览器记录Mapper接口
 *
 * @author XiaoShuai
 * @date 2023-05-27
 */
public interface AnLiulanqiMapper extends BaseMapper<AnLiulanqi>
{
    /**
     * 查询浏览器记录
     *
     * @param id 浏览器记录ID
     * @return 浏览器记录
     */
    public AnLiulanqi selectAnLiulanqiById(Long id);

    /**
     * 查询浏览器记录列表
     *
     * @param anLiulanqi 浏览器记录
     * @return 浏览器记录集合
     */
    public List<AnLiulanqi> selectAnLiulanqiList(AnLiulanqi anLiulanqi);

    /**
     * 新增浏览器记录
     *
     * @param anLiulanqi 浏览器记录
     * @return 结果
     */
    public int insertAnLiulanqi(AnLiulanqi anLiulanqi);

    /**
     * 修改浏览器记录
     *
     * @param anLiulanqi 浏览器记录
     * @return 结果
     */
    public int updateAnLiulanqi(AnLiulanqi anLiulanqi);

    /**
     * 删除浏览器记录
     *
     * @param id 浏览器记录ID
     * @return 结果
     */
    public int deleteAnLiulanqiById(Long id);

    /**
     * 批量删除浏览器记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAnLiulanqiByIds(Long[] ids);
}
