package com.hmtmcse.text2web.controllers

import com.hmtmcse.te.FreemarkerTemplate
import com.hmtmcse.text2web.services.ManagementService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
@RequestMapping("/manage")
class ManagementController {

    @Autowired
    private ManagementService managementService

    @RequestMapping(value = ["", "/"])
    @ResponseBody
    String bismillah() {
        return managementService.index()
    }

}
