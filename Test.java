package Lesson4;

public class Test {
    public static void main(String[] args) {
        CustomTreeSet<Integer> cts = new CustomTreeSet<>();
        cts.add(1);
        System.out.println(cts.contains(1));
        cts.remove(1);
        System.out.println(cts.contains(1));
    }
}
