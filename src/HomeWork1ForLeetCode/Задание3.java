package HomeWork1ForLeetCode;

class Задание3 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        if(node==null){
            return node;
        }
        while(node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
            }else{
                node =node.next;
            }
        }
        return head;
    }
}