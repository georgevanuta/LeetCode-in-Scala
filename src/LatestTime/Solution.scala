package LatestTime


// https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
object Solution {
	def maximumTime(time: String): String = {
		if (!time.contains('?')) time
		else {
			val HOUR1: Char = time.head
			val HOUR2: Char = time(1)

			val MINUTE1: Char = time(3)
			val MINUTE2: Char = time(4)

			val LATEST_MINUTE2: Char =
				if (MINUTE2 == '?') '9'
				else MINUTE2

			val LATEST_MINUTE1: Char =
				if (MINUTE1 == '?') '5'
				else MINUTE1

			val LATEST_HOUR2: Char = {
				if (HOUR2 == '?' && HOUR1 == '?') '3'
				else if (HOUR2 == '?') {
					HOUR1 match {
						case '0' => '9'
						case '1' => '9'
						case '2' => '3'
						case  _  => throw new IllegalArgumentException("[ERROR]: Can't form a vlaid time.")
					}
				}
				else HOUR2
			}

			val LATEST_HOUR1: Char = {
				if (HOUR1 == '?' && HOUR2 == '?') '2'
				else if (HOUR1 == '?') {
					if (HOUR2.toString.toInt <= 3) '2'
					else '1'
				}
				else HOUR1
			}

			f"$LATEST_HOUR1$LATEST_HOUR2:$LATEST_MINUTE1$LATEST_MINUTE2"
		}
	}
}
