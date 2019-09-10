
public class TestTree {
    public static void main(String[] args) {
        Tree root = new Tree();
        root.addValue(20);
        root.addValue(10);
        root.addValue(30);
        root.addValue(5);
        root.addValue(15);
        root.addValue(25);
        root.addValue(35);
        root.addValue(12);
        root.addValue(17);
        root.addValue(3);
        root.addValue(7);
        root.addValue(23);
        root.addValue(27);
        root.addValue(33);
        root.addValue(37);
        root.addValue(32);
        root.addValue(11);
        root.addValue(13);

        root.printTree();

        int arr[] = root.getArray();
        for(int i = 0 ; i < arr.length ; i++)
        {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println(root.contains(29)?"29 содержится в дереве":"29 не содержится в дереве" );
        System.out.println(root.contains(7)?"7 содержится в дереве":"7 не содержится в дереве");
        /*if(root.deleteValue(29))
        {
            System.out.println("-------------------");
            System.out.println("   After delete");
            System.out.println("-------------------");
            root.printTree();
        }
        else
        {
            System.out.println("Нет такого элемента");
        }*/
    }


}
