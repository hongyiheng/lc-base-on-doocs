from typing import List


class Robot:
    def __init__(self, width: int, height: int):
        self.w = width
        self.h = height
        self.path = []

        for x in range(width):
            self.path.append((x, 0))
        for y in range(1, height):
            self.path.append((width - 1, y))
        for x in range(width - 2, -1, -1):
            self.path.append((x, height - 1))
        for y in range(height - 2, 0, -1):
            self.path.append((0, y))

        self.idx = 0
        self.moved = False

    def step(self, num: int) -> None:
        if num > 0:
            self.moved = True
            self.idx = (self.idx + num) % len(self.path)

    def move(self, num: int) -> None:
        self.step(num)

    def getPos(self) -> List[int]:
        x, y = self.path[self.idx]
        return [x, y]

    def getDir(self) -> str:
        if self.idx == 0:
            return "South" if self.moved else "East"
        if self.idx < self.w:
            return "East"
        if self.idx < self.w + self.h - 1:
            return "North"
        if self.idx < self.w * 2 + self.h - 2:
            return "West"
        return "South"


# Your Robot object will be instantiated and called as such:
# obj = Robot(width, height)
# obj.step(num)
# param_2 = obj.getPos()
# param_3 = obj.getDir()
