# [1052. 爱生气的书店老板](https://leetcode-cn.com/problems/grumpy-bookstore-owner)



## 题目描述

<!-- 这里写题目描述 -->

<p>今天，书店老板有一家店打算试营业 <code>customers.length</code> 分钟。每分钟都有一些顾客（<code>customers[i]</code>）会进入书店，所有这些顾客都会在那一分钟结束后离开。</p>

<p>在某些时候，书店老板会生气。 如果书店老板在第 <code>i</code> 分钟生气，那么 <code>grumpy[i] = 1</code>，否则 <code>grumpy[i] = 0</code>。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。</p>

<p>书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 <code>X</code> 分钟不生气，但却只能使用一次。</p>

<p>请你返回这一天营业下来，最多有多少客户能够感到满意。<br />
 </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
<strong>输出：</strong>16
<strong>解释：
</strong>书店老板在最后 3 分钟保持冷静。
感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= X <= customers.length == grumpy.length <= 20000</code></li>
	<li><code>0 <= customers[i] <= 1000</code></li>
	<li><code>0 <= grumpy[i] <= 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        n = len(customers)
        pre = [0] * (n + 1)
        basic = 0
        for i in range(1, n + 1):
            pre[i] = pre[i - 1]
            if grumpy[i - 1] == 1:
                pre[i] += customers[i - 1]
            else:
                basic += customers[i - 1]
        res = 0
        for i in range(n + 1):
            right = i + minutes if i + minutes < n else n
            res = max(res, basic + pre[right] - pre[i])
        return res
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int[] preSum = new int[n + 1];
        int basic = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1];
            if (grumpy[i - 1] == 1) {
                preSum[i] += customers[i - 1];
            } else {
                basic += customers[i - 1];
            }
        }
        int res = 0;
        for (int i = 0; i <= n; i++) {
            int right = i + minutes >= n ? n : i + minutes;
            int diff = preSum[right] - preSum[i];
            res = Math.max(res, basic + diff);
        }
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
