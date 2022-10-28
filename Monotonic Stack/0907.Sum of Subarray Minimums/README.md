# [907. 子数组的最小值之和](https://leetcode-cn.com/problems/sum-of-subarray-minimums)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数数组 <code>arr</code>，找到 <code>min(b)</code> 的总和，其中 <code>b</code> 的范围为 <code>arr</code> 的每个（连续）子数组。</p>

<p>由于答案可能很大，因此<strong> 返回答案模 <code>10^9 + 7</code></strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [3,1,2,4]
<strong>输出：</strong>17
<strong>解释：
</strong>子数组为<strong> </strong>[3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [11,81,94,43,3]
<strong>输出：</strong>444
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= arr.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>1 <= arr[i] <= 3 * 10<sup>4</sup></code></li>
</ul>

<p> </p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        n = len(arr)
        l, r = [-1] * n, [n] * n
        q = deque()
        for i in range(n):
            while q and arr[q[-1]] >= arr[i]:
                r[q.pop()] = i
            q.append(i)
        q.clear()
        for i in range(n - 1, -1, -1):
            while q and arr[q[-1]] > arr[i]:
                l[q.pop()] = i
            q.append(i)
        ans = 0
        for i in range(n):
            a, b = l[i], r[i]
            ans += (i - a) * (b - i) * arr[i]
            ans %= int(1e9 + 7)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)1e9 + 7;
        int n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] l = new int[n];
        Arrays.fill(l, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!q.isEmpty() && arr[q.peekLast()] >= arr[i]) {
                l[q.pollLast()] = i;
            }
            q.addLast(i);
        }
        q.clear();
        int[] r = new int[n];
        Arrays.fill(r, n);
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && arr[q.peekLast()] > arr[i]) {
                r[q.pollLast()] = i;
            }
            q.addLast(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (int)(ans + 1L * (i - l[i]) * (r[i] - i) * arr[i] % mod) % mod;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
