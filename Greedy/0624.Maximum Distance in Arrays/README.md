# [624. 数组列表中的最大距离](https://leetcode-cn.com/problems/maximum-distance-in-arrays)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定&nbsp;<code>m</code>&nbsp;个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数&nbsp;<code>a</code>&nbsp;和&nbsp;<code>b</code>&nbsp;之间的距离定义为它们差的绝对值&nbsp;<code>|a-b|</code>&nbsp;。你的任务就是去找到最大距离</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong> 
[[1,2,3],
 [4,5],
 [1,2,3]]
<strong>输出：</strong> 4
<strong>解释：</strong>
一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
</pre>

<p>&nbsp;</p>

<p><strong>注意：</strong></p>

<ol>
	<li>每个给定数组至少会有 1 个数字。列表中至少有两个非空数组。</li>
	<li><strong>所有</strong>&nbsp;<code>m</code>&nbsp;个数组中的数字总数目在范围 [2, 10000] 内。</li>
	<li><code>m</code>&nbsp;个数组中所有整数的范围在 [-10000, 10000] 内。</li>
</ol>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        min_, max_ = float('inf'), float('-inf')
        ans = 0
        for i, r in enumerate(arrays):
            if i > 0:
                ans = max(ans, abs(r[0] - max_))
                ans = max(ans, abs(r[-1] - min_))
            min_ = min(min_, r[0])
            max_ = max(max_, r[-1])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> cur = arrays.get(i);
            if (i > 0) {
                ans = Math.max(ans, Math.abs(cur.get(cur.size() - 1) - min));
                ans = Math.max(ans, Math.abs(max - cur.get(0)));
            }
            max = Math.max(max, cur.get(cur.size() - 1));
            min = Math.min(min, cur.get(0));
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
