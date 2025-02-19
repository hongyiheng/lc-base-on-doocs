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
        mi, mx = arrays[0][0], arrays[0][-1]
        ans = 0
        for i in range(1, len(arrays)):
            ans = max(ans, abs(mx - arrays[i][0]))
            ans = max(ans, abs(arrays[i][-1] - mi))
            mx = max(mx, arrays[i][-1])
            mi = min(mi, arrays[i][0])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int mi = arrays.get(0).get(0), mx = arrays.get(0).get(arrays.get(0).size() - 1);
        int ans = 0;
        for (int i = 1; i < arrays.size(); i++) {
            int l = arrays.get(i).get(0), r = arrays.get(i).get(arrays.get(i).size() - 1);
            ans = Math.max(ans, Math.abs(mx - l));
            ans = Math.max(ans, Math.abs(r - mi));
            mx = Math.max(mx, r);
            mi = Math.min(mi, l);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
