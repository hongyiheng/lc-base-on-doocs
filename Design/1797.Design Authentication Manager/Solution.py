class AuthenticationManager:

    def __init__(self, timeToLive: int):
        self.t = timeToLive
        self.mp = dict()


    def generate(self, tokenId: str, currentTime: int) -> None:
        self.mp[tokenId] = currentTime + self.t


    def renew(self, tokenId: str, currentTime: int) -> None:
        if self.mp.get(tokenId, -1) > currentTime:
            self.mp[tokenId] = currentTime + self.t


    def countUnexpiredTokens(self, currentTime: int) -> int:
        ans = 0
        for v in self.mp.values():
            if v > currentTime:
                ans += 1
        return ans



# Your AuthenticationManager object will be instantiated and called as such:
# obj = AuthenticationManager(timeToLive)
# obj.generate(tokenId,currentTime)
# obj.renew(tokenId,currentTime)
# param_3 = obj.countUnexpiredTokens(currentTime)