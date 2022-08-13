# [23. 合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个链表数组，每个链表都已经按升序排列。</p>

<p>请你将所有链表合并到一个升序链表中，返回合并后的链表。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>lists = [[1,4,5],[1,3,4],[2,6]]
<strong>输出：</strong>[1,1,2,3,4,4,5,6]
<strong>解释：</strong>链表数组如下：
[
  1-&gt;4-&gt;5,
  1-&gt;3-&gt;4,
  2-&gt;6
]
将它们合并到一个有序链表中得到。
1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>lists = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>lists = [[]]
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>k == lists.length</code></li>
	<li><code>0 &lt;= k &lt;= 10^4</code></li>
	<li><code>0 &lt;= lists[i].length &lt;= 500</code></li>
	<li><code>-10^4 &lt;= lists[i][j] &lt;= 10^4</code></li>
	<li><code>lists[i]</code> 按 <strong>升序</strong> 排列</li>
	<li><code>lists[i].length</code> 的总和不超过 <code>10^4</code></li>
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
from sortedcontainers import SortedList
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode()
        tail = dummy
        q = SortedList(key=lambda x: x[0])
        for v in lists:
            if v:
                q.add([v.val, v])
        while True:
            min_root = None
            if q:
                min_root = q.pop(0)[1]
            if not min_root:
                break
            tail.next = ListNode(min_root.val)
            tail = tail.next
            min_root = min_root.next
            if min_root:
                q.add([min_root.val, min_root])
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        PriorityQueue<Pair<Integer, ListNode>> q = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        for (ListNode node : lists) {
            if (node != null) {
                q.add(new Pair<>(node.val, node));
            }
        }
        while (true) {
            ListNode minRoot = null;
            if (!q.isEmpty()) {
                minRoot = q.poll().getValue();
            }
            if (minRoot == null) {
                break;
            }
            tail.next = new ListNode(minRoot.val);
            tail = tail.next;
            minRoot = minRoot.next;
            if (minRoot != null) {
                q.add(new Pair<>(minRoot.val, minRoot));
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
