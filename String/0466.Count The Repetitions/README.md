# [466. 统计重复个数](https://leetcode-cn.com/problems/count-the-repetitions)



## 题目描述

<!-- 这里写题目描述 -->

<p>定义 <code>str = [s, n]</code> 表示 <code>str</code> 由 <code>n</code> 个字符串 <code>s</code> 连接构成。</p>

<ul>
	<li>例如，<code>str == ["abc", 3] =="abcabcabc"</code> 。</li>
</ul>

<p>如果可以从 <code>s2</code><sub> </sub>中删除某些字符使其变为 <code>s1</code>，则称字符串 <code>s1</code><sub> </sub>可以从字符串 <code>s2</code> 获得。</p>

<ul>
	<li>例如，根据定义，<code>s1 = "abc"</code> 可以从 <code>s2 = "ab<em><strong>dbe</strong></em>c"</code> 获得，仅需要删除加粗且用斜体标识的字符。</li>
</ul>

<p>现在给你两个字符串 <code>s1</code> 和 <code>s2</code> 和两个整数 <code>n1</code> 和 <code>n2</code> 。由此构造得到两个字符串，其中 <code>str1 = [s1, n1]</code>、<code>str2 = [s2, n2]</code> 。</p>

<p>请你找出一个最大整数 <code>m</code> ，以满足 <code>str = [str2, m]</code> 可以从 <code>str1</code> 获得。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s1 = "acb", n1 = 4, s2 = "ab", n2 = 2
<strong>输出：</strong>2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s1 = "acb", n1 = 1, s2 = "acb", n2 = 1
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s1.length, s2.length <= 100</code></li>
	<li><code>s1</code> 和 <code>s2</code> 由小写英文字母组成</li>
	<li><code>1 <= n1, n2 <= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def getMaxRepetitions(self, s1: str, n1: int, s2: str, n2: int) -> int:
        m, n = len(s1), len(s2)
        if m * n1 < n * n2:
            return 0
        i = j = 0
        ids = dict()
        while i < m * n1:
            if s1[i % m] == s2[j % n]:
                j += 1
                i += 1
                if not j % n:
                    if i % m in ids:
                        last_i, last_j = ids[i % m]
                        i_d = i - last_i
                        j_d = j - last_j
                        if i_d and (m * n1 - i) // i_d:
                            v = (m * n1 - i) // i_d
                            i += i_d * v
                            j += j_d * v
                    else:
                        ids[i % m] = (i, j)
            else:
                i += 1
        return j // n // n2
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int m = s1.length(), n = s2.length();
        int i = 0, j = 0;
        Map<Integer, int[]> ids = new HashMap<>();
        while (i < m * n1) {
            if (s1.charAt(i % m) == s2.charAt(j % n)) {
                i++;
                j++;
                if (j % n == 0) {
                    if (ids.containsKey(i % m)) {
                        int[] last = ids.get(i % m);
                        int iDist = i - last[0], jDist = j - last[1];
                        int v = (m * n1 - i) / iDist;
                        i += v * iDist;
                        j += v * jDist;
                    } else {
                        ids.put((i % m), new int[]{i, j});
                    }
                }
            } else {
                i++;
            }
        }
        return j / n / n2;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
