class MyHashMap {
    boolean[] keyArr = new boolean[1000001];
    int[] valueArr = new int[1000001];

    public MyHashMap() {
        
    }
    
    public void put(int key, int value) {
        keyArr[key] = true;
        valueArr[key] = value;
    }
    
    public int get(int key) {
        if(keyArr[key] == false)
            return -1;
        return valueArr[key];
    }
    
    public void remove(int key) {
        keyArr[key] = false;
    }
}