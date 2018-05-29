package DataStrucuture;

public class MySinglyListNode {
    protected int value;
    protected MySinglyListNode next;
    /*  Constructor  */
    public MySinglyListNode()
    {
        next = null;
        value = 0;
    }
    /*  Constructor  */
    public MySinglyListNode(int v,MySinglyListNode n)
    {
        value = v;
        next = n;
    }
    /*  Function to set link to next Node  */
    public void setNext(MySinglyListNode n)
    {
        next = n;
    }
    /*  Function to set data to current Node  */
    public void setValue(int v)
    {
        value = v;
    }
    /*  Function to get link to next node  */
    public MySinglyListNode getNext()
    {
        return next;
    }
    /*  Function to get data from current Node  */
    public int getValue()
    {
        return value;
    }
}
