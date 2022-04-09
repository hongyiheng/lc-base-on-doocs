# [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list)



## 题目描述

<!-- 这里写题目描述 -->

给你单链表的头节点 <code>head</code> ，请你反转链表，并返回反转后的链表。
<div class="original__bRMd">
<div>
<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4,5]
<strong>输出：</strong>[5,4,3,2,1]
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 182px; height: 222px;" />
<pre>
<strong>输入：</strong>head = [1,2]
<strong>输出：</strong>[2,1]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = []
<strong>输出：</strong>[]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点的数目范围是 <code>[0, 5000]</code></li>
	<li><code>-5000 <= Node.val <= 5000</code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong>链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？</p>
</div>
</div>


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
    def reverseList(self, head: ListNode) -> ListNode:
        node = ListNode()
        ans = node
        
        def dfs(head):
            nonlocal node
            if not head:
                return
            if head.next:
                dfs(head.next)
            node.next = ListNode(head.val)
            node = node.next
        
        dfs(head)
        return ans.next
            
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
    ListNode node;

    public ListNode reverseList(ListNode head) {
        node = new ListNode();
        ListNode ans = node;
        dfs(head);
        return ans.next;
    }

    public void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        if (head.next != null) {
            dfs(head.next);
        }
        node.next = new ListNode(head.val);
        node = node.next;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
