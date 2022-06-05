class Solution:

    def __init__(self, radius: float, x_center: float, y_center: float):
        self.r = radius
        self.x = x_center
        self.y = y_center

    def randPoint(self) -> List[float]:
        while True:
            nx = random.random() * 2 * self.r - self.r
            ny = random.random() * 2 * self.r - self.r
            if math.sqrt(nx * nx + ny * ny) <= self.r:
                return [nx + self.x, ny + self.y]



# Your Solution object will be instantiated and called as such:
# obj = Solution(radius, x_center, y_center)
# param_1 = obj.randPoint()