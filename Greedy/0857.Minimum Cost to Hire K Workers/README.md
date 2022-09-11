# [857. 雇佣 K 名工人的最低成本](https://leetcode-cn.com/problems/minimum-cost-to-hire-k-workers)



## 题目描述

<!-- 这里写题目描述 -->

<p>有 <code>N</code>&nbsp;名工人。&nbsp;第&nbsp;<code>i</code>&nbsp;名工人的工作质量为&nbsp;<code>quality[i]</code>&nbsp;，其最低期望工资为&nbsp;<code>wage[i]</code>&nbsp;。</p>

<p>现在我们想雇佣&nbsp;<code>K</code>&nbsp;名工人组成一个<em>工资组。</em>在雇佣&nbsp;一组 K 名工人时，我们必须按照下述规则向他们支付工资：</p>

<ol>
	<li>对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。</li>
	<li>工资组中的每名工人至少应当得到他们的最低期望工资。</li>
</ol>

<p>返回组成一个满足上述条件的工资组至少需要多少钱。</p>

<p>&nbsp;</p>

<ol>
</ol>

<p><strong>示例 1：</strong></p>

<pre><strong>输入： </strong>quality = [10,20,5], wage = [70,50,30], K = 2
<strong>输出： </strong>105.00000
<strong>解释：</strong> 我们向 0 号工人支付 70，向 2 号工人支付 35。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入： </strong>quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
<strong>输出： </strong>30.66667
<strong>解释： </strong>我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 &lt;= K &lt;= N &lt;= 10000</code>，其中&nbsp;<code>N = quality.length = wage.length</code></li>
	<li><code>1 &lt;= quality[i] &lt;= 10000</code></li>
	<li><code>1 &lt;= wage[i] &lt;= 10000</code></li>
	<li>与正确答案误差在&nbsp;<code>10^-5</code>&nbsp;之内的答案将被视为正确的。</li>
</ol>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        n = len(quality)
        ds = [[0] * 2 for _ in range(n)]
        for i in range(n):
            ds[i][0] = wage[i] / quality[i]
            ds[i][1] = quality[i]
        ds.sort(key=lambda x:x[0])
        ans = float('inf')
        q = []
        cnt = 0
        for i in range(n):
            cnt += ds[i][1]
            heapq.heappush(q, -ds[i][1])
            if len(q) > k:
                cnt += heapq.heappop(q)
            if len(q) == k:
                ans = min(ans, cnt * ds[i][0])
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] ds = new double[n][2];
        for (int i = 0; i < n; i++) {
            ds[i][0] = wage[i] * 1.0 / quality[i] * 1.0;
            ds[i][1] = quality[i] * 1.0;
        }
        Arrays.sort(ds, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        double ans = Double.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += (int)ds[i][1];
            q.add((int)ds[i][1]);
            if (q.size() > k) {
                cnt -= q.poll();
            }
            if (q.size() == k) {
                ans = Math.min(ans, cnt * ds[i][0]);
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
