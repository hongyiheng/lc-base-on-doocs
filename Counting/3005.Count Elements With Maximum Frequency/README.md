# [3005. 最大频率元素计数](https://leetcode.cn/problems/count-elements-with-maximum-frequency)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由 <strong>正整数 </strong>组成的数组 <code>nums</code> 。</p>

<p>返回数组 <code>nums</code> 中所有具有 <strong>最大 </strong>频率的元素的 <strong>总频率 </strong>。</p>

<p>元素的 <strong>频率 </strong>是指该元素在数组中出现的次数。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,2,3,1,4]
<strong>输出：</strong>4
<strong>解释：</strong>元素 1 和 2 的频率为 2 ，是数组中的最大频率。
因此具有最大频率的元素在数组中的数量是 4 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4,5]
<strong>输出：</strong>5
<strong>解释：</strong>数组中的所有元素的频率都为 1 ，是最大频率。
因此具有最大频率的元素在数组中的数量是 5 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        cnt = [0] * 26
        for c in word:
            cnt[ord(c) - ord('a')] += 1
        ans = n = len(word)
        for x in cnt:
            c = 0
            for v in cnt:
                if v >= x:
                    c += min(x + k, v)
            ans = min(ans, n - c)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public int minimumDeletions(String word, int k) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        int n = word.length();
        int ans = n;
        for (int x : cnt) {
            int c = 0;
            for (int v : cnt) {
                if (v >= x) {
                    c += Math.min(x + k, v);
                }  
            }
            ans = Math.min(ans, n - c);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
