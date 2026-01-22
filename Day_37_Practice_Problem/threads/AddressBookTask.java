package Day_37_Practice_Problem.threads;

public class AddressBookTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Performing IO operation in separate thread");
    }
}

