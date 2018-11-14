package my.java.app;

public class SimpleHashtable {

    private StoredEmployee[] hashtable;

    public SimpleHashtable() {
        this.hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        // check through the entire array, wrap if we hit the end, stop at hashed key
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length - 1) {
                // wrap if this is the last slot in the array
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                // may have to wrap to the front of the array
                // 9%10 = 9, but 10%10 = 0 (wraps back to front)
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }
        // happens if we've probed the entire array
        if (occupied(hashedKey)) {
            System.out.println("Sorry, position is already filled at " + hashedKey);
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        // temporarily store hashtable into oldHashtable
        StoredEmployee[] oldHashtable = hashtable;
        // reset hashtable
        hashtable = new StoredEmployee[oldHashtable.length];
        // put exisiting items from oldHashtable into hashtable
        for (int i = 0; i < oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }

        return employee;
    }

    private int hashKey(String key) {
        return key.toString().length() % hashtable.length;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        // if key stored at hashed key == key we are using to retrieve employee
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            // employee was stored using key we are looking for
            return hashedKey;
        }

        // use linear probing if that's not the case
        int stopIndex = hashedKey;
        // set first probe
        if (hashedKey == hashtable.length - 1) {
            // wrap if this is the last slot in the array
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
            // wrap back to front
            hashedKey = (hashedKey + 1) % hashtable.length;

            // NOTE: We are allowed to drop out after hitting one null value
            // because the item is always stored in the next available index.
            // There is never an empty spot between hashed val of key and where 
            // we end up putting the item, due to linear probing. 
        }

        // looped entire array or found employee
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("empty");
            } else {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
    }
}