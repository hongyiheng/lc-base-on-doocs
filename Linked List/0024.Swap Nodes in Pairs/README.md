# [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。</p>

<p><strong>你不能只是单纯的改变节点内部的值</strong>，而是需要实际的进行节点交换。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4]
<strong>输出：</strong>[2,1,4,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1]
<strong>输出：</strong>[1]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点的数目在范围 <code>[0, 100]</code> 内</li>
	<li><code>0 <= Node.val <= 100</code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong>你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）</p>


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
    def swapPairs(self, head: ListNode) -> ListNode:
        stk = []
        temp, cur = ListNode(), head
        head = temp
        while cur and cur.next:
            stk.append(cur)
            stk.append(cur.next)
            cur = cur.next.next
            temp.next = stk.pop()
            temp = temp.next
            temp.next = stk.pop()
            temp = temp.next
        temp.next = cur
        return head.next
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
    public ListNode swapPairs(ListNode head) {
        Deque<ListNode> stk = new ArrayDeque<>();
        ListNode temp = new ListNode();
        ListNode cur = head;
        head = temp;
        while (cur != null && cur.next != null) {
            stk.addFirst(cur);
            stk.addFirst(cur.next);
            cur = cur.next.next;
            temp.next = stk.pop();
            temp = temp.next;
            temp.next = stk.pop();
            temp = temp.next;
        }
        temp.next = cur;
        return head.next;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
