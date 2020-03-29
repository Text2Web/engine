package com.hmtmcse.text2web.controllers

import com.hmtmcse.te.FreemarkerTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
@RequestMapping("/admin")
class AdministratorController {

    @RequestMapping("/mia")
    @ResponseBody
    String index() {
        FreemarkerTemplate freemarkerTemplate = new FreemarkerTemplate()
        return freemarkerTemplate.processTextClassPath("/internal-asset/", "index.html")
    }

}
