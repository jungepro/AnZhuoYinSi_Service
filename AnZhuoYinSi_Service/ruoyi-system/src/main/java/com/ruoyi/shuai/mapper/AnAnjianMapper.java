package com.ruoyi.shuai.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.shuai.domain.AnAnjian;

/**
 * 案件管理Mapper接口
 *
 * @author XiaoShuai
 * @date 2023-05-30
 */
public interface AnAnjianMapper extends BaseMapper<AnAnjian> {
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
     * 删除案件管理
     *
     * @param id 案件管理ID
     * @return 结果
     */
    public int deleteAnAnjianById(Long id);

    /**
     * 批量删除案件管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAnAnjianByIds(Long[] ids);
}
