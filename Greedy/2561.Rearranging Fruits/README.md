# [2561. 重排水果](https://leetcode-cn.com/problems/rearranging-fruits)



## 题目描述

<!-- 这里写题目描述 -->

<p>你有两个果篮，每个果篮中有 <code>n</code> 个水果。给你两个下标从 <strong>0</strong> 开始的整数数组 <code>basket1</code> 和 <code>basket2</code> ，用以表示两个果篮中每个水果的成本。</p>

<p>你希望两个果篮相等。为此，可以根据需要多次执行下述操作：</p>

<ul>
	<li>选中两个下标 <code>i</code> 和 <code>j</code> ，并交换 <code>basket1</code> 中的第 <code>i</code> 个水果和 <code>basket2</code> 中的第 <code>j</code> 个水果。</li>
	<li>交换的成本是 <code>min(basket1<sub>i</sub>,basket2<sub>j</sub>)</code> 。</li>
</ul>

<p>根据果篮中水果的成本进行排序，如果排序后结果完全相同，则认为两个果篮相等。</p>

<p>返回使两个果篮相等的最小交换成本，如果无法使两个果篮相等，则返回<em> </em><code>-1</code><em> </em>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>basket1 = [4,2,2,2], basket2 = [1,4,1,2]
<strong>输出：</strong>1
<strong>解释：</strong>交换 basket1 中下标为 1 的水果和 basket2 中下标为 0 的水果，交换的成本为 1 。此时，basket1 = [4,1,2,2] 且 basket2 = [2,4,1,2] 。重排两个数组，发现二者相等。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>basket1 = [2,3,4,1], basket2 = [3,2,5,1]
<strong>输出：</strong>-1
<strong>解释：</strong>可以证明无法使两个果篮相等。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>basket1.length == bakste2.length</code></li>
	<li><code>1 &lt;= basket1.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= basket1<sub>i</sub>,basket2<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        diff = defaultdict(int)
        for v in basket1:
            diff[v] += 1
        for v in basket2:
            diff[v] -= 1
        l, r = [], []
        for k in diff.keys():
            if diff[k] % 2:
                return -1
            while diff[k] > 0:
                l.append(k)
                diff[k] -= 2
            while diff[k] < 0:
                r.append(k)
                diff[k] += 2
        l.sort()
        r.sort(reverse=True)
        mi = min(min(basket1), min(basket2))
        ans = 0
        for a, b in zip(l, r):
            ans += min(a, b, 2 * mi)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> diff = new HashMap<>();
        int mi = basket1[0];
        for (int v : basket1) {
            diff.put(v, diff.getOrDefault(v, 0) + 1);
            mi = Math.min(mi, v);
        }
        for (int v : basket2) {
            diff.put(v, diff.getOrDefault(v, 0) - 1);
            mi = Math.min(mi, v);
        }
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        for (int k : diff.keySet()) {
            int d = diff.get(k);
            if ((d & 1) != 0) {
                return -1;
            }
            while (d > 0) {
                l.add(k);
                d -= 2;
            }
            while (d < 0) {
                r.add(k);
                d += 2;
            }
        }
        l.sort((a, b) -> a - b);
        r.sort((a, b) -> b - a);
        long ans = 0;
        for (int i = 0; i < l.size(); i++) {
            int a = l.get(i);
            int b = r.get(i);
            ans += Math.min(Math.min(a, b), 2 * mi);
        }
        return ans;
    }
}

```

### **...**

```

```

<!-- tabs:end -->
