class BrowserHistory:

    def __init__(self, homepage: str):
        self.q = [homepage]
        self.idx = 0

    def visit(self, url: str) -> None:
        self.q = self.q[:self.idx + 1]
        self.q.append(url)
        self.idx = len(self.q) - 1

    def back(self, steps: int) -> str:
        self.idx = max(0, self.idx - steps)
        return self.q[self.idx]

    def forward(self, steps: int) -> str:
        self.idx = min(self.idx + steps, len(self.q) - 1)
        return self.q[self.idx]

# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)