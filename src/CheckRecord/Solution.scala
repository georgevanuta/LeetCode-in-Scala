package CheckRecord

// https://leetcode.com/problems/student-attendance-record-i/
object Solution {
	def checkRecord(s: String): Boolean = {
		"LLL+".r.findFirstMatchIn(s) match {
			case Some(_) => false
			case None => "A".r.findAllIn(s).size < 2
		}
	}
}