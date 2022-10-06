# [503. 下一个更大元素 II](https://leetcode-cn.com/problems/next-greater-element-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> [1,2,1]
<strong>输出:</strong> [2,-1,2]
<strong>解释:</strong> 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数； 
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
</pre>

<p><strong>注意:</strong> 输入数组的长度不会超过 10000。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [-1] * n
        q = deque()
        for i, v in enumerate(nums):
            while q and q[-1][1] < v:
                ans[q.pop()[0]] = v
            q.append([i, v])
        for i, v in enumerate(nums):
            while q and q[-1][1] < v:
                ans[q.pop()[0]] = v
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peekLast()[1] < nums[i]) {
                ans[q.pollLast()[0]] = nums[i];
            }
            q.addLast(new int[]{i, nums[i]});
        }
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peekLast()[1] < nums[i]) {
                ans[q.pollLast()[0]] = nums[i];
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
