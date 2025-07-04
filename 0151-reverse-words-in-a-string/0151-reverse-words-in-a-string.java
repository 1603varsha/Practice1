class Solution {
    public String reverseWords(String s) {
        String[] arr=s.trim().split("\\s+");
        String res="";
        for(int i=arr.length-1;i>=0;i--){
            res+=arr[i];
            if(i!=0)
                res+=" ";
        }
        return res;
    }
}