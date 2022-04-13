# [380. O(1) 时间插入、删除和获取随机元素](https://leetcode-cn.com/problems/insert-delete-getrandom-o1)



## 题目描述

<!-- 这里写题目描述 -->

<p>设计一个支持在<em>平均&nbsp;</em>时间复杂度 <strong>O(1)</strong>&nbsp;下，执行以下操作的数据结构。</p>

<ol>
	<li><code>insert(val)</code>：当元素 val 不存在时，向集合中插入该项。</li>
	<li><code>remove(val)</code>：元素 val 存在时，从集合中移除该项。</li>
	<li><code>getRandom</code>：随机返回现有集合中的一项。每个元素应该有<strong>相同的概率</strong>被返回。</li>
</ol>

<p><strong>示例 :</strong></p>

<pre>
// 初始化一个空的集合。
RandomizedSet randomSet = new RandomizedSet();

// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
randomSet.insert(1);

// 返回 false ，表示集合中不存在 2 。
randomSet.remove(2);

// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
randomSet.insert(2);

// getRandom 应随机返回 1 或 2 。
randomSet.getRandom();

// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
randomSet.remove(1);

// 2 已在集合中，所以返回 false 。
randomSet.insert(2);

// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
randomSet.getRandom();
</pre>


## 解法

<!-- 这里可写通用的实现逻辑 -->

<!-- tabs:start -->

### **Python3**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```python
class RandomizedSet:
    def __init__(self):
        self.mp = dict()
        self.idx = -1
        self.nums = [0] * 20010

    def insert(self, val: int) -> bool:
        if val in self.mp:
            return False
        self.idx += 1
        self.mp[val] = self.idx
        self.nums[self.idx] = val
        return True

    def remove(self, val: int) -> bool:
        if val not in self.mp:
            return False
        index = self.mp[val]
        self.mp.pop(val)
        if index != self.idx:
            self.mp[self.nums[self.idx]] = index
        self.nums[index] = self.nums[self.idx]
        self.idx -= 1
        return True


    def getRandom(self) -> int:
        return self.nums[random.randint(0, self.idx)]
        



# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
```

### **Java**

<!-- 这里可写当前语言的特殊实现逻辑 -->

```java
class RandomizedSet {
    int[] nums;
    Map<Integer, Integer> mp = new HashMap<>();
    int idx;
    Random r;

    public RandomizedSet() {
        nums = new int[200010];
        mp = new HashMap<>();
        idx = -1;
        r = new Random();
    }
    
    public boolean insert(int val) {
        if (mp.containsKey(val)) {
            return false;
        }
        mp.put(val, ++idx);
        nums[idx] = val;
        return true;
    }
    
    public boolean remove(int val) {
        if (!mp.containsKey(val)) {
            return false;
        }
        int index = mp.get(val);
        mp.remove(val);
        if (index != idx) {
            mp.put(nums[idx], index);
        }
        nums[index] = nums[idx--];
        return true;
    }
    
    public int getRandom() {
        return nums[r.nextInt(idx + 1)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```

### **...**

```

```

<!-- tabs:end -->
