# [1079. 活字印刷](https://leetcode-cn.com/problems/letter-tile-possibilities)



## 题目描述

<!-- 这里写题目描述 -->

<p>你有一套活字字模&nbsp;<code>tiles</code>，其中每个字模上都刻有一个字母&nbsp;<code>tiles[i]</code>。返回你可以印出的非空字母序列的数目。</p>

<p><strong>注意：</strong>本题中，每个活字字模只能使用一次。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>&quot;AAB&quot;
<strong>输出：</strong>8
<strong>解释：</strong>可能的序列为 &quot;A&quot;, &quot;B&quot;, &quot;AA&quot;, &quot;AB&quot;, &quot;BA&quot;, &quot;AAB&quot;, &quot;ABA&quot;, &quot;BAA&quot;。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>&quot;AAABBC&quot;
<strong>输出：</strong>188
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= tiles.length &lt;= 7</code></li>
	<li><code>tiles</code> 由大写英文字母组成</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        def dfs():
            ans = 0
            for k in cnt.keys():
                if cnt[k] > 0:
                    ans += 1
                    cnt[k] -= 1
                    ans += dfs()
                    cnt[k] += 1
            return ans

        cnt = Counter(tiles)
        return dfs()
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    int[] cnt = new int[26];

    public int numTilePossibilities(String tiles) {
        for (char c : tiles.toCharArray()) {
            cnt[c - 'A']++;
        }        
        return dfs();
    }

    public int dfs() {
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                ans++;
                cnt[i]--;
                ans += dfs();
                cnt[i]++;
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
