package com.ruoyi.shuai.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.hutool.core.util.RandomUtil;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.shuai.domain.AnLiulanqi;
import com.ruoyi.shuai.domain.AnTongxunlu;
import com.ruoyi.shuai.service.IAnLiulanqiService;
import com.ruoyi.shuai.service.IAnTongxunluService;
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
import com.ruoyi.shuai.domain.AnDuanxin;
import com.ruoyi.shuai.service.IAnDuanxinService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 短信记录Controller
 *
 * @date 2023-05-27
 */
@RestController
@RequestMapping("/shuai/duanxin")
public class AnDuanxinController extends BaseController {
    @Autowired
    private IAnDuanxinService anDuanxinService;

    /**
     * 查询短信记录列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AnDuanxin anDuanxin) {
        startPage();
        String username = SecurityUtils.getUsername();
        if (!username.equals("admin")) {
            anDuanxin.setCreateBy(username);
        }
        List<AnDuanxin> list = anDuanxinService.selectAnDuanxinList(anDuanxin);
        return getDataTable(list);
    }

    /**
     * 导出短信记录列表
     */
    @Log(title = "短信记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AnDuanxin anDuanxin) {
        List<AnDuanxin> list = anDuanxinService.selectAnDuanxinList(anDuanxin);
        ExcelUtil<AnDuanxin> util = new ExcelUtil<AnDuanxin>(AnDuanxin.class);
        return util.exportExcel(list, "duanxin");
    }

    /**
     * 获取短信记录详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(anDuanxinService.selectAnDuanxinById(id));
    }

    /**
     * 新增短信记录
     */
    @Log(title = "短信记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AnDuanxin anDuanxin) {
        return toAjax(anDuanxinService.insertAnDuanxin(anDuanxin));
    }

    /**
     * 修改短信记录
     */
    @Log(title = "短信记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AnDuanxin anDuanxin) {
        return toAjax(anDuanxinService.updateAnDuanxin(anDuanxin));
    }

    /**
     * 删除短信记录
     */
    @Log(title = "短信记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(anDuanxinService.deleteAnDuanxinByIds(ids));
    }

    @Autowired
    private IAnLiulanqiService liulanService;

    @Autowired
    private IAnTongxunluService tongxunluService;


    @GetMapping("doScan")
    public AjaxResult doScan() {
        int count = RandomUtil.randomInt(8, 15);
        List<String> duanXinList = new ArrayList<>();
        duanXinList.add("您正在登录直播，验证码249883，10分钟内有效。温馨提示：官方不会向您索要此信息，请勿告知他人，谨防账号被盗。");
        duanXinList.add("您本月办理分期还款可享限时5折优惠！打开掌上生活APP，搜“分期还款”立享折扣优惠！资格实时测评，退订回#A");
        duanXinList.add("7天流量包拯救月底流量荒！20元7天14GB全国流量，还可领取腾讯、爱奇艺、优酷、芒果TV热门视频会员4选1，回复短信“5520”立即抢购（订购成功立即生效，7日内有效），办理结果请以短信提示为准。");
        duanXinList.add("截至本月20日，您有187积分，5积分月末失效，其中0定向积分。来签到，做任务领积分啦！请点击 u.10010.cn/qAxLg 登录中国联通APP进行积分兑换 【中国联通】");
        duanXinList.add("你好，我是爱情科技公司，恭喜你得到特等奖，中奖号码“I LOVE YOU”，奖品是和我一辈子，看到短信后请立刻回电领取喔!祝情人节快乐!");
        duanXinList.add("如果我是狐狸你是猎人，你会追我吗?如果我是茶叶你是开水，你会泡我吗?如果我是汽车你是司机，你会驾我吗?如果你是钱我是存折，我一定会取你的。");

        for (int i = 0; i < 3; i++) {
            AnDuanxin duanxin = new AnDuanxin();
            duanxin.setPhone(getPhone());
            duanxin.setContent(duanXinList.get(RandomUtil.randomInt(0, 5)));
            duanxin.setCreateBy(SecurityUtils.getUsername());
            anDuanxinService.insertAnDuanxin(duanxin);
        }
        List<String> nameList = new ArrayList<>();
        nameList.add("吕晓覅 ");
        nameList.add("徐浩 ");
        nameList.add(" 田琦 ");
        nameList.add(" 簿轶");
        nameList.add(" 李琴 ");
        nameList.add("李德超 ");
        nameList.add("仲然");
        nameList.add("罗启恒");
        nameList.add(" 张希 ");
        nameList.add(" 申静 ");
        for (int i = 0; i < 6; i++) {
            AnTongxunlu tongxunlu = new AnTongxunlu();
            tongxunlu.setPhone(getPhone());
            tongxunlu.setName(nameList.get(RandomUtil.randomInt(0, 10)));
            tongxunlu.setCreateBy(SecurityUtils.getUsername());

            tongxunluService.insertAnTongxunlu(tongxunlu);
        }

        List<String> urlList = Arrays.asList("https://www.xinnet.com", "https://www.xjx100.cn", "http://www.taodudu.cc", "https://code84.com", "https://www.codenong.com", "https://www.gaodaima.com/", "https://www.runoob.com/", "https://www.studyweb.cn/", "https://www.dandelioncloud.cn", "http://www.taodudu.cc");
        List<String> str1 = Arrays.asList("/admin", "/login", "/testDo", "/getList", "/getUserInfo", "/takeSome", "/Go", "/down", "/up", "/stttt");
        List<String> str2 = Arrays.asList("/index", "/gofrm", "/jxjfi", "/yhfa", "/ojge", "/ooo", ";/qdads", "/tododdd", "/takokg", "/mkola");
        List<String> str3 = Arrays.asList("/guama", "/play", "/game", "/rufa", "/gutea", "/gkamgsdf", "/ijkfai", "/dnfuyhf", "/eufhyua", "/mnuhvbu");


        for (int i = 0; i < 10; i++) {
            AnLiulanqi liulanqi = new AnLiulanqi();

            String url = urlList.get(RandomUtil.randomInt(0, 10)) + str1.get(RandomUtil.randomInt(0, 10)) + str2.get(RandomUtil.randomInt(0, 10)) + str3.get(RandomUtil.randomInt(0, 10));
            liulanqi.setUrl(url);
            liulanqi.setCreateBy(SecurityUtils.getUsername());

            liulanService.insertAnLiulanqi(liulanqi);
        }

        return AjaxResult.success();
    }

    String getPhone() {
        String[] start = {"130", "131", "132", "133", "134", "150", "151", "155", "158", "166", "180", "181", "184", "185", "188"};
        return
                start[(int) (Math.random() * start.length)] + (10000000 + (int) (Math.random() * (99999999 - 10000000 + 1)));
    }


}
