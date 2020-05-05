
public class IntList {
    private IntNode _head;

    public IntList() {
        _head = null;
    }

    public IntList(IntNode h) {
        _head = h;
    }


    public static void swap(IntNode p, IntNode q) {
        int tmp = p.getValue();
        p.setValue(q.getValue());
        q.setValue(tmp);
    }

    /*
    this method will remove duplicates from the list
     */
    public void what() {
        IntNode ptr1 = null, ptr2 = null;
        ptr1 = _head;

        while (ptr1 != null && ptr1.getNext() != null) {
            ptr2 = ptr1;

            while (ptr2.getNext() != null) {
                if (ptr1.getValue() == ptr2.getNext().getValue())
                    ptr2.setNext(ptr2.getNext().getNext());
                else
                    ptr2 = ptr2.getNext();
            }
            ptr1 = ptr1.getNext();
        }
    }

    public IntList what1(int k) {
        IntNode x, y, prevX = null, prevY = _head;
        IntNode curr = _head;
        for (int i = 1; i < k && curr != null; i++) {
            prevX = curr;
            curr = curr.getNext();
        }
        x = curr;
        if (curr == null)
            return null;
        IntNode ptr = _head;
        while (curr.getNext() != null) {
            prevY = ptr;
            ptr = ptr.getNext();
            curr = curr.getNext();
        }
        y = ptr;
        if (x.getNext() == y) {
            x.setNext(y.getNext());
            y.setNext(x);
            prevX.setNext(y);
        } else if (y.getNext() == x) {
            y.setNext(x.getNext());
            x.setNext(y);
            prevY.setNext(x);
        } else if (x == _head) {
            _head = y;
            y.setNext(x.getNext());
            prevY.setNext(x);
            x.setNext(null);
        } else if (y == _head) {
            _head = x;
            x.setNext(y.getNext());
            prevX.setNext(y);
            y.setNext(null);
        } else {
            ptr = y.getNext();
            y.setNext(x.getNext());
            x.setNext(ptr);
            prevX.setNext(y);
            prevY.setNext(x);
        }

        return new IntList(_head);
    }

    public int secret() {
        IntNode p = _head, q = _head;
        int i = 0, j = 0;

        while (p != null) {
            if (p.getValue() != 0) {
                swap(p, q);
                q = q.getNext();
                j++;
            }
            p = p.getNext();
            i++;
        }
        return i - j;
    }


    public String toString(IntNode head) {
        IntNode ptr = head;
        String s = "";
        while (ptr != null) {
            s += ptr.getValue() + ",";
            ptr = ptr.getNext();
        }
        return s;
    }

    public static void main(String[] args) {
        IntNode list = new IntNode(
                2, new IntNode(
                17, new IntNode(
                13, new IntNode(
                7, new IntNode(
                10, new IntNode(
                5, new IntNode(
                4, new IntNode(
                20,null))))))));
        IntList l = new IntList(list);
        System.out.println(l.toString(list));
        l.what1(3);
        System.out.println(l.toString(list));


    }
}