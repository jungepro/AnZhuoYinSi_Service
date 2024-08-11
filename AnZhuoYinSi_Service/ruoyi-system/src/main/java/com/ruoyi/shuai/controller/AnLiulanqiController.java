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
import com.ruoyi.shuai.domain.AnLiulanqi;
import com.ruoyi.shuai.service.IAnLiulanqiService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 浏览器记录Controller
 *
 * @author XiaoShuai
 * @date 2023-05-27
 */
@RestController
@RequestMapping("/shuai/liulanqi")
public class AnLiulanqiController extends BaseController
{
    @Autowired
    private IAnLiulanqiService anLiulanqiService;

    /**
     * 查询浏览器记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AnLiulanqi anLiulanqi)
    {
        startPage();
        String username = SecurityUtils.getUsername();
        if (!username.equals("admin")) {
            anLiulanqi.setCreateBy(username);
        }
        List<AnLiulanqi> list = anLiulanqiService.selectAnLiulanqiList(anLiulanqi);
        return getDataTable(list);
    }

    /**
     * 导出浏览器记录列表
     */
    @Log(title = "浏览器记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AnLiulanqi anLiulanqi)
    {
        List<AnLiulanqi> list = anLiulanqiService.selectAnLiulanqiList(anLiulanqi);
        ExcelUtil<AnLiulanqi> util = new ExcelUtil<AnLiulanqi>(AnLiulanqi.class);
        return util.exportExcel(list, "liulanqi");
    }

    /**
     * 获取浏览器记录详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(anLiulanqiService.selectAnLiulanqiById(id));
    }

    /**
     * 新增浏览器记录
     */
    @Log(title = "浏览器记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AnLiulanqi anLiulanqi)
    {
        return toAjax(anLiulanqiService.insertAnLiulanqi(anLiulanqi));
    }

    /**
     * 修改浏览器记录
     */
    @Log(title = "浏览器记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AnLiulanqi anLiulanqi)
    {
        return toAjax(anLiulanqiService.updateAnLiulanqi(anLiulanqi));
    }

    /**
     * 删除浏览器记录
     */
    @Log(title = "浏览器记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(anLiulanqiService.deleteAnLiulanqiByIds(ids));
    }
}
