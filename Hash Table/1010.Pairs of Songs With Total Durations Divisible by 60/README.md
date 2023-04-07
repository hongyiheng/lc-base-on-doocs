# [1010. 总持续时间可被 60 整除的歌曲](https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60)



## 题目描述

<!-- 这里写题目描述 -->

<p>在歌曲列表中，第 <code>i</code> 首歌曲的持续时间为 <code>time[i]</code> 秒。</p>

<p>返回其总持续时间（以秒为单位）可被 <code>60</code> 整除的歌曲对的数量。形式上，我们希望索引的数字 <code>i</code> 和 <code>j</code> 满足&nbsp; <code>i &lt; j</code> 且有&nbsp;<code>(time[i] + time[j]) % 60 == 0</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[30,20,150,100,40]
<strong>输出：</strong>3
<strong>解释：</strong>这三对的总持续时间可被 60 整数：
(time[0] = 30, time[2] = 150): 总持续时间 180
(time[1] = 20, time[3] = 100): 总持续时间 120
(time[1] = 20, time[4] = 40): 总持续时间 60
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[60,60,60]
<strong>输出：</strong>3
<strong>解释：</strong>所有三对的总持续时间都是 120，可以被 60 整数。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= time.length &lt;= 60000</code></li>
	<li><code>1 &lt;= time[i] &lt;= 500</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        cnt = defaultdict(int)
        ans = 0
        for t in time:
            gap = 60 - t % 60
            ans += cnt[0 if gap == 60 else gap]
            cnt[t % 60] += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int o = 60 - t % 60;
            ans += cnt.getOrDefault(o == 60 ? 0 : o, 0);
            cnt.put(t % 60, cnt.getOrDefault(t % 60, 0) + 1);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
