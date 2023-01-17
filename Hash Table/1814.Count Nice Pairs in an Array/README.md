# [1814. 统计一个数组中好对子的数目](https://leetcode-cn.com/problems/count-nice-pairs-in-an-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个数组 <code>nums</code> ，数组中只包含非负整数。定义 <code>rev(x)</code> 的值为将整数 <code>x</code> 各个数字位反转得到的结果。比方说 <code>rev(123) = 321</code> ， <code>rev(120) = 21</code> 。我们称满足下面条件的下标对 <code>(i, j)</code> 是 <strong>好的</strong> ：</p>

<ul>
	<li><code>0 &lt;= i &lt; j &lt; nums.length</code></li>
	<li><code>nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])</code></li>
</ul>

<p>请你返回好下标对的数目。由于结果可能会很大，请将结果对 <code>10<sup>9</sup> + 7</code> <b>取余</b> 后返回。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [42,11,1,97]
<b>输出：</b>2
<b>解释：</b>两个坐标对为：
 - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [13,10,35,24,76]
<b>输出：</b>4
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        mp = dict()
        for v in nums:
            t = v - int(str(v)[::-1])
            mp[t] = mp.get(t, 0) + 1
        ans = 0
        for v in mp.values():
            ans += v * (v - 1) // 2
        return ans % (10 ** 9 + 7)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countNicePairs(int[] nums) {
        int mod = (int) 1e9 + 7;
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums) {
            int rev = Integer.parseInt(new StringBuilder(String.valueOf(v)).reverse().toString());
            map.put(v - rev, map.getOrDefault(v - rev, 0) + 1);
        }
        long ans = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            ans = (ans + (long) val * (val - 1) / 2 % mod) % mod;
        }
        return (int) ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
