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
        return freemarkerTemplate.processTextClassPath("/templates/", templateName + ".ftl")
    }

    String index() {
        return render("index")
    }

    String configure() {
        return render("index")
    }

    String descriptorReport() {
        return render("index")
    }

    String documentReport() {
        return render("index")
    }

    String exportHtml() {
        return render("index")
    }

    String clearHtmlVcs() {
        return render("index")
    }
}
