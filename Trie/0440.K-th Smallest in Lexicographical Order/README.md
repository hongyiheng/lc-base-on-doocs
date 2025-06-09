# [440. 字典序的第K小数字](https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定整数&nbsp;<code>n</code>&nbsp;和&nbsp;<code>k</code>，找到&nbsp;<code>1</code>&nbsp;到&nbsp;<code>n</code>&nbsp;中字典序第&nbsp;<code>k</code>&nbsp;小的数字。</p>

<p>注意：1 &le; k &le; n &le; 10<sup>9</sup>。</p>

<p><strong>示例 :</strong></p>

<pre>
<strong>输入:</strong>
n: 13   k: 2

<strong>输出:</strong>
10

<strong>解释:</strong>
字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        def get_cnt(x):
            cnt = 0
            l, r = x, x + 1
            while l <= n:
                cnt += min(r, n + 1) - l
                l *= 10
                r *= 10
            return cnt
        
        cur = 1
        k -= 1
        while k > 0:
            cnt = get_cnt(cur)
            if k >= cnt:
                cur += 1
                k -= cnt
            else:
                cur *= 10
                k -= 1
        return cur
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int n;

    public long getCnt(int x) {
        long cnt = 0;
        long l = x, r = x + 1;
        while (l <= n) {
            cnt += Math.min(n + 1, r) - l;
            l *= 10;
            r *= 10;
        }
        return cnt;
    }

    public int findKthNumber(int n, int k) {
        this.n = n;
        int cur = 1;
        k--;
        while (k > 0) {
            long cnt = getCnt(cur);
            if (k >= cnt) {
                cur++;
                k -= cnt;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
