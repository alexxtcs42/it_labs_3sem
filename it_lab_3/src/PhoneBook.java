import java.util.LinkedList;

public class PhoneBook {
    private LinkedList<PhoneBookEntry>[] phoneBook;
    private int size;

    public PhoneBook(int n) {
        size = n;
        phoneBook = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            phoneBook[i] = new LinkedList<>();
        }
    }

    public void put(String number, Contact contact) {
        int index = getIndex(number);
        for (PhoneBookEntry entry : phoneBook[index]) {
            if (entry.key.equals(number)) {
                entry.value = contact;
                return;
            }
        }
        phoneBook[index].add(new PhoneBookEntry(number, contact));
        size++;
    }

    public String get(String number) {
        int index = getIndex(number);
        for (PhoneBookEntry entry : phoneBook[index]) {
            if (entry.key.equals(number)) {
                return entry.value.name + ": " + entry.value.address +
                        "; additional information:" + entry.value.additional_info;
            }
        }
        return null;
    }

    public void remove(String number) {
        int index = getIndex(number);
        for (PhoneBookEntry entry : phoneBook[index]) {
            if (entry.key.equals(number)) {
                phoneBook[index].remove(entry);
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
        return Math.abs(key.hashCode() % phoneBook.length);
    }
}
