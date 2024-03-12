import java.util.LinkedList;

public class HashTable {
    private LinkedList<HashTableEntry>[] table;
    private int size;

    public HashTable(int n) {
        size = n;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(String key, String value) {
        int index = getIndex(key);
        for (HashTableEntry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new HashTableEntry(key, value));
        size++;
    }

    public String get(String key) {
        int index = getIndex(key);
        for (HashTableEntry entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = getIndex(key);
        for (HashTableEntry entry : table[index]) {
            if (entry.key.equals(key)) {
                table[index].remove(entry);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getIndex(String key) {
        return Math.abs(key.hashCode() % table.length);
    }
}
