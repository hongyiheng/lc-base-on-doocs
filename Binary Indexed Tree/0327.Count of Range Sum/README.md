# [327. 区间和的个数](https://leetcode-cn.com/problems/count-of-range-sum)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> 以及两个整数 <code>lower</code> 和 <code>upper</code> 。求数组中，值位于范围 <code>[lower, upper]</code> （包含 <code>lower</code> 和 <code>upper</code>）之内的 <strong>区间和的个数</strong> 。</p>

<p><strong>区间和</strong> <code>S(i, j)</code> 表示在 <code>nums</code> 中，位置从 <code>i</code> 到 <code>j</code> 的元素之和，包含 <code>i</code> 和 <code>j</code> (<code>i</code> ≤ <code>j</code>)。</p>

<p> </p>
<strong>示例 1：</strong>

<pre>
<strong>输入：</strong>nums = [-2,5,-1], lower = -2, upper = 2
<strong>输出：</strong>3
<strong>解释：</strong>存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0], lower = 0, upper = 0
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1</code></li>
	<li><code>-10<sup>5</sup> <= lower <= upper <= 10<sup>5</sup></code></li>
	<li>题目数据保证答案是一个 <strong>32 位</strong> 的整数</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        def lowbit(x):
            return x & -x
        
        def query(x):
            ans = 0
            while x > 0:
                ans += self.tree[x]
                x -= lowbit(x)
            return ans
        
        def add(x, incr):
            while x < len(self.tree):
                self.tree[x] += incr
                x += lowbit(x)
        
        n = len(nums)
        pre = [0] * (n + 1)
        for i, v in enumerate(nums, 1):
            pre[i] = pre[i - 1] + nums[i - 1]
        s = set()
        for v in pre:
            s.add(v)
            s.add(v - upper)
            s.add(v - lower)
        mp = dict()
        idx = 1
        for v in sorted(s):
            mp[v] = idx
            idx += 1
        self.tree = [0] * (len(mp) + 1)
        ans = 0
        for v in pre:
            l, r = mp[v - upper] - 1, mp[v - lower]
            ans += query(r) - query(l)
            add(mp[v], 1)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    long[] tree;
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        TreeSet<Long> ts = new TreeSet<>();
        for (long s : pre) {
            ts.add(s);
            ts.add(s - upper);
            ts.add(s - lower);
        }
        Map<Long, Integer> mp = new HashMap<>();
        int idx = 1;
        for (long s : ts) {
            mp.put(s, idx++);
        }
        tree = new long[mp.size() + 1];
        int ans = 0;
        for (long s : pre) {
            int l = mp.get(s - upper) - 1;
            int r = mp.get(s - lower);
            ans += query(r) - query(l);
            add(mp.get(s), 1);
        }
        return ans;    
    }

    public int lowbit(int x) {
        return x & -x;
    }

    public int query(int x) {
        int ans = 0;
        while (x > 0) {
            ans += tree[x];
            x -= lowbit(x);
        }
        return ans;
    }

    public void add(int x, int incr) {
        while (x < tree.length) {
            tree[x] += incr;
            x += lowbit(x);
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->
