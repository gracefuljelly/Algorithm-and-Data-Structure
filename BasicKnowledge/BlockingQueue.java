package BasicKnowledge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {
    private Queue<Integer> q;
    private final int limit;
    private Lock lock;
    private Condition full;
    private Condition empty;

    public BlockingQueue(int limit){
        this.q= new LinkedList<>();
        this.limit=limit;
        this.lock= new ReentrantLock();
        this.full= lock.newCondition();
        this.empty=lock.newCondition();
    }

    public void enqueue(Integer ele){
        lock.lock();
        try {
            while (q.size()==limit){
                full.await();
            }
            if(q.size()==0){
                empty.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Integer dequeue() {
        lock.lock();
        try{
            while (q.size()==0){
                empty.await();
            }
            if(q.size()==limit){
                full.signalAll();
            }
            return q.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
