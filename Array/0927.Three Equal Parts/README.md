# [927. 三等分](https://leetcode-cn.com/problems/three-equal-parts)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个由 <code>0</code> 和 <code>1</code> 组成的数组&nbsp;<code>A</code>，将数组分成 3&nbsp;个非空的部分，使得所有这些部分表示相同的二进制值。</p>

<p>如果可以做到，请返回<strong>任何</strong>&nbsp;<code>[i, j]</code>，其中 <code>i+1 &lt; j</code>，这样一来：</p>

<ul>
	<li><code>A[0], A[1], ..., A[i]</code>&nbsp;组成第一部分；</li>
	<li><code>A[i+1], A[i+2], ..., A[j-1]</code>&nbsp;作为第二部分；</li>
	<li><code>A[j], A[j+1], ..., A[A.length - 1]</code> 是第三部分。</li>
	<li>这三个部分所表示的二进制值相等。</li>
</ul>

<p>如果无法做到，就返回&nbsp;<code>[-1, -1]</code>。</p>

<p>注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，<code>[1,1,0]</code>&nbsp;表示十进制中的&nbsp;<code>6</code>，而不会是&nbsp;<code>3</code>。此外，前导零也是被允许的，所以&nbsp;<code>[0,1,1]</code> 和&nbsp;<code>[1,1]</code>&nbsp;表示相同的值。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[1,0,1,0,1]
<strong>输出：</strong>[0,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输出：</strong>[1,1,0,1,1]
<strong>输出：</strong>[-1,-1]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>3 &lt;= A.length &lt;= 30000</code></li>
	<li><code>A[i] == 0</code>&nbsp;或&nbsp;<code>A[i] == 1</code></li>
</ol>

<p>&nbsp;</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def threeEqualParts(self, arr: List[int]) -> List[int]:
        def find(end, k):
            cur = 0
            for i in range(end, -1, -1):
                cur += arr[i]
                if cur == k:
                    return i
            return -1

        n, cnt = len(arr), 0
        for v in arr:
            cnt += v
        ans = [-1, -1]
        if cnt % 3 != 0:
            return ans
        if cnt == 0:
            return [0, n - 1]
        k = cnt // 3
        c = find(n - 1, k)
        b = find(c - 1, k)
        a = find(b - 1, k)
        if a == -1 or b == -1 or c == -1:
            return ans
        while c < n:
            if arr[a] != arr[b] or arr[b] != arr[c]:
                return ans
            a += 1
            b += 1
            c += 1
        return [a - 1, b]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int cnt = 0, n = arr.length;
        int[] ans = new int[]{-1, -1};
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
            }
        }
        if (cnt % 3 != 0) {
            return ans;
        }
        if (cnt == 0) {
            return new int[]{0, n - 1};
        }
        int k = cnt / 3;
        int c = find(n - 1, k, arr);
        int b = find(c - 1, k, arr);
        int a = find(b - 1, k, arr);
        if (a == -1 || b == -1 || c == -1) {
            return ans;
        }
        while (c < n) {
            if (arr[a] != arr[b] || arr[b] != arr[c]) {
                return ans;
            }
            a++;
            b++;
            c++;
        }
        return new int[]{a - 1, b};
    }


    public int find(int end, int k, int[] arr) {
        int cur = 0;
        for (int i = end; i >= 0; i--) {
            cur += arr[i];
            if (cur == k) {
                return i;
            }
        }
        return -1;
    }

}
```

### **...**

```

```

<!-- tabs:end -->
