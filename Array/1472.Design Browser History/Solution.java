class BrowserHistory {

    List<String> q = new ArrayList<>();
    int idx = 0;

    public BrowserHistory(String homepage) {
        q.add(homepage);
    }

    public void visit(String url) {
        q = q.subList(0, idx + 1);
        q.add(url);
        idx = q.size() - 1;
    }

    public String back(int steps) {
        idx = Math.max(0, idx - steps);
        return q.get(idx);
    }

    public String forward(int steps) {
        idx = Math.min(idx + steps, q.size() - 1);
        return q.get(idx);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */