# [1362. 最接近的因数](https://leetcode-cn.com/problems/closest-divisors)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数&nbsp;<code>num</code>，请你找出同时满足下面全部要求的两个整数：</p>

<ul>
	<li>两数乘积等于 &nbsp;<code>num + 1</code>&nbsp;或&nbsp;<code>num + 2</code></li>
	<li>以绝对差进行度量，两数大小最接近</li>
</ul>

<p>你可以按任意顺序返回这两个整数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>num = 8
<strong>输出：</strong>[3,3]
<strong>解释：</strong>对于 num + 1 = 9，最接近的两个因数是 3 &amp; 3；对于 num + 2 = 10, 最接近的两个因数是 2 &amp; 5，因此返回 3 &amp; 3 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>num = 123
<strong>输出：</strong>[5,25]
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>num = 999
<strong>输出：</strong>[40,25]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= num &lt;= 10^9</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def closestDivisors(self, num: int) -> List[int]:
        mi = num + 1
        ans = []
        for i in range(1, int(math.sqrt(num + 2)) + 1):
            if (num + 1) % i == 0 and abs(i - (num + 1) // i) < mi:
                ans = [i, (num + 1) // i]
                mi = abs(i - (num + 1) // i)
            if (num + 2) % i == 0 and abs(i - (num + 2) // i) < mi:
                ans = [i, (num + 2) // i]
                mi = abs(i - (num + 2) // i)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] closestDivisors(int num) {
        int mi = num + 1;
        int[] ans = new int[2];
        for (int i = 1; i * i <= num + 2; i++) {
            if ((num + 1) % i == 0) {
                if (Math.abs(i - (num + 1) / i) < mi) {
                    mi = Math.abs(i - (num + 1) / i);
                    ans[0] = i;
                    ans[1] = (num + 1) / i;
                }
            }
            if ((num + 2) % i == 0) {
                if (Math.abs(i - (num + 2) / i) < mi) {
                    mi = Math.abs(i - (num + 2) / i);
                    ans[0] = i;
                    ans[1] = (num + 2) / i;
                }
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
