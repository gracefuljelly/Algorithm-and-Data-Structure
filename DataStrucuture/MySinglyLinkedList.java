package DataStrucuture;

public class MySinglyLinkedList {

    /* Class linkedList */



        protected MySinglyListNode head;
        protected MySinglyListNode tail ;
        public int size ;

        /*  Constructor  */
        public MySinglyLinkedList()
        {
            head = null;
            tail = null;
            size = 0;
        }
        /*  Function to check if list is empty  */
        public boolean isEmpty()
        {
            return head == null;
        }
        /*  Function to get size of list  */
        public int getSize()
        {
            return size;
        }
        /*  Function to insert an element at begining  */
        public void insertAtHead(int val)
        {
            MySinglyListNode cur = new MySinglyListNode(val, null);
            size++ ;
            if(head == null)
            {
                head = cur;
                tail = head;
            }
            else
            {
                cur.setNext(head);
                head = cur;
            }
        }
        /*  Function to insert an element at end  */
        public void insertAtTail(int val)
        {
            MySinglyListNode cur = new MySinglyListNode(val,null);
            size++ ;
            if(head == null)
            {
                head = cur;
                tail = head;
            }
            else
            {
                tail.setNext(cur);
                tail = cur;
            }
        }
        /*  Function to insert an element at position  */
        public void insertAtPos(int val , int pos)
        {
            MySinglyListNode cur = new MySinglyListNode(val, null);
            MySinglyListNode  ptr = head;
            pos = pos - 1 ;
            for (int i = 1; i < size; i++)
            {
                if (i == pos)
                {
                    MySinglyListNode tmp = ptr.getNext() ;
                    ptr.setNext(cur);
                    cur.setNext(tmp);
                    break;
                }
                ptr = ptr.getNext();
            }
            size++ ;
        }
        /*  Function to delete an element at position  */
        public void deleteAtPos(int pos)
        {
            if (pos == 1)
            {
                head = head.getNext();
                size--;
                return ;
            }
            if (pos == size)
            {
                MySinglyListNode s = head;
                MySinglyListNode t = head;
                while (s != tail)
                {
                    t = s;
                    s = s.getNext();
                }
                tail = t;
                tail.setNext(null);
                size --;
                return;
            }
            MySinglyListNode ptr = head;
            pos = pos - 1 ;
            for (int i = 1; i < size - 1; i++)
            {
                if (i == pos)
                {
                    MySinglyListNode tmp = ptr.getNext();
                    tmp = tmp.getNext();
                    ptr.setNext(tmp);
                    break;
                }
                ptr = ptr.getNext();
            }
            size-- ;
        }
        /*  Function to display elements  */
        public void display()
        {
            System.out.print("\nSingly Linked List = ");
            if (size == 0)
            {
                System.out.print("empty\n");
                return;
            }
            if (head.getNext() == null)
            {
                System.out.println(head.getValue() );
                return;
            }
            MySinglyListNode ptr = head;
            System.out.print(head.getValue()+ "->");
            ptr = head.getNext();
            while (ptr.getNext() != null)
            {
                System.out.print(ptr.getValue()+ "->");
                ptr = ptr.getNext();
            }
            System.out.print(ptr.getValue()+ "\n");
        }

}

