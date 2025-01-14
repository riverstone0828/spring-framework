package com.example.tlo.config.logging;

import com.example.tlo.config.logging.properties.FuncIdsProperties;
import com.example.tlo.config.logging.properties.TloLoggerProperties;
import com.example.tlo.config.logging.properties.UserAgentProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.tlo")
public class PropertiesConfig {

	// application.yml
	@Bean
	@ConfigurationProperties("user-agent")
	public UserAgentProperties userAgentProperties(){ return new UserAgentProperties();}

	// application-local.yml
	@Bean
	@ConfigurationProperties("logger.tlo")
	public TloLoggerProperties tslLoggerProperties() {
		return new TloLoggerProperties();
	}

	/**
	 * {@link TloLogger} bean 생성 <br/>
	 * Chat-GPT <br/>
	 * - 여기서 `destroyMethod = "destroy"`는 `TloLogger` 객체의 `destroy()` 메서드를 호출하겠다는 의미입니다. <br/>
	 * - Bean이 컨텍스트에서 제거되거나 애플리케이션이 종료될 때 호출됩니다. <br/>
	 */
	@Bean(destroyMethod = "destroy")
	public TloLogger tslLogger() { return new TloLogger(tslLoggerProperties()); }

	// application.yml
	// spring:
	//  config:
	//    import: classpath:endpoint-function-ids.yml
	// endpoint-function-ids.yml
	@Bean
	@ConfigurationProperties("tlo-sample.api")
	public FuncIdsProperties funcIdsProperties() { return new FuncIdsProperties(); }

}
