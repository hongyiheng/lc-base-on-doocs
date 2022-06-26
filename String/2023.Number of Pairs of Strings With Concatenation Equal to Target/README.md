# [2023. 连接后等于目标字符串的字符串对](https://leetcode-cn.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <strong>数字</strong>&nbsp;字符串数组 <code>nums</code>&nbsp;和一个 <strong>数字</strong>&nbsp;字符串 <code>target</code>&nbsp;，请你返回 <code>nums[i] + nums[j]</code>&nbsp;（两个字符串连接）结果等于 <code>target</code>&nbsp;的下标 <code>(i, j)</code>&nbsp;（需满足 <code>i != j</code>）的数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = ["777","7","77","77"], target = "7777"
<b>输出：</b>4
<b>解释：</b>符合要求的下标对包括：
- (0, 1)："777" + "7"
- (1, 0)："7" + "777"
- (2, 3)："77" + "77"
- (3, 2)："77" + "77"
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = ["123","4","12","34"], target = "1234"
<b>输出：</b>2
<b>解释：</b>符合要求的下标对包括
- (0, 1)："123" + "4"
- (2, 3)："12" + "34"
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>nums = ["1","1","1"], target = "11"
<b>输出：</b>6
<b>解释：</b>符合要求的下标对包括
- (0, 1)："1" + "1"
- (1, 0)："1" + "1"
- (0, 2)："1" + "1"
- (2, 0)："1" + "1"
- (1, 2)："1" + "1"
- (2, 1)："1" + "1"
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i].length &lt;= 100</code></li>
	<li><code>2 &lt;= target.length &lt;= 100</code></li>
	<li><code>nums[i]</code>&nbsp;和&nbsp;<code>target</code>&nbsp;只包含数字。</li>
	<li><code>nums[i]</code>&nbsp;和&nbsp;<code>target</code>&nbsp;不含有任何前导 0 。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numOfPairs(self, nums: List[str], target: str) -> int:
        n, ans = len(target), 0
        mp = {}
        for w in nums:
            mp[w] = mp.get(w, 0) + 1
        for i in range(n):
            pre, tail = target[:i], target[i:]
            pre_num = mp.get(pre, 0)
            if pre != tail:
                ans += pre_num * mp.get(tail, 0)
            else:
                ans += pre_num * (pre_num - 1)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> mp = new HashMap<>();
        int n = target.length(), ans = 0;
        for (String w : nums) {
            mp.put(w, mp.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            String pre = target.substring(0, i), tail = target.substring(i);
            int preNum = mp.getOrDefault(pre, 0);
            if (!pre.equals(tail)) {
                ans += preNum * mp.getOrDefault(tail, 0);
            } else {
                ans += preNum * (preNum - 1);
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
