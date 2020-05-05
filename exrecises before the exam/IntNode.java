
public class IntNode {
    private int _value;
    private IntNode _next;

    public IntNode(int val, IntNode n) {
        _value = val;
        _next = n;
    }

    public int getValue() {
        return _value;
    }

    public IntNode getNext() {
        return _next;
    }

    public void setNext(IntNode node) {
        this._next = node;
    }

    public void setValue(int val) {
        this._value = val;
    }


}