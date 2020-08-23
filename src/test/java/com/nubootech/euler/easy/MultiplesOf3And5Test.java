package com.nubootech.euler.easy;

import io.micrometer.core.instrument.Timer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.nubootech.euler.EulerProjectApp.meterRegistry;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The sum of all the multiples of 3 or 5")
class MultiplesOf3And5Test {

    private static final Logger log = LoggerFactory.getLogger(MultiplesOf3And5Test.class);

    private final MultiplesOf3And5 multiplesOf3And5;
    private final Timer timer;

    MultiplesOf3And5Test() {
        multiplesOf3And5 = new MultiplesOf3And5();
        timer = meterRegistry.timer(this.getClass().getSimpleName());
    }

    @ParameterizedTest(name = "below {0} is {1}")
    @CsvSource({
            "10, 23",
            "20, 78",
            "1000, 233168"
    })
    void calculate(int limit, int expectedSum) {
        timer.record(() -> assertEquals(expectedSum, multiplesOf3And5.calculate(limit)));
    }

    @ParameterizedTest(name = "below {0} is {1}")
    @CsvSource({
            "10, 23",
            "20, 78",
            "1000, 233168"
    })
    void calculateUsingStreams(int limit, int expectedSum) {
        timer.record(() -> assertEquals(expectedSum, multiplesOf3And5.calculateUsingStreams(limit)));
    }

    @AfterEach
    void close() {
        log.info("Time elapsed: {} millisecods", timer.totalTime(MILLISECONDS));
        meterRegistry.clear();
    }
}
