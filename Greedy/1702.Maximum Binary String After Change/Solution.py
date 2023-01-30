class Solution:
    def maximumBinaryString(self, binary: str) -> str:
        cnt, begin = 0, 0x3f3f3f
        for i, c in enumerate(binary):
            if c == '0':
                cnt += 1
                begin = min(i, begin)
        if cnt <= 1:
            return binary
        ans = ['1'] * len(binary)
        ans[begin + cnt - 1] = '0'
        return "".join(ans)