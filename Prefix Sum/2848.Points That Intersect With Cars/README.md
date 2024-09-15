# [2848. 与车相交的点](https://leetcode-cn.com/problems/points-that-intersect-with-cars)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong> 开始的二维整数数组 <code>nums</code> 表示汽车停放在数轴上的坐标。对于任意下标 <code>i</code>，<code>nums[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> ，其中 <code>start<sub>i</sub></code> 是第 <code>i</code> 辆车的起点，<code>end<sub>i</sub></code> 是第 <code>i</code> 辆车的终点。</p>

<p>返回数轴上被车 <strong>任意部分</strong> 覆盖的整数点的数目。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [[3,6],[1,5],[4,7]]
<strong>输出：</strong>7
<strong>解释：</strong>从 1 到 7 的所有点都至少与一辆车相交，因此答案为 7 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [[1,3],[5,8]]
<strong>输出：</strong>7
<strong>解释：</strong>1、2、3、5、6、7、8 共计 7 个点满足至少与一辆车相交，因此答案为 7 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>nums[i].length == 2</code></li>
	<li><code><font face="monospace">1 &lt;= start<sub>i</sub>&nbsp;&lt;= end<sub>i</sub>&nbsp;&lt;= 100</font></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numberOfPoints(self, nums: List[List[int]]) -> int:
        q = [0] * 110
        for u, v in nums:
            q[u] += 1
            q[v + 1] -= 1
        ans = s = 0
        for v in q:
            s += v
            if s:
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] q = new int[110];
        for (List<Integer> e : nums) {
            q[e.get(0)]++;
            q[e.get(1) + 1]--;
        }
        int ans = 0, s = 0;
        for (int v : q) {
            s += v;
            if (s > 0) {
                ans++;
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
