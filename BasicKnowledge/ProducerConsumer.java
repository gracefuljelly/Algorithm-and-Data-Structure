package BasicKnowledge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class ProducerConsumer {


    public static void main(String[] args) {
        int limit =1;
        Q q= new Q(limit);
        List<Thread> threads = new ArrayList<>();
        for(int i=0; i<100; i++){
            threads.add(new Thread(new Producer(q)));
        }
        for(int i=0; i<100; i++){
            threads.add(new Thread(new Consumer(q)));
        }
        for(Thread t:threads){
            t.start();
        }
    }
}

class Producer implements Runnable{
    Q q;
    public Producer(Q q){
        super();
        this.q=q;
    }
    @Override
    public void run(){
        try {
            q.put(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Consumer implements Runnable{
    Q q;
    public Consumer(Q q){
        super();
        this.q=q;
    }
    @Override
    public void run(){
        try {
            System.out.println(q.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Q{
    private Queue<Integer> q;
    private final int limit;
    public Q(int limit){
        this.q= new LinkedList<>();
        this.limit=limit;
    }

    public synchronized void put(Integer ele) throws InterruptedException {
        while(q.size()==limit){
            wait();
        }
        if(q.size()==0){
            notifyAll();
        }
        q.offer(ele);
    }

    public synchronized Integer take() throws InterruptedException{
        while(q.size()==0){
            wait();
        }
        if(q.size()==limit){
            notifyAll();
        }
        return q.poll();
    }
}