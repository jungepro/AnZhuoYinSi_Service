package com.ruoyi.shuai.controller;

import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shuai.domain.AnTongxunlu;
import com.ruoyi.shuai.service.IAnTongxunluService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 通讯录记录Controller
 *
 * @author XiaoShuai
 * @date 2023-05-27
 */
@RestController
@RequestMapping("/shuai/tongxunlu")
public class AnTongxunluController extends BaseController {
    @Autowired
    private IAnTongxunluService anTongxunluService;

    /**
     * 查询通讯录记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AnTongxunlu anTongxunlu) {
        startPage();
        String username = SecurityUtils.getUsername();
        if (!username.equals("admin")) {
            anTongxunlu.setCreateBy(username);
        }
        List<AnTongxunlu> list = anTongxunluService.selectAnTongxunluList(anTongxunlu);
        return getDataTable(list);
    }

    /**
     * 导出通讯录记录列表
     */
    @Log(title = "通讯录记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AnTongxunlu anTongxunlu) {
        List<AnTongxunlu> list = anTongxunluService.selectAnTongxunluList(anTongxunlu);
        ExcelUtil<AnTongxunlu> util = new ExcelUtil<AnTongxunlu>(AnTongxunlu.class);
        return util.exportExcel(list, "tongxunlu");
    }

    /**
     * 获取通讯录记录详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(anTongxunluService.selectAnTongxunluById(id));
    }

    /**
     * 新增通讯录记录
     */
    @Log(title = "通讯录记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AnTongxunlu anTongxunlu) {
        return toAjax(anTongxunluService.insertAnTongxunlu(anTongxunlu));
    }

    /**
     * 修改通讯录记录
     */
    @Log(title = "通讯录记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AnTongxunlu anTongxunlu) {
        return toAjax(anTongxunluService.updateAnTongxunlu(anTongxunlu));
    }

    /**
     * 删除通讯录记录
     */
    @Log(title = "通讯录记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(anTongxunluService.deleteAnTongxunluByIds(ids));
    }
}
