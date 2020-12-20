package com.xinzodl.code.java.codeward;

import java.util.stream.IntStream;

public class CW1_Multiples3And5 {
    public int solution(int number) {
        IntStream intStream = IntStream.range(1, number);
        IntStream filteredIntStream = intStream.filter( x -> x % 3 == 0 || x % 5 == 0);
        int result = filteredIntStream.reduce(Integer::sum).orElse(-1);
        return result;

        
    }

}
