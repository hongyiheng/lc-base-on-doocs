# [372. 超级次方](https://leetcode-cn.com/problems/super-pow)



## 题目描述

<!-- 这里写题目描述 -->

<p>你的任务是计算 <code>a<sup>b</sup></code> 对 <code>1337</code> 取模，<code>a</code> 是一个正整数，<code>b</code> 是一个非常大的正整数且会以数组形式给出。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>a = 2, b = [3]
<strong>输出：</strong>8
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>a = 2, b = [1,0]
<strong>输出：</strong>1024
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>a = 1, b = [4,3,3,8,5,2]
<strong>输出：</strong>1
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>a = 2147483647, b = [2,0,0]
<strong>输出：</strong>1198
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= a <= 2<sup>31</sup> - 1</code></li>
	<li><code>1 <= b.length <= 2000</code></li>
	<li><code>0 <= b[i] <= 9</code></li>
	<li><code>b</code> 不含前导 0</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        mod = 1337

        def pow(a, b):
            nonlocal mod
            ans = 1
            a %= mod
            while b > 0:
                ans = ans * a % mod
                b -= 1
            return ans
        
        def dfs(index):
            nonlocal a, b
            if index < 0:
                return 1
            return pow(dfs(index - 1), 10) * pow(a, b[index]) % mod
        
        return dfs(len(b) - 1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int mod = 1337;
    public int superPow(int a, int[] b) {   
        return dfs(a, b, b.length - 1);
    }

    public int dfs (int a, int[] b, int index) {
        if (index < 0) {
            return 1;
        } 
        return pow(dfs(a, b, index - 1), 10) * pow(a, b[index]) % mod;
    }

    public int pow(int a, int b) {
        int ans = 1;
        a %= mod;
        while (b-- > 0) {
            ans = ans * a % mod;
        }
        return ans;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
