# [1125. 最小的必要团队](https://leetcode-cn.com/problems/smallest-sufficient-team)



## 题目描述

<!-- 这里写题目描述 -->

<p>作为项目经理，你规划了一份需求的技能清单 <code>req_skills</code>，并打算从备选人员名单 <code>people</code> 中选出些人组成一个「必要团队」（ 编号为 <code>i</code> 的备选人员 <code>people[i]</code> 含有一份该备选人员掌握的技能列表）。</p>

<p>所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 <code>req_skills</code> 中列出的每项技能，团队中至少有一名成员已经掌握。可以用每个人的编号来表示团队中的成员：</p>

<ul>
	<li>例如，团队 <code>team = [0, 1, 3]</code> 表示掌握技能分别为 <code>people[0]</code>，<code>people[1]</code>，和 <code>people[3]</code> 的备选人员。</li>
</ul>

<p>请你返回 <strong>任一</strong> 规模最小的必要团队，团队成员用人员编号表示。你可以按 <strong>任意顺序</strong> 返回答案，题目数据保证答案存在。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
<strong>输出：</strong>[0,2]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
<strong>输出：</strong>[1,2]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= req_skills.length <= 16</code></li>
	<li><code>1 <= req_skills[i].length <= 16</code></li>
	<li><code>req_skills[i]</code> 由小写英文字母组成</li>
	<li><code>req_skills</code> 中的所有字符串 <strong>互不相同</strong></li>
	<li><code>1 <= people.length <= 60</code></li>
	<li><code>0 <= people[i].length <= 16</code></li>
	<li><code>1 <= people[i][j].length <= 16</code></li>
	<li><code>people[i][j]</code> 由小写英文字母组成</li>
	<li><code>people[i]</code> 中的所有字符串 <strong>互不相同</strong></li>
	<li><code>people[i]</code> 中的每个技能是 <code>req_skills</code> 中的技能</li>
	<li>题目数据保证「必要团队」一定存在</li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def smallestSufficientTeam(self, req_skills: List[str], people: List[List[str]]) -> List[int]:
        n, m = len(people), len(req_skills)
        sid = {s: i for i, s in enumerate(req_skills)}
        mask = [0] * n
        for i, skill in enumerate(people):
            for s in skill:
                mask[i] |= 1 << sid[s]
        f = [(1 << n) - 1] * (1 << m)
        f[0] = 0
        for i in range((1 << m) - 1):
            if f[i] == (1 << n) - 1:
                continue
            for j, msk in enumerate(mask):
                if f[i].bit_count() + 1 < f[i | msk].bit_count():
                    f[i | msk] = f[i] | (1 << j)
        ans = f[-1]
        return [i for i in range(n) if (ans >> i) & 1]

```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = people.size(), m = req_skills.length;
        Map<String, Integer> sid = new HashMap<>();
        for (int i = 0; i < m; i++) {
            sid.put(req_skills[i], i);
        }
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (String s : people.get(i)) {
                mask[i] |= 1 << sid.get(s);
            }
        }
        long[] f = new long[1 << m];
        Arrays.fill(f, (1L << n) - 1);
        f[0] = 0;
        for (int i = 0; i < (1 << m) - 1; i++) {
            if (f[i] == (1 << n) - 1) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (Long.bitCount(f[i]) + 1 < Long.bitCount(f[i | mask[j]])) {
                    f[i | mask[j]] = f[i] | (1L << j);
                }
            }
        }
        long ans = f[(1 << m) - 1];
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((ans >> i & 1) == 1) {
                tmp.add(i);
            }
        }
        return tmp.stream().mapToInt(Integer::valueOf).toArray();
    }
}
```

### **...**

```

```

<!-- tabs:end -->
