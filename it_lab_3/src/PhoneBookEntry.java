public class PhoneBookEntry extends Entry {
    Contact value;
    public PhoneBookEntry(String key, Contact value) {
        super(key);
        this.value = value;
    }
}
