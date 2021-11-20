# [1046. 最后一块石头的重量](https://leetcode-cn.com/problems/last-stone-weight)



## 题目描述

<!-- 这里写题目描述 -->

<p>有一堆石头，每块石头的重量都是正整数。</p>

<p>每一回合，从中选出两块<strong> 最重的</strong> 石头，然后将它们一起粉碎。假设石头的重量分别为 <code>x</code> 和 <code>y</code>，且 <code>x <= y</code>。那么粉碎的可能结果如下：</p>

<ul>
	<li>如果 <code>x == y</code>，那么两块石头都会被完全粉碎；</li>
	<li>如果 <code>x != y</code>，那么重量为 <code>x</code> 的石头将会完全粉碎，而重量为 <code>y</code> 的石头新重量为 <code>y-x</code>。</li>
</ul>

<p>最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 <code>0</code>。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>[2,7,4,1,8,1]
<strong>输出：</strong>1
<strong>解释：</strong>
先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= stones.length <= 30</code></li>
	<li><code>1 <= stones[i] <= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stk = [-i for i in stones]
        heapq.heapify(stk)
        while len(stk) > 1:
            x, y = heapq.heappop(stk), heapq.heappop(stk)
            if x != y:
                heapq.heappush(stk, x - y)
        return -heapq.heappop(stk) if stk else 0
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> stk = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            stk.offer(stone);
        }
        while (stk.size() > 1) {
            int y = stk.poll();
            int x = stk.poll();
            if (x != y) {
                stk.offer(y - x);
            }
        }
        return stk.isEmpty() ? 0 : stk.poll();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
