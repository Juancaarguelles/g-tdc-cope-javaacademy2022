package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args)
    {
        IntStream numbers = IntStream.iterate(0, i -> i + 1);
         numbers.limit(1000).filter(i -> i % 2 == 0).parallel()
                .boxed().collect(Collectors.toList());

    }
}
