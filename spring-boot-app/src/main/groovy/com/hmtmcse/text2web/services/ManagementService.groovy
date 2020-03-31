package com.hmtmcse.text2web.services

import com.hmtmcse.te.FreemarkerTemplate
import com.hmtmcse.texttoweb.processor.TextToWebProcessor
import org.springframework.stereotype.Service


@Service
class ManagementService {

    private TextToWebProcessor textToWebProcessor
    private FreemarkerTemplate freemarkerTemplate

    ManagementService() {
        textToWebProcessor = new TextToWebProcessor()
        freemarkerTemplate = new FreemarkerTemplate()
    }

    private String render(String templateName) {
//        return freemarkerTemplate.processTextClassPath("/templates/", templateName + ".ftl")
        return freemarkerTemplate.processTextWithTemplateDir("W:\\text-to-web-engine\\engine\\spring-boot-app\\src\\main\\resources\\templates\\", templateName + ".ftl")
    }

    String dashboard() {
        return render("dashboard")
    }

    String settings() {
        return render("settings")
    }

    String descriptorReport() {
        return render("descriptor-report")
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
}
