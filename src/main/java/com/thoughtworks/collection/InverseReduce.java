package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        //throw new NotImplementedException();
        int tmp = number;
        List<Integer> list = new ArrayList<>();
        tmp -= random.nextInt(3);
        while (tmp >0){
            list.add(tmp);
            tmp -= random.nextInt(3);
        }

        return list;
    }
}
