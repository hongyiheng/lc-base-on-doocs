# [143. 重排链表](https://leetcode-cn.com/problems/reorder-list)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个单链表 <code>L</code><em> </em>的头节点 <code>head</code> ，单链表 <code>L</code> 表示为：</p>

<p><code> L<sub>0 </sub>→ L<sub>1 </sub>→ … → L<sub>n-1 </sub>→ L<sub>n </sub></code><br />
请将其重新排列后变为：</p>

<p><code>L<sub>0 </sub>→ L<sub>n </sub>→ L<sub>1 </sub>→ L<sub>n-1 </sub>→ L<sub>2 </sub>→ L<sub>n-2 </sub>→ …</code></p>

<p>不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626420311-PkUiGI-image.png" style="width: 240px; " /></p>

<pre>
<strong>输入: </strong>head = [1,2,3,4]
<strong>输出: </strong>[1,4,2,3]</pre>

<p><strong>示例 2:</strong></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626420320-YUiulT-image.png" style="width: 320px; " /></p>

<pre>
<strong>输入: </strong>head = [1,2,3,4,5]
<strong>输出: </strong>[1,5,2,4,3]</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表的长度范围为 <code>[1, 5 * 10<sup>4</sup>]</code></li>
	<li><code>1 <= node.val <= 1000</code></li>
</ul>


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
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        cur = slow.next
        slow.next = pre = None
        while cur:
            tmp = cur.next
            cur.next = pre
            pre, cur = cur, tmp
            
        cur = head
        while pre:
            tmp = pre.next
            pre.next = cur.next
            cur.next = pre
            cur, pre = pre.next, tmp
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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        } 
        cur = head;
        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = cur.next;
            cur.next = pre;
            cur = pre.next;
            pre = tmp;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
