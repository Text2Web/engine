package com.hmtmcse.text2web

import com.hmtmcse.common.AsciiDocConstant
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
				.addResourceHandler("/${AsciiDocConstant.asset}/**".toString(), "/${AsciiDocConstant.asset}/**".toString(), "/${AsciiDocConstant.asset}/**".toString())
				.addResourceLocations(
						FDUtil.concatPathToURI(config.template, AsciiDocConstant.asset),
						FDUtil.concatPathToURI(config.source, AsciiDocConstant.staticFiles),
						"classpath:/${AsciiDocConstant.asset}/".toString()
				)
	}

	static void main(String[] args) {
		SpringApplication.run(Text2WebEngine, args)
	}

}
