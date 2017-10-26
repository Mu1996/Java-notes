package com.muyonghui;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Long[] data = {1L,2L,3L,4L,5L,6L,7L,8L,9L,10L};
        Long[] res = new Long[data.length];
        for (int i = data.length-1; i >= 5;i--) {
            BigDecimal sum = BigDecimal.ZERO;
            for (int j = 0; j < 5; j++) {
                sum = sum.add(new BigDecimal(data[i-j]));
            }
            res[i-5] = sum.divide(new BigDecimal(5)).longValue();

        }
        for (Long count :
                res) {
            System.out.println(count);
        }
    }
}
