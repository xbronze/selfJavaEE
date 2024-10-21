package com.dingli.miniprogram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: xbronze
 * @date: 2024-10-21 15:05
 * @description: TODO
 */
@Controller
@RequestMapping("/investigate")
public class InvestigateController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public InfoVO add(@RequestBody Investigate investigate) {
        InfoVO infoVO = new InfoVO();
        if (investigate == null) {
            infoVO.setCode(444);
            infoVO.setMsg("未接收到数据");
        } else {
            System.out.println("investigate:" + investigate);
            infoVO.setCode(200);
            infoVO.setData(investigate);
            infoVO.setMsg("成功");
        }
        return infoVO;
    }


    @RequestMapping(value = "/add2", method = RequestMethod.POST)
    @ResponseBody
    public InfoVO add2(Investigate investigate) {
        InfoVO infoVO = new InfoVO();
        if (investigate == null) {
            infoVO.setCode(444);
            infoVO.setMsg("未接收到数据");
        } else {
            System.out.println("investigate:" + investigate);
            infoVO.setCode(200);
            infoVO.setData(investigate);
            infoVO.setMsg("success");
        }
        return infoVO;
    }
}
