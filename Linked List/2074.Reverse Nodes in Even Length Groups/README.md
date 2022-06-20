# [2074. 反转偶数长度组的节点](https://leetcode-cn.com/problems/reverse-nodes-in-even-length-groups)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个链表的头节点 <code>head</code> 。</p>

<p>链表中的节点 <strong>按顺序</strong> 划分成若干 <strong>非空</strong> 组，这些非空组的长度构成一个自然数序列（<code>1, 2, 3, 4, ...</code>）。一个组的 <strong>长度</strong> 就是组中分配到的节点数目。换句话说：</p>

<ul>
	<li>节点 <code>1</code> 分配给第一组</li>
	<li>节点 <code>2</code> 和 <code>3</code> 分配给第二组</li>
	<li>节点 <code>4</code>、<code>5</code> 和 <code>6</code> 分配给第三组，以此类推</li>
</ul>

<p>注意，最后一组的长度可能小于或者等于 <code>1 + 倒数第二组的长度</code> 。</p>

<p><strong>反转</strong> 每个 <strong>偶数</strong> 长度组中的节点，并返回修改后链表的头节点 <code>head</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/10/25/eg1.png" style="width: 699px; height: 124px;" /></p>

<pre>
<strong>输入：</strong>head = [5,2,6,3,9,1,7,3,8,4]
<strong>输出：</strong>[5,6,2,3,9,1,4,8,3,7]
<strong>解释：</strong>
- 第一组长度为 1 ，奇数，没有发生反转。
- 第二组长度为 2 ，偶数，节点反转。
- 第三组长度为 3 ，奇数，没有发生反转。
- 最后一组长度为 4 ，偶数，节点反转。
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/10/25/eg2.png" style="width: 284px; height: 114px;" /></p>

<pre>
<strong>输入：</strong>head = [1,1,0,6]
<strong>输出：</strong>[1,0,1,6]
<strong>解释：</strong>
- 第一组长度为 1 ，没有发生反转。
- 第二组长度为 2 ，节点反转。
- 最后一组长度为 1 ，没有发生反转。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/10/28/eg3.png" style="width: 139px; height: 114px;" /></p>

<pre>
<strong>输入：</strong>head = [2,1]
<strong>输出：</strong>[2,1]
<strong>解释：</strong>
- 第一组长度为 1 ，没有发生反转。
- 最后一组长度为 1 ，没有发生反转。
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>head = [8]
<strong>输出：</strong>[8]
<strong>解释：</strong>只有一个长度为 1 的组，没有发生反转。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点数目范围是 <code>[1, 10<sup>5</sup>]</code></li>
	<li><code>0 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
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
    def reverseEvenLengthGroups(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        nums = list()
        n = 0
        while head:
            n += 1
            nums.append(head.val)
            head = head.next
        new_nums = list()
        idx, cur = 0, 1
        while idx < n:
            r = min(idx + cur, n)
            if (r - idx) % 2 == 0:
                for i in range(r - 1, idx - 1, -1):
                    new_nums.append(nums[i])   
            else:
                for i in range(idx, r):
                    new_nums.append(nums[i]) 
            cur += 1
            idx = r
        dummy = ListNode()
        tmp = dummy
        for v in new_nums:
            tmp.next = ListNode(v)
            tmp = tmp.next
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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> nums = new ArrayList<>();
        int n = 0;
        while (head != null) {
            nums.add(head.val);
            n++;
            head = head.next;
        }
        int idx = 0, cur = 1;
        List<Integer> newNums = new ArrayList<>();
        while (idx < n) {
            int r = Math.min(idx + cur, n);
            if ((r - idx) % 2 == 0) {
                for (int i = r - 1; i >= idx; i--) {
                    newNums.add(nums.get(i));
                }
            } else {
                for (int i = idx; i < r; i++) {
                    newNums.add(nums.get(i));
                }
            }
            idx = r;
            cur++;
        }
        ListNode dummy = new ListNode();
        ListNode tmp = dummy;
        for (int v : newNums) {
            tmp.next = new ListNode(v);
            tmp = tmp.next;
        }
        return dummy.next;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
