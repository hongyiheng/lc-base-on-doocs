# [2279. 装满石头的背包的最大数量](https://leetcode-cn.com/problems/maximum-bags-with-full-capacity-of-rocks)

## 题目描述

<!-- 这里写题目描述 -->

<p>现有编号从&nbsp;<code>0</code> 到 <code>n - 1</code> 的 <code>n</code> 个背包。给你两个下标从 <strong>0</strong> 开始的整数数组 <code>capacity</code> 和 <code>rocks</code> 。第 <code>i</code> 个背包最大可以装 <code>capacity[i]</code> 块石头，当前已经装了 <code>rocks[i]</code> 块石头。另给你一个整数 <code>additionalRocks</code> ，表示<span class="text-only" data-eleid="10" style="white-space: pre;">你可以放置的额外石头数量，石头可以往 </span><strong><span class="text-only" data-eleid="11" style="white-space: pre;">任意</span></strong><span class="text-only" data-eleid="12" style="white-space: pre;"> 背包中放置。</span></p>

<p>请你将额外的石头放入一些背包中，并返回放置后装满石头的背包的 <strong>最大 </strong>数量<em>。</em></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
<strong>输出：</strong>3
<strong>解释：</strong>
1 块石头放入背包 0 ，1 块石头放入背包 1 。
每个背包中的石头总数是 [2,3,4,4] 。
背包 0 、背包 1 和 背包 2 都装满石头。
总计 3 个背包装满石头，所以返回 3 。
可以证明不存在超过 3 个背包装满石头的情况。
注意，可能存在其他放置石头的方案同样能够得到 3 这个结果。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>capacity = [10,2,2], rocks = [2,2,0], additionalRocks = 100
<strong>输出：</strong>3
<strong>解释：</strong>
8 块石头放入背包 0 ，2 块石头放入背包 2 。
每个背包中的石头总数是 [10,2,2] 。
背包 0 、背包 1 和背包 2 都装满石头。
总计 3 个背包装满石头，所以返回 3 。
可以证明不存在超过 3 个背包装满石头的情况。
注意，不必用完所有的额外石头。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == capacity.length == rocks.length</code></li>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= capacity[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= rocks[i] &lt;= capacity[i]</code></li>
	<li><code>1 &lt;= additionalRocks &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumBags(self, capacity: List[int], rocks: List[int], additionalRocks: int) -> int:
        q = [c - r for c, r in zip(capacity, rocks)]
        q.sort()
        ans = 0
        for v in q:
            if additionalRocks < v:
                break
            additionalRocks -= v
            ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length, ans = 0;
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(q);
        for (int v : q) {
            if (v > additionalRocks) {
                break;
            }
            additionalRocks -= v;
            ans++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
