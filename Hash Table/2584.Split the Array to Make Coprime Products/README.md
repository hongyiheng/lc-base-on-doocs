# [2584. 分割数组使乘积互质](https://leetcode-cn.com/problems/split-the-array-to-make-coprime-products)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>n</code> 的整数数组 <code>nums</code> ，下标从 <strong>0</strong> 开始。</p>

<p>如果在下标 <code>i</code> 处 <strong>分割</strong> 数组，其中 <code>0 &lt;= i &lt;= n - 2</code> ，使前 <code>i + 1</code> 个元素的乘积和剩余元素的乘积互质，则认为该分割 <strong>有效</strong> 。</p>

<ul>
	<li>例如，如果 <code>nums = [2, 3, 3]</code> ，那么在下标 <code>i = 0</code> 处的分割有效，因为 <code>2</code> 和 <code>9</code> 互质，而在下标 <code>i = 1</code> 处的分割无效，因为 <code>6</code> 和 <code>3</code> 不互质。在下标 <code>i = 2</code> 处的分割也无效，因为 <code>i == n - 1</code> 。</li>
</ul>

<p>返回可以有效分割数组的最小下标 <code>i</code> ，如果不存在有效分割，则返回 <code>-1</code> 。</p>

<p>当且仅当 <code>gcd(val1, val2) == 1</code> 成立时，<code>val1</code> 和 <code>val2</code> 这两个值才是互质的，其中 <code>gcd(val1, val2)</code> 表示 <code>val1</code> 和 <code>val2</code> 的最大公约数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/12/14/second.PNG" style="width: 450px; height: 211px;" /></p>

<pre>
<strong>输入：</strong>nums = [4,7,8,15,3,5]
<strong>输出：</strong>2
<strong>解释：</strong>上表展示了每个下标 i 处的前 i + 1 个元素的乘积、剩余元素的乘积和它们的最大公约数的值。
唯一一个有效分割位于下标 2 。</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2022/12/14/capture.PNG" style="width: 450px; height: 215px;" /></p>

<pre>
<strong>输入：</strong>nums = [4,7,15,8,3,5]
<strong>输出：</strong>-1
<strong>解释：</strong>上表展示了每个下标 i 处的前 i + 1 个元素的乘积、剩余元素的乘积和它们的最大公约数的值。
不存在有效分割。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findValidSplit(self, nums: List[int]) -> int:
        def f(x, i):
            if x not in left:
                left[x] = i
            else:
                right[left[x]] = i

        left = dict()
        right = [0] * len(nums)

        for i, v in enumerate(nums):
            d = 2
            while d * d <= v:
                if not v % d:
                    f(d, i)
                    while not v % d:
                        v //= d
                d += 1
            if v > 1:
                f(v, i)

        mr = 0
        for l, r in enumerate(right):
            if l > mr:
                return mr
            mr = max(mr, r)
        return -1
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Map<Integer, Integer> left = new HashMap<>();
    int[] right;

    public void f(int x, int i) {
        if (!left.containsKey(x)) {
            left.put(x, i);
        } else {
            right[left.get(x)] = i;
        }
    }

    public int findValidSplit(int[] nums) {
        int n = nums.length;
        right = new int[n];

        for (int i = 0; i < n; i++) {
            int d = 2;
            while (d * d <= nums[i]) {
                if (nums[i] % d == 0) {
                    f(d, i);
                    while (nums[i] % d == 0) {
                        nums[i] /= d;
                    }
                }
                d++;
            }
            if (nums[i] > 1) {
                f(nums[i], i);
            }
        }

        int mr = 0;
        for (int i = 0; i < n; i++) {
            int l = i, r = right[i];
            if (l > mr) {
                return mr;
            }
            mr = Math.max(r, mr);
        }
        return -1;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
