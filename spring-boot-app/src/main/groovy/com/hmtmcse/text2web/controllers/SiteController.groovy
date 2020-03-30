package com.hmtmcse.text2web.controllers

import com.hmtmcse.te.TextToWebHtmlEngine
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpServletRequest


@Controller
class SiteController {

    @RequestMapping("/{start:^(?!asset|static-files|internal-asset|manage).*}/**")
    @ResponseBody
    String startWith(@PathVariable("start") String start, HttpServletRequest request) {
        TextToWebHtmlEngine templateEngine = new TextToWebHtmlEngine()
        return templateEngine.getContentByURL(request.getRequestURI())
    }

    @RequestMapping("/")
    @ResponseBody
    String index(HttpServletRequest request) {
        TextToWebHtmlEngine templateEngine = new TextToWebHtmlEngine()
        return templateEngine.getContentByURL(request.getRequestURI())
    }

}
