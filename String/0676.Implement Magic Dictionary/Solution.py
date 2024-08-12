class MagicDictionary:

    def __init__(self):
        return

    def buildDict(self, dictionary: List[str]) -> None:
        self.ws = dictionary

    def search(self, searchWord: str) -> bool:
        for s in self.ws:
            if len(s) != len(searchWord):
                continue
            diff = 0
            for a, b in zip(s, searchWord):
                if a != b:
                    diff += 1
                if diff > 1:
                    break
            if diff == 1:
                return True
        return False


# Your MagicDictionary object will be instantiated and called as such:
# obj = MagicDictionary()
# obj.buildDict(dictionary)
# param_2 = obj.search(searchWord)