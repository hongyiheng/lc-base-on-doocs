# [3300. 替换为数位和以后的最小元素](https://leetcode.cn/problems/minimum-element-after-replacement-with-digit-sum)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组&nbsp;<code>nums</code>&nbsp;。</p>

<p>请你将 <code>nums</code>&nbsp;中每一个元素都替换为它的各个数位之 <strong>和</strong>&nbsp;。</p>

<p>请你返回替换所有元素以后 <code>nums</code>&nbsp;中的 <strong>最小</strong>&nbsp;元素。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [10,12,13,14]</span></p>

<p><span class="example-io"><b>输出：</b>1</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code>&nbsp;替换后变为&nbsp;<code>[1, 3, 4, 5]</code>&nbsp;，最小元素为 1 。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [1,2,3,4]</span></p>

<p><span class="example-io"><b>输出：</b>1</span></p>

<p><b>解释：</b></p>

<p><code>nums</code>&nbsp;替换后变为&nbsp;<code>[1, 2, 3, 4]</code>&nbsp;，最小元素为 1 。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><span class="example-io"><b>输入：</b>nums = [999,19,199]</span></p>

<p><span class="example-io"><b>输出：</b>10</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code>&nbsp;替换后变为&nbsp;<code>[27, 10, 19]</code>&nbsp;，最小元素为 10 。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def countOfSubstrings(self, word: str, k: int) -> int:
        n = len(word)
        ans = 0
        for i in range(n):
            g = defaultdict(int)
            t = 0
            for j in range(i, n):
                c = word[j]
                if c in {'a', 'e', 'i', 'o', 'u'}:
                    g[c] += 1
                else:
                    t += 1
                if len(g.keys()) == 5 and t == k:
                    ans += 1
                if t > k:
                    break
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int countOfSubstrings(String word, int k) {
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int n = word.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> s = new HashSet<>();
            int t = 0;
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (vowel.contains(c)) {
                    s.add(c);
                } else {
                    t++;
                }
                if (s.size() == 5 && t == k) {
                    ans++;
                }
                if (t > k) {
                    break;
                }
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
