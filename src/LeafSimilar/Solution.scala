package LeafSimilar

case class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
 }

// https://leetcode.com/problems/leaf-similar-trees/
object Solution {
	def getLeafSeq(root: TreeNode): List[Int] = {
		if (root == null) return List()

		if (root.left == null && root.right == null) return List(root.value)

		if (root.left == null) return getLeafSeq(root.right)

		if (root.right == null ) return getLeafSeq(root.left)

		getLeafSeq(root.left) ++ getLeafSeq(root.right)
	}

	def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
		getLeafSeq(root1) == getLeafSeq(root2)
	}
}

