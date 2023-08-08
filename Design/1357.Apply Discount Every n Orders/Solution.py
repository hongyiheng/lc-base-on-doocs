class Cashier:

    def __init__(self, n: int, discount: int, products: List[int], prices: List[int]):
        self.n = n
        self.cur = 0
        self.discount = discount
        self.skus = dict()
        for a, b in zip(products, prices):
            self.skus[a] = b


    def getBill(self, product: List[int], amount: List[int]) -> float:
        ans = 0
        for a, b in zip(product, amount):
            ans += (self.skus[a] * b)
        self.cur += 1
        if self.cur == self.n:
            self.cur = 0
            ans = ans - (self.discount / 100) * ans
        return ans



# Your Cashier object will be instantiated and called as such:
# obj = Cashier(n, discount, products, prices)
# param_1 = obj.getBill(product,amount)