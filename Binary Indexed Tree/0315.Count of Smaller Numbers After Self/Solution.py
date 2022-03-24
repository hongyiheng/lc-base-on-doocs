class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        n = len(nums)
        tree = [0] * (n + 10)

        def lowbit(x):
            return x & -x

        def query(x):
            i, ans = x, 0
            while i > 0:
                ans += tree[i]
                i -= lowbit(i)
            return ans

        def add(index, incr):
            i = index
            while i <= len(tree):
                tree[i] += incr
                i += lowbit(i)

        temp = nums[::]
        temp.sort()
        index = 1
        mp = dict()
        for v in temp:
            if v in mp:
                continue
            mp[v] = index
            index += 1
        ans = []
        for v in nums[::-1]:
            index = mp[v]
            ans.append(query(index - 1))
            add(index, 1)
        return ans[::-1]