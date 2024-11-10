# [LCP 78. 城墙防线](https://leetcode.cn/problems/Nsibyl)

## 题目描述

<!-- 这里写题目描述 -->

在探险营地间，小扣意外发现了一片城墙遗迹，在探索期间，却不巧遇到迁徙中的兽群向他迎面冲来。情急之下小扣吹响了他的苍蓝笛，随着笛声响起，遗迹中的城墙逐渐发生了横向膨胀。
已知 `rampart[i] = [x,y]` 表示第 `i` 段城墙的初始所在区间。当城墙发生膨胀时，将遵循以下规则：
- 所有的城墙会同时膨胀相等的长度；
- 每个城墙可以向左、向右或向两个方向膨胀。

小扣为了确保自身的安全，需要在所有城墙均无重叠的情况下，让城墙尽可能的膨胀。请返回城墙可以膨胀的 **最大值** 。

**注意：**
- 初始情况下，所有城墙均不重叠，且 `rampart` 中的元素升序排列；
- 两侧的城墙可以向外无限膨胀。

**示例 1：**
>输入：`rampart = [[0,3],[4,5],[7,9]]`
>
>输出：`3`
>
>解释：如下图所示：
>`rampart[0]` 向左侧膨胀 3 个单位；
>`rampart[2]` 向右侧膨胀 3 个单位；
>`rampart[1]` 向左侧膨胀 1 个单位，向右膨胀 2 个单位。
>不存在膨胀更多的方案，返回 3。
![image.png](https://pic.leetcode.cn/1681717918-tWywrp-image.png){:width=750px}

**示例 2：**
>输入：`rampart = [[1,2],[5,8],[11,15],[18,25]]`
>
>输出：`4`

**提示：**
- `3 <= rampart.length <= 10^4`
- `rampart[i].length == 2`
- `0 <= rampart[i][0] < rampart[i][1] <= rampart[i+1][0] <= 10^8`

## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def rampartDefensiveLine(self, rampart: List[List[int]]) -> int:
        def check(x):
            last = -inf
            n = len(rampart)
            for i in range(n - 1):
                l, r = rampart[i]
                if l - last + rampart[i + 1][0] - r < x:
                    return False
                last = max(r, r + x - l + last)
            return True

        l, r = 0, rampart[-1][0] - rampart[0][1]
        while l < r:
            mid = (l + r + 1) >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return r
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int rampartDefensiveLine(int[][] rampart) {
        int l = 0, r = rampart[rampart.length - 1][0] - rampart[0][1];
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid, rampart)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    public boolean check(int x, int[][] rampart) {
        int n = rampart.length;
        int last = -0x3f3f3f3f;
        for (int i = 0; i < n - 1; i++) {
            int l = rampart[i][0], r = rampart[i][1];
            if (l - last + rampart[i + 1][0] - r < x) {
                return false;
            }
            last = Math.max(r, r + x - l + last);
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
