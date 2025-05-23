# [1534. 统计好三元组](https://leetcode-cn.com/problems/count-good-triplets)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>arr</code> ，以及 <code>a</code>、<code>b</code> 、<code>c</code> 三个整数。请你统计其中好三元组的数量。</p>

<p>如果三元组 <code>(arr[i], arr[j], arr[k])</code> 满足下列全部条件，则认为它是一个 <strong>好三元组</strong> 。</p>

<ul>
	<li><code>0 &lt;= i &lt; j &lt; k &lt;&nbsp;arr.length</code></li>
	<li><code>|arr[i] - arr[j]| &lt;= a</code></li>
	<li><code>|arr[j] - arr[k]| &lt;= b</code></li>
	<li><code>|arr[i] - arr[k]| &lt;= c</code></li>
</ul>

<p>其中 <code>|x|</code> 表示 <code>x</code> 的绝对值。</p>

<p>返回 <strong>好三元组的数量</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
<strong>输出：</strong>4
<strong>解释：</strong>一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr = [1,1,2,2,3], a = 0, b = 0, c = 1
<strong>输出：</strong>0
<strong>解释：</strong>不存在满足所有条件的三元组。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= arr.length &lt;= 100</code></li>
	<li><code>0 &lt;= arr[i] &lt;= 1000</code></li>
	<li><code>0 &lt;= a, b, c &lt;= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        n = len(arr)
        ans = 0
        for i in range(n):
            for k in range(i + 2, n):
                if abs(arr[i] - arr[k]) > c:
                    continue
                for j in range(i + 1, k):
                    if abs(arr[i] - arr[j]) > a or abs(arr[j] - arr[k]) > b:
                        continue
                    ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 2; k < n; k++) {
                if (Math.abs(arr[i] - arr[k]) > c) {
                    continue;
                }
                for (int j = i + 1; j < k; j++) {
                    if (Math.abs(arr[i] - arr[j]) > a || Math.abs(arr[j] - arr[k]) > b) {
                        continue;
                    }
                    ans++;
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
