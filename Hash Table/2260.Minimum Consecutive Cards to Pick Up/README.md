# [2260. 必须拿起的最小连续卡牌数](https://leetcode-cn.com/problems/minimum-consecutive-cards-to-pick-up)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>cards</code> ，其中 <code>cards[i]</code> 表示第 <code>i</code> 张卡牌的 <strong>值</strong> 。如果两张卡牌的值相同，则认为这一对卡牌 <strong>匹配</strong> 。</p>

<p>返回你必须拿起的最小连续卡牌数，以使在拿起的卡牌中有一对匹配的卡牌。如果无法得到一对匹配的卡牌，返回 <code>-1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>cards = [3,4,2,3,4,7]
<strong>输出：</strong>4
<strong>解释：</strong>拿起卡牌 [3,4,2,3] 将会包含一对值为 3 的匹配卡牌。注意，拿起 [4,2,3,4] 也是最优方案。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>cards = [1,0,5,3]
<strong>输出：</strong>-1
<strong>解释：</strong>无法找出含一对匹配卡牌的一组连续卡牌。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= cards.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= cards[i] &lt;= 10<sup>6</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        n = len(cards)
        ans = n + 1
        mp = dict()
        for i, v in enumerate(cards):
            if v in mp:
                ans = min(ans, i - mp[v] + 1)
            mp[v] = i
        return -1 if ans == n + 1 else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = cards.length, ans = cards.length + 1;
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(cards[i])) {
                ans = Math.min(ans, i - mp.get(cards[i]) + 1);
            }
            mp.put(cards[i], i);
        }
        return ans == n + 1 ? -1 : ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
