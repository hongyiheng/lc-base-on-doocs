# [473. 火柴拼正方形](https://leetcode-cn.com/problems/matchsticks-to-square)



## 题目描述

<!-- 这里写题目描述 -->

<p>还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。</p>

<p>输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> [1,1,2,2,2]
<strong>输出:</strong> true

<strong>解释:</strong> 能拼成一个边长为2的正方形，每边两根火柴。
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> [3,3,3,3,4]
<strong>输出:</strong> false

<strong>解释:</strong> 不能用所有火柴拼成一个正方形。
</pre>

<p><strong>注意:</strong></p>

<ol>
	<li>给定的火柴长度和在&nbsp;<code>0</code>&nbsp;到&nbsp;<code>10^9</code>之间。</li>
	<li>火柴数组的长度不超过15。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        all = sum(matchsticks)
        if all % 4 != 0:
            return False
        t = all // 4
        if max(matchsticks) > t:
            return False
        n = len(matchsticks)
        matchsticks.sort()
        vis = [False] * n

        def dfs(k, target, idx):
            nonlocal t, matchsticks, n
            if target == 0:
                k -= 1
                if k == 0:
                    return True
                else:
                    return dfs(k, t, n - 1)

            for i in range(idx, -1, -1):
                if target < matchsticks[i] or vis[i]:
                    continue
                vis[i] = True
                if dfs(k, target - matchsticks[i], i - 1):
                    return True
                vis[i] = False
                if target == t:
                    return False
            return False
        
        return dfs(4, t, n - 1)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    int t;
    boolean[] vis;
    int n;
    int[] matchsticks;

    public boolean makesquare(int[] matchsticks) {
        this.matchsticks = matchsticks;
        n = matchsticks.length;
        int mx = 0, all = 0;
        for (int v : matchsticks) {
            mx = Math.max(v, mx);
            all += v;
        }
        if (all % 4 != 0) {
            return false;
        }
        t = all / 4;
        if (mx > t) {
            return false;
        }
        Arrays.sort(matchsticks);
        vis = new boolean[n];
        return dfs(t, 4, n - 1);
    }

    public boolean dfs(int target, int k, int idx) {
        if (target == 0) {
            if (--k == 0) {
                return true;
            }
            return dfs(t, k, n -1);
        }
        for (int i = idx; i >= 0; i--) {
            if (matchsticks[i] > target || vis[i]) {
                continue;
            }
            vis[i] = true;
            if (dfs(target - matchsticks[i], k, idx - 1)) {
                return true;
            }
            vis[i] = false;
            if (target == t) {
                return false;
            }
        }
        return false;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
