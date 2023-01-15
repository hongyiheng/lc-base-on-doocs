# [1669. 合并两个链表](https://leetcode-cn.com/problems/merge-in-between-linked-lists)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个链表 <code>list1</code> 和 <code>list2</code> ，它们包含的元素分别为 <code>n</code> 个和 <code>m</code> 个。</p>

<p>请你将 <code>list1</code> 中第 <code>a</code> 个节点到第 <code>b</code> 个节点删除，并将<code>list2</code> 接在被删除节点的位置。</p>

<p>下图中蓝色边和节点展示了操作后的结果：</p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/28/fig1.png" style="height: 130px; width: 504px;" />
<p>请你返回结果链表的头指针。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/28/merge_linked_list_ex1.png" style="width: 406px; height: 140px;" /></p>

<pre>
<b>输入：</b>list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
<b>输出：</b>[0,1,2,1000000,1000001,1000002,5]
<b>解释：</b>我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/28/merge_linked_list_ex2.png" style="width: 463px; height: 140px;" />
<pre>
<b>输入：</b>list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
<b>输出：</b>[0,1,1000000,1000001,1000002,1000003,1000004,6]
<b>解释：</b>上图中蓝色的边和节点为答案链表。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 <= list1.length <= 10<sup>4</sup></code></li>
	<li><code>1 <= a <= b < list1.length - 1</code></li>
	<li><code>1 <= list2.length <= 10<sup>4</sup></code></li>
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
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        pre = list1
        for i in range(a - 1):
            pre = pre.next
        tail = list1
        for i in range(b + 1):
            tail = tail.next
        pre.next = list2
        while list2.next:
            list2 = list2.next
        list2.next = tail
        return list1
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre = list1;
        for (int i = 0; i < a - 1; i++) {
            pre = pre.next;
        }
        ListNode tail = list1;
        for (int i = 0; i < b + 1; i++) {
            tail = tail.next;
        }
        pre.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = tail;
        return list1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
