package com.hmtmcse.text2web.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class SiteController {


    @GetMapping("/")
    @ResponseBody
    String index() {
        return "bismillah"
    }

}
