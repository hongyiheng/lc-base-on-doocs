# [2181. 合并零之间的节点](https://leetcode-cn.com/problems/merge-nodes-in-between-zeros)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个链表的头节点 <code>head</code> ，该链表包含由 <code>0</code> 分隔开的一连串整数。链表的 <strong>开端</strong> 和 <strong>末尾</strong> 的节点都满足 <code>Node.val == 0</code> 。</p>

<p>对于每两个相邻的 <code>0</code> ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 <code>0</code> 移除，修改后的链表不应该含有任何 <code>0</code> 。</p>

<p>&nbsp;返回修改后链表的头节点 <code>head</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：<br />
<img alt="" src="https://assets.leetcode.com/uploads/2022/02/02/ex1-1.png" style="width: 600px; height: 41px;" /></strong></p>

<pre>
<strong>输入：</strong>head = [0,3,1,0,4,5,2,0]
<strong>输出：</strong>[4,11]
<strong>解释：</strong>
上图表示输入的链表。修改后的链表包含：
- 标记为绿色的节点之和：3 + 1 = 4
- 标记为红色的节点之和：4 + 5 + 2 = 11
</pre>

<p><strong>示例 2：<br />
<img alt="" src="https://assets.leetcode.com/uploads/2022/02/02/ex2-1.png" style="width: 600px; height: 41px;" /></strong></p>

<pre>
<strong>输入：</strong>head = [0,1,0,3,0,2,2,0]
<strong>输出：</strong>[1,3,4]
<strong>解释：</strong>
上图表示输入的链表。修改后的链表包含：
- 标记为绿色的节点之和：1 = 1
- 标记为红色的节点之和：3 = 3
- 标记为黄色的节点之和：2 + 2 = 4
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>列表中的节点数目在范围 <code>[3, 2 * 10<sup>5</sup>]</code> 内</li>
	<li><code>0 &lt;= Node.val &lt;= 1000</code></li>
	<li><strong>不</strong> 存在连续两个&nbsp;<code>Node.val == 0</code> 的节点</li>
	<li>链表的 <strong>开端</strong> 和 <strong>末尾</strong> 节点都满足 <code>Node.val == 0</code></li>
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
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        ans = ListNode()
        tmp = ans
        cur = 0
        while head:
            if head.val == 0 and cur:
                tmp.next = ListNode(cur)
                tmp = tmp.next
                cur = 0
            cur += head.val
            head = head.next
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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode();
        ListNode tmp = ans;
        int cur = 0;
        while (head != null) {
            if (head.val == 0 && cur > 0) {
                tmp.next = new ListNode(cur);
                tmp = tmp.next;
                cur = 0;
            }
            cur += head.val;
            head = head.next;
        }
        return ans.next;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
