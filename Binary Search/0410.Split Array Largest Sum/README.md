# [410. 分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个非负整数数组 <code>nums</code> 和一个整数 <code>m</code> ，你需要将这个数组分成 <code>m</code><em> </em>个非空的连续子数组。</p>

<p>设计一个算法使得这 <code>m</code><em> </em>个子数组各自和的最大值最小。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [7,2,5,10,8], m = 2
<strong>输出：</strong>18
<strong>解释：</strong>
一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4,5], m = 2
<strong>输出：</strong>9
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,4,4], m = 3
<strong>输出：</strong>4
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 1000</code></li>
	<li><code>0 <= nums[i] <= 10<sup>6</sup></code></li>
	<li><code>1 <= m <= min(50, nums.length)</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        def check(x):
            nonlocal nums, m
            cnt = cur = 0
            for v in nums:
                if v > x:
                    return False
                cur += v
                if cur > x:
                    cur = v
                    cnt += 1
            return cnt + 1 <= m

        left, right = 0, sum(nums)
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
    int m;
    int[] nums;

    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        this.m = m;
        long left = 0, right = 0;
        for (int v : nums) {
            right = right + v;
        }
        while (left < right) {
            long mid = (left + right) >>> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int)left;
    }

    public boolean check(long x) {
        long cnt = 0, cur = 0;
        for (int v : nums) {
            if (v > x) {
                return false;
            }
            cur = cur + v;
            if (cur > x) {
                cur = v;
                cnt++;
            }
        }
        return cnt + 1 <= m;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
