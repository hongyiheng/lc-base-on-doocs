# [3281. 范围内整数的最大得分](https://leetcode.cn/problems/maximize-score-of-numbers-in-ranges)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>start</code> 和一个整数 <code>d</code>，代表 <code>n</code> 个区间 <code>[start[i], start[i] + d]</code>。</p>

<p>你需要选择 <code>n</code> 个整数，其中第 <code>i</code> 个整数必须属于第 <code>i</code> 个区间。所选整数的 <strong>得分</strong> 定义为所选整数两两之间的 <strong>最小 </strong>绝对差。</p>

<p>返回所选整数的 <strong>最大可能得分 </strong>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">start = [6,0,3], d = 2</span></p>

<p><strong>输出：</strong> <span class="example-io">4</span></p>

<p><strong>解释：</strong></p>

<p>可以选择整数 8, 0 和 4 获得最大可能得分，得分为 <code>min(|8 - 0|, |8 - 4|, |0 - 4|)</code>，等于 4。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong> <span class="example-io">start = [2,6,13,13], d = 5</span></p>

<p><strong>输出：</strong> <span class="example-io">5</span></p>

<p><strong>解释：</strong></p>

<p>可以选择整数 2, 7, 13 和 18 获得最大可能得分，得分为 <code>min(|2 - 7|, |2 - 13|, |2 - 18|, |7 - 13|, |7 - 18|, |13 - 18|)</code>，等于 5。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= start.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= start[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= d &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxPossibleScore(self, start: List[int], d: int) -> int:
        def check(x):
            last = start[0]
            for i in range(1, len(start)):
                if last + x > start[i] + d:
                    return False
                last = max(last + x, start[i])
            return True

        start.sort()
        l, r = 0, start[-1] - start[0] + 2 * d
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return r
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int n;

    public boolean check(int[] start, int d, long x) {
        long last = start[0];
        for (int i = 1; i < n; i++) {
            if (last + x > start[i] + d) {
                return false;
            }
            last = Math.max(last + x, start[i]);
        }
        return true;
    }

    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        n = start.length;
        long l = 0, r = start[n - 1] - start[0] + 2L * d;
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (check(start, d, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int)r;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
