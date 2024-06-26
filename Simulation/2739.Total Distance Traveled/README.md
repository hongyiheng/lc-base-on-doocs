# [2739. 总行驶距离](https://leetcode-cn.com/problems/total-distance-traveled)

## 题目描述

<!-- 这里写题目描述 -->

<p>卡车有两个油箱。给你两个整数，<code>mainTank</code> 表示主油箱中的燃料（以升为单位），<code>additionalTank</code> 表示副油箱中的燃料（以升为单位）。</p>

<p>该卡车每耗费 <code>1</code> 升燃料都可以行驶 <code>10</code> km。每当主油箱使用了 <code>5</code> 升燃料时，如果副油箱至少有 <code>1</code> 升燃料，则会将 <code>1</code> 升燃料从副油箱转移到主油箱。</p>

<p>返回卡车可以行驶的最大距离。</p>

<p>注意：从副油箱向主油箱注入燃料不是连续行为。这一事件会在每消耗 <code>5</code> 升燃料时突然且立即发生。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>mainTank = 5, additionalTank = 10
<strong>输出：</strong>60
<strong>解释：</strong>
在用掉 5 升燃料后，主油箱中燃料还剩下 (5 - 5 + 1) = 1 升，行驶距离为 50km 。
在用掉剩下的 1 升燃料后，没有新的燃料注入到主油箱中，主油箱变为空。
总行驶距离为 60km 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>mainTank = 1, additionalTank = 2
<strong>输出：</strong>10
<strong>解释：</strong>
在用掉 1 升燃料后，主油箱变为空。
总行驶距离为 10km 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= mainTank, additionalTank &lt;= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def distanceTraveled(self, mainTank: int, additionalTank: int) -> int:
        ans = cnt = 0
        while mainTank:
            ans += mainTank * 10
            cnt += mainTank
            extra = min(additionalTank, cnt // 5)
            cnt %= 5
            additionalTank -= extra
            mainTank = extra
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0, cnt = 0;
        while (mainTank > 0) {
            ans += mainTank * 10;
            cnt += mainTank;
            int extra = Math.min(cnt / 5, additionalTank);
            additionalTank -= extra;
            cnt %= 5;
            mainTank = extra;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
