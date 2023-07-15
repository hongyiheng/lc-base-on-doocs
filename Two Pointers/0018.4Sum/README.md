# [18. 四数之和](https://leetcode-cn.com/problems/4sum)



## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个包含 <em>n</em> 个整数的数组 <code>nums</code> 和一个目标值 <code>target</code>，判断 <code>nums</code> 中是否存在四个元素 <em>a，</em><em>b，c</em> 和 <em>d</em> ，使得 <em>a</em> + <em>b</em> + <em>c</em> + <em>d</em> 的值与 <code>target</code> 相等？找出所有满足条件且不重复的四元组。</p>

<p><strong>注意：</strong>答案中不可以包含重复的四元组。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,0,-1,0,-2,2], target = 0
<strong>输出：</strong>[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [], target = 0
<strong>输出：</strong>[]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= nums.length <= 200</code></li>
	<li><code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> <= target <= 10<sup>9</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []
        use = set()
        for a in range(n):
            for b in range(a + 1, n):
                t = target - nums[a] - nums[b]
                c, d = b + 1, n - 1
                while c < d:
                    v = nums[c] + nums[d]
                    if v > t:
                        d -= 1
                    elif v < t:
                        c += 1
                    else:
                        arr = [nums[a], nums[b], nums[c], nums[d]]
                        if str(arr) not in use:
                            ans.append(arr)
                            use.add(str(arr))
                        c += 1
                        d -= 1
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> use = new HashSet<>();
        int n = nums.length;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                long t = (long)target - nums[a] - nums[b];
                int c = b + 1, d = n - 1;
                while (c < d) {
                    long v = nums[c] + nums[d];
                    if (v < t) {
                        c++;
                    } else if (v > t) {
                        d--;
                    } else {
                        List<Integer> arr = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (int k : new int[]{nums[a], nums[b], nums[c], nums[d]}) { 
                            arr.add(k);
                            sb.append(k + ",");
                        }
                        if (!use.contains(sb.toString())) {
                            ans.add(arr);
                            use.add(sb.toString());
                        }
                        c++;
                        d--;
                    }
                }
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
