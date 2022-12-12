class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        cnt = [False] * 26
        for c in sentence:
            cnt[ord(c) - ord('a')] = True
        ans = True
        for v in cnt:
            ans = ans and v
        return ans
