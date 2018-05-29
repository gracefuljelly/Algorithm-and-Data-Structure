package laioffer;
import java.util.*;
public class deepcopylinkedlist {

    public RandomListNode copy(RandomListNode head){
        if(head == null){
            return null;
        }

        RandomListNode newhead = new RandomListNode(head.value);
        RandomListNode cur=newhead;

        Map<RandomListNode,RandomListNode> lookup = new HashMap<>();
        lookup.put(head, newhead);
        while(head != null){
            if(head.next !=null){
                if(!lookup.containsKey(head.next)){
                    lookup.put(head.next,new RandomListNode(head.next.value));
                }
                cur.next=lookup.get(head.next);
            }
            if(head.random !=null){
                if(!lookup.containsKey(head.random)){
                    lookup.put(head.random,new RandomListNode(head.random.value));
                }
                cur.random = lookup.get(head.random);
            }
            head =head.next;
            cur= cur.next;
        }
        return newhead;
    }

}
