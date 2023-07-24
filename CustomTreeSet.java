package Lesson4;

public class CustomTreeSet<E> {
    private CustomTreeMap<E, Object> map = new CustomTreeMap<>();
    private static final Object PRESENT = new Object();

    public boolean add(E e) {return map.put(e, PRESENT)==null;}
    public boolean remove(E e) {return map.remove(e)!=null;}
    public boolean contains(E e) {return map.get(e)!=null;}
}
