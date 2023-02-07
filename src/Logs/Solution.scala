package Logs

// https://leetcode.com/problems/reorder-data-in-log-files/
object Solution {
	def reorderLogFiles(logs: Array[String]): Array[String] = {
		def getDigLogs(): Array[String] = {
			logs.filter(log => log.split(" ")(1).head.isDigit)
		}
		def getLowLogs(): Array[String] = {
			def getContents(log: String) = {
				log.split(" ").tail.mkString(" ")
			}
			def getId(log: String) = {
				log.split(" ").head
			}
			logs.filterNot(log => log.split(" ")(1).head.isDigit)
			.sortWith((l1, l2) =>
				if (getContents(l1) < getContents(l2)) true
				else if (getContents(l1) > getContents(l2)) false
				else if (getId(l1) <= getId(l2)) true
				else false)
		}
		getLowLogs().concat(getDigLogs())
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		val logs =
			Array("a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car")
		println(Solution.reorderLogFiles(logs).toList)
	}
}