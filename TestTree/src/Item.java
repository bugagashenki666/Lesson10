public class Item {
    private Item left;
    private Item right;
    private int value;

    public Item(Item left, Item right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Item getLeft() {
        return left;
    }

    public void setLeft(Item left) {
        this.left = left;
    }

    public Item getRight() {
        return right;
    }

    public void setRight(Item right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
