# [354. 俄罗斯套娃信封问题](https://leetcode-cn.com/problems/russian-doll-envelopes)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二维整数数组 <code>envelopes</code> ，其中 <code>envelopes[i] = [w<sub>i</sub>, h<sub>i</sub>]</code> ，表示第 <code>i</code> 个信封的宽度和高度。</p>

<p>当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。</p>

<p>请计算 <strong>最多能有多少个</strong> 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。</p>

<p><strong>注意</strong>：不允许旋转信封。</p>
 

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>envelopes = [[5,4],[6,4],[6,7],[2,3]]
<strong>输出：</strong>3
<strong>解释：</strong>最多信封的个数为 <code>3, 组合为: </code>[2,3] => [5,4] => [6,7]。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>envelopes = [[1,1],[1,1],[1,1]]
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= envelopes.length <= 5000</code></li>
	<li><code>envelopes[i].length == 2</code></li>
	<li><code>1 <= w<sub>i</sub>, h<sub>i</sub> <= 10<sup>4</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        def cmp(a, b):
            if a[0] != b[0]:
                return a[0] - b[0]
            return b[1] - a[1]

        envelopes.sort(key=cmp_to_key(cmp))
        nums = [v[1] for v in envelopes]
        ans, n = 0, len(nums)
        dp = [0] * n
        for i in range(n):
            l, r = 0, ans
            while l < r:
                mid = (l + r) >> 1
                if dp[mid] < nums[i]:
                    l = mid + 1
                else:
                    r = mid
            dp[l] = nums[i]
            if l == ans:
                ans += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        int n = envelopes.length, ans = 0;
        int[] dp = new int[n], nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = envelopes[i][1];
        }
        for (int i = 0; i < n; i++) {
            int left = 0, right = ans;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (dp[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = nums[i];
            if (left == ans) {
                ans++;
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
