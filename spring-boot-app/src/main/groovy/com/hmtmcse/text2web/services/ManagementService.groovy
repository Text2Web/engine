package com.hmtmcse.text2web.services

import com.hmtmcse.data.SeoEditData
import com.hmtmcse.te.FreemarkerTemplate
import com.hmtmcse.text2web.data.MergeDescriptor
import com.hmtmcse.texttoweb.Seo
import com.hmtmcse.texttoweb.Tag
import com.hmtmcse.texttoweb.data.ProcessRequest
import com.hmtmcse.texttoweb.data.ProcessTask
import com.hmtmcse.texttoweb.data.TopicMergeReport
import com.hmtmcse.texttoweb.processor.SeoProcessor
import com.hmtmcse.texttoweb.processor.TextToWebProcessor
import org.springframework.stereotype.Service


@Service
class ManagementService {

    private FreemarkerTemplate freemarkerTemplate

    ManagementService() {
        freemarkerTemplate = new FreemarkerTemplate()
    }

    private String render(String templateName, Map<String, Object> params = [:]) {
        return freemarkerTemplate.processTextClassPath("/templates/", templateName + ".ftl", params)
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
            e.printStackTrace()
            return e.getMessage()
        }
        return "Successfully Merge Descriptor"
    }


    String documentExport(Boolean isForce) {
        ProcessRequest processRequest = new ProcessRequest()
        TextToWebProcessor textToWebProcessor = new TextToWebProcessor(processRequest)
        List<TopicMergeReport> reports = textToWebProcessor.exportToHtml(isForce)
        return render("document-report", [reports: reports])
    }

    String exportHtml() {
        ProcessRequest processRequest = new ProcessRequest()
        processRequest.task = ProcessTask.MERGE
        try {
            TextToWebProcessor textToWebProcessor = new TextToWebProcessor(processRequest)
            textToWebProcessor.exportToHtml()
        } catch (Exception e) {
            return e.getMessage()
        }
        return "Successfully Exported Html"
    }

    String clearHtmlVcs() {
        return render("index")
    }

    String page404() {
        return render("page404")
    }

    String loadSeoSettings(String url) {
        SeoProcessor seoProcessor = new SeoProcessor()
        return render("load-seo-settings", [seo: seoProcessor.getSeoSetting(url)])
    }

    String updateSeoSettings(SeoEditData seoEditData) {
        SeoProcessor seoProcessor = new SeoProcessor()
        return seoProcessor.updateSeoSetting(seoEditData)
    }
}
