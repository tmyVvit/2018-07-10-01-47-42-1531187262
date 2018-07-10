package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int small = leftBorder > rightBorder ? rightBorder : leftBorder;
        int big = leftBorder <= rightBorder ? rightBorder : leftBorder;

        List<Integer> array = IntStream.range(small, big+1).boxed().collect(Collectors.toList());
        return array.stream().filter(n->n%2==0).reduce(0, Integer::sum);

        //throw new NotImplementedException();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        //throw new NotImplementedException();
        int small = leftBorder > rightBorder ? rightBorder : leftBorder;
        int big = leftBorder <= rightBorder ? rightBorder : leftBorder;

        List<Integer> array = IntStream.range(small, big+1).boxed().collect(Collectors.toList());
        return array.stream().filter(n->n%2!=0).reduce(0, Integer::sum);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        //throw new NotImplementedException();
        return arrayList.stream().map(x->3*x+2).reduce(0, Integer::sum);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        //throw new NotImplementedException();
        return arrayList.stream().map(x->x%2==0?x:3*x+2).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        //throw new NotImplementedException();
        return arrayList.stream().filter(x->x%2!=0).map(x->3*x+5).reduce(0, Integer::sum);
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        //throw new NotImplementedException();
        List<Integer> list =  arrayList.stream().filter(x->x%2==0).sorted().collect(Collectors.toList());
        return (list.get((list.size()-1)/2)+list.get(list.size()/2))/2;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        //throw new NotImplementedException();
        return arrayList.stream().filter(x->x%2==0).collect(Collectors.averagingInt(i->i));
        //return evenlist.stream().reduce(0, Integer::sum)/evenlist.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        //throw new NotImplementedException();
        return arrayList.stream().filter(x->x%2==0).anyMatch(x->x==specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        //throw new NotImplementedException();
        return arrayList.stream().filter(x->x%2==0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        //throw new NotImplementedException();
        List<Integer> even = arrayList.stream().filter(x->x%2==0).sorted().collect(Collectors.toList());
        List<Integer> odd = arrayList.stream().filter(x->x%2!=0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> ans = new ArrayList<>();
        even.forEach(x->ans.add(x));
        odd.forEach(x->ans.add(x));
        return ans;

    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        //throw new NotImplementedException();
        // 数组中前一个元素和后一个元素的和的3倍的数组
        //return arrayList.stream().map((x, index, array)-> 3*(x+array[index+1])).
        List<Integer> ans = arrayList.stream().skip(1).collect(Collectors.toList());
        for(int i = 0; i < ans.size(); i++) {
            ans.set(i, 3*( ans.get(i) + arrayList.get(i)));
        }
        return ans;

    }
}
