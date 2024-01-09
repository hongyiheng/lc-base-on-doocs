# [2829. k-avoiding 数组的最小总和](https://leetcode-cn.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个整数 <code>n</code> 和 <code>k</code> 。</p>

<p>对于一个由 <strong>不同</strong> 正整数组成的数组，如果其中不存在任何求和等于 k 的不同元素对，则称其为 <strong>k-avoiding</strong> 数组。</p>

<p>返回长度为 <code>n</code> 的 <strong>k-avoiding</strong> 数组的可能的最小总和。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 5, k = 4
<strong>输出：</strong>18
<strong>解释：</strong>设若 k-avoiding 数组为 [1,2,4,5,6] ，其元素总和为 18 。
可以证明不存在总和小于 18 的 k-avoiding 数组。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 2, k = 6
<strong>输出：</strong>3
<strong>解释：</strong>可以构造数组 [1,2] ，其元素总和为 3 。
可以证明不存在总和小于 3 的 k-avoiding 数组。 
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n, k &lt;= 50</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumSum(self, n: int, k: int) -> int:
        ans = 0
        for i in range(1, k // 2 + 1):
            if not n:
                break
            ans += i
            n -= 1
        while n:
            ans += k
            k += 1
            n -= 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumSum(int n, int k) {
        int ans = 0;
        for (int i = 1; i < k / 2 + 1; i++) {
            if (n == 0) {
                break;
            }
            ans += i;
            n--;
        }
        while (n > 0) {
            ans += k++;
            n--;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
