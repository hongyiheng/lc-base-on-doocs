# [2058. 找出临界点之间的最小和最大距离](https://leetcode-cn.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points)

## 题目描述

<!-- 这里写题目描述 -->

<p>链表中的 <strong>临界点</strong> 定义为一个 <strong>局部极大值点</strong> <strong>或</strong> <strong>局部极小值点 。</strong></p>

<p>如果当前节点的值 <strong>严格大于</strong> 前一个节点和后一个节点，那么这个节点就是一个<strong>&nbsp; 局部极大值点</strong> 。</p>

<p>如果当前节点的值 <strong>严格小于</strong> 前一个节点和后一个节点，那么这个节点就是一个<strong>&nbsp; 局部极小值点</strong> 。</p>

<p>注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 <strong>局部极大值点 / 极小值点</strong> 。</p>

<p>给你一个链表 <code>head</code> ，返回一个长度为 2 的数组<em> </em><code>[minDistance, maxDistance]</code> ，其中<em> </em><code>minDistance</code><em> </em>是任意两个不同临界点之间的最小距离，<code>maxDistance</code> 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 <code>[-1，-1]</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/10/13/a1.png" style="width: 148px; height: 55px;" /></p>

<pre>
<strong>输入：</strong>head = [3,1]
<strong>输出：</strong>[-1,-1]
<strong>解释：</strong>链表 [3,1] 中不存在临界点。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/10/13/a2.png" style="width: 624px; height: 46px;" /></p>

<pre>
<strong>输入：</strong>head = [5,3,1,2,5,1,2]
<strong>输出：</strong>[1,3]
<strong>解释：</strong>存在三个临界点：
- [5,3,<em><strong>1</strong></em>,2,5,1,2]：第三个节点是一个局部极小值点，因为 1 比 3 和 2 小。
- [5,3,1,2,<em><strong>5</strong></em>,1,2]：第五个节点是一个局部极大值点，因为 5 比 2 和 1 大。
- [5,3,1,2,5,<em><strong>1</strong></em>,2]：第六个节点是一个局部极小值点，因为 1 比 5 和 2 小。
第五个节点和第六个节点之间距离最小。minDistance = 6 - 5 = 1 。
第三个节点和第六个节点之间距离最大。maxDistance = 6 - 3 = 3 。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/10/14/a5.png" style="width: 624px; height: 39px;" /></p>

<pre>
<strong>输入：</strong>head = [1,3,2,2,3,2,2,2,7]
<strong>输出：</strong>[3,3]
<strong>解释：</strong>存在两个临界点：
- [1,<em><strong>3</strong></em>,2,2,3,2,2,2,7]：第二个节点是一个局部极大值点，因为 3 比 1 和 2 大。
- [1,3,2,2,<em><strong>3</strong></em>,2,2,2,7]：第五个节点是一个局部极大值点，因为 3 比 2 和 2 大。
最小和最大距离都存在于第二个节点和第五个节点之间。
因此，minDistance 和 maxDistance 是 5 - 2 = 3 。
注意，最后一个节点不算一个局部极大值点，因为它之后就没有节点了。
</pre>

<p><strong>示例 4：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/10/13/a4.png" style="width: 345px; height: 52px;" /></p>

<pre>
<strong>输入：</strong>head = [2,3,3,2]
<strong>输出：</strong>[-1,-1]
<strong>解释：</strong>链表 [2,3,3,2] 中不存在临界点。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点的数量在范围 <code>[2, 10<sup>5</sup>]</code> 内</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
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
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        f = s = 0
        f_idx = last_idx = -1
        min_dis, max_dis = float('inf'), float('-inf')
        idx = 1
        while head:
            if f == 0:
                f = head.val
            elif s == 0:
                s = head.val
            else:
                if f > s < head.val or f < s > head.val:
                    if f_idx == -1:
                        f_idx = idx - 1
                    if last_idx != -1:
                        min_dis = min(min_dis, abs(last_idx - idx + 1))
                        max_dis = max(max_dis, abs(f_idx - idx + 1))
                    last_idx = idx - 1
                f = s
                s = head.val
            head = head.next
            idx += 1
        return [-1, -1] if min_dis == float('inf') else [min_dis, max_dis]
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int f = 0, s = 0, idx = 1;
        int firstIdx = -1, lastIdx = -1;
        int minDis = Integer.MAX_VALUE, maxDis = Integer.MIN_VALUE;
        while (head != null) {
            if (f == 0) {
                f = head.val;
            } else if (s == 0) {
                s = head.val;
            } else {
                if ((f > s && s < head.val) || (f < s && s > head.val)) {
                    if (firstIdx == -1) {
                        firstIdx = idx - 1;
                    }
                    if (lastIdx != -1) {
                        minDis = Math.min(minDis, Math.abs(lastIdx - idx + 1));
                        maxDis = Math.max(maxDis, Math.abs(firstIdx - idx + 1));
                    }
                    lastIdx = idx - 1;
                }
                f = s;
                s = head.val;
            }
            head = head.next;
            idx++;
        }
        return minDis == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[]{minDis, maxDis};
    }
}
```

### **...**

```

```

<!-- tabs:end -->
