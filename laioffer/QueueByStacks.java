package laioffer;
import java.util.*;

public class QueueByStacks {
    Deque<Integer> inStack= new LinkedList<>() ;
    Deque<Integer> outStack = new LinkedList<>();

    QueueByStacks(Deque<Integer> inStack, Deque<Integer> outStack){
        this.inStack=inStack;
        this.outStack=outStack;
    }

    
}
