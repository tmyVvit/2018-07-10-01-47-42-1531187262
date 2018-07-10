package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        //throw new NotImplementedException();
        int small = left>right?right:left;
        int big = left<=right?right:left;

        List<Integer> ans = IntStream.range(small, big+1).boxed().collect(Collectors.toList());
        return small==left?ans:ans.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        //throw new NotImplementedException();
        int small = left>right?right:left;
        int big = left<=right?right:left;

        List<Integer> ans = IntStream.range(small, big+1).boxed().filter(x->x%2==0).collect(Collectors.toList());
        return small==left?ans:ans.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
//        throw new NotImplementedException();
        return Arrays.stream(array).boxed().filter(x->x%2==0).collect(Collectors.toList());
    }


    public int popLastElment(int[] array) {
        //throw new NotImplementedException();
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        //throw new NotImplementedException();
        List<Integer> first = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> second = Arrays.stream(secondArray).boxed().collect(Collectors.toList());

        return first.stream().filter(x->second.contains(x)).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        //throw new NotImplementedException();
        List<Integer> first = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> second = Arrays.stream(secondArray).collect(Collectors.toList());
        // 将集合二中与集合一不同的元素加入集合一

        first.addAll(second.stream().filter(x->!first.contains(x)).collect(Collectors.toList()));
        return first;

    }
}
