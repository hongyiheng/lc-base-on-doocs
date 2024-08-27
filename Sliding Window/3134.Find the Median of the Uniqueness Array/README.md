# [3134. 找出唯一性数组的中位数](https://leetcode.cn/problems/find-the-median-of-the-uniqueness-array)



## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> 。数组 <code>nums</code> 的<strong> 唯一性数组</strong> 是一个按元素从小到大排序的数组，包含了 <code>nums</code> 的所有<span data-keyword="subarray-nonempty">非空子数组中</span>不同元素的个数。</p>

<p>换句话说，这是由所有 <code>0 &lt;= i &lt;= j &lt; nums.length</code> 的 <code>distinct(nums[i..j])</code> 组成的递增数组。</p>

<p>其中，<code>distinct(nums[i..j])</code> 表示从下标 <code>i</code> 到下标 <code>j</code> 的子数组中不同元素的数量。</p>

<p>返回 <code>nums</code> <strong>唯一性数组 </strong>的 <strong>中位数 </strong>。</p>

<p><strong>注意</strong>，数组的 <strong>中位数 </strong>定义为有序数组的中间元素。如果有两个中间元素，则取值较小的那个。<!-- notionvc: 7e0f5178-4273-4a82-95ce-3395297921dc --></p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">nums = [1,2,3]</span></p>

<p><strong>输出：</strong><span class="example-io">1</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code> 的唯一性数组为 <code>[distinct(nums[0..0]), distinct(nums[1..1]), distinct(nums[2..2]), distinct(nums[0..1]), distinct(nums[1..2]), distinct(nums[0..2])]</code>，即 <code>[1, 1, 1, 2, 2, 3]</code> 。唯一性数组的中位数为 1 ，因此答案是 1 。</p>
</div>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">nums = [3,4,3,4,5]</span></p>

<p><strong>输出：</strong><span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code> 的唯一性数组为 <code>[1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3]</code> 。唯一性数组的中位数为 2 ，因此答案是 2 。</p>
</div>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block">
<p><strong>输入：</strong><span class="example-io">nums = [4,3,5,4]</span></p>

<p><strong>输出：</strong><span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code> 的唯一性数组为 <code>[1, 1, 1, 1, 2, 2, 2, 3, 3, 3]</code> 。唯一性数组的中位数为 2 ，因此答案是 2 。</p>
</div>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def medianOfUniquenessArray(self, nums: List[int]) -> int:
        def check(x):
            nonlocal k, n
            l = r = s = 0
            cnt = defaultdict(int)
            while r < n:
                cnt[nums[r]] += 1
                while len(cnt) > x:
                    cnt[nums[l]] -= 1
                    if cnt[nums[l]] == 0:
                        cnt.pop(nums[l])
                    l += 1
                s += r - l + 1
                if s >= k:
                    return True
                r += 1
            return False

        n = len(nums)
        k = ((1 + n) * n / 2 + 1) // 2
        l, r = 1, 10 ** 5
        while l < r:
            mid = (l + r) >> 1
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return r
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public boolean check(int[] nums, int x, long k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0, r = 0;
        long s = 0;
        while (r < nums.length) {
            cnt.put(nums[r], cnt.getOrDefault(nums[r], 0) + 1);
            while (cnt.keySet().size() > x) {
                int v = cnt.get(nums[l]);
                if (v == 1) {
                    cnt.remove(nums[l]);
                } else {
                    cnt.put(nums[l], --v);
                }
                l++;
            }
            s += r - l + 1;
            if (s >= k) {
                return true;
            }
            r++;
        }
        return false;
    }

    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        long k = ((long)(1 + n) * n / 2 + 1) / 2;
        int l = 1, r = (int)1e6;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(nums, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
```

### **...**

```

```

<!-- tabs:end -->
