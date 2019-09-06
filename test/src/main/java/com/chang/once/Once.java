package com.chang.once;

import java.util.ArrayList;
import java.util.List;

public class Once {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.forEach(x -> {
            System.out.println(x);
        });
    }

}

