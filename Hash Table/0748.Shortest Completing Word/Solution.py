class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        licensePlate = licensePlate.lower()
        mp = [0] * 26
        for i in range(len(licensePlate)):
            index = ord(licensePlate[i]) - ord('a')
            if 0 <= index < 26:
                mp[index] += 1
        min_len, ans = float("inf"), None
        for word in words:
            if len(word) >= min_len:
                continue
            temp = mp[:]
            flag = True
            for i in range(len(word)):
                index = ord(word[i]) - ord('a')
                temp[index] -= 1
            for num in temp:
                if num > 0:
                    flag = False
                    break
            if flag:
                min_len = len(word)
                ans = word
        return ans