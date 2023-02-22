# [1140. 石子游戏 II](https://leetcode-cn.com/problems/stone-game-ii)



## 题目描述

<!-- 这里写题目描述 -->

<p>亚历克斯和李继续他们的石子游戏。许多堆石子&nbsp;<strong>排成一行</strong>，每堆都有正整数颗石子&nbsp;<code>piles[i]</code>。游戏以谁手中的石子最多来决出胜负。</p>

<p>亚历克斯和李轮流进行，亚历克斯先开始。最初，<code>M = 1</code>。</p>

<p>在每个玩家的回合中，该玩家可以拿走剩下的&nbsp;<strong>前</strong>&nbsp;<code>X</code>&nbsp;堆的所有石子，其中&nbsp;<code>1 &lt;= X &lt;= 2M</code>。然后，令&nbsp;<code>M = max(M, X)</code>。</p>

<p>游戏一直持续到所有石子都被拿走。</p>

<p>假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>piles = [2,7,9,4,4]
<strong>输出：</strong>10
<strong>解释：
</strong>如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。 
如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
所以我们返回更大的 10。 
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= piles.length &lt;= 100</code></li>
	<li><code>1 &lt;= piles[i]&nbsp;&lt;= 10 ^ 4</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        tail = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            tail[i] += tail[i + 1] + piles[i]

        @cache
        def dfs(i: int, m: int) -> int:
            if i + m * 2 >= n:
                return tail[i]
            t = 0x3f3f3f3f3f
            for x in range(1, m * 2 + 1):
                t = min(dfs(i + x, max(m, x)), t)
            return tail[i] - t

        return dfs(0, 1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    Map<String, Integer> mp = new HashMap<>();

    int[] tail;

    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        tail = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            tail[i] = tail[i + 1] + piles[i];
        }
        return dfs(0, 1);
    }

    public int dfs(int i, int m) {
        if (i + 2 * m >= n) {
            return tail[i];
        }
        if (mp.containsKey(i + ":" + m)) {
            return mp.get(i + ":" + m);
        }
        int mi = 0x3f3f3f3f;
        for (int x = 1; x <= 2 * m; x++) {
            mi = Math.min(mi, dfs(i + x, Math.max(x, m)));
        }
        mp.put(i + ":" + m, tail[i] - mi);
        return tail[i] - mi;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
