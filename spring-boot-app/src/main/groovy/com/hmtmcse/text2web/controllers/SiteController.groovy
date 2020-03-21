package com.hmtmcse.text2web.controllers

import com.hmtmcse.te.TextToWebHtmlEngine
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpServletRequest


@Controller
class SiteController {


    @GetMapping("/**")
    @ResponseBody
    String index(HttpServletRequest request) {
        println(request.getRequestURI())
        TextToWebHtmlEngine templateEngine = new TextToWebHtmlEngine()
        return templateEngine.parse()

    }

}
