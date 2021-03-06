# [1011. 在 D 天内送达包裹的能力](https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days)



## 题目描述

<!-- 这里写题目描述 -->

<p>传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。</p>

<p>传送带上的第 <code>i</code> 个包裹的重量为 <code>weights[i]</code>。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。</p>

<p>返回能在 <code>D</code> 天内将传送带上的所有包裹送达的船的最低运载能力。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>weights = [1,2,3,4,5,6,7,8,9,10], D = 5
<strong>输出：</strong>15
<strong>解释：</strong>
船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
第 1 天：1, 2, 3, 4, 5
第 2 天：6, 7
第 3 天：8
第 4 天：9
第 5 天：10

请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>weights = [3,2,2,4,1,4], D = 3
<strong>输出：</strong>6
<strong>解释：</strong>
船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
第 1 天：3, 2
第 2 天：2, 4
第 3 天：1, 4
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>weights = [1,2,3,1,1], D = 4
<strong>输出：</strong>3
<strong>解释：</strong>
第 1 天：1
第 2 天：2
第 3 天：3
第 4 天：1, 1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= D <= weights.length <= 5 * 10<sup>4</sup></code></li>
	<li><code>1 <= weights[i] <= 500</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def check(k):
            nonlocal weights, days
            cur, use_day = 0, 1
            for w in weights:
                if w > k:
                    return False
                cur += w
                if cur > k:
                    cur = w
                    use_day += 1
            return use_day <= days
        
        left, right = 0, 0x7fffffff
        while left < right:
            mid = (left + right) >> 1
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int[] weights;
    public int shipWithinDays(int[] weights, int days) {
        this.weights = weights;
        int left = 0, right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (check(mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int k, int days) {
        int cur = 0, useDay = 1;
        for (int w : weights) {
            if (w > k) {
                return false;
            }
            cur += w;
            if (cur > k) {
                cur = w;
                useDay++;
            }
        }
        return useDay <= days;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
