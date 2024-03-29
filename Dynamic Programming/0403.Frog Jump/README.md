# [403. 青蛙过河](https://leetcode-cn.com/problems/frog-jump)



## 题目描述

<!-- 这里写题目描述 -->

<p>一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。</p>

<p>给你石子的位置列表 <code>stones</code>（用单元格序号 <strong>升序</strong> 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。</p>

<p>开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。</p>

<p>如果青蛙上一步跳跃了 <code>k</code><em> </em>个单位，那么它接下来的跳跃距离只能选择为 <code>k - 1</code>、<code>k</code><em> </em>或 <code>k + 1</code> 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>stones = [0,1,3,5,6,8,12,17]
<strong>输出：</strong>true
<strong>解释：</strong>青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>stones = [0,1,2,3,4,8,9,11]
<strong>输出：</strong>false
<strong>解释：</strong>这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 <= stones.length <= 2000</code></li>
	<li><code>0 <= stones[i] <= 2<sup>31</sup> - 1</code></li>
	<li><code>stones[0] == 0</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def canCross(self, stones: List[int]) -> bool:
        @cache
        def dfs(pos, k):
            if pos == t:
                return True
            for i in range(-1, 2, 1):
                nx = pos + k + i
                if nx not in s:
                    continue
                if nx <= pos:
                    continue
                if dfs(nx, k + i):
                    return True
            return False
        
        t = stones[-1]
        s = set(stones)
        return dfs(0, 0)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Map<String, Boolean> f;
    Set<Integer> s;
    int t;

    public boolean canCross(int[] stones) {
        f = new HashMap<>();
        s = new HashSet<>(Arrays.stream(stones).boxed().collect(Collectors.toList()));
        t = stones[stones.length - 1];
        return dfs(0, 0);
    }

    public boolean dfs(int pos, int k) {
        String key = pos + ":" + k;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        if (pos == t) {
            return true;
        }
        boolean ans = false;
        for (int i = -1; i <= 1; i++) {
            int nx = pos + k + i;
            if (nx <= pos || !s.contains(nx)) {
                continue;
            }
            ans = ans || dfs(nx, k + i);
        }
        f.put(key, ans);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
