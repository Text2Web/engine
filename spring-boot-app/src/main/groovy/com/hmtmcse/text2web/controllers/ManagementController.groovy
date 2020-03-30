package com.hmtmcse.text2web.controllers

import com.hmtmcse.te.FreemarkerTemplate
import com.hmtmcse.text2web.services.ManagementService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
@RequestMapping("/manage-text2web")
class ManagementController {

    @Autowired
    private ManagementService managementService

    @RequestMapping(value = ["", "/"])
    @ResponseBody
    String bismillah() {
        return managementService.index()
    }

    @RequestMapping(value = ["/configure"])
    @ResponseBody
    String configure() {
        return managementService.configure()
    }

    @RequestMapping(value = ["/descriptor-report"])
    @ResponseBody
    String descriptorReport() {
        return managementService.descriptorReport()
    }

    @RequestMapping(value = ["/document-report"])
    @ResponseBody
    String documentReport() {
        return managementService.documentReport()
    }

    @RequestMapping(value = ["/export-html"])
    @ResponseBody
    String exportHtml() {
        return managementService.exportHtml()
    }

    @RequestMapping(value = ["/clear-html-vcs"])
    @ResponseBody
    String clearHtmlVcs() {
        return managementService.clearHtmlVcs()
    }

}
