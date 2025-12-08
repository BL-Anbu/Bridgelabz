package Day_15_Practice_Problem_HT_BST;

public class HashTableMain {

    public static void main(String[] args) {

        HashTable newHT = new HashTable();
        newHT.set("anbu", 169);
        newHT.set("vinoth", 180);
        newHT.set("prabhu", 175);
        newHT.printTable();

        System.out.println("Get By Key");
        System.out.println(newHT.get("vinoth"));

        System.out.println("All Keys : ");
        for (var a : newHT.keys()) {
            System.out.println(a);
        }
    }
}