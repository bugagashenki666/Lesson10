import java.util.Scanner;

public class Controller {
    private Tree tree;
    private Scanner scanner;
    public Controller()
    {
        this.tree = new Tree();
        this.scanner = new Scanner(System.in);
    }
    public boolean Execute()
    {
        System.out.println("Введите команду: ");
        String command = this.scanner.next();
        switch (command.trim().toLowerCase()){
            case "add":
                this.tree.addValue(this.readInt());
                return true;
            case "values":
                this.tree.addValues(this.readArray());
                return true;
            case "delete":
                this.tree.deleteValue(this.readInt());
                return true;
            case "print":
                this.tree.printTree();
                return true;
            case "check":
                int n = this.readInt();
                System.out.println(this.tree.contains(n)? n + " содержится в дереве":n + "не содержится в дереве");
                return true;
            case "balancing":
                this.tree.balancing(this.readInt());
                return true;
            case "array":
                this.printArray(this.tree.getArray());
                return true;
            case "exit": case "quit":
                return false;
            case "length":
                System.out.println("Количество элементов в дереве = " + this.tree.length());
                return true;
            default:
                System.out.println("Введена неверная команда " + command);
                return true;

        }
    }

    private void printArray(int[] arr)
    {
        if(arr == null) return;
        for (int i = 0 ; i < arr.length ; i ++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    private int[] readArray()
    {
        System.out.println("Введите количество чисел:");
        int n = this.readInt();
        System.out.println("Введите " + n + " чисел: ");
        int arr[] = new int[n];
        for(int i = 0 ; i < arr.length ; i++)
        {
            arr[i] = this.readInt();
        }
        return arr;
    }
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(this.scanner.next());
            } catch (Exception e) {
                System.out.println("Пожалуйста введите целое число");
            }
        }
    }
}
