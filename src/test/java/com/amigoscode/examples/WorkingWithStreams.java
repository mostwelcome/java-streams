package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreams {

    @Test
    void steams() {
        List<String> names = List.of("Tua", "Swagata", "Krish");
        Stream<String> namesStream = names.stream();
        namesStream.limit(2).map(null).sorted(null).dropWhile(null).collect(Collectors.toList());

        //Stream from an array
        String[] arrayStream = {};
        Arrays.stream(arrayStream).distinct().collect(Collectors.toList());

    }
}
