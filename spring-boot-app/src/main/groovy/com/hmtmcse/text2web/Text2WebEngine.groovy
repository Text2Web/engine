package com.hmtmcse.text2web

import com.hmtmcse.fileutil.fd.FDUtil
import com.hmtmcse.texttoweb.Config
import com.hmtmcse.texttoweb.common.ConfigLoader
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class Text2WebEngine  implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Config config = ConfigLoader.getConfig()
		registry
				.addResourceHandler("/asset/**", "/static-files/**", "/internal-asset/**")
				.addResourceLocations(
						FDUtil.concatPathToURI(config.template, "asset"),
						FDUtil.concatPathToURI(config.source, "static-files"),
						"classpath:/internal-asset/"
				)
	}

	static void main(String[] args) {
		SpringApplication.run(Text2WebEngine, args)
	}

}
