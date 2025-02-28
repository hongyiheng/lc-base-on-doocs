class FoodRatings {

    Map<String, PriorityQueue<Pair<Integer, String>>> g = new HashMap<>();
    Map<String, Pair<String, Integer>> f = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            if (g.get(cuisines[i]) == null) {
                g.put(cuisines[i], new PriorityQueue<>((a, b) -> !a.getKey().equals(b.getKey()) ? b.getKey() - a.getKey() : a.getValue().compareTo(b.getValue())));
            }
            g.get(cuisines[i]).add(new Pair<>(ratings[i], foods[i]));
            f.put(foods[i], new Pair<>(cuisines[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = f.get(food).getKey();
        g.get(cuisine).add(new Pair<>(newRating, food));
        f.put(food, new Pair<>(cuisine, newRating));
    }

    public String highestRated(String cuisine) {
        while (!g.get(cuisine).isEmpty()) {
            Pair<Integer, String> p = g.get(cuisine).peek();
            if (!f.get(p.getValue()).getValue().equals(p.getKey())) {
                g.get(cuisine).poll();
            } else {
                return p.getValue();
            }
        }
        return null;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */