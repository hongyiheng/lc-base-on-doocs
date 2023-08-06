# [2742. 给墙壁刷油漆](https://leetcode.cn/problems/painting-the-walls)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个长度为 <code>n</code>&nbsp;下标从 <strong>0</strong>&nbsp;开始的整数数组&nbsp;<code>cost</code> 和&nbsp;<code>time</code>&nbsp;，分别表示给&nbsp;<code>n</code>&nbsp;堵不同的墙刷油漆需要的开销和时间。你有两名油漆匠：</p>

<ul>
	<li>一位需要 <strong>付费</strong>&nbsp;的油漆匠，刷第&nbsp;<code>i</code>&nbsp;堵墙需要花费&nbsp;<code>time[i]</code>&nbsp;单位的时间，开销为&nbsp;<code>cost[i]</code>&nbsp;单位的钱。</li>
	<li>一位 <strong>免费</strong>&nbsp;的油漆匠，刷 <strong>任意</strong>&nbsp;一堵墙的时间为&nbsp;<code>1</code>&nbsp;单位，开销为&nbsp;<code>0</code>&nbsp;。但是必须在付费油漆匠&nbsp;<strong>工作</strong>&nbsp;时，免费油漆匠才会工作。</li>
</ul>

<p>请你返回刷完 <code>n</code>&nbsp;堵墙最少开销为多少。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>cost = [1,2,3,2], time = [1,2,3,2]
<b>输出：</b>3
<strong>解释：</strong>下标为 0 和 1 的墙由付费油漆匠来刷，需要 3 单位时间。同时，免费油漆匠刷下标为 2 和 3 的墙，需要 2 单位时间，开销为 0 。总开销为 1 + 2 = 3 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>cost = [2,3,4,2], time = [1,1,1,1]
<b>输出：</b>4
<b>解释：</b>下标为 0 和 3 的墙由付费油漆匠来刷，需要 2 单位时间。同时，免费油漆匠刷下标为 1 和 2 的墙，需要 2 单位时间，开销为 0 。总开销为 2 + 2 = 4 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= cost.length &lt;= 500</code></li>
	<li><code>cost.length == time.length</code></li>
	<li><code>1 &lt;= cost[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= time[i] &lt;= 500</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def paintWalls(self, cost: List[int], time: List[int]) -> int:
        @cache
        def dfs(i, t):
            nonlocal n
            if t >= n - i:
                return 0
            if i == n:
                return inf
            return min(dfs(i + 1, t + time[i]) + cost[i], dfs(i + 1, t - 1))
        
        n = len(cost)
        return dfs(0, 0)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int n;
    Map<String, Integer> f;
    int[] cost, time;

    public int dfs(int i, int t) {
        String key = i + ":" + t;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        if (t >= n - i) {
            return 0;
        }
        if (i == n) {
            return 0x3f3f3f3f;
        }
        int ans = Math.min(dfs(i + 1, t + time[i]) + cost[i], dfs(i + 1, t - 1));
        f.put(key, ans);
        return ans;
    }

    public int paintWalls(int[] cost, int[] time) {
        f = new HashMap<>();
        this.cost = cost;
        this.time = time;
        n = cost.length;
        return dfs(0, 0);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
