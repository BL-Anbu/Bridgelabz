package Java_8_Features.StreamAPI;

import Java_8_Features.Functional_Interface.MyFunction;
import Java_8_Features.Functional_Interface.MyPredicate;

import java.util.*;

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

    public MyStream<T> limit(int n){
        List<T> result = new ArrayList<>();
        for(int i = 0;i< data.size() && i<n;i++){
            result.add(data.get(i));
        }
        return new MyStream<>(result);
    }

}
