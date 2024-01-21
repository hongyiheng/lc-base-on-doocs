# [2933. 高访问员工](https://leetcode-cn.com/problems/high-access-employees)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个长度为 <code>n</code> 、下标从 <strong>0</strong> 开始的二维字符串数组 <code>access_times</code> 。对于每个 <code>i</code>（<code>0 &lt;= i &lt;= n - 1</code> ），<code>access_times[i][0]</code> 表示某位员工的姓名，<code>access_times[i][1]</code> 表示该员工的访问时间。<code>access_times</code> 中的所有条目都发生在同一天内。</p>

<p>访问时间用 <strong>四位</strong> 数字表示， 符合 <strong>24 小时制</strong> ，例如 <code>"0800"</code> 或 <code>"2250"</code> 。</p>

<p>如果员工在 <strong>同一小时内</strong> 访问系统 <strong>三次或更多</strong> ，则称其为 <strong>高访问</strong> 员工。</p>

<p>时间间隔正好相差一小时的时间 <strong>不</strong> 被视为同一小时内。例如，<code>"0815"</code> 和 <code>"0915"</code> 不属于同一小时内。</p>

<p>一天开始和结束时的访问时间不被计算为同一小时内。例如，<code>"0005"</code> 和 <code>"2350"</code> 不属于同一小时内。</p>

<p>以列表形式，按任意顺序，返回所有 <strong>高访问</strong> 员工的姓名。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>access_times = [["a","0549"],["b","0457"],["a","0532"],["a","0621"],["b","0540"]]
<strong>输出：</strong>["a"]
<strong>解释：</strong>"a" 在时间段 [05:32, 06:31] 内有三条访问记录，时间分别为 05:32 、05:49 和 06:21 。
但是 "b" 的访问记录只有两条。
因此，答案是 ["a"] 。</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>access_times = [["d","0002"],["c","0808"],["c","0829"],["e","0215"],["d","1508"],["d","1444"],["d","1410"],["c","0809"]]
<strong>输出：</strong>["c","d"]
<strong>解释：</strong>"c" 在时间段 [08:08, 09:07] 内有三条访问记录，时间分别为 08:08 、08:09 和 08:29 。
"d" 在时间段 [14:10, 15:09] 内有三条访问记录，时间分别为 14:10 、14:44 和 15:08 。
然而，"e" 只有一条访问记录，因此不能包含在答案中，最终答案是 ["c","d"] 。</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<strong>输入：</strong>access_times = [["cd","1025"],["ab","1025"],["cd","1046"],["cd","1055"],["ab","1124"],["ab","1120"]]
<strong>输出：</strong>["ab","cd"]
<strong>解释：</strong>"ab"在时间段 [10:25, 11:24] 内有三条访问记录，时间分别为 10:25 、11:20 和 11:24 。
"cd" 在时间段 [10:25, 11:24] 内有三条访问记录，时间分别为 10:25 、10:46 和 10:55 。
因此，答案是 ["ab","cd"] 。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= access_times.length &lt;= 100</code></li>
	<li><code>access_times[i].length == 2</code></li>
	<li><code>1 &lt;= access_times[i][0].length &lt;= 10</code></li>
	<li><code>access_times[i][0]</code> 仅由小写英文字母组成。</li>
	<li><code>access_times[i][1].length == 4</code></li>
	<li><code>access_times[i][1]</code> 采用24小时制表示时间。</li>
	<li><code>access_times[i][1]</code> 仅由数字 <code>'0'</code> 到 <code>'9'</code> 组成。</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findHighAccessEmployees(self, access_times: List[List[str]]) -> List[str]:
        ans = set()
        q = [(k, int(t[:2]) * 60 + int(t[2:])) for k, t in access_times]
        q.sort(key=lambda x: x[1])
        cnt = defaultdict(list)
        for k, t in q:
            if k in ans:
                continue
            while cnt[k] and cnt[k][0] <= t - 60:
                cnt[k].pop(0)
            cnt[k].append(t)
            if len(cnt[k]) == 3:
                ans.add(k)
        return list(ans)
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        int n = access_times.size();
        List<Pair<String, Integer>> q = new ArrayList<>();
        for (List<String> at : access_times) {
            int t = Integer.valueOf(at.get(1).substring(0, 2)) * 60 + Integer.valueOf(at.get(1).substring(2, 4));
            q.add(new Pair<>(at.get(0), t));
        }
        Collections.sort(q, (a, b) -> a.getValue() - b.getValue());
        Set<String> ans = new HashSet<>();
        Map<String, Deque<Integer>> cnt = new HashMap<>();
        for (Pair<String, Integer> p : q) {
            String k = p.getKey();
            if (ans.contains(k)) {
                continue;
            }
            int t = p.getValue();
            Deque<Integer> ts = cnt.getOrDefault(k, new ArrayDeque<>());
            while (!ts.isEmpty() && ts.peekFirst() <= t - 60) {
                ts.pollFirst();
            }
            ts.add(t);
            if (ts.size() == 3) {
                ans.add(k);
            }
            cnt.put(k, ts);
        }
        return new ArrayList<>(ans);
    }
}
```

### **...**

```

```

<!-- tabs:end -->
