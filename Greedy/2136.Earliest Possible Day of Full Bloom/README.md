# [2136. 全部开花的最早一天](https://leetcode-cn.com/problems/earliest-possible-day-of-full-bloom)

## 题目描述

<!-- 这里写题目描述 -->

<p>你有 <code>n</code> 枚花的种子。每枚种子必须先种下，才能开始生长、开花。播种需要时间，种子的生长也是如此。给你两个下标从 <strong>0</strong> 开始的整数数组 <code>plantTime</code> 和 <code>growTime</code> ，每个数组的长度都是 <code>n</code> ：</p>

<ul>
	<li><code>plantTime[i]</code> 是 <strong>播种</strong> 第 <code>i</code> 枚种子所需的 <strong>完整天数</strong> 。每天，你只能为播种某一枚种子而劳作。<strong>无须</strong> 连续几天都在种同一枚种子，但是种子播种必须在你工作的天数达到 <code>plantTime[i]</code> 之后才算完成。</li>
	<li><code>growTime[i]</code> 是第 <code>i</code> 枚种子完全种下后生长所需的 <strong>完整天数 </strong>。在它生长的最后一天 <strong>之后</strong> ，将会开花并且永远 <strong>绽放</strong> 。</li>
</ul>

<p>从第 <code>0</code> 开始，你可以按 <strong>任意</strong> 顺序播种种子。</p>

<p>返回所有种子都开花的 <strong>最早</strong> 一天是第几天。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/21/1.png" style="width: 453px; height: 149px;">
<pre><strong>输入：</strong>plantTime = [1,4,3], growTime = [2,3,1]
<strong>输出：</strong>9
<strong>解释：</strong>灰色的花盆表示播种的日子，彩色的花盆表示生长的日子，花朵表示开花的日子。
一种最优方案是：
第 0 天，播种第 0 枚种子，种子生长 2 整天。并在第 3 天开花。
第 1、2、3、4 天，播种第 1 枚种子。种子生长 3 整天，并在第 8 天开花。
第 5、6、7 天，播种第 2 枚种子。种子生长 1 整天，并在第 9 天开花。
因此，在第 9 天，所有种子都开花。 
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/12/21/2.png" style="width: 454px; height: 184px;">
<pre><strong>输入：</strong>plantTime = [1,2,3,2], growTime = [2,1,2,1]
<strong>输出：</strong>9
<strong>解释：</strong>灰色的花盆表示播种的日子，彩色的花盆表示生长的日子，花朵表示开花的日子。 
一种最优方案是：
第 1 天，播种第 0 枚种子，种子生长 2 整天。并在第 4 天开花。
第 0、3 天，播种第 1 枚种子。种子生长 1 整天，并在第 5 天开花。
第 2、4、5 天，播种第 2 枚种子。种子生长 2 整天，并在第 8 天开花。
第 6、7 天，播种第 3 枚种子。种子生长 1 整天，并在第 9 天开花。
因此，在第 9 天，所有种子都开花。 
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>plantTime = [1], growTime = [1]
<strong>输出：</strong>2
<strong>解释：</strong>第 0 天，播种第 0 枚种子。种子需要生长 1 整天，然后在第 2 天开花。
因此，在第 2 天，所有种子都开花。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == plantTime.length == growTime.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= plantTime[i], growTime[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def earliestFullBloom(self, plantTime: List[int], growTime: List[int]) -> int:
        n = len(plantTime)
        q = [(plantTime[i], growTime[i]) for i in range(n)]
        q.sort(key=lambda x:x[1])
        idx = ans = 0
        while q:  
            cur = q.pop()
            idx += cur[0]
            ans = max(idx + cur[1], ans)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < plantTime.length; i++) {
            q.add(new int[]{plantTime[i], growTime[i]});
        }
        int idx = 0, ans = 0;;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            idx += cur[0];
            ans = Math.max(idx + cur[1], ans);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
