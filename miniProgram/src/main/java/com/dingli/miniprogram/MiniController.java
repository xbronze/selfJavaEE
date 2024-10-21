package com.dingli.miniprogram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: xbronze
 * @date: 2024-10-21 10:26
 * @description: TODO
 */
@Controller
@RequestMapping("/mini")
public class MiniController {

    @RequestMapping("/info")
    @ResponseBody
    public InfoVO info() throws InterruptedException {
        Thread.sleep(5000);
        InfoVO infoVO = new InfoVO();
        infoVO.setCode(200);
        infoVO.setData("This info from Spring MVC");
        return infoVO;
    }
}
