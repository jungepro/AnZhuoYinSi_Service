package com.ruoyi.shuai.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.shuai.domain.AnAnjian;

import java.util.List;

/**
 * 案件管理Service接口
 *
 * @author XiaoShuai
 * @date 2023-05-30
 */
public interface IAnAnjianService extends IService<AnAnjian> {
    /**
     * 查询案件管理
     *
     * @param id 案件管理ID
     * @return 案件管理
     */
    public AnAnjian selectAnAnjianById(Long id);

    /**
     * 查询案件管理列表
     *
     * @param anAnjian 案件管理
     * @return 案件管理集合
     */
    public List<AnAnjian> selectAnAnjianList(AnAnjian anAnjian);

    /**
     * 新增案件管理
     *
     * @param anAnjian 案件管理
     * @return 结果
     */
    public int insertAnAnjian(AnAnjian anAnjian);

    /**
     * 修改案件管理
     *
     * @param anAnjian 案件管理
     * @return 结果
     */
    public int updateAnAnjian(AnAnjian anAnjian);

    /**
     * 批量删除案件管理
     *
     * @param ids 需要删除的案件管理ID
     * @return 结果
     */
    public int deleteAnAnjianByIds(Long[] ids);

    /**
     * 删除案件管理信息
     *
     * @param id 案件管理ID
     * @return 结果
     */
    public int deleteAnAnjianById(Long id);
}
