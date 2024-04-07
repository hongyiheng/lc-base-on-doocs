class User:
    def __init__(self, name):
        self.name = name
        self.live = True
        self.children = []

class ThroneInheritance:

    def __init__(self, kingName: str):
        self.root = kingName
        self.g = dict()
        self.g[kingName] = User(kingName)

    def birth(self, parentName: str, childName: str) -> None:
        child = User(childName)
        self.g[parentName].children.append(child)
        self.g[childName] = child

    def death(self, name: str) -> None:
        self.g[name].live = False

    def getInheritanceOrder(self) -> List[str]:
        def dfs(name):
            cur = self.g[name]
            if cur.live:
                ans.append(name)
            for child in cur.children:
                dfs(child.name)

        ans = []
        dfs(self.root)
        return ans



# Your ThroneInheritance object will be instantiated and called as such:
# obj = ThroneInheritance(kingName)
# obj.birth(parentName,childName)
# obj.death(name)
# param_3 = obj.getInheritanceOrder()