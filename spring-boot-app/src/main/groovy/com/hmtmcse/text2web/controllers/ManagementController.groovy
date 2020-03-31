package com.hmtmcse.text2web.controllers

import com.hmtmcse.text2web.data.MergeDescriptor
import com.hmtmcse.text2web.services.ManagementService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.mvc.support.RedirectAttributes


@Controller
@RequestMapping("/text2web-manage")
class ManagementController {

    @Autowired
    private ManagementService managementService

    @RequestMapping(value = ["", "/"])
    @ResponseBody
    String bismillah() {
        return managementService.dashboard()
    }

    @RequestMapping(value = ["/settings"])
    @ResponseBody
    String configure() {
        return managementService.settings()
    }

    @RequestMapping(value = ["/descriptor-report"])
    @ResponseBody
    String descriptorReport(@ModelAttribute("flash") String flash) {
        return managementService.descriptorReport(flash)
    }

    @RequestMapping(value = ["/merge-descriptor"], method = RequestMethod.POST)
    String mergeDescriptor(MergeDescriptor mergeDescriptor, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("flash", managementService.mergeDescriptor(mergeDescriptor));
        return "redirect:/text2web-manage/descriptor-report"
    }

    @RequestMapping(value = ["/document-report"])
    @ResponseBody
    String documentReport() {
        return managementService.documentReport()
    }

    @RequestMapping(value = ["/export-html"],  method = RequestMethod.POST)
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
