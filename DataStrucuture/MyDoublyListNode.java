package DataStrucuture;

public class MyDoublyListNode {

     protected int val;
     protected MyDoublyListNode next, prev;
     /* Constructor */
     public MyDoublyListNode(){
         next = null;
         prev = null;
         val = 0;
     }
     /* Constructor */
     public MyDoublyListNode(int v, MyDoublyListNode n, MyDoublyListNode p)
     {
         val = v;
         next = n;
         prev = p;
     }
     /* Function to set link to next node */
     public void setNext(MyDoublyListNode n)
     {
         next = n;
     }
     /* Function to set link to previous node */
     public void setPrev(MyDoublyListNode p)
     {
         prev = p;
     }
     /* Funtion to get link to next node */
     public MyDoublyListNode getNext()
     {
         return next;
     }
     /* Function to get link to previous node */
     public MyDoublyListNode getPrev()
     {
         return prev;
     }
     /* Function to set data to node */
     public void setVal(int val)
     {
         this.val = val;
     }
     /* Function to get data from node */
     public int getData()
     {
         return val;
     }
 }
