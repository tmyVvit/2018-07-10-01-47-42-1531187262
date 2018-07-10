package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
//        throw new NotImplementedException();
        return arrayList.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }

    public double getMinimum() {
//        throw new NotImplementedException();
        return arrayList.stream().reduce(Integer.MAX_VALUE, Integer::min);
    }

    public double getAverage() {
//        throw new NotImplementedException();
        return arrayList.stream().collect(Collectors.averagingInt(x->x));
    }

    public double getOrderedMedian() {
//        throw new NotImplementedException();
        List<Integer> list =  arrayList.stream().sorted().collect(Collectors.toList());
        return (list.get((list.size()-1)/2)+list.get(list.size()/2))/2.0;
    }

    public int getFirstEven() {
//        throw new NotImplementedException();
        return arrayList.stream().filter(x->x%2==0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
//        throw new NotImplementedException();
        return arrayList.indexOf(arrayList.stream().filter(x->x%2==0).findFirst().get());
    }

    public boolean isEqual(List<Integer> arrayList) {
//        throw new NotImplementedException();
        return this.arrayList.equals(arrayList);
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
//        throw new NotImplementedException();
        //List<Integer> list =  arrayList.stream().sorted().collect(Collectors.toList());
        return (arrayList.get((arrayList.size()-1)/2)+arrayList.get(arrayList.size()/2))/2.0;
    }

    public int getLastOdd() {
//        throw new NotImplementedException();
        List<Integer> list = arrayList.stream().filter(x->x%2!=0).collect(Collectors.toList());
        return list.get(list.size()-1);
    }


    public int getIndexOfLastOdd() {
//        throw new NotImplementedException();
        List<Integer> list = arrayList.stream().filter(x->x%2!=0).collect(Collectors.toList());
        return arrayList.indexOf(list.get(list.size()-1));
    }
}
