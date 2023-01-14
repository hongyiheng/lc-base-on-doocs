# [1819. 序列中不同最大公约数的数目](https://leetcode-cn.com/problems/number-of-different-subsequences-gcds)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由正整数组成的数组 <code>nums</code> 。</p>

<p>数字序列的 <strong>最大公约数</strong> 定义为序列中所有整数的共有约数中的最大整数。</p>

<ul>
	<li>例如，序列 <code>[4,6,16]</code> 的最大公约数是 <code>2</code> 。</li>
</ul>

<p>数组的一个 <strong>子序列</strong> 本质是一个序列，可以通过删除数组中的某些元素（或者不删除）得到。</p>

<ul>
	<li>例如，<code>[2,5,10]</code> 是 <code>[1,2,1,<strong>2</strong>,4,1,<strong>5</strong>,<strong>10</strong>]</code> 的一个子序列。</li>
</ul>

<p>计算并返回 <code>nums</code> 的所有 <strong>非空</strong> 子序列中 <strong>不同</strong> 最大公约数的 <strong>数目</strong> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/04/03/image-1.png" />
<pre>
<strong>输入：</strong>nums = [6,10,3]
<strong>输出：</strong>5
<strong>解释：</strong>上图显示了所有的非空子序列与各自的最大公约数。
不同的最大公约数为 6 、10 、3 、2 和 1 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [5,15,40,5,6]
<strong>输出：</strong>7
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>1 <= nums[i] <= 2 * 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        def gcd(a, b):
            if b == 0:
                return a
            return gcd(b, a % b)
        
        s = set(nums)
        mx = max(nums)
        ans = len(s)
        for i in range(1, (mx + 1) // 2):
            if i in s:
                continue
            g = 0
            for j in range(i * 2, mx + 1, i):
                if j in s:
                    g = gcd(g, j)
                    if g == i:
                        ans += 1
                        break
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int n = nums.length;
        int mx = 0;
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            s.add(nums[i]);
        }
        int ans = s.size();
        for (int i = 1; i < (mx + 1) / 2; i++) {
            if (s.contains(i)) {
                continue;
            }
            int g = 0;
            for (int j = i * 2; j < mx + 1; j += i) {
                if (!s.contains(j)) {
                    continue;
                }
                g = gcd(g, j);
                if (g == i) {
                    ans++;
                    break;
                }
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
