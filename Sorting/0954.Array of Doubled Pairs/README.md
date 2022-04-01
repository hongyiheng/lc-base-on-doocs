# [954. 二倍数对数组](https://leetcode-cn.com/problems/array-of-doubled-pairs)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个长度为偶数的整数数组 <code>arr</code>，只有对 <code>arr</code> 进行重组后可以满足 “对于每个 <code>0 <= i < len(arr) / 2</code>，都有 <code>arr[2 * i + 1] = 2 * arr[2 * i]</code>” 时，返回 <code>true</code>；否则，返回 <code>false</code>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [3,1,3,6]
<strong>输出：</strong>false
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [2,1,2,6]
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>arr = [4,-2,2,-4]
<strong>输出：</strong>true
<strong>解释：</strong>可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,2,4,16,8,4]
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= arr.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>arr.length</code> 是偶数</li>
	<li><code>-10<sup>5</sup> <= arr[i] <= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def canReorderDoubled(self, arr: List[int]) -> bool:
        n, m = 100010, 2 * 100010
        cnt = [0] * 2 * m
        nums = []
        for v in arr:
            cnt[v + n] += 1
            if cnt[v + n] == 1:
                nums.append(v)
        nums.sort(key=lambda x: abs(x))
        for v in nums:
            if cnt[v + n] > cnt[2 * v + n]:
                return False
            cnt[2 * v + n] -= cnt[v + n]
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int n = 100010;
        int m = 2 * n;
        int[] cnt = new int[m * 2];
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Math.abs(a) - Math.abs(b));
        for (int num : arr) {
            if (++cnt[num + n] == 1) {
                q.add(num);
            }
        }
        while (!q.isEmpty()) {
            int idx = q.poll();
            if (cnt[idx + n] > cnt[idx * 2 + n]) {
                return false;
            }
            cnt[idx * 2 + n] -= cnt[idx + n];
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
