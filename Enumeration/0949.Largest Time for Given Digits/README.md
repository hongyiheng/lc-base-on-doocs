# [949. 给定数字能组成的最大时间](https://leetcode-cn.com/problems/largest-time-for-given-digits)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。</p>

<p>24 小时格式为 <code>"HH:MM"</code> ，其中 <code>HH</code> 在 <code>00</code> 到 <code>23</code> 之间，<code>MM</code> 在 <code>00</code> 到 <code>59</code> 之间。最小的 24 小时制时间是 <code>00:00</code> ，而最大的是 <code>23:59</code> 。从 00:00 （午夜）开始算起，过得越久，时间越大。</p>

<p>以长度为 5 的字符串，按 <code>"HH:MM"</code> 格式返回答案。如果不能确定有效时间，则返回空字符串。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,2,3,4]
<strong>输出：</strong>"23:41"
<strong>解释：</strong>有效的 24 小时制时间是 "12:34"，"12:43"，"13:24"，"13:42"，"14:23"，"14:32"，"21:34"，"21:43"，"23:14" 和 "23:41" 。这些时间中，"23:41" 是最大时间。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [5,5,5,5]
<strong>输出：</strong>""
<strong>解释：</strong>不存在有效的 24 小时制时间，因为 "55:55" 无效。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>arr = [0,0,0,0]
<strong>输出：</strong>"00:00"
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>arr = [0,0,1,0]
<strong>输出：</strong>"10:00"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>arr.length == 4</code></li>
	<li><code>0 <= arr[i] <= 9</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def largestTimeFromDigits(self, arr: List[int]) -> str:
        def dfs(v, mask):
            nonlocal ans
            if mask == (1 << 4) - 1:
                if v % 100 < 60 and v // 100 < 24:
                    ans = max(ans, v)
                return
            for i in range(4):
                if not mask >> i & 1:
                    dfs(v * 10 + arr[i], mask | 1 << i)
        
        ans = -1
        dfs(0, 0)
        if ans == -1:
            return ""
        h = str(ans // 100) if ans // 100 >= 10 else "0" + str(ans // 100)
        m = str(ans % 100) if ans % 100 >= 10 else "0" + str(ans % 100)
        return h + ":" + m
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int ans;
    int[] arr;

    public void dfs(int v, int mask) {
        if (mask == (1 << 4) - 1) {
            if (v / 100 < 24 && v % 100 < 60) {
                ans = Math.max(ans, v);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            if ((mask >> i & 1) == 0) {
                dfs(v * 10 + arr[i], mask | 1 << i);
            }
        }
    }

    public String largestTimeFromDigits(int[] arr) {
        this.arr = arr;
        ans = -1;
        dfs(0, 0);
        if (ans == -1) {
            return "";
        }
        String h = ans / 100 >= 10 ? String.valueOf(ans / 100) : "0" + ans / 100;
        String m = ans % 100 >= 10 ? String.valueOf(ans % 100) : "0" + ans % 100;
        return h + ":" + m;   
    }
}
```

### **...**

```

```

<!-- tabs:end -->
