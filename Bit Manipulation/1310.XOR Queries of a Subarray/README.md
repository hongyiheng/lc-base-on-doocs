# [1310. 子数组异或查询](https://leetcode-cn.com/problems/xor-queries-of-a-subarray)



## 题目描述

<!-- 这里写题目描述 -->

<p>有一个正整数数组 <code>arr</code>，现给你一个对应的查询数组 <code>queries</code>，其中 <code>queries[i] = [L<sub>i, </sub>R<sub>i</sub>]</code>。</p>

<p>对于每个查询 <code>i</code>，请你计算从 <code>L<sub>i</sub></code> 到 <code>R<sub>i</sub></code> 的 <strong>XOR</strong> 值（即 <code>arr[L<sub>i</sub>] <strong>xor</strong> arr[L<sub>i</sub>+1] <strong>xor</strong> ... <strong>xor</strong> arr[R<sub>i</sub>]</code>）作为本次查询的结果。</p>

<p>并返回一个包含给定查询 <code>queries</code> 所有结果的数组。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
<strong>输出：</strong>[2,7,14,8] 
<strong>解释：</strong>
数组中元素的二进制表示形式是：
1 = 0001 
3 = 0011 
4 = 0100 
8 = 1000 
查询的 XOR 值为：
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
<strong>输出：</strong>[8,0,4,4]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= arr.length <= 3 * 10^4</code></li>
	<li><code>1 <= arr[i] <= 10^9</code></li>
	<li><code>1 <= queries.length <= 3 * 10^4</code></li>
	<li><code>queries[i].length == 2</code></li>
	<li><code>0 <= queries[i][0] <= queries[i][1] < arr.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        n = len(arr)
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] ^ arr[i]
        ans = []
        for l, r in queries:
            ans.append(pre[r + 1] ^ pre[l])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            ans[i] = pre[r + 1] ^ pre[l];
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
