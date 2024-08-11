package com.ruoyi.shuai.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.shuai.domain.AnAnjian;
import com.ruoyi.shuai.service.IAnAnjianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 案件管理Controller
 *
 * @author XiaoShuai
 * @date 2023-05-30
 */
@RestController
@RequestMapping("/shuai/anjian")
public class AnAnjianController extends BaseController {
    @Autowired
    private IAnAnjianService anAnjianService;

    /**
     * 查询案件管理列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AnAnjian anAnjian) {
        startPage();
        String username = SecurityUtils.getUsername();
        if (!username.equals("admin")) {
            anAnjian.setCreateBy(username);
        }
        List<AnAnjian> list = anAnjianService.selectAnAnjianList(anAnjian);
        return getDataTable(list);
    }

    /**
     * 导出案件管理列表
     */
    @Log(title = "案件管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AnAnjian anAnjian) {
        List<AnAnjian> list = anAnjianService.selectAnAnjianList(anAnjian);
        ExcelUtil<AnAnjian> util = new ExcelUtil<AnAnjian>(AnAnjian.class);
        return util.exportExcel(list, "anjian");
    }

    /**
     * 获取案件管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(anAnjianService.selectAnAnjianById(id));
    }

    /**
     * 新增案件管理
     */
    @Log(title = "案件管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AnAnjian anAnjian) {
        String username = SecurityUtils.getUsername();
        anAnjian.setCreateBy(username);
        return toAjax(anAnjianService.insertAnAnjian(anAnjian));
    }

    /**
     * 修改案件管理
     */
    @Log(title = "案件管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AnAnjian anAnjian) {
        return toAjax(anAnjianService.updateAnAnjian(anAnjian));
    }

    /**
     * 删除案件管理
     */
    @Log(title = "案件管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(anAnjianService.deleteAnAnjianByIds(ids));
    }
}
