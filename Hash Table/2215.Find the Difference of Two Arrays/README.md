# [2215. 找出两数组的不同](https://leetcode-cn.com/problems/find-the-difference-of-two-arrays)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个下标从 <code>0</code> 开始的整数数组 <code>nums1</code> 和 <code>nums2</code> ，请你返回一个长度为 <code>2</code> 的列表 <code>answer</code> ，其中：</p>

<ul>
	<li><code>answer[0]</code> 是 <code>nums1</code> 中所有<strong> 不 </strong>存在于 <code>nums2</code> 中的 <strong>不同</strong> 整数组成的列表。</li>
	<li><code>answer[1]</code> 是 <code>nums2</code> 中所有<strong> 不 </strong>存在于 <code>nums1</code> 中的 <strong>不同</strong> 整数组成的列表。</li>
</ul>

<p><strong>注意：</strong>列表中的整数可以按 <strong>任意</strong> 顺序返回。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [1,2,3], nums2 = [2,4,6]
<strong>输出：</strong>[[1,3],[4,6]]
<strong>解释：
</strong>对于 nums1 ，nums1[1] = 2 出现在 nums2 中下标 0 处，然而 nums1[0] = 1 和 nums1[2] = 3 没有出现在 nums2 中。因此，answer[0] = [1,3]。
对于 nums2 ，nums2[0] = 2 出现在 nums1 中下标 1 处，然而 nums2[1] = 4 和 nums2[2] = 6 没有出现在 nums2 中。因此，answer[1] = [4,6]。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [1,2,3,3], nums2 = [1,1,2,2]
<strong>输出：</strong>[[3],[]]
<strong>解释：
</strong>对于 nums1 ，nums1[2] 和 nums1[3] 没有出现在 nums2 中。由于 nums1[2] == nums1[3] ，二者的值只需要在 answer[0] 中出现一次，故 answer[0] = [3]。
nums2 中的每个整数都在 nums1 中出现，因此，answer[1] = [] 。 
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li>
	<li><code>-1000 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        cnt1, cnt2 = [0] * 2001, [0] * 2001
        for v in nums1:
            cnt1[v + 1000] += 1
        for v in nums2:
            cnt2[v + 1000] += 1
        diff1, diff2 = [], []
        for i in range(2001):
            if cnt1[i] != 0 and cnt2[i] == 0:
                diff1.append(i - 1000)
            if cnt2[i] != 0 and cnt1[i] == 0:
                diff2.append(i - 1000)
        return [diff1, diff2]
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] cnt1 = new int[2001], cnt2 = new int[2001];
        for (int v : nums1) {
            cnt1[v + 1000]++;
        }
        for (int v : nums2) {
            cnt2[v + 1000]++;
        }
        List<Integer> diff1 = new ArrayList<>();
        List<Integer> diff2 = new ArrayList<>();
        for (int i = 0; i < 2001; i++) {
            if (cnt1[i] != 0 && cnt2[i] == 0) {
                diff1.add(i - 1000);
            }
            if (cnt2[i] != 0 && cnt1[i] == 0) {
                diff2.add(i - 1000);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(diff1);
        ans.add(diff2);
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
