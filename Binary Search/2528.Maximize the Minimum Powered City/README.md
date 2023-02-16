# [2528. 最大化城市的最小供电站数目](https://leetcode-cn.com/problems/maximize-the-minimum-powered-city)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个下标从 <strong>0</strong>&nbsp;开始长度为 <code>n</code>&nbsp;的整数数组&nbsp;<code>stations</code>&nbsp;，其中&nbsp;<code>stations[i]</code>&nbsp;表示第 <code>i</code>&nbsp;座城市的供电站数目。</p>

<p>每个供电站可以在一定 <strong>范围</strong>&nbsp;内给所有城市提供电力。换句话说，如果给定的范围是&nbsp;<code>r</code>&nbsp;，在城市&nbsp;<code>i</code>&nbsp;处的供电站可以给所有满足&nbsp;<code>|i - j| &lt;= r</code> 且&nbsp;<code>0 &lt;= i, j &lt;= n - 1</code>&nbsp;的城市&nbsp;<code>j</code>&nbsp;供电。</p>

<ul>
	<li><code>|x|</code>&nbsp;表示 <code>x</code>&nbsp;的 <strong>绝对值</strong>&nbsp;。比方说，<code>|7 - 5| = 2</code>&nbsp;，<code>|3 - 10| = 7</code>&nbsp;。</li>
</ul>

<p>一座城市的 <strong>电量</strong>&nbsp;是所有能给它供电的供电站数目。</p>

<p>政府批准了可以额外建造 <code>k</code>&nbsp;座供电站，你需要决定这些供电站分别应该建在哪里，这些供电站与已经存在的供电站有相同的供电范围。</p>

<p>给你两个整数&nbsp;<code>r</code> 和&nbsp;<code>k</code>&nbsp;，如果以最优策略建造额外的发电站，返回所有城市中，最小供电站数目的最大值是多少。</p>

<p>这 <code>k</code>&nbsp;座供电站可以建在多个城市。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>stations = [1,2,4,5,0], r = 1, k = 2
<b>输出：</b>5
<b>解释：</b>
最优方案之一是把 2 座供电站都建在城市 1 。
每座城市的供电站数目分别为 [1,4,4,5,0] 。
- 城市 0 的供电站数目为 1 + 4 = 5 。
- 城市 1 的供电站数目为 1 + 4 + 4 = 9 。
- 城市 2 的供电站数目为 4 + 4 + 5 = 13 。
- 城市 3 的供电站数目为 5 + 4 = 9 。
- 城市 4 的供电站数目为 5 + 0 = 5 。
供电站数目最少是 5 。
无法得到更优解，所以我们返回 5 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>stations = [4,4,4,4], r = 0, k = 3
<b>输出：</b>4
<b>解释：</b>
无论如何安排，总有一座城市的供电站数目是 4 ，所以最优解是 4 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == stations.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= stations[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= r&nbsp;&lt;= n - 1</code></li>
	<li><code>0 &lt;= k&nbsp;&lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxPower(self, stations: List[int], r: int, k: int) -> int:
        def check(arr, r, t, k):
            nonlocal n
            cur = sum(arr[:r + 1])
            left, right = 0, r
            for _ in range(n):
                if cur < t:
                    if t - cur > k:
                        return False
                    arr[min(right, n - 1)] += (t - cur)
                    k -= (t - cur)
                    cur = t
                right += 1
                if right < n:
                    cur += arr[right]
                if right - left + 1 > 2 * r + 1:
                    cur -= arr[left]
                    left += 1
            return True

        n = len(stations)
        left, right = 0, 0x3f3f3f3f3f3f
        while left < right:
            mid = (left + right + 1) >> 1
            if check(stations[::], r, mid, k):
                left = mid
            else:
                right = mid - 1
        return left
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long left = 0, right = 0x3f3f3f3f3fL;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            if (check(stations.clone(), r, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int r, int k, long t) {
        int n = nums.length;
        long cur = 0;
        for (int i = 0; i <= r; i++) {
            cur += nums[i];
        }
        int left = 0, right = r;
        for (int i = 0; i < n; i++) {
            if (cur < t) {
                long diff = t - cur;
                if (diff > k) {
                    return false;
                }
                nums[Math.min(right, n - 1)] += diff;
                k -= diff;
                cur = t;
            }
            if (++right < n) {
                cur += nums[right];
            }
            if (right - left + 1 > 2 * r + 1) {
                cur -= nums[left++];
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
