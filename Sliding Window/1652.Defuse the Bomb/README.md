# [1652. 拆炸弹](https://leetcode-cn.com/problems/defuse-the-bomb)



## 题目描述

<!-- 这里写题目描述 -->

<p>你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 <code>n</code> 的 <strong>循环</strong> 数组 <code>code</code> 以及一个密钥 <code>k</code> 。</p>

<p>为了获得正确的密码，你需要替换掉每一个数字。所有数字会 <strong>同时</strong> 被替换。</p>

<ul>
	<li>如果 <code>k > 0</code> ，将第 <code>i</code> 个数字用 <strong>接下来</strong> <code>k</code> 个数字之和替换。</li>
	<li>如果 <code>k < 0</code> ，将第 <code>i</code> 个数字用 <strong>之前</strong> <code>k</code> 个数字之和替换。</li>
	<li>如果 <code>k == 0</code> ，将第 <code>i</code> 个数字用 <code>0</code> 替换。</li>
</ul>

<p>由于 <code>code</code> 是循环的， <code>code[n-1]</code> 下一个元素是 <code>code[0]</code> ，且 <code>code[0]</code> 前一个元素是 <code>code[n-1]</code> 。</p>

<p>给你 <strong>循环</strong> 数组 <code>code</code> 和整数密钥 <code>k</code> ，请你返回解密后的结果来拆除炸弹！</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>code = [5,7,1,4], k = 3
<b>输出：</b>[12,10,16,13]
<b>解释：</b>每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>code = [1,2,3,4], k = 0
<b>输出：</b>[0,0,0,0]
<b>解释：</b>当 k 为 0 时，所有数字都被 0 替换。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<b>输入：</b>code = [2,4,9,3], k = -2
<b>输出：</b>[12,5,6,13]
<b>解释：</b>解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 <strong>之前</strong> 的数字。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>n == code.length</code></li>
	<li><code>1 <= n <= 100</code></li>
	<li><code>1 <= code[i] <= 100</code></li>
	<li><code>-(n - 1) <= k <= n - 1</code></li>
</ul>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        n = len(code)
        ans = [0] * n
        if not k:
            return ans
        if k > 0:
            s = sum(code[1:k + 1])
            for i in range(n):
                ans[i] = s
                s -= code[(i + 1) % n]
                s += code[(i + k + 1) % n]
        else:
            s = sum(code[n + k:])
            for i in range(n):
                ans[i] = s
                s -= code[(i + n + k) % n]
                s += code[i]
        return ans
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class Solution {

    public int getS(int[] code, int k) {
        int ans = 0, n = code.length;
        if (k > 0) {
            for (int i = 1; i < k + 1; i++) {
                ans += code[i];
            }
        } else {
            for (int i = n - 1; i >= n + k; i--) {
                ans += code[i];
            }
        }
        return ans;
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        int s = getS(code, k);
        for (int i = 0; i < n; i++) {
            ans[i] = s;
            if (k > 0) {
                s += code[(i + k + 1) % n];
                s -= code[(i + 1) % n];
            } else {
                s += code[i];
                s -= code[(n + k + i + n) % n];
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
