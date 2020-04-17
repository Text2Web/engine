package com.hmtmcse.text2web.controllers

import com.hmtmcse.te.TextToWebHtmlEngine
import com.hmtmcse.te.data.TextToWebEngineConfig
import com.hmtmcse.text2web.services.SiteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpServletRequest


@Controller
class SiteController {

    @Autowired
    private SiteService siteService

    @RequestMapping("/{start:^(?!asset|static-files|internal-asset|data-search|text2web-manage|text2web-system|favicon\\.ico).*}/**")
    @ResponseBody
    String startWith(@PathVariable("start") String start, HttpServletRequest request) {
        TextToWebHtmlEngine templateEngine = new TextToWebHtmlEngine()
        TextToWebEngineConfig config = new TextToWebEngineConfig()
        config.isDevelopmentMode = true
        return templateEngine.getContentByURL(request.getRequestURI(), config)
    }

    @RequestMapping("/")
    @ResponseBody
    String index(HttpServletRequest request) {
        TextToWebHtmlEngine templateEngine = new TextToWebHtmlEngine()
        TextToWebEngineConfig config = new TextToWebEngineConfig()
        config.isDevelopmentMode = true
        return templateEngine.getContentByURL(request.getRequestURI(), config)
    }

    @RequestMapping("/data-search")
    @ResponseBody
    String search(HttpServletRequest request) {
        return siteService.searchResult()
    }

}
