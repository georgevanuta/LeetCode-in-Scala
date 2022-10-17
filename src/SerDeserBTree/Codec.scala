package SerDeserBTree


class TreeNode(var _value: Int) {
    var value: Int = _value
 	var left: TreeNode = null
 	var right: TreeNode = null


class Codec {
	def listToStringFormat(l: List[Int]): String = {
		var strL: String = "["

		for (i <- 0 to (l.length - 2)) {
			strL += s"${l(i)},"
		}

		if (l.length > 1) strL += s"${l.last}"
		strL += "]"

		strL
	}

	def formatStringToList(strL: String): List[Int] = {
		strL
			.slice(1, strL.length - 1)
			.split(",")
			.foldRight(List(): List[Int])((curr: String, acc: List[Int]) => curr.toInt :: acc)
	}

	// Encodes a list of strings to a single string.
	def serialize(root: TreeNode): String = {
		def serializeAux(root: TreeNode): List[Int] = {
			if (root == null) return List()

			root.value :: (serializeAux(root.left) ++ serializeAux(root.right))
		}
		listToStringFormat(serializeAux(root))
	}
	}

	// Decodes a single string to a list of strings.
	def deserialize(data: String): TreeNode = {
		new TreeNode(1)
	}
}


object Main {
	def main(args: Array[String]): Unit = {
		println()
	}
}
