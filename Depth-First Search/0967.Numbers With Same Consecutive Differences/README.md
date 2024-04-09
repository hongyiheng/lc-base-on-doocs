# [967. 连续差相同的数字](https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences)



## 题目描述

<!-- 这里写题目描述 -->

<p>返回所有长度为 <code>n</code> 且满足其每两个连续位上的数字之间的差的绝对值为 <code>k</code> 的<strong> 非负整数 </strong>。</p>

<p>请注意，<strong>除了 </strong>数字 <code>0</code> 本身之外，答案中的每个数字都 <strong>不能 </strong>有前导零。例如，<code>01</code> 有一个前导零，所以是无效的；但 <code>0</code> 是有效的。</p>

<p>你可以按 <strong>任何顺序</strong> 返回答案。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 3, k = 7
<strong>输出：</strong>[181,292,707,818,929]
<strong>解释：</strong>注意，070 不是一个有效的数字，因为它有前导零。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 2, k = 1
<strong>输出：</strong>[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 2, k = 0
<strong>输出：</strong>[11,22,33,44,55,66,77,88,99]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>n = 2, k = 2
<strong>输出：</strong>[13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= n <= 9</code></li>
	<li><code>0 <= k <= 9</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        def dfs(x):
            if len(str(x)) == n:
                ans.append(x)
                return
            last = x % 10
            if last - k >= 0:
                dfs(x * 10 + last - k)
            if k != 0 and last + k < 10:
                dfs(x * 10 + last + k)

        ans = []
        for i in range(1, 10):
            dfs(i)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    List<Integer> ans = new ArrayList<>();

    public void dfs(int x, int n, int k) {
        if (String.valueOf(x).length() == n) {
            ans.add(x);
            return;
        }
        int last = x % 10;
        if (last - k >= 0) {
            dfs(x * 10 + last - k, n, k);
        }
        if (k != 0 && last + k < 10) {
            dfs(x * 10 + last + k, n, k);
        }
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i < 10; i++) {
            dfs(i, n, k);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
