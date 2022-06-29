class Codec:
    def __init__(self):
        self.idx = 0
        self.mp = {}

    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        self.idx += 1
        self.mp[self.idx] = longUrl
        return self.idx


    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        return self.mp[shortUrl]


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))