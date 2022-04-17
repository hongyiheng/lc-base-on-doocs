class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        ban = set(banned)
        paragraph = paragraph.lower()
        cnt = dict()
        ans, cur = "", ""
        for c in paragraph:
            if c.isalpha():
                cur += c
                continue
            word = cur
            cur = ""
            if word == "" or word in ban:
                continue
            cnt[word] = cnt.get(word, 0) + 1
            if cnt.get(ans, 0) < cnt[word]:
                ans = word
        if cur != "" and cnt.get(ans, 0) < cnt.get(cur, 0) + 1:
            ans = cur
        return ans