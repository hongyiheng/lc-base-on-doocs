# [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个链表，每 <em>k </em>个节点一组进行翻转，请你返回翻转后的链表。</p>

<p><em>k </em>是一个正整数，它的值小于或等于链表的长度。</p>

<p>如果节点总数不是 <em>k </em>的整数倍，那么请将最后剩余的节点保持原有顺序。</p>

<p><strong>进阶：</strong></p>

<ul>
	<li>你可以设计一个只使用常数额外空间的算法来解决此问题吗？</li>
	<li><strong>你不能只是单纯的改变节点内部的值</strong>，而是需要实际进行节点交换。</li>
</ul>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], k = 2
<strong>输出：</strong>[2,1,4,3,5]
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], k = 3
<strong>输出：</strong>[3,2,1,4,5]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1,2,3,4,5], k = 1
<strong>输出：</strong>[1,2,3,4,5]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>head = [1], k = 1
<strong>输出：</strong>[1]
</pre>

<ul>
</ul>

<p><strong>提示：</strong></p>

<ul>
	<li>列表中节点的数量在范围 <code>sz</code> 内</li>
	<li><code>1 <= sz <= 5000</code></li>
	<li><code>0 <= Node.val <= 1000</code></li>
	<li><code>1 <= k <= sz</code></li>
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
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if k == 1:
            return head
        tail, tmp = head, head
        vals = []
        cnt = 0
        while tail:
            vals.append(tail.val)
            cnt += 1
            if cnt == k:
                while vals:
                    tmp.val = vals.pop()
                    tmp = tmp.next
                cnt = 0
                tmp = tail.next
            tail = tail.next
        return head
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode tail = head, tmp = head;
        Deque<Integer> vals = new ArrayDeque<>();
        int cnt = 0;
        while (tail != null) {
            vals.addLast(tail.val);
            if (++cnt == k) {
                while (!vals.isEmpty()) {
                    tmp.val = vals.pollLast();
                    tmp = tmp.next;
                }
                cnt = 0;
                tmp = tail.next;
            }
            tail = tail.next;
        }
        return head;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
