class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max_right = -1;
        for(int i = n-1; i>=0; i--){
            int temp = arr[i];
            arr[i] = max_right;
            max_right = Math.max(max_right,temp);
        }
        return arr;
    }
}