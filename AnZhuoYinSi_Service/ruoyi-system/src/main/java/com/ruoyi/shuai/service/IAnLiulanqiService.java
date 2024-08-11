package com.ruoyi.shuai.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.shuai.domain.AnLiulanqi;

/**
 * 浏览器记录Service接口
 *
 * @author XiaoShuai
 * @date 2023-05-27
 */
public interface IAnLiulanqiService extends IService<AnLiulanqi>
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
     * 批量删除浏览器记录
     *
     * @param ids 需要删除的浏览器记录ID
     * @return 结果
     */
    public int deleteAnLiulanqiByIds(Long[] ids);

    /**
     * 删除浏览器记录信息
     *
     * @param id 浏览器记录ID
     * @return 结果
     */
    public int deleteAnLiulanqiById(Long id);
}
