# [1721. 交换链表中的节点](https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你链表的头节点 <code>head</code> 和一个整数 <code>k</code> 。</p>

<p><strong>交换</strong> 链表正数第 <code>k</code> 个节点和倒数第 <code>k</code> 个节点的值后，返回链表的头节点（链表 <strong>从 1 开始索引</strong>）。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/10/linked1.jpg" style="width: 722px; height: 202px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], k = 2
<strong>输出：</strong>[1,4,3,2,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = [7,9,6,6,7,8,3,0,9,5], k = 5
<strong>输出：</strong>[7,9,6,6,8,7,3,0,9,5]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1], k = 1
<strong>输出：</strong>[1]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>head = [1,2], k = 1
<strong>输出：</strong>[2,1]
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>head = [1,2,3], k = 2
<strong>输出：</strong>[1,2,3]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点的数目是 <code>n</code></li>
	<li><code>1 <= k <= n <= 10<sup>5</sup></code></li>
	<li><code>0 <= Node.val <= 100</code></li>
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
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        def dfs(node, d):
            if not node:
                return 1
            h = dfs(node.next, d + 1)
            if d == k:
                ans[0] = node
            if h == k:
                ans[1] = node
            return h + 1

        ans = [None, None]
        dfs(head, 1)
        ans[0].val, ans[1].val = ans[1].val, ans[0].val
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

    ListNode[] ans = new ListNode[2];

    public int dfs(ListNode node, int d, int k) {
        if (node == null) {
            return 1;
        }
        int h = dfs(node.next, d + 1, k);
        if (d == k) {
            ans[0] = node;
        }
        if (h == k) {
            ans[1] = node;
        }
        return h + 1;
    }

    public ListNode swapNodes(ListNode head, int k) {
        dfs(head, 1, k);
        int tmp = ans[0].val;
        ans[0].val = ans[1].val;
        ans[1].val = tmp;
        return head;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
