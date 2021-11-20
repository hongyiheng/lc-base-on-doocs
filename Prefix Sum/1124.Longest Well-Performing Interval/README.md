# [1124. 表现良好的最长时间段](https://leetcode-cn.com/problems/longest-well-performing-interval)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一份工作时间表&nbsp;<code>hours</code>，上面记录着某一位员工每天的工作小时数。</p>

<p>我们认为当员工一天中的工作小时数大于&nbsp;<code>8</code> 小时的时候，那么这一天就是「<strong>劳累的一天</strong>」。</p>

<p>所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格<strong> 大于</strong>「不劳累的天数」。</p>

<p>请你返回「表现良好时间段」的最大长度。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>hours = [9,9,6,0,6,6,9]
<strong>输出：</strong>3
<strong>解释：</strong>最长的表现良好时间段是 [9,9,6]。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= hours.length &lt;= 10000</code></li>
	<li><code>0 &lt;= hours[i] &lt;= 16</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def longestWPI(self, hours: List[int]) -> int:
        pre_sum, res = 0, 0
        mp = {}
        for i in range(len(hours)):
            temp = 1 if hours[i] > 8 else -1
            pre_sum += temp
            if pre_sum > 0:
                res = i + 1
            else:
                if pre_sum not in mp:
                    mp[pre_sum] = i
                if (pre_sum - 1) in mp:
                    res = max(res, i - mp[pre_sum - 1])
        return res
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int longestWPI(int[] hours) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            int temp = hours[i] > 8 ? 1 : -1;
            sum += temp;
            if (sum > 0) {
                res = i + 1;
            } else {
                if (!mp.containsKey(sum)) {
                    mp.put(sum, i);
                }
                if (mp.containsKey(sum - 1)) {
                    res = Math.max(res, i - mp.get(sum - 1));
                }
            }
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
