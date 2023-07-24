package Lesson4;

public class CustomTreeMap<K, V> {
    private int size = 0;
    private Node root = null;

    class Node {
        private Node right;
        private Node left;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            right = null;
            left = null;
        }
    }

    public int getSize() {
        return size;
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException();
        }
        if (root == null) {
            root = new Node(key, value);
            size++;
            return null;
        }

        return putHelper(root, key, value);
    }

    private V putHelper(Node node, K key, V value) {
        Comparable<? super K> k = (Comparable<? super K>) key;
        int cmp = k.compareTo(node.key);

        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node(key, value);
                size++;
                return null;
            } else {
                return putHelper(node.left, key, value);
            }
        }
        if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node(key, value);
                size++;
                return null;
            } else {
                return putHelper(node.right, key, value);
            }
        }
        V oldValue = node.value;
        node.value = value;
        return oldValue;
    }

    public V get(K key) {
        if (root == null)
            return null;
        Node node = findNode(root, key);
        return node == null ? null : node.value;
    }

    private Node findNode(Node current, K key) {
        Comparable<? super K> k = (Comparable<? super K>) key;
        int cmp = k.compareTo(current.key);

        if (cmp < 0) {
            if (current.left == null)
                return null;
            return findNode(current.left, key);
        }
        if (cmp > 0) {
            if (current.right == null)
                return null;
            return findNode(current.right, key);
        }
        return current;
    }

    private Node delRecursive(K key) {
        Node node = findNode(root, key);

        if (node.left == null && node.right == null) {
            node = null;
            size--;
            return null;
        }
        if (node.left == null) {
            node = node.right;
            size--;
            return node;
        }
        if (node.right == null) {
            node = node.left;
            size--;
            return node;
        }
        node = findSmallestValue(node.right);
        size--;
        return node;
    }

    public V remove(K key) {
        V value = get(key);
        if (value == null)
            return null;
        root = delRecursive(key);
        return value;
    }

    private Node findSmallestValue(Node root) {
        return root.left == null ? root : findSmallestValue(root.left);
    }
}