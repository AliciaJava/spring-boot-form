package com.springboot.form.app;

import com.springboot.form.app.interceptors.TiempoTranscurridoInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {
	
	private final TiempoTranscurridoInterceptor tiempoTranscurridoInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form/**");
	}

}
