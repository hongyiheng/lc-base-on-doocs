# [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list)



## 题目描述

<!-- 这里写题目描述 -->

<p>请判断一个链表是否为回文链表。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> 1-&gt;2
<strong>输出:</strong> false</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong> 1-&gt;2-&gt;2-&gt;1
<strong>输出:</strong> true
</pre>

<p><strong>进阶：</strong><br>
你能否用&nbsp;O(n) 时间复杂度和 O(1) 空间复杂度解决此题？</p>


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
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        q = []
        while head:
            q.append(head.val)
            head = head.next
        l, r = 0, len(q) - 1
        while l < r:
            if q[l] != q[r]:
                break
            l += 1
            r -= 1
        return l >= r
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
    public boolean isPalindrome(ListNode head) {
        List<Integer> q = new ArrayList<>();
        while (head != null) {
            q.add(head.val);
            head = head.next;
        }
        int l = 0, r = q.size() - 1;
        while (l < r) {
            if (q.get(l) != q.get(r)) {
                break;
            }
            l++;
            r--;
        }
        return l >= r;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
