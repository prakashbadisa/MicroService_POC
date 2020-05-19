package com.giffgaff.nttoawelcome.web.resource;

import com.giffgaff.nttoawelcome.metrics.MetricsService;
import com.giffgaff.nttoawelcome.model.WelcomeMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeResource {

    private static final String template = "Welcome %s !!!";

    private  final MetricsService metricsService;

    public WelcomeResource(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @GetMapping("/welcome/{username}")
    public WelcomeMessage welcome(@PathVariable String username) {
        this.metricsService.incrementRequestCounter();
        return new WelcomeMessage(String.format(template, username));
    }
}
