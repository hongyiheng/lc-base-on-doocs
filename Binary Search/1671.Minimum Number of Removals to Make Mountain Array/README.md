# [1671. 得到山形数组的最少删除次数](https://leetcode-cn.com/problems/minimum-number-of-removals-to-make-mountain-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>我们定义 <code>arr</code> 是 <b>山形数组</b> 当且仅当它满足：</p>

<ul>
	<li><code>arr.length &gt;= 3</code></li>
	<li>存在某个下标 <code>i</code> （<strong>从 0 开始</strong>） 满足 <code>0 &lt; i &lt; arr.length - 1</code> 且：
	<ul>
		<li><code>arr[0] &lt; arr[1] &lt; ... &lt; arr[i - 1] &lt; arr[i]</code></li>
		<li><code>arr[i] &gt; arr[i + 1] &gt; ... &gt; arr[arr.length - 1]</code></li>
	</ul>
	</li>
</ul>

<p>给你整数数组 <code>nums</code>​ ，请你返回将 <code>nums</code> 变成 <strong>山形状数组</strong> 的​ <strong>最少</strong> 删除次数。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [1,3,1]
<b>输出：</b>0
<b>解释：</b>数组本身就是山形数组，所以我们不需要删除任何元素。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [2,1,1,5,6,2,3,1]
<b>输出：</b>3
<b>解释：</b>一种方法是将下标为 0，1 和 5 的元素删除，剩余元素为 [1,5,6,3,1] ，是山形数组。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>nums = [4,3,2,1,1,2,3,1]
<b>输出：</b>4
</pre>

<p><strong>提示：</strong></p>

<pre><b>输入：</b>nums = [1,2,3,4,4,3,2,1]
<b>输出：</b>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li>题目保证 <code>nums</code> 删除一些元素后一定能得到山形数组。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumMountainRemovals(self, nums: List[int]) -> int:
        n = len(nums)
        suf = [0] * n
        g = []
        for i in range(n - 1, 0, -1):
            x = nums[i]
            j = bisect_left(g, x)
            if j == len(g):
                g.append(x)
            else:
                g[j] = x
            suf[i] = j + 1

        mx = 0 
        g = []
        for i, x in enumerate(nums):
            j = bisect_left(g, x)
            if j == len(g):
                g.append(x)
            else:
                g[j] = x
            pre = j + 1 
            if pre >= 2 and suf[i] >= 2:
                mx = max(mx, pre + suf[i] - 1) 
        return n - mx
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            int idx = queryLowBound(q, v);
            if (idx == q.size()) {
                q.add(v);
            } else {
                q.set(idx, v);
            }
            pre[i] = idx + 1;
        }

        int ans = 0;
        q.clear();
        for (int i = n - 1; i > -1; i--) {
            int v = nums[i];
            int idx = queryLowBound(q, v);
            if (idx == q.size()) {
                q.add(v);
            } else {
                q.set(idx, v);
            }
            if (idx + 1 >= 2 && pre[i] >= 2) {
                ans = Math.max(ans, idx + pre[i]);
            }
        }
        return n - ans;
    }

    public int queryLowBound(List<Integer> q, int v) {
        if (q.isEmpty()) {
            return 0;
        }
        int l = 0, r = q.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (q.get(mid) < v) {
                l = mid + 1;
            } else {
                r = mid;
            }  
        }
        return q.get(r) < v ? r + 1 : r;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
