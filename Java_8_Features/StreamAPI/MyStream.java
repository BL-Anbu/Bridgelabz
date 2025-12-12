package Java_8_Features.StreamAPI;

import Java_8_Features.Functional_Interface.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;

//All Intermediate Operations Implemented
//
//You now have:
//
//filter()
//
//map()
//
//flatMap()
//
//distinct()
//
//sorted()
//
//sorted(Comparator)
//
//limit()
//
//skip()
//
//peek()
//
//mapToInt()
//
//parallel(), sequential()

public class MyStream<T> {

    private List<T> data;

    private MyStream(List<T> data) {
        this.data = data;
    }

    public static <T> MyStream<T> of(List<T> list) {
        return new MyStream<>(list);
    }

    public MyStream<T> filter(MyPredicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : data) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return new MyStream<>(result);
    }

    public <R> MyStream<R> map(MyFunction<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T item : data) {
            result.add(function.apply(item));
        }
        return new MyStream<>(result);
    }

    public <R> MyStream<R> flatMap(MyFunction<T, List<R>> function) {
        List<R> result = new ArrayList<>();
        for (T item : data) {
            List<R> returnedList = function.apply(item);
            result.addAll(returnedList);
        }
        return new MyStream<>(result);
    }

    public MyStream<T> distinct() {
        Set<T> set = new LinkedHashSet<>(data);
        return new MyStream<>(new ArrayList<>(set));
    }

    public MyStream<T> sorted() {
        List<T> result = new ArrayList<>(data);
        Collections.sort((List) result);
        return new MyStream<>(result);
    }

    public MyStream<T> sorted(Comparator<T> comparator) {
        List<T> result = new ArrayList<>(data);
        result.sort(comparator);
        return new MyStream<>(result);
    }

    public MyStream<T> limit(int n) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < data.size() && i < n; i++) {
            result.add(data.get(i));
        }
        return new MyStream<>(result);
    }

    public MyStream<T> skip(int n) {
        List<T> result = new ArrayList<>();
        for (int i = n; i < data.size(); i++) {
            result.add(data.get(i));
        }
        return new MyStream<>(result);
    }

    public MyStream<T> peek(MyConsumer<T> consumer) {
        List<T> result = new ArrayList<>();

        for (T item : data) {
            consumer.accept(item);
            result.add(item);
        }
        return new MyStream<>(result);
    }

    public MyStream<Integer> mapToInt(MyFunction<T, Integer> function) {
        List<Integer> result = new ArrayList<>();
        for (T item : data) {
            result.add(function.apply(item));
        }
        return new MyStream<>(result);
    }

    private boolean isParallel = false;

    public MyStream<T> parallel() {
        this.isParallel = true;
        return this;
    }

    public MyStream<T> sequential() {
        this.isParallel = true;
        return this;
    }

//    Terminal Operations
//    forEach()
//    collect()
//    reduce()
//    count()
//    min(), max()
//    anyMatch(), allMatch(), noneMatch()

    public void forEach(MyConsumer<T> consumer){
        for(T item : data){
            consumer.accept(item);
        }
    }

    public List<T> collect(){
        return new ArrayList<>(data);
    }

    public long count(){
        return data.size();
    }

    public T findFirst(){
        return data.isEmpty()?null:data.get(0);
    }

    public boolean anyMatch(MyPredicate<T> predicate){
        for (T item : data){
            if(predicate.test(item)) return true;
        }
        return false;
    }

    public boolean allMatch(MyPredicate<T> predicate){
        for(T item : data){
            if(!predicate.test(item)) return false;
        }
        return true;
    }

    public boolean noneMatch(MyPredicate<T> predicate){
        for(T item : data){
            if(predicate.test(item)) return false;
        }
        return true;
    }

    public T reduce(T identity, MyBinaryOperator operator){
        T result = identity;
        for(T item : data){
            result = (T) operator.apply(result, item);
        }
        return result;
    }
    public T min(Comparator<T> comparator) {
        if (data.isEmpty()) return null;

        T min = data.get(0);
        for (T item : data) {
            if (comparator.compare(item, min) < 0) {
                min = item;
            }
        }
        return min;
    }
    public T max(Comparator<T> comparator) {
        if (data.isEmpty()) return null;

        T max = data.get(0);
        for (T item : data) {
            if (comparator.compare(item, max) > 0) {
                max = item;
            }
        }
        return max;
    }

}
