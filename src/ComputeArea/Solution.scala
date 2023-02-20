package ComputeArea


// https://leetcode.com/problems/rectangle-area/
object Solution {
	def computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int = {
		def computeAreaOfIntersection: Int = {
			val LEFT_X: Int = Math.max(ax1, bx1)
			val RIGHT_X: Int = Math.min(ax2, bx2)
			val TOP_Y: Int = Math.max(ay1, by1)
			val BOTTOM_Y: Int = Math.min(ay2, by2)

			if (LEFT_X < RIGHT_X && TOP_Y < BOTTOM_Y) {
				val WIDTH: Int =  RIGHT_X - LEFT_X
				val HEIGHT: Int = BOTTOM_Y - TOP_Y

				WIDTH * HEIGHT
			}
			else 0
		}

		val A_AREA: Int = (ax2 - ax1) * (ay2 - ay1)
		val B_AREA: Int = (bx2 - bx1) * (by2 - by1)
		val INTERSECTION_AREA: Int = computeAreaOfIntersection

		A_AREA + B_AREA - INTERSECTION_AREA
	}
}
