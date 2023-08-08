class Cashier {

    Map<Integer, Integer> skus;
    int n = 0, cur = 0, discount = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        skus = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            skus.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        double ans = 0;
        for (int i = 0; i < product.length; i++) {
            ans += skus.get(product[i]) * amount[i];
        }
        if (++cur == n) {
            cur = 0;
            ans = ans - (discount / 100.0) * ans;
        }
        return ans;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */