package SimplifyPath

import scala.collection.mutable.Stack

// https://leetcode.com/problems/simplify-path/
object Solution {
	def simplifyPath(path: String): Any = {
		val dirs: List[String] =
			path
			.replaceAll("""/+""", "/")
			.split("/")
			.filter(!List("", ".").contains(_))
			.toList

		val simplifiedDirs : Stack[String] = Stack()

		for (dir <- dirs) {
			dir match {
				case ".." => if (!simplifiedDirs.isEmpty) simplifiedDirs.pop()
				case _	  => simplifiedDirs.push(dir)
			}
		}

		"/" + simplifiedDirs.reverse.mkString("/")
	}
}


object Main {
	def main(args: Array[String]): Unit = {
		println(Solution.simplifyPath("/hi/iam/../.././start////wtf"))
	}
}