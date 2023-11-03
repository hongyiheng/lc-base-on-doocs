# [1477. 找两个和为目标值且不重叠的子数组](https://leetcode-cn.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组&nbsp;<code>arr</code> 和一个整数值&nbsp;<code>target</code>&nbsp;。</p>

<p>请你在 <code>arr</code>&nbsp;中找 <strong>两个互不重叠的子数组</strong>&nbsp;且它们的和都等于&nbsp;<code>target</code>&nbsp;。可能会有多种方案，请你返回满足要求的两个子数组长度和的 <strong>最小值</strong> 。</p>

<p>请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 <strong>-1</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr = [3,2,2,4,3], target = 3
<strong>输出：</strong>2
<strong>解释：</strong>只有两个子数组和为 3 （[3] 和 [3]）。它们的长度和为 2 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr = [7,3,4,7], target = 7
<strong>输出：</strong>2
<strong>解释：</strong>尽管我们有 3 个互不重叠的子数组和为 7 （[7], [3,4] 和 [7]），但我们会选择第一个和第三个子数组，因为它们的长度和 2 是最小值。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>arr = [4,3,2,6,2,3,4], target = 6
<strong>输出：</strong>-1
<strong>解释：</strong>我们只有一个和为 6 的子数组。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>arr = [5,5,4,4,5], target = 3
<strong>输出：</strong>-1
<strong>解释：</strong>我们无法找到和为 3 的子数组。
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>arr = [3,1,1,1,5,1,2,1], target = 3
<strong>输出：</strong>3
<strong>解释：</strong>注意子数组 [1,2] 和 [2,1] 不能成为一个方案因为它们重叠了。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 10^5</code></li>
	<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
	<li><code>1 &lt;= target &lt;= 10^8</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def minSumOfLengths(self, arr: List[int], target: int) -> int:
        n = len(arr)
        l = r = s = 0
        q = []
        while r < n:
            s += arr[r]
            while s > target:
                s -= arr[l]
                l += 1
            if s == target:
                q.append((r - l + 1, l, r))
            r += 1

        q.sort(key=lambda x: x[0])
        ans = n + 1
        for i in range(len(q)):
            for j in range(i + 1, len(q)):
                if q[i][0] + q[j][0] >= ans:
                    break
                if q[i][1] > q[j][2] or q[j][1] > q[i][2]:
                    ans = min(q[i][0] + q[j][0], ans)
                    break
        return -1 if ans > n else ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int l = 0, r = 0, s = 0;
        List<int[]> q = new ArrayList<>();
        while (r < n) {
            s += arr[r];
            while (s > target) {
                s -= arr[l++];
            }
            if (s == target) {
                q.add(new int[]{r - l + 1, l, r});
            }
            r++;
        }
        Collections.sort(q, (a, b) -> a[0] - b[0]);
        int m = q.size(), ans = n + 1;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (q.get(i)[0] + q.get(j)[0] >= ans) {
                    break;
                }
                if (q.get(i)[1] > q.get(j)[2] || q.get(j)[1] > q.get(i)[2]) {
                    ans = q.get(i)[0] + q.get(j)[0];
                }
            }
        }
        return ans > n ? -1 : ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
