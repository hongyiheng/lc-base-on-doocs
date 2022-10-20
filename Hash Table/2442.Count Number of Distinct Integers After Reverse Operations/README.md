# [2442. 反转之后不同整数的数目](https://leetcode-cn.com/problems/count-number-of-distinct-integers-after-reverse-operations)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由 <strong>正</strong> 整数组成的数组 <code>nums</code> 。</p>

<p>你必须取出数组中的每个整数，<strong>反转其中每个数位</strong>，并将反转后得到的数字添加到数组的末尾。这一操作只针对 <code>nums</code> 中原有的整数执行。</p>

<p>返回结果数组中 <strong>不同</strong> 整数的数目。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,13,10,12,31]
<strong>输出：</strong>6
<strong>解释：</strong>反转每个数字后，结果数组是 [1,13,10,12,31,<em><strong>1,31,1,21,13</strong></em>] 。
反转后得到的数字添加到数组的末尾并按斜体加粗表示。注意对于整数 10 ，反转之后会变成 01 ，即 1 。
数组中不同整数的数目为 6（数字 1、10、12、13、21 和 31）。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,2,2]
<strong>输出：</strong>1
<strong>解释：</strong>反转每个数字后，结果数组是 [2,2,2,<em><strong>2,2,2</strong></em>] 。
数组中不同整数的数目为 1（数字 2）。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countDistinctIntegers(self, nums: List[int]) -> int:
        s = set()
        for v in nums:
            s.add(v)
            s.add(int(str(v)[::-1]))
        return len(s)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            StringBuilder sb = new StringBuilder(String.valueOf(v));
            s.add(Integer.parseInt(sb.toString()));
            s.add(Integer.parseInt(sb.reverse().toString()));
        }
        return s.size();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
