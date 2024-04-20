import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private Integer value;
    private Lock lock;

    public Counter(Integer value, ReentrantLock lock){
        this.value = value;
        this.lock = lock;

    }


    public  void increment(String threadName){
        this.lock.lock();
        System.out.println(threadName + "entrou no método increment");
        this.value++;
        System.out.println(threadName + "saiu no método increment");
        this.lock.unlock();
    }

    public Integer getValue() {
        return this.value;
    }


}