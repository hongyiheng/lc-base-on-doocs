# [718. 最长重复子数组](https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray)



## 题目描述

<!-- 这里写题目描述 -->

<p>给两个整数数组&nbsp;<code>A</code>&nbsp;和&nbsp;<code>B</code>&nbsp;，返回两个数组中公共的、长度最长的子数组的长度。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>
A: [1,2,3,2,1]
B: [3,2,1,4,7]
<strong>输出：</strong>3
<strong>解释：</strong>
长度最长的公共子数组是 [3, 2, 1] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= len(A), len(B) &lt;= 1000</code></li>
	<li><code>0 &lt;= A[i], B[i] &lt; 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findLength(self, A: List[int], B: List[int]) -> int:
        base, mod = 113, int(1e9 + 7)

        def get_hash_set(arr, k):
            h = 0
            for i in range(k):
                h = (h * base + arr[i]) % mod
            ans = {h}
            mult = pow(base, k - 1, mod)
            for i in range(k, len(arr)):
                h = ((h - arr[i - k] * mult) * base + arr[i]) % mod
                ans.add(h)
            return ans

        def check(k):
            s1 = get_hash_set(A, k)
            s2 = get_hash_set(B, k)
            return len(s1 & s2) > 0

        left, right = 0, min(len(A), len(B))
        while left < right:
            mid = (left + right + 1) >> 1
            if check(mid):
                left = mid
            else:
                right = mid - 1
        return left

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    long base = 113, mod = (int)1e9 + 7;

    public int findLength(int[] nums1, int[] nums2) {
        int left = 0, right = Math.min(nums1.length, nums2.length);
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(nums1, nums2, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums1, int[] nums2, int k) {
        Set<Long> a = getHashSet(nums1, k);
        Set<Long> b = getHashSet(nums2, k);
        a.retainAll(b);
        return !a.isEmpty();
    }

    public Set<Long> getHashSet(int[] path, int k) {
        long h = 0;
        for (int i = 0; i < k; i++) {
            h = (h * base + path[i]) % mod;
        }
        Set<Long> ans = new HashSet<>();
        ans.add(h);
        long mult = 1;
        for (int i = 0; i < k; i++) {
            mult = mult * base % mod;
        }
        for (int i = k; i < path.length; i++) {
            h = ((h * base - path[i - k] * mult) % mod + mod) % mod;
            h = (h + path[i]) % mod;
            ans.add(h);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
