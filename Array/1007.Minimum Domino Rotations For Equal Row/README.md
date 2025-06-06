# [1007. 行相等的最少多米诺旋转](https://leetcode-cn.com/problems/minimum-domino-rotations-for-equal-row)



## 题目描述

<!-- 这里写题目描述 -->

<p>在一排多米诺骨牌中，<code>A[i]</code> 和 <code>B[i]</code>&nbsp;分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的&nbsp;&mdash;&mdash; 该平铺的每一半上都有一个数字。）</p>

<p>我们可以旋转第&nbsp;<code>i</code>&nbsp;张多米诺，使得&nbsp;<code>A[i]</code> 和&nbsp;<code>B[i]</code>&nbsp;的值交换。</p>

<p>返回能使 <code>A</code> 中所有值或者 <code>B</code> 中所有值都相同的最小旋转次数。</p>

<p>如果无法做到，返回&nbsp;<code>-1</code>.</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/03/08/domino.png" style="height: 161px; width: 200px;"></p>

<pre><strong>输入：</strong>A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
<strong>输出：</strong>2
<strong>解释：</strong>
图一表示：在我们旋转之前， A 和 B 给出的多米诺牌。
如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>A = [3,5,1,2,3], B = [3,6,3,3,4]
<strong>输出：</strong>-1
<strong>解释：</strong>
在这种情况下，不可能旋转多米诺牌使一行的值相等。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= A[i], B[i] &lt;= 6</code></li>
	<li><code>2 &lt;= A.length == B.length &lt;= 20000</code></li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        def f(x):
            ans1 = ans2 = 0
            for t, b in zip(tops, bottoms):
                if t == b == x:
                    continue
                if t == x:
                    ans2 += 1
                elif b == x:
                    ans1 += 1
                else:
                    return -1
            return min(ans1, ans2)
        
        ans1, ans2 = f(tops[0]), f(bottoms[0])
        if ans1 == -1:
            return ans2
        elif ans2 == -1:
            return ans1
        return min(ans1, ans2)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public int f(int x, int[] tops, int[] bottoms) {
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < tops.length; i++) {
            int t = tops[i], b = bottoms[i];
            if (t == x && b == x) {
                continue;
            }
            if (t == x) {
                ans2++;
            } else if (b == x) {
                ans1++;
            } else {
                return -1;
            }
        }
        return Math.min(ans1, ans2);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans1 = f(tops[0], tops, bottoms);
        int ans2 = f(bottoms[0], tops, bottoms);
        if (ans1 == -1) {
            return ans2;
        } else if (ans2 == -1) {
            return ans1;
        }
        return Math.min(ans1, ans2);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
