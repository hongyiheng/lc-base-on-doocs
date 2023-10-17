# [2653. 滑动子数组的美丽值](https://leetcode-cn.com/problems/sliding-subarray-beauty)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>n</code>&nbsp;的整数数组&nbsp;<code>nums</code>&nbsp;，请你求出每个长度为&nbsp;<code>k</code>&nbsp;的子数组的 <b>美丽值</b>&nbsp;。</p>

<p>一个子数组的 <strong>美丽值</strong>&nbsp;定义为：如果子数组中第 <code>x</code>&nbsp;<strong>小整数</strong>&nbsp;是 <strong>负数</strong>&nbsp;，那么美丽值为第 <code>x</code>&nbsp;小的数，否则美丽值为 <code>0</code>&nbsp;。</p>

<p>请你返回一个包含<em>&nbsp;</em><code>n - k + 1</code>&nbsp;个整数的数组，<strong>依次</strong>&nbsp;表示数组中从第一个下标开始，每个长度为&nbsp;<code>k</code>&nbsp;的子数组的<strong>&nbsp;美丽值</strong>&nbsp;。</p>

<ul>
	<li>
	<p>子数组指的是数组中一段连续 <strong>非空</strong>&nbsp;的元素序列。</p>
	</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [1,-1,-3,-2,3], k = 3, x = 2
<b>输出：</b>[-1,-2,-2]
<b>解释：</b>总共有 3 个 k = 3 的子数组。
第一个子数组是 <code>[1, -1, -3]</code> ，第二小的数是负数 -1 。
第二个子数组是 <code>[-1, -3, -2]</code> ，第二小的数是负数 -2 。
第三个子数组是 <code>[-3, -2, 3]&nbsp;，第二小的数是负数 -2 。</code></pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [-1,-2,-3,-4,-5], k = 2, x = 2
<b>输出：</b>[-1,-2,-3,-4]
<b>解释：</b>总共有 4 个 k = 2 的子数组。
<code>[-1, -2] 中第二小的数是负数 -1 。</code>
<code>[-2, -3] 中第二小的数是负数 -2 。</code>
<code>[-3, -4] 中第二小的数是负数 -3 。</code>
<code>[-4, -5] 中第二小的数是负数 -4 。</code></pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>nums = [-3,1,2,-3,0,-3], k = 2, x = 1
<b>输出：</b>[-3,0,-3,-3,-3]
<b>解释：</b>总共有 5 个 k = 2 的子数组。
<code>[-3, 1] 中最小的数是负数 -3 。</code>
<code>[1, 2] 中最小的数不是负数，所以美丽值为 0 。</code>
<code>[2, -3] 中最小的数是负数 -3 。</code>
<code>[-3, 0] 中最小的数是负数 -3 。</code>
<code>[0, -3] 中最小的数是负数 -3 。</code></pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == nums.length&nbsp;</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= n</code></li>
	<li><code>1 &lt;= x &lt;= k&nbsp;</code></li>
	<li><code>-50&nbsp;&lt;= nums[i] &lt;= 50&nbsp;</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def getSubarrayBeauty(self, nums: List[int], k: int, x: int) -> List[int]:
        def getXMin():
            t = x
            for i, v in enumerate(cnt):
                if v >= t:
                    return i - 50 if i <= 50 else 0
                t -= v
            return 0
            
        ans = []
        l = r = 0
        cnt = [0] * 110
        while r < len(nums):
            cnt[nums[r] + 50] += 1
            if r - l + 1 == k:
                ans.append(getXMin())
                cnt[nums[l] + 50] -= 1
                l += 1
            r += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int getXMin(int[]cnt, int x) {
        int t = x;
        for (int i = 0; i < 110; i++) {
            if (cnt[i] >= t) {
                return i <= 50 ? i - 50 : 0;
            }
            t -= cnt[i];
        }
        return 0;
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] cnt = new int[110];
        int l = 0, r = 0;
        while (r < n) {
            cnt[nums[r] + 50]++;
            if (r - l + 1 == k) {
                ans[l] = getXMin(cnt, x);
                cnt[nums[l] + 50]--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
