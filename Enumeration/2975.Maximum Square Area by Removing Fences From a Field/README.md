# [2975. 移除栅栏得到的正方形田地的最大面积](https://leetcode-cn.com/problems/maximum-square-area-by-removing-fences-from-a-field)



## 题目描述

<!-- 这里写题目描述 -->

<p>有一个大型的 <code>(m - 1) x (n - 1)</code> 矩形田地，其两个对角分别是 <code>(1, 1)</code> 和 <code>(m, n)</code> ，田地内部有一些水平栅栏和垂直栅栏，分别由数组 <code>hFences</code> 和 <code>vFences</code> 给出。</p>

<p>水平栅栏为坐标 <code>(hFences[i], 1)</code> 到 <code>(hFences[i], n)</code>，垂直栅栏为坐标 <code>(1, vFences[i])</code> 到 <code>(m, vFences[i])</code> 。</p>

<p>返回通过<strong> 移除 </strong>一些栅栏（<strong>可能不移除</strong>）所能形成的最大面积的<strong> 正方形 </strong>田地的面积，或者如果无法形成正方形田地则返回 <code>-1</code>。</p>

<p>由于答案可能很大，所以请返回结果对 <code>10<sup>9</sup> + 7</code> <strong>取余</strong> 后的值。</p>

<p><strong>注意：</strong>田地外围两个水平栅栏（坐标 <code>(1, 1)</code> 到 <code>(1, n)</code> 和坐标 <code>(m, 1)</code> 到 <code>(m, n)</code> ）以及两个垂直栅栏（坐标 <code>(1, 1)</code> 到 <code>(m, 1)</code> 和坐标 <code>(1, n)</code> 到 <code>(m, n)</code> ）所包围。这些栅栏<strong> 不能</strong> 被移除。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/11/05/screenshot-from-2023-11-05-22-40-25.png" /></p>

<pre>
<strong>输入：</strong>m = 4, n = 3, hFences = [2,3], vFences = [2]
<strong>输出：</strong>4
<strong>解释：</strong>移除位于 2 的水平栅栏和位于 2 的垂直栅栏将得到一个面积为 4 的正方形田地。
</pre>

<p><strong class="example">示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2023/11/22/maxsquareareaexample1.png" style="width: 285px; height: 242px;" /></p>

<pre>
<strong>输入：</strong>m = 6, n = 7, hFences = [2], vFences = [4]
<strong>输出：</strong>-1
<strong>解释：</strong>可以证明无法通过移除栅栏形成正方形田地。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= m, n &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= hFences.length, vFences.length &lt;= 600</code></li>
	<li><code>1 &lt; hFences[i] &lt; m</code></li>
	<li><code>1 &lt; vFences[i] &lt; n</code></li>
	<li><code>hFences</code> 和 <code>vFences</code> 中的元素是唯一的。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def maximizeSquareArea(self, m: int, n: int, hFences: List[int], vFences: List[int]) -> int:
        hFences = hFences + [1, m]
        vFences = vFences + [1, n]
        hs = set()
        for i in range(len(hFences)):
            for j in range(i + 1, len(hFences)):
                hs.add(abs(hFences[i] - hFences[j]))
        ans = -1
        for i in range(len(vFences)):
            for j in range(i + 1, len(vFences)):
                v = abs(vFences[i] - vFences[j])
                if v in hs:
                    ans = max(ans, v)
        return -1 if ans == -1 else ans * ans % int(1e9 + 7)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> hs = new HashSet<>(), vs = new HashSet<>();
        for (int i = 0; i < hFences.length; i++) {
            for (int j = i + 1; j < hFences.length; j++) {
                hs.add(Math.abs(hFences[i] - hFences[j]));
            }
            hs.add(Math.abs(hFences[i] - 1));
            hs.add(Math.abs(hFences[i] - m));
            hs.add(Math.abs(m - 1));
        }
        for (int i = 0; i < vFences.length; i++) {
            for (int j = i + 1; j < vFences.length; j++) {
                vs.add(Math.abs(vFences[i] - vFences[j]));
            }
            vs.add(Math.abs(vFences[i] - 1));
            vs.add(Math.abs(vFences[i] - n));
            vs.add(Math.abs(n - 1));
        }
        hs.retainAll(vs);
        int ans = -1;
        for (int v : hs) {
            ans = Math.max(ans, v);
        }
        return ans == -1 ? -1 : (int)(1L * ans * ans % ((int)1e9 + 7));
    }
}
```

### **...**

```

```

<!-- tabs:end -->
