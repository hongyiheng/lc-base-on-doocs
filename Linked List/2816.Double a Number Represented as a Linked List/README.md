# [2816. 翻倍以链表形式表示的数字](https://leetcode-cn.com/problems/double-a-number-represented-as-a-linked-list)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <strong>非空</strong> 链表的头节点 <code>head</code> ，表示一个不含前导零的非负数整数。</p>

<p>将链表 <strong>翻倍</strong> 后，返回头节点<em> </em><code>head</code><em> </em>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/05/28/example.png" style="width: 401px; height: 81px;" />
<pre>
<strong>输入：</strong>head = [1,8,9]
<strong>输出：</strong>[3,7,8]
<strong>解释：</strong>上图中给出的链表，表示数字 189 。返回的链表表示数字 189 * 2 = 378 。</pre>

<p><strong class="example">示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/05/28/example2.png" style="width: 401px; height: 81px;" />
<pre>
<strong>输入：</strong>head = [9,9,9]
<strong>输出：</strong>[1,9,9,8]
<strong>解释：</strong>上图中给出的链表，表示数字 999 。返回的链表表示数字 999 * 2 = 1998 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点的数目在范围 <code>[1, 10<sup>4</sup>]</code> 内</li>
	<li><font face="monospace"><code>0 &lt;= Node.val &lt;= 9</code></font></li>
	<li>生成的输入满足：链表表示一个不含前导零的数字，除了数字 <code>0</code> 本身。</li>
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
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def dfs(head):
            if not head:
                return None
            up = dfs(head.next)
            v = head.val * 2 + 1 if up else head.val * 2
            head.val = v % 10
            return v >= 10
        
        up = dfs(head)
        return ListNode(1, head) if up else head

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

    public boolean dfs(ListNode head) {
        if (head == null) {
            return false;
        }
        boolean up = dfs(head.next);
        int v = up ? head.val * 2 + 1 : head.val * 2;
        head.val = v % 10;
        return v >= 10;
    }

    public ListNode doubleIt(ListNode head) {
        boolean up = dfs(head);
        return up ? new ListNode(1, head) : head;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
