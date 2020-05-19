package com.giffgaff.nttoawelcome.config;

import com.giffgaff.nttoawelcome.metrics.MetricsService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {


    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return MeterRegistry::config;
    }
    @Bean
    public MetricsService metricsService(MeterRegistry registry){
        return new MetricsService(
                Counter
                        .builder("total_welcome_service_requests")
                        .description("total welcome service requests")
                        .register(registry)
        );
    }

}
