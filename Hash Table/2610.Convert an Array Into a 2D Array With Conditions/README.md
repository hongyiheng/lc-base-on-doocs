# [2610. 转换二维数组](https://leetcode-cn.com/problems/convert-an-array-into-a-2d-array-with-conditions)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> 。请你创建一个满足以下条件的二维数组：</p>

<ul>
	<li>二维数组应该 <strong>只</strong> 包含数组 <code>nums</code> 中的元素。</li>
	<li>二维数组中的每一行都包含 <strong>不同</strong> 的整数。</li>
	<li>二维数组的行数应尽可能 <strong>少</strong> 。</li>
</ul>

<p>返回结果数组。如果存在多种答案，则返回其中任何一种。</p>

<p>请注意，二维数组的每一行上可以存在不同数量的元素。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums = [1,3,4,1,2,3,1]
<strong>输出：</strong>[[1,3,4,2],[1,3],[1]]
<strong>解释：</strong>根据题目要求可以创建包含以下几行元素的二维数组：
- 1,3,4,2
- 1,3
- 1
nums 中的所有元素都有用到，并且每一行都由不同的整数组成，所以这是一个符合题目要求的答案。
可以证明无法创建少于三行且符合题目要求的二维数组。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums = [1,2,3,4]
<strong>输出：</strong>[[4,3,2,1]]
<strong>解释：</strong>nums 中的所有元素都不同，所以我们可以将其全部保存在二维数组中的第一行。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>1 &lt;= nums[i] &lt;= nums.length</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        cnt = Counter(nums)
        ans = []
        while cnt:
            row = []
            del_k = []
            for k in cnt.keys():
                row.append(k)
                cnt[k] = cnt[k] - 1
                if cnt[k] == 0:
                    del_k.append(k)
            for k in del_k:
                cnt.pop(k)
            ans.append(row)
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] cnt = new int[210];
        for (int v : nums) {
            cnt[v]++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        while (n > 0) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < 210; i++) {
                if (cnt[i] > 0) {
                    row.add(i);
                    cnt[i]--;
                    n--;
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
