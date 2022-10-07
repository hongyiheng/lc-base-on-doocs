# [593. 有效的正方形](https://leetcode-cn.com/problems/valid-square)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。</p>

<p>一个点的坐标（x，y）由一个有两个整数的整数数组表示。</p>

<p><strong>示例:</strong></p>

<pre>
<strong>输入:</strong> p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
<strong>输出:</strong> True
</pre>

<p>&nbsp;</p>

<p><strong>注意:</strong></p>

<ol>
	<li>所有输入整数都在 [-10000，10000] 范围内。</li>
	<li>一个有效的正方形有四个等长的正长和四个等角（90度角）。</li>
	<li>输入点没有顺序。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        def get_dist(a, b):
            return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1])
        
        ps = [p1, p2, p3, p4]
        mp = dict()
        l = float('inf')    
        for i in range(4):
            for j in range(i + 1, 4):
                dist = get_dist(ps[i], ps[j])
                l = min(l, dist)
                mp[dist] = mp.get(dist, 0) + 1
        return len(mp) == 2 and mp[l] == 4
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] ps = new int[][]{p1, p2, p3, p4};
        Map<Integer, Integer> mp = new HashMap<>();
        int l = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int dist = getDist(ps[i], ps[j]);
                l = Math.min(l, dist);
                mp.put(dist, mp.getOrDefault(dist, 0) + 1);
            }
        }
        return mp.size() == 2 && mp.get(l) == 4;
    }

    public int getDist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
