package com.ruoyi.shuai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.shuai.domain.AnAnjian;
import com.ruoyi.shuai.mapper.AnAnjianMapper;
import com.ruoyi.shuai.service.IAnAnjianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 案件管理Service业务层处理
 *
 * @author XiaoShuai
 * @date 2023-05-30
 */
@Service
public class AnAnjianServiceImpl extends ServiceImpl<AnAnjianMapper, AnAnjian> implements IAnAnjianService {
    @Autowired
    private AnAnjianMapper anAnjianMapper;

    /**
     * 查询案件管理
     *
     * @param id 案件管理ID
     * @return 案件管理
     */
    @Override
    public AnAnjian selectAnAnjianById(Long id) {
        return anAnjianMapper.selectAnAnjianById(id);
    }

    /**
     * 查询案件管理列表
     *
     * @param anAnjian 案件管理
     * @return 案件管理
     */
    @Override
    public List<AnAnjian> selectAnAnjianList(AnAnjian anAnjian) {
        return anAnjianMapper.selectAnAnjianList(anAnjian);
    }

    /**
     * 新增案件管理
     *
     * @param anAnjian 案件管理
     * @return 结果
     */
    @Override
    public int insertAnAnjian(AnAnjian anAnjian) {
        anAnjian.setCreateTime(DateUtils.getNowDate());
        return anAnjianMapper.insertAnAnjian(anAnjian);
    }

    /**
     * 修改案件管理
     *
     * @param anAnjian 案件管理
     * @return 结果
     */
    @Override
    public int updateAnAnjian(AnAnjian anAnjian) {
        anAnjian.setUpdateTime(DateUtils.getNowDate());
        return anAnjianMapper.updateAnAnjian(anAnjian);
    }

    /**
     * 批量删除案件管理
     *
     * @param ids 需要删除的案件管理ID
     * @return 结果
     */
    @Override
    public int deleteAnAnjianByIds(Long[] ids) {
        return anAnjianMapper.deleteAnAnjianByIds(ids);
    }

    /**
     * 删除案件管理信息
     *
     * @param id 案件管理ID
     * @return 结果
     */
    @Override
    public int deleteAnAnjianById(Long id) {
        return anAnjianMapper.deleteAnAnjianById(id);
    }
}
