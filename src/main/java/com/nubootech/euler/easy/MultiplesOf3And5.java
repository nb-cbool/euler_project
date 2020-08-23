package com.nubootech.euler.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

public class MultiplesOf3And5 {

    public static final int NUMBER_1 = 3;
    public static final int NUMBER_2 = 5;
    private static final Logger log = LoggerFactory.getLogger(MultiplesOf3And5.class);

    public int calculate(int limit) {
        int sum = 0;
        for (int i = 1; i < limit; i++) {
            if (i % NUMBER_1 == 0 || i % NUMBER_2 == 0) {
                sum += i;
                log.debug("{} is multiple and the sum is {}", i, sum);
            }
        }
        log.info("The sum of all the multiples is {}", sum);
        return sum;
    }

    public int calculateUsingStreams(int limit) {
        return IntStream.range(1, limit)
                .parallel()
                .filter(e -> (e % NUMBER_1 == 0 || e % NUMBER_2 == 0))
                .sum();
    }
}