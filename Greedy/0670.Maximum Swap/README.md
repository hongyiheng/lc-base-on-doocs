# [670. 最大交换](https://leetcode-cn.com/problems/maximum-swap)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个非负整数，你<strong>至多</strong>可以交换一次数字中的任意两位。返回你能得到的最大值。</p>

<p><strong>示例 1 :</strong></p>

<pre>
<strong>输入:</strong> 2736
<strong>输出:</strong> 7236
<strong>解释:</strong> 交换数字2和数字7。
</pre>

<p><strong>示例 2 :</strong></p>

<pre>
<strong>输入:</strong> 9973
<strong>输出:</strong> 9973
<strong>解释:</strong> 不需要交换。
</pre>

<p><strong>注意:</strong></p>

<ol>
	<li>给定数字的范围是&nbsp;[0, 10<sup>8</sup>]</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximumSwap(self, num: int) -> int:
        s = list(str(num))
        n = len(s)
        for i in range(n):
            mx = 0
            for j in range(i + 1, n):
                if int(s[i]) < int(s[j]):
                    if mx == 0 or int(s[mx]) <= int(s[j]):
                        mx = j
            if mx != 0:
                s[i], s[mx] = s[mx], s[i]
                break
        return int("".join(s))
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximumSwap(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            int mx = 0;
            for (int j = i + 1; j < n; j++) {
                if (cs[j] > cs[i]) {
                    if (mx == 0 || cs[mx] <= cs[j]) {
                        mx = j;
                    }
                }
            }
            if (mx != 0) {
                char tmp = cs[i];
                cs[i] = cs[mx];
                cs[mx] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(cs));
    }
}
```

### **...**

```

```

<!-- tabs:end -->
