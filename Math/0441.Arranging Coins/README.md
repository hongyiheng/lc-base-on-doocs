# [441. 排列硬币](https://leetcode-cn.com/problems/arranging-coins)



## 题目描述

<!-- 这里写题目描述 -->

<p>你总共有&nbsp;<em>n&nbsp;</em>枚硬币，你需要将它们摆成一个阶梯形状，第&nbsp;<em>k&nbsp;</em>行就必须正好有&nbsp;<em>k&nbsp;</em>枚硬币。</p>

<p>给定一个数字&nbsp;<em>n</em>，找出可形成完整阶梯行的总行数。</p>

<p><em>n&nbsp;</em>是一个非负整数，并且在32位有符号整型的范围内。</p>

<p><strong>示例 1:</strong></p>

<pre>
n = 5

硬币可排列成以下几行:
&curren;
&curren; &curren;
&curren; &curren;

因为第三行不完整，所以返回2.
</pre>

<p><strong>示例 2:</strong></p>

<pre>
n = 8

硬币可排列成以下几行:
&curren;
&curren; &curren;
&curren; &curren; &curren;
&curren; &curren;

因为第四行不完整，所以返回3.
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        def getNodes(cur):
            nonlocal n
            node_count = 0
            next = cur + 1
            while cur <= n:
                node_count += min(n - cur + 1, next - cur)
                next *= 10
                cur *= 10
            return node_count
        
        cur = 1
        k -= 1
        while k > 0:
            node_count = getNodes(cur)
            if k >= node_count:
                k -= node_count
                cur += 1
            else:
                k -= 1
                cur *= 10
        return cur
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int nodeCount = getNodeCount(n, cur);
            if (k >= nodeCount) {
                k -= nodeCount;
                cur ++;
            } else {
                k--;
                cur *= 10;
            }
        }
        return cur;
    }

    public int getNodeCount(int n, long cur) {
        int nodeCount = 0;
        long next = cur + 1;
        while (cur <= n) {
            nodeCount += Math.min(n - cur + 1, next - cur);
            next *= 10;
            cur *= 10;
        }
        return nodeCount;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
