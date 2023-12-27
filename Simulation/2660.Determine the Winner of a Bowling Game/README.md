# [2660. 保龄球游戏的获胜者](https://leetcode-cn.com/problems/determine-the-winner-of-a-bowling-game)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个下标从 <strong>0</strong> 开始的整数数组 <code>player1</code> 和 <code>player2</code> ，分别表示玩家 1 和玩家 2 击中的瓶数。</p>

<p>保龄球比赛由 <code>n</code> 轮组成，每轮的瓶数恰好为 <code>10</code> 。</p>

<p>假设玩家在第 <code>i</code> 轮中击中&nbsp;<code>x<sub>i</sub></code> 个瓶子。玩家第 <code>i</code> 轮的价值为：</p>

<ul>
	<li>如果玩家在该轮的前两轮的任何一轮中击中了 <code>10</code> 个瓶子，则为 <code>2x<sub>i</sub></code> 。</li>
	<li>否则，为&nbsp;<code>x<sub>i</sub></code> 。</li>
</ul>

<p>玩家的得分是其 <code>n</code> 轮价值的总和。</p>

<p>返回</p>

<ul>
	<li>如果玩家 1 的得分高于玩家 2 的得分，则为 <code>1</code> ；</li>
	<li>如果玩家 2 的得分高于玩家 1 的得分，则为 <code>2</code> ；</li>
	<li>如果平局，则为 <code>0</code> 。</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>player1 = [4,10,7,9], player2 = [6,5,2,3]
<strong>输出：</strong>1
<strong>解释：</strong>player1 的得分是 4 + 10 + 2*7 + 2*9 = 46 。
player2 的得分是 6 + 5 + 2 + 3 = 16 。
player1 的得分高于 player2 的得分，所以 play1 在比赛中获胜，答案为 1 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>player1 = [3,5,7,6], player2 = [8,10,10,2]
<strong>输出：</strong>2
<strong>解释：</strong>player1 的得分是 3 + 5 + 7 + 6 = 21 。
player2 的得分是 8 + 10 + 2*10 + 2*2 = 42 。
player2 的得分高于 player1 的得分，所以 play2 在比赛中获胜，答案为 2 。</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>player1 = [2,3], player2 = [4,1]
<strong>输出：</strong>0
<strong>解释：</strong>player1 的得分是 2 + 3 = 5 。
player2 的得分是 4 + 1 = 5 。
player1 的得分等于 player2 的得分，所以这一场比赛平局，答案为 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == player1.length == player2.length</code></li>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
	<li><code>0 &lt;= player1[i], player2[i] &lt;= 10</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def isWinner(self, player1: List[int], player2: List[int]) -> int:
        t1 = t2 = d1 = d2 = 0
        for a, b in zip(player1, player2):
            t1 += 2 * a if d1 > 0 else a
            t2 += 2 * b if d2 > 0 else b
            d1 = 2 if a == 10 else d1 - 1
            d2 = 2 if b == 10 else d2 - 1
        if t1 == t2:
            return 0
        return 1 if t1 > t2 else 2
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int t1 = 0, t2 = 0, d1 = 0, d2 = 0;
        for (int i = 0; i < player1.length; i++) {
            int a = player1[i], b = player2[i];
            t1 += d1 > 0 ? 2 * a : a;
            t2 += d2 > 0 ? 2 * b : b;
            d1 = a == 10 ? 2 : d1 - 1;
            d2 = b == 10 ? 2 : d2 - 1;
        }
        if (t1 == t2) {
            return 0;
        }
        return t1 > t2 ? 1 : 2;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
