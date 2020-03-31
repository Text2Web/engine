package com.hmtmcse.text2web.services

import com.hmtmcse.te.FreemarkerTemplate
import com.hmtmcse.texttoweb.data.ProcessRequest
import com.hmtmcse.texttoweb.processor.TextToWebProcessor
import org.springframework.stereotype.Service


@Service
class ManagementService {

    private FreemarkerTemplate freemarkerTemplate

    ManagementService() {
        freemarkerTemplate = new FreemarkerTemplate()
    }

    private String render(String templateName, Map<String, Object> params = [:]) {
//        return freemarkerTemplate.processTextClassPath("/templates/", templateName + ".ftl", params)
        return freemarkerTemplate.processTextWithTemplateDir("W:\\text-to-web-engine\\engine\\spring-boot-app\\src\\main\\resources\\templates\\", templateName + ".ftl", params)
    }

    String dashboard() {
        return render("dashboard")
    }

    String settings() {
        return render("settings")
    }

    String descriptorReport() {
        ProcessRequest processRequest = new ProcessRequest()
        TextToWebProcessor textToWebProcessor = new TextToWebProcessor(processRequest)
        return render("descriptor-report", [reports: textToWebProcessor.manipulateDescriptorOutline()])
    }

    String documentReport() {
        return render("document-report")
    }

    String exportHtml() {
        return render("index")
    }

    String clearHtmlVcs() {
        return render("index")
    }

    String page404() {
        return render("page404")
    }
}
