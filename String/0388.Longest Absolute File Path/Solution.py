class Solution:
    def lengthLongestPath(self, input: str) -> int:
        mp = dict()
        i, ans, n = 0, 0, len(input)
        while i < n:
            level = 0
            while i < n and input[i] == '\t':
                i += 1
                level += 1
            j = i
            is_dir = True
            while j < n and input[j] != '\n':
                if input[j] == '.':
                    is_dir = False
                j += 1
            cur = mp.get(level - 1, 0)
            cur += j - i if level == 0 else j - i + 1
            if is_dir:
                mp[level] = cur
            else:
                ans = max(ans, cur)
            i = j + 1
        return ans