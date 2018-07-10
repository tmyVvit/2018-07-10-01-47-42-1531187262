package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        //throw new NotImplementedException();
        List<Integer> ans = new ArrayList<>();
        for(Integer[] list : array){
            for(Integer integer : list){
                ans.add(integer);
            }
        }
        return ans;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        //throw new NotImplementedException();
        List<Integer> list = transformToOneDimesional();
        return list.stream().distinct().collect(Collectors.toList());
    }
}
