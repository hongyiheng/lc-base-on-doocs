class FoodRatings:

    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.g = defaultdict(list)
        self.foods = defaultdict(list)
        for c, f, r in zip(cuisines, foods, ratings):
            self.g[c].append((-r, f))
            self.foods[f] = [c, r]
        for q in self.g.values():
            heapify(q)

    def changeRating(self, food: str, newRating: int) -> None:
        heapq.heappush(self.g[self.foods[food][0]], (-newRating, food))
        self.foods[food][1] = newRating

    def highestRated(self, cuisine: str) -> str:
        while self.g[cuisine]:
            r, f = self.g[cuisine][0]
            if -r == self.foods[f][1]:
                return f
            heapq.heappop(self.g[cuisine])

# Your FoodRatings object will be instantiated and called as such:
# obj = FoodRatings(foods, cuisines, ratings)
# obj.changeRating(food,newRating)
# param_2 = obj.highestRated(cuisine)