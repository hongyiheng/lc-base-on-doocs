# [247. 中心对称数 II](https://leetcode-cn.com/problems/strobogrammatic-number-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>中心对称数是指一个数字在旋转了&nbsp;180 度之后看起来依旧相同的数字（或者上下颠倒地看）。</p>

<p>找到所有长度为 n 的中心对称数。</p>

<p><strong>示例</strong> <strong>:</strong></p>

<pre><strong>输入:</strong>  n = 2
<strong>输出:</strong> <code>[&quot;11&quot;,&quot;69&quot;,&quot;88&quot;,&quot;96&quot;]</code>
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findStrobogrammatic(self, n: int) -> List[str]:
        dp = [list()] * (n + 2)
        dp[1] = ["0", "1", "8"]
        dp[2] = ["11", "69", "88", "96", "00"]
        idx = 2
        while idx < n:
            idx += 1
            tmp = list()
            for s in dp[idx - 2]:
                tmp.append("6" + s + "9")
                tmp.append("9" + s + "6")
                tmp.append("8" + s + "8")
                tmp.append("1" + s + "1")
                tmp.append("0" + s + "0")
            dp[idx] = tmp
        dp[2] = ["11", "69", "88", "96"]
        if n > 2:
            tmp = list()
            for s in dp[n]:
                if s[0] != '0':
                    tmp.append(s)
            dp[n] = tmp
        return dp[n]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String>[] dp = new List[n + 2];
        dp[1] = Arrays.asList(new String[]{"8", "1", "0"});
        dp[2] = Arrays.asList(new String[]{"11","69","88","96", "00"});
        int idx = 2;
        while (idx++ < n) {
            List<String> tmp = new ArrayList<>();
            for (String s : dp[idx - 2]) {
                tmp.add("6" + s + "9");
                tmp.add("9" + s + "6");
                tmp.add("8" + s + "8");
                tmp.add("1" + s + "1");
                tmp.add("0" + s + "0");
            }
            dp[idx] = tmp;
        }
        dp[2] = Arrays.asList(new String[]{"11","69","88","96"});
        if (n > 2) {
            List<String> tmp = new ArrayList<>();
            for (String s : dp[n]) {
                if (s.charAt(0) != '0') {
                    tmp.add(s);
                }
            }
            dp[n] = tmp;
        }
        return dp[n];
    }
}
```

### **...**

```

```

<!-- tabs:end -->
