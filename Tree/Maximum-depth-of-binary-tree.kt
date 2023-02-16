class `Maximum-depth-of-binary-tree` {
    fun maxDepth(root: TreeNode?): Int {
        return dfs(root, 0)
    }

    private fun dfs(node: TreeNode?, depth: Int): Int {
        if(node == null) return depth
        return maxOf(dfs(node.left, depth + 1), dfs(node.right, depth + 1))
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
