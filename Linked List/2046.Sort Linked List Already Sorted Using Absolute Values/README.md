# [2046. 给按照绝对值排序的链表排序](https://leetcode-cn.com/problems/sort-linked-list-already-sorted-using-absolute-values)

## 题目描述

<!-- 这里写题目描述 -->

None

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortLinkedList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        tmp = head
        while tmp and tmp.next:
            if tmp.next.val < 0:
                node = tmp.next
                tmp.next = tmp.next.next
                node.next = dummy.next
                dummy.next = node
            else:
                tmp = tmp.next 
        return dummy.next
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortLinkedList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.next.val < 0) {
                ListNode node = tmp.next;
                tmp.next = tmp.next.next;
                node.next = dummy.next;
                dummy.next = node;
            } else {
                tmp = tmp.next;
            }
        }
        return dummy.next;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
