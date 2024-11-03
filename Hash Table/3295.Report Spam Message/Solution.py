class Solution:
    def reportSpam(self, message: List[str], bannedWords: List[str]) -> bool:
        bans = set(bannedWords)
        return sum(1 if s in bans else 0 for s in message) >= 2
