package problem.medium;

import java.lang.reflect.Array;

public class Solution_0003 {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        
        for(int right = 0; right < s.length(); right++) {
        	char ch = s.charAt(right);
        	
        	if(hashMap.containsKey(ch)) {
        		left = Math.max(hashMap.get(ch) + 1, left);
        	}
        	
        	hashMap.put(ch, right);
        	maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
    
    public class HashMap<K, V>{
    	Map<K, V>[] maps;
    	int hash;
    	int size;
    	
    	@SuppressWarnings("unchecked")
		public HashMap() {
    		this.hash = 50;
    		this.size = 0;
    		
    		maps = (Map<K, V>[]) Array.newInstance(Map.class, this.hash);
    		
    		for(int i = 0; i < maps.length; i++) 
    			maps[i] = new Map<K, V>();
    	}
    	
    	public boolean put(K key, V value) {
    		if(key == null)
    			return false;
    		
    		int hashCode = key.hashCode();
    		hashCode = hashCode >= 0 ? hashCode : hashCode * -1;
    		
    		boolean isAdded = maps[hashCode % this.hash].put(key, value);
    		
    		if(isAdded)
    			this.size++;
    		
    		return isAdded;
    	}
    	
    	public V get(K key) {
    		if(key == null || isEmpty())
    			return null;
    		
    		int hashCode = key.hashCode();
    		hashCode = hashCode >= 0 ? hashCode : hashCode * -1;
    		
    		return maps[hashCode % this.hash].get(key);
    	}
    	
    	public boolean delete(K key) {
    		if(key == null)
    			return false;
    		
    		int hashCode = key.hashCode();
    		hashCode = hashCode >= 0 ? hashCode : hashCode * -1;
    		
    		boolean isDelete = maps[hashCode % this.hash].delete(key);
    		
    		if(isDelete)
    			this.size--;
    		
    		return isDelete;
    	}
    	
    	public boolean containsKey(K key) {
    		if(key == null)
    			return false;
    		
    		int hashCode = key.hashCode();
    		hashCode = hashCode >= 0 ? hashCode : hashCode * -1;
    		
    		return maps[hashCode % this.hash].isContain(key);
    	}
    	
    	public boolean isEmpty() {
    		return this.size == 0 ? true : false;
    	}
    	public int size() {
    		return this.size;
    	}
    }
    
    public class Map<K, V>{
    	Entry<K, V> startEntry; // making through AVL tree.
    	int size;
    	
    	public Map () {
    		this.size = 0;
    	}
    	
    	public boolean put(K key, V value) {
    		if(key == null)
    			return false;
    		
    		if(isEmpty()) {
    			this.startEntry = new Entry<>(key, value);
    			this.size++;
    			return true;
    		} 
    		int tempSize = this.size;
    		this.startEntry = putEntry(startEntry, key, value);
    		
    		return tempSize != this.size ? true : false;
    	}
    	private Entry<K, V> putEntry(Entry<K, V> entry, K key, V value){
    		if(entry == null) {
    			this.size++;
    			return new Entry<K, V>(key, value);
    		}
    		
    		if(entry.getKey().hashCode() == key.hashCode()) {
    			entry.setValue(value);
    		} else if(entry.getKey().hashCode() < key.hashCode()) {
    			entry.setRightEntry(putEntry(entry.getRightEntry(), key, value));
    		} else {
    			entry.setLeftEntry(putEntry(entry.getLeftEntry(), key, value));
    		}
    		
    		entry.setHeight(Math.max(height(entry.getLeftEntry()), height(entry.getRightEntry())));
    		
    		int balance = height(entry.getLeftEntry()) - height(entry.getRightEntry());
    		
    		// LL
    		if(balance > 1 && entry.getLeftEntry().getKey().hashCode() > key.hashCode()) {
    			return rightRotate(entry);
    		}
    		
    		// RR
    		if(balance < -1 && entry.getRightEntry().getKey().hashCode() < key.hashCode()) {
    			return leftRotate(entry);
    		}
    		
    		// LR
    		if(balance > 1 && entry.getLeftEntry().getKey().hashCode() < key.hashCode()) {
    			entry.setLeftEntry(leftRotate(entry.getLeftEntry()));
    			return rightRotate(entry);
    		}
    		
    		// RL
    		if(balance < -1 && entry.getRightEntry().getKey().hashCode() > key.hashCode()) {
    			entry.setRightEntry(rightRotate(entry.getRightEntry()));
    			return leftRotate(entry);
    		}
    		
    		
    		return entry;
    	}
    	private Entry<K, V> leftRotate(Entry<K, V> highEntry){
    		Entry<K, V> middleEntry = highEntry.getRightEntry();
    		Entry<K, V> lowEntry = middleEntry.getLeftEntry();
    		
    		middleEntry.setLeftEntry(highEntry);
    		highEntry.setRightEntry(lowEntry);
    		
    		highEntry.setHeight(Math.max(height(highEntry.getLeftEntry()), height(highEntry.getRightEntry())));
    		middleEntry.setHeight(Math.max(height(middleEntry.getLeftEntry()), height(middleEntry.getRightEntry())));
    		
    		return middleEntry;
    	}
    	private Entry<K, V> rightRotate(Entry<K, V> highEntry){
    		Entry<K, V> middleEntry = highEntry.getLeftEntry();
    		Entry<K, V> lowEntry = middleEntry.getRightEntry();
    		
    		middleEntry.setRightEntry(highEntry);
    		highEntry.setLeftEntry(lowEntry);
    		
    		highEntry.setHeight(Math.max(height(highEntry.getLeftEntry()), height(highEntry.getRightEntry())));
    		middleEntry.setHeight(Math.max(height(middleEntry.getLeftEntry()), height(middleEntry.getRightEntry())));
    		
    		return middleEntry;
    	}
    	
    	public boolean delete(K key) {
    		if(key == null || isEmpty())
    			return false;
    		
    		int tempSize = this.size;
    		
    		startEntry = deleteEntry(startEntry, key);
    		
    		if(tempSize == this.size)
    			return false;
    		else
    			return true;
    	}
    	private Entry<K, V> deleteEntry(Entry<K, V> entry, K key) {
    		if(entry == null) {
    			return null;
    		}
    		
    		if(entry.getKey().hashCode() == key.hashCode()) {
    			this.size--;
    			return null;
    		} else if(entry.getKey().hashCode() < key.hashCode()) {
    			entry.setRightEntry(deleteEntry(entry.getRightEntry(), key));
    		} else {
    			entry.setLeftEntry(deleteEntry(entry.getLeftEntry(), key));
    		}
    		
    		entry.setHeight(Math.max(height(entry.getLeftEntry()), height(entry.getRightEntry())));
    		
    		int balance = height(entry.getLeftEntry()) - height(entry.getRightEntry());
    		
    		// LL
    		if(balance > 1 && entry.getLeftEntry().getKey().hashCode() > key.hashCode()) {
    			return rightRotate(entry);
    		}
    		
    		// RR
    		if(balance < -1 && entry.getRightEntry().getKey().hashCode() < key.hashCode()) {
    			return leftRotate(entry);
    		}
    		
    		// LR
    		if(balance > 1 && entry.getLeftEntry().getKey().hashCode() < key.hashCode()) {
    			entry.setLeftEntry(deleteEntry(entry.getLeftEntry(), key));
    			return rightRotate(entry);
    		}
    		
    		// RL
    		if(balance < -1 && entry.getRightEntry().getKey().hashCode() > key.hashCode()) {
    			entry.setRightEntry(deleteEntry(entry.getRightEntry(), key));
    			return leftRotate(entry);
    		}
    		
    		
    		return entry;
    	}
    	
    	public V get(K key) {
    		if(key == null || isEmpty())
    			return null;
    		
    		Entry<K, V> currEntry = startEntry;
    		
    		while(currEntry != null) {
    			if(currEntry.getKey().hashCode() == key.hashCode())
    				break;
    			
    			if(currEntry.getKey().hashCode() < key.hashCode())
    				currEntry = currEntry.getRightEntry();
    			else
    				currEntry = currEntry.getLeftEntry();
    		}
    		
    		if(currEntry == null)
    			return null;
    		else
    			return currEntry.getValue();
    	}
    	
    	public boolean isContain(K key) {
    		if(key == null || isEmpty())
    			return false;
    		
    		Entry<K, V> currEntry = startEntry;
    		
    		while(currEntry != null) {
    			if(currEntry.getKey().hashCode() == key.hashCode())
    				break;
    			
    			if(currEntry.getKey().hashCode() < key.hashCode())
    				currEntry = currEntry.getRightEntry();
    			else
    				currEntry = currEntry.getLeftEntry();
    		}
    		
    		if(currEntry == null)
    			return false;
    		else
    			return true;
    	}
    	
    	private int height(Entry<K, V> entry) {
    		return entry == null ? 0 : entry.getHeight();
    	}
    	public boolean isEmpty() {
    		return this.size == 0 ? true : false;
    	}
    	public int size() {
    		return this.size;
    	}
    }
    
    public class Entry<K, V>{
    	K key;
    	V value;
    	int height;
    	
    	Entry<K, V> leftEntry;
    	Entry<K, V> rightEntry;
    	
    	public Entry (){
    		key = null;
    		value = null;
    		leftEntry = null;
    		rightEntry = null;
    	}
    	
    	public Entry(K key, V value) {
    		this.key = key;
    		this.value = value;
    		this.height = 1;
    	}
    	
    	public K getKey() {
    		return this.key;
    	}
    	public boolean setKey(K key) {
    		if(key == null)
    			return false;
    		
    		this.key = key;
    		return true;
    	}
    	
    	public V getValue() {
    		return this.value;
    	}
    	public boolean setValue(V value) {
    		if(value == null)
    			return false;
    		
    		this.value = value;
    		return true;
    	}
    	
    	public void setHeight(int height) {
    		this.height = height;
    	}
    	public int getHeight() {
    		return this.height;
    	}
    	
    	public Entry<K, V> getLeftEntry(){
    		return this.leftEntry;
    	}
    	public boolean setLeftEntry(Entry<K, V> leftEntry) {
    		if(leftEntry == null)
    			return false;
    		
    		this.leftEntry = leftEntry;
    		return true;
    	}
    	
    	public Entry<K, V> getRightEntry(){
    		return this.rightEntry;
    	}
    	public boolean setRightEntry(Entry<K, V> rightEntry) {
    		if(rightEntry == null)
    			return false;
    		
    		this.rightEntry = rightEntry;
    		return true;
    	}
    }
}
