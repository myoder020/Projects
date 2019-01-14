class Tree:
    def __init__(self,pos):
        self.parent = None
        self.child = None
        self.pos = pos

    def setChild(self, child):
        self.child = child

    def setParent(self, parent):
        self.parent = parent

