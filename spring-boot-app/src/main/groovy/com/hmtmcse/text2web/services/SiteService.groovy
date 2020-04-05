package com.hmtmcse.text2web.services

import com.hmtmcse.te.FreemarkerTemplate
import com.hmtmcse.texttoweb.Config
import com.hmtmcse.texttoweb.common.ConfigLoader
import org.springframework.stereotype.Service

@Service
class SiteService {

    private FreemarkerTemplate freemarkerTemplate
    private Config config

    SiteService() {
        freemarkerTemplate = new FreemarkerTemplate()
        config = ConfigLoader.getConfig()
    }

    private String render(String templateName, Map<String, Object> params = [:]) {
        return freemarkerTemplate.processTextWithTemplateDir(config.template, templateName + ".ftl", params)
    }

    String searchResult() {
        return render("search-result")
    }


}
