package Java_8_Features.Functional_Interface;

@FunctionalInterface
public interface MyCallable<V> {
    V call() throws Exception;
}

//Interface	    Input	    Return Type	    Throws Exception?
//Predicate<T>	    T	    boolean	        No
//Function<T,R>	    T	    R	            No
//Consumer<T>	    T	    void	        No
//Supplier<R>	    None	R	            No
//Runnable	        None	void	        No
//Callable<V>	    None	V	            Yes