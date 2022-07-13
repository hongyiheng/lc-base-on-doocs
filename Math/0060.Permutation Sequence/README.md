# [60. 排列序列](https://leetcode-cn.com/problems/permutation-sequence)



## 题目描述

<!-- 这里写题目描述 -->

<p>给出集合 <code>[1,2,3,...,n]</code>，其所有元素共有 <code>n!</code> 种排列。</p>

<p>按大小顺序列出所有排列情况，并一一标记，当 <code>n = 3</code> 时, 所有排列如下：</p>

<ol>
	<li><code>"123"</code></li>
	<li><code>"132"</code></li>
	<li><code>"213"</code></li>
	<li><code>"231"</code></li>
	<li><code>"312"</code></li>
	<li><code>"321"</code></li>
</ol>

<p>给定 <code>n</code> 和 <code>k</code>，返回第 <code>k</code> 个排列。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 3, k = 3
<strong>输出：</strong>"213"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 4, k = 9
<strong>输出：</strong>"2314"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>n = 3, k = 1
<strong>输出：</strong>"123"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= n <= 9</code></li>
	<li><code>1 <= k <= n!</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        cnt = [0] * (n + 1)
        cnt[0] = 1
        for i in range(1, n + 1):
            cnt[i] = cnt[i - 1] * i
        used = [False] * (n + 1)
        ans = ""
        for i in range(n - 1, -1, -1):
            num = cnt[i]
            for j in range(1, n + 1):
                if used[j]:
                    continue
                if k > num:
                    k -= num
                    continue
                ans += str(j)
                used[j] = True
                break
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public String getPermutation(int n, int k) {
        int[] cnt = new int[10];
        cnt[0] = 1;
        for (int i = 1; i < 10; i++) {
            cnt[i] = cnt[i - 1] * i;
        }
        StringBuilder ans = new StringBuilder();
        boolean[] used = new boolean[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int num = cnt[i];
            for (int j = 1; j <= n; j++) {
                if (used[j]) {
                    continue;
                }
                if (k > num) {
                    k -= num;
                    continue;
                }
                used[j] = true;
                ans.append(j);
                break;
            }
        }
        return ans.toString();
    }   
}
```

### **...**

```

```

<!-- tabs:end -->
