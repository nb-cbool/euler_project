package com.nubootech.euler;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class EulerProjectApp {

    public static final SimpleMeterRegistry meterRegistry;

    static {
        meterRegistry = new SimpleMeterRegistry();
    }

    private EulerProjectApp() {
    }
}
