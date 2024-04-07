class User {
    String name;
    boolean live;
    List<User> children;

    public User(String name) {
        this.name = name;
        this.live = true;
        this.children = new ArrayList<>();
    }
}

class ThroneInheritance {
    String root;
    Map<String, User> g;

    public ThroneInheritance(String kingName) {
        this.root = kingName;
        this.g = new HashMap<>();
        this.g.put(kingName, new User(kingName));
    }

    public void birth(String parentName, String childName) {
        User child = new User(childName);
        g.get(parentName).children.add(child);
        g.put(childName, child);
    }

    public void death(String name) {
        g.get(name).live = false;
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public void dfs(String name, List<String> ans) {
        User cur = g.get(name);
        if (cur.live) {
            ans.add(name);
        }
        for (User child : cur.children) {
            dfs(child.name, ans);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */