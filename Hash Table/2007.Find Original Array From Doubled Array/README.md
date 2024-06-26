# [2007. 从双倍数组中还原原数组](https://leetcode-cn.com/problems/find-original-array-from-doubled-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>一个整数数组&nbsp;<code>original</code>&nbsp;可以转变成一个 <strong>双倍</strong>&nbsp;数组&nbsp;<code>changed</code>&nbsp;，转变方式为将 <code>original</code>&nbsp;中每个元素 <strong>值乘以 2 </strong>加入数组中，然后将所有元素 <strong>随机打乱</strong>&nbsp;。</p>

<p>给你一个数组&nbsp;<code>changed</code>&nbsp;，如果&nbsp;<code>change</code>&nbsp;是&nbsp;<strong>双倍</strong>&nbsp;数组，那么请你返回&nbsp;<code>original</code>数组，否则请返回空数组。<code>original</code>&nbsp;的元素可以以&nbsp;<strong>任意</strong>&nbsp;顺序返回。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>changed = [1,3,4,2,6,8]
<b>输出：</b>[1,3,4]
<b>解释：</b>一个可能的 original 数组为 [1,3,4] :
- 将 1 乘以 2 ，得到 1 * 2 = 2 。
- 将 3 乘以 2 ，得到 3 * 2 = 6 。
- 将 4 乘以 2 ，得到 4 * 2 = 8 。
其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>changed = [6,3,0,1]
<b>输出：</b>[]
<b>解释：</b>changed 不是一个双倍数组。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>changed = [1]
<b>输出：</b>[]
<b>解释：</b>changed 不是一个双倍数组。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= changed.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= changed[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        n = len(changed)
        if n % 2:
            return []
        changed.sort()
        g = defaultdict(int)
        for v in changed:
            g[v] += 1
        ans = []
        for v in changed:
            if not g[v]:
                continue
            if not g[v * 2]:
                return []
            g[v * 2] -= 1
            g[v] -= 1
            ans.append(v)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) {
            return new int[0];
        }
        Map<Integer, Integer> g = new HashMap<>();
        for (int v : changed) {
            g.put(v, g.getOrDefault(v, 0) + 1);
        }
        Arrays.sort(changed);
        int[] ans = new int[n / 2];
        int i = 0;
        for (int v : changed) {
            if (g.getOrDefault(v, 0) == 0) {
                continue;
            }
            if (g.getOrDefault(v * 2, 0) < 1) {
                return new int[0];
            }
            g.put(v, g.get(v) - 1);
            g.put(2 * v, g.get(2 * v) - 1);
            ans[i++] = v;
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
