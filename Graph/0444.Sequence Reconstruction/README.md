# [444. 序列重建](https://leetcode-cn.com/problems/sequence-reconstruction)



## 题目描述

<!-- 这里写题目描述 -->

<p>验证原始的序列&nbsp;<code>org</code>&nbsp;是否可以从序列集&nbsp;<code>seqs</code>&nbsp;中唯一地重建。序列&nbsp;<code>org</code>&nbsp;是 1 到 n 整数的排列，其中 1 &le; n &le; 10<sup>4</sup>。重建是指在序列集 <code>seqs</code> 中构建最短的公共超序列。（即使得所有 &nbsp;<code>seqs</code>&nbsp;中的序列都是该最短序列的子序列）。确定是否只可以从 <code>seqs</code> 重建唯一的序列，且该序列就是 <code>org</code> 。</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>
org: [1,2,3], seqs: [[1,2],[1,3]]

<strong>输出：</strong>
false

<strong>解释：</strong>
[1,2,3] 不是可以被重建的唯一的序列，因为 [1,3,2] 也是一个合法的序列。
</pre>

<p>&nbsp;</p>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>
org: [1,2,3], seqs: [[1,2]]

<strong>输出：</strong>
false

<strong>解释：</strong>
可以重建的序列只有 [1,2]。
</pre>

<p>&nbsp;</p>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>
org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

<strong>输出：</strong>
true

<strong>解释：</strong>
序列 [1,2], [1,3] 和 [2,3] 可以被唯一地重建为原始的序列 [1,2,3]。
</pre>

<p>&nbsp;</p>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>
org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

<strong>输出：</strong>
true
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def sequenceReconstruction(self, nums: List[int], sequences: List[List[int]]) -> bool:
        mp = defaultdict(set)
        in_deg = [0] * (len(nums) + 1)
        for seq in sequences:
            for i in range(1, len(seq)):
                mp[seq[i - 1]].add(seq[i])
                in_deg[seq[i]] += 1
        q = []
        for i in range(1, len(nums) + 1):
            if in_deg[i] == 0:
                q.append(i)
        idx = 0
        while q:
            if len(q) != 1:
                return False
            cur = q.pop(0)
            if cur != nums[idx]:
                return False
            idx += 1
            for nxt in mp[cur]:
                in_deg[nxt] -= 1
                if in_deg[nxt] == 0:
                    q.append(nxt)
        return True
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        int n = nums.length;
        int[] in = new int[n + 1];
        for (List<Integer> seq : sequences) {
            for (int i = 1; i < seq.size(); i++) {
                mp.computeIfAbsent(seq.get(i - 1), k -> new HashSet<>()).add(seq.get(i));
                in[seq.get(i)]++;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }
        int idx = 0;
        while (!q.isEmpty()) {
            if (q.size() != 1) {
                return false;
            }
            int cur = q.poll();
            if (cur != nums[idx++]) {
                return false;
            }
            for (int nxt : mp.getOrDefault(cur, new HashSet<>())) {
                in[nxt]--;
                if (in[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }
        return true;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
