package com.giffgaff.nttoawelcome.metrics;

import io.micrometer.core.instrument.Counter;

public class MetricsService {

    private final Counter requestCounter;

    public MetricsService(Counter requestCounter){
        this.requestCounter = requestCounter;

    }

    public void incrementRequestCounter() {
        this.requestCounter.increment(1);
    }
}
