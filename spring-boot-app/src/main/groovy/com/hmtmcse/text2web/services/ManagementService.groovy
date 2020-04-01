package com.hmtmcse.text2web.services

import com.hmtmcse.te.FreemarkerTemplate
import com.hmtmcse.text2web.data.MergeDescriptor
import com.hmtmcse.texttoweb.data.ProcessRequest
import com.hmtmcse.texttoweb.data.ProcessTask
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
        return freemarkerTemplate.processTextWithTemplateDir("D:\\touhid\\engine\\spring-boot-app\\src\\main\\resources\\templates\\", templateName + ".ftl", params)
    }

    String dashboard() {
        return render("dashboard")
    }

    String settings() {
        return render("settings")
    }

    String descriptorReport(String flash = null) {
        ProcessRequest processRequest = new ProcessRequest()
        TextToWebProcessor textToWebProcessor = new TextToWebProcessor(processRequest)
        return render("descriptor-report", [reports: textToWebProcessor.manipulateDescriptorOutline(), flash: flash])
    }

    String mergeDescriptor(MergeDescriptor mergeDescriptor) {
        ProcessRequest processRequest = new ProcessRequest()
        processRequest.task = ProcessTask.MERGE
        processRequest.mergeData = mergeDescriptor.mergeData ?: [:]
        try {
            TextToWebProcessor textToWebProcessor = new TextToWebProcessor(processRequest)
            textToWebProcessor.manipulateDescriptorOutline()
            if (!processRequest.mergeData || processRequest.mergeData.count { key, value -> value.isMerge } == 0) {
                return "Nothing for update!."
            }
        } catch (Exception e) {
            return e.getMessage()
        }
        return "Successfully Merge Descriptor"
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
