# [756. 金字塔转换矩阵](https://leetcode-cn.com/problems/pyramid-transition-matrix)



## 题目描述

<!-- 这里写题目描述 -->

<p>现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示。</p>

<p>使用三元组表示金字塔的堆砌规则如下：</p>

<p>对于三元组 <code>ABC</code> ，<code>C</code> 为顶层方块，方块 <code>A</code> 、<code>B</code> 分别作为方块 <code>C</code> 下一层的的左、右子块。当且仅当 <code>ABC</code> 是被允许的三元组，我们才可以将其堆砌上。</p>

<p>初始时，给定金字塔的基层 <code>bottom</code>，用一个字符串表示。一个允许的三元组列表 <code>allowed</code>，每个三元组用一个长度为 3 的字符串表示。</p>

<p>如果可以由基层一直堆到塔尖就返回 <code>true</code> ，否则返回 <code>false</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
<strong>输出：</strong>true
<strong>解释：</strong>
可以堆砌成这样的金字塔:
    A
   / \
  G   E
 / \ / \
B   C   D

因为符合 BCG、CDE 和 GEA 三种规则。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
<strong>输出：</strong>false
<strong>解释：</strong>
无法一直堆到塔尖。
注意, 允许存在像 ABC 和 ABD 这样的三元组，其中 C != D。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>bottom</code> 的长度范围在 <code>[2, 8]</code>。</li>
	<li><code>allowed</code> 的长度范围在<code>[0, 200]</code>。</li>
	<li>方块的标记字母范围为<code>{'A', 'B', 'C', 'D', 'E', 'F', 'G'}</code>。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        mp = defaultdict(list)
        for a, b, c in allowed:
            mp[(a, b)].append(c)

        @cache
        def dfs(row, cur):
            if len(row) == 1:
                return True
            if len(cur) + 1 == len(row):
                return dfs(cur, "")
            a, b = row[len(cur)], row[len(cur) + 1]
            for c in mp.get((a, b), []):
                cur += c
                if dfs(row, cur):
                    return True
                cur = cur[:-1]
            return False

        return dfs(bottom, "")
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Map<String, List<String>> mp = new HashMap<>();
    Map<String, Boolean> f = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(s.substring(2));
        }
        return dfs(bottom, "");
    }

    public boolean dfs(String row, String cur) {
        if (f.containsKey(row + cur)) {
            return f.get(row + cur);
        }
        if (row.length() == 1) {
            return true;
        }
        if (cur.length() + 1 == row.length()) {
            return dfs(cur, "");
        }
        for (String c : mp.getOrDefault(row.substring(cur.length(), cur.length() + 2), new ArrayList<>())) {
            if (dfs(row, cur + c)) {
                return true;
            }
        }
        f.put(row + cur, false);
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
