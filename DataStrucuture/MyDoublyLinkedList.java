package DataStrucuture;

/* linkedList */
    class MyDoublyLinkedList
    {
        protected MyDoublyListNode head;
        protected MyDoublyListNode tail ;
        public int size;

        /* Constructor */
        public MyDoublyLinkedList()
        {
            head = null;
            tail = null;
            size = 0;
        }
        /* Function to check if list is empty */
        public boolean isEmpty()
        {
            return head == null;
        }
        /* Function to get size of list */
        public int getSize()
        {
            return size;
        }
        /* Function to insert element at begining */
        public void insertAtHead(int val)
        {
            MyDoublyListNode cur = new MyDoublyListNode(val, null, null);
            if(head == null) {
                head = cur;
                tail = head;
            }
            else
            {
                head.setPrev(cur);
                cur.setNext(head);
                head = cur;
            }
            size++;
        }
        /* Function to insert element at end */
        public void insertAtTail(int val)
        {
            MyDoublyListNode cur = new MyDoublyListNode(val, null, null);
            if(head == null){
                head = cur;
                tail = head;
            } else{
                cur.setPrev(tail);
                tail.setNext(cur);
                tail = cur;
            }
            size++;
        }
        /* Function to insert element at position */
        public void insertAtPos(int val , int pos)
        {
            MyDoublyListNode cur = new MyDoublyListNode(val, null, null);
            if (pos == 0)
            {
                insertAtHead(val);
                return;
            }
            MyDoublyListNode ptr = head;
            for (int i = 1; i <= size; i++)
            {
                if (i == pos)
                {
                    MyDoublyListNode tmp = ptr.getNext();
                    ptr.setNext(cur);
                    cur.setPrev(ptr);
                    cur.setNext(tmp);
                    tmp.setPrev(cur);
                }
                cur = cur.getNext();
            }
            size++ ;
        }
        /* Function to delete node at position */
        public void deleteAtPos(int pos)
        {
            if (pos == 0)
            {
                if (size == 0)
                {
                    head = null;
                    tail = null;
                    size = 0;
                    return;
                }
                head = head.getNext();
                head.setPrev(null);
                size--;
                return ;
            }
            if (pos == size)
            {
                tail = tail.getPrev();
                tail.setNext(null);
                size-- ;
            }
            MyDoublyListNode cur = head.getNext();
            for (int i = 1; i <= size; i++)
            {
                if (i == pos)
                {
                    MyDoublyListNode p = cur.getPrev();
                    MyDoublyListNode n = cur.getNext();
                    p.setNext(n);
                    n.setPrev(p);
                    size-- ;
                    return;
                }
                cur = cur.getNext();
            }
        }

    }

