public class Tree {
    private Item root;
    private int data[];


    public void printTree() {
        if (root != null)
            printTree(root);
    }

    public void addValue(int value) {
        if (root == null) {
            this.root = new Item(null, null, value);
        } else {
            this.add(this.root, value);
        }
    }

    public boolean deleteValue(int value) {
        if (this.root == null) {
            return false;
        } else {
            return this.delete(this.root, null, value);
        }
    }

    public int length()
    {
        return  this.length(this.root, 0);
    }

    private int length(Item item, int count)
    {
        count++;
        if (item.getLeft() != null) count =  length(item.getLeft(), count);
        if (item.getRight() != null) count =  length(item.getRight(), count);
        return count;
    }

    private void add(Item current, int newValue) {
        if (current.getValue() > newValue) {
            if (current.getLeft() != null) {
                this.add(current.getLeft(), newValue);
            } else {
                Item item = new Item(null, null, newValue);
                current.setLeft(item);
            }
        } else if (current.getValue() < newValue) {
            if (current.getRight() != null) {
                this.add(current.getRight(), newValue);
            } else {
                Item item = new Item(null, null, newValue);
                current.setRight(item);
            }
        }
    }

    private boolean delete(Item current, Item parent, int deletedValue) {
        if(current == null) return false;
        if (current.getValue() == deletedValue) {
            if (parent != null) {
                Item right = current.getRight();
                Item downLeft;
                if (right != null) {
                    downLeft = this.getDownLeft(right);
                    downLeft.setLeft(current.getLeft());
                }
                if (parent.getLeft() == current) {
                    parent.setLeft(right);
                }
                else if(parent.getRight() == current) {
                    parent.setRight(right);
                }
            }
            return true;
        }
        else if(current.getValue() > deletedValue) {
            return this.delete(current.getLeft(), current, deletedValue);
        }
        else if(current.getValue() < deletedValue) {
            return this.delete(current.getRight(), current, deletedValue);
        }
        return false;
    }

    public boolean contains(int value)
    {
        return contains(this.root, value);
    }

    private boolean contains(Item item, int value)
    {
        if(item.getValue() == value) return true;
        if (item.getLeft() != null) if(contains(item.getLeft(), value)) return true;
        if (item.getRight() != null) if(contains(item.getRight(), value)) return true;
        return false;
    }
    private Item getDownLeft(Item current) {
        if (current.getLeft() != null) return getDownLeft(current.getLeft());
        else return current;
    }

    private Item getDownRight(Item current) {
        if (current.getRight() != null) return getDownRight(current.getRight());
        else return current;
    }

    private void printTree(Item item) {
        System.out.println("Here = " + item.getValue());
        System.out.println("Left = " + (item.getLeft() != null ? item.getLeft().getValue() : "null") +
                " Right = " + (item.getRight() != null ? item.getRight().getValue() : "null"));
        if (item.getLeft() != null) printTree(item.getLeft());
        if (item.getRight() != null) printTree(item.getRight());
    }
    public int[] getArray()
    {
        this.data = new int[this.length()];
        this.array(this.root, 0);
        return this.data;

    }
    private int array(Item item, int index)
    {
        this.data[index++] = item.getValue();
        if (item.getLeft() != null) index =  array(item.getLeft(), index);
        if (item.getRight() != null) index =  array(item.getRight(), index);
        return index;
    }
}
