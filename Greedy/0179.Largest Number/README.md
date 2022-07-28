# [179. 最大数](https://leetcode-cn.com/problems/largest-number)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一组非负整数 <code>nums</code>，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。</p>

<p><strong>注意：</strong>输出结果可能非常大，所以你需要返回一个字符串而不是整数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入<code>：</code></strong><code>nums = [10,2]</code>
<strong>输出：</strong><code>"210"</code></pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入<code>：</code></strong><code>nums = [3,30,34,5,9]</code>
<strong>输出：</strong><code>"9534330"</code>
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入<code>：</code></strong>nums = [1]
<strong>输出：</strong>"1"
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入<code>：</code></strong>nums = [10]
<strong>输出：</strong>"10"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 100</code></li>
	<li><code>0 <= nums[i] <= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        def cmp(a, b):
            a_, b_ = str(a), str(b)
            return 1 if b_ + a_ > a_ + b_ else -1
        
        nums.sort(key=cmp_to_key(cmp))
        ans = ""
        for v in nums:
            ans += str(v)
        while len(ans) > 1 and ans[0] == "0":
            ans = ans[1:]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = "" + nums[i];
        }
        Arrays.sort(s, (a, b) -> {
            return (b + a).compareTo(a + b) > 0 ? 1 : -1;
        });
        StringBuilder ans = new StringBuilder();
        for (String v : s) {
            ans.append(v);
        }
        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans = ans.deleteCharAt(0);
        }
        return ans.toString();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
