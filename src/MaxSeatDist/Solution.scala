package MaxSeatDist

// https://leetcode.com/problems/maximize-distance-to-closest-person/
object Solution {
	def maxDistToClosest(seats: Array[Int]): Int = {
		def isOccupied(seatIndex: Int): Boolean = {
			seats(seatIndex) == 1
		}

		var firstIndex: Int = -1
		var secondIndex: Int = -1

		var firstOccupiedSeat: Int = -1
		var lastOccupiedSeat: Int = -1

		var distances: List[Int] = List()

		def resetVars: Unit = {
			firstIndex = secondIndex
			secondIndex = -1
		}

		for (i <- 0 to seats.size - 1) {
			if (firstIndex == -1 && isOccupied(i)) firstIndex = i
			else if (secondIndex == -1 && isOccupied(i)) {
				secondIndex = i
				distances :+= (secondIndex - firstIndex)
				resetVars
			}
			if (isOccupied(i)) {
				if (firstOccupiedSeat == -1) firstOccupiedSeat = i
				lastOccupiedSeat = i
			}
		}

		distances = distances.map(x => x / 2)

		if (!isOccupied(0) && !isOccupied(seats.size - 1)) {
			(distances ++ List(firstOccupiedSeat, seats.size - lastOccupiedSeat - 1)).max
		}
		else if (!isOccupied(0)) {
			(firstOccupiedSeat :: distances).max
		}
		else if (!isOccupied(seats.size - 1)) {
			((seats.size - lastOccupiedSeat - 1) :: distances).max
		}
		else {
			distances.max
		}
	}
}

object Main extends App {
	val seats: Array[Int] =
		Array(0, 0, 0, 1,0,0,0,1,0,1, 0, 0, 0, 0)

	println(Solution.maxDistToClosest(seats))
}