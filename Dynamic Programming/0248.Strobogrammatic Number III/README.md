# [248. 中心对称数 III](https://leetcode-cn.com/problems/strobogrammatic-number-iii)



## 题目描述

<!-- 这里写题目描述 -->

<p>中心对称数是指一个数字在旋转了&nbsp;180 度之后看起来依旧相同的数字（或者上下颠倒地看）。</p>

<p>写一个函数来计算范围在 [low, high] 之间中心对称数的个数。</p>

<p><strong>示例:</strong></p>

<pre><strong>输入:</strong> low = &quot;50&quot;, high = &quot;100&quot;
<strong>输出:</strong> 3 
<strong>解释: </strong>69，88 和 96 是三个在该范围内的中心对称数</pre>

<p><strong>注意:</strong><br>
由于范围可能很大，所以 low 和 high 都用字符串表示。</p>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def strobogrammaticInRange(self, low: str, high: str) -> int:
        m, n = len(low), len(high)
        dp = [list()] * (n + 2)
        dp[1] = ["0", "1", "8"]
        dp[2] = ["00", "11", "69", "88", "96"]
        idx = 3
        while idx <= n:
            tmp = []
            for s in dp[idx - 2]:
                tmp.append("0" + s + "0")
                tmp.append("1" + s + "1")
                tmp.append("6" + s + "9")
                tmp.append("8" + s + "8")
                tmp.append("9" + s + "6")
            dp[idx] = tmp
            idx += 1
        low_num, high_num = int(low), int(high)
        ans = 0
        while m <= n:
            for s in dp[m]:
                if len(s) > 1 and s[0] == '0':
                    continue
                num = int(s)
                if low_num <= num <= high_num:
                    ans += 1
            m += 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int m = low.length(), n = high.length();
        List<String>[] dp = new List[n + 2];
        dp[1] = Arrays.asList(new String[]{"0", "1", "8"});
        dp[2] = Arrays.asList(new String[]{"11", "69", "88", "96", "00"});
        int idx = 2;
        while (++idx <= n) {
            List<String> tmp = new ArrayList<>();
            for (String s : dp[idx - 2]) {
                tmp.add("0" + s + "0");
                tmp.add("1" + s + "1");
                tmp.add("6" + s + "9");
                tmp.add("8" + s + "8");
                tmp.add("9" + s + "6");
            }
            dp[idx] = tmp;
        }
        int ans = 0;
        long lowNum = Long.parseLong(low), highNum = Long.parseLong(high);
        while (m <= n) {
            for (String s : dp[m]) {
                if (s.length() > 1 && s.charAt(0) == '0') {
                    continue;
                }
                long num = Long.parseLong(s);
                if (lowNum <= num && highNum >= num) {
                    ans++;
                }
            }
            m++;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
