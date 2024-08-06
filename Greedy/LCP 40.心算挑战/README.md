# [LCP 40. 心算挑战](https://leetcode.cn/problems/uOAnQW)



## 题目描述

<!-- 这里写题目描述 -->

「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 `cnt` 张卡牌数字总和。
给定数组 `cards` 和 `cnt`，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。

**示例 1：**
>输入：`cards = [1,2,8,9], cnt = 3`
>
>输出：`18`
>
>解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。

**示例 2：**
>输入：`cards = [3,3,1], cnt = 1`
>
>输出：`0`
>
>解释：不存在获取有效得分的卡牌方案。

**提示：**
- `1 <= cnt <= cards.length <= 10^5`
- `1 <= cards[i] <= 1000`




## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maxmiumScore(self, cards: List[int], cnt: int) -> int:
        cards.sort(reverse=True)
        ans = 0
        odd = even = inf
        for v in cards:
            if cnt:
                if v % 2 == 0:
                    even = v
                else:
                    odd = v
                ans += v
                cnt -= 1
            elif ans % 2:
                if v % 2 == 0 and (ans - odd + v) % 2 == 0:
                    ans = ans - odd + v
                elif v % 2 == 1 and (ans - even + v) % 2 == 0:
                    ans = ans - even + v
        return ans if ans % 2 == 0 else 0
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int ans = 0;
        int odd = 2, even = 1;
        for (int i = cards.length - 1; i > -1; i--) {
            int v = cards[i];
            if (cnt > 0) {
                if (v % 2 == 0) {
                    even = v;
                } else {
                    odd = v;
                }
                ans += v;
                cnt--;
            } else if (ans % 2 == 1) {
                if (v % 2 == 0 && (ans - odd + v) % 2 == 0) {
                    return ans - odd + v;
                } else if (v % 2 == 1 && (ans - even + v) % 2 == 0) {
                    return ans - even + v;
                }
            } 
        }
        return ans % 2 == 0 ? ans : 0;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
