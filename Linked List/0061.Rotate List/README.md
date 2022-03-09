# [61. 旋转链表](https://leetcode-cn.com/problems/rotate-list)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个链表的头节点 <code>head</code> ，旋转链表，将链表每个节点向右移动 <code>k</code><em> </em>个位置。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg" style="width: 600px; height: 254px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], k = 2
<strong>输出：</strong>[4,5,1,2,3]
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg" style="width: 472px; height: 542px;" />
<pre>
<strong>输入：</strong>head = [0,1,2], k = 4
<strong>输出：</strong>[2,0,1]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点的数目在范围 <code>[0, 500]</code> 内</li>
	<li><code>-100 <= Node.val <= 100</code></li>
	<li><code>0 <= k <= 2 * 10<sup>9</sup></code></li>
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
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None:
            return head
        deep = 0
        
        def link(root):
            nonlocal head, deep
            deep += 1
            if root.next is None:
                root.next = head
                return
            link(root.next)
        
        link(head)
        offset = deep - k % deep
        while offset > 1:
            offset -= 1
            head = head.next
        ans = head.next
        head.next = None
        return ans
    
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
    ListNode head;
    int deep;
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        deep = 0;
        this.head = head;
        link(head);
        int offset = deep - k % deep;
        while (offset-- > 1) {
            head = head.next;
        }
        ListNode ans = head.next;
        head.next = null;
        return ans;
    }

    public void link(ListNode root) {
        deep++;
        if (root.next == null) {
            root.next = head;
            return;
        }
        link(root.next);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
