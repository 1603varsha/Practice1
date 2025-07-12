class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp1 = head, temp2 = head;
        while (temp1 != null) {
            list.add(temp1.val);
            temp1 = temp1.next;
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            temp2.val = list.get(i);
            temp2 = temp2.next;
        }
        return head;
    }
}