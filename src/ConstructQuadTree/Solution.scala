package ConstructQuadTree


class Node(var _value: Boolean, var _isLeaf: Boolean) {
	var value: Boolean = _value
	var isLeaf: Boolean = _isLeaf
	var topLeft: Node = null
	var topRight: Node = null
	var bottomLeft: Node = null
	var bottomRight: Node = null
}


// https://leetcode.com/problems/construct-quad-tree/description/
object Solution {
	private type Grid = Array[Array[Int]]

	private type Quarters =
		(Grid, Grid, Grid, Grid)

	def construct(grid: Grid): Node = {
		def divideGrid(grid: Array[Array[Int]]): Option[Quarters] = {
			if (grid.length == 1) None
			else {
				val GRID_LEN: Int = grid.length
				val QUARTER_LEN: Int = GRID_LEN / 2

				val UPPER_LEFT: Grid =
					grid
					.slice(0, QUARTER_LEN)
					.map(_.slice(0, QUARTER_LEN))

				val UPPER_RIGHT: Grid =
					grid
					.slice(0, QUARTER_LEN)
					.map(_.slice(QUARTER_LEN, GRID_LEN))

				val LOWER_LEFT: Grid =
					grid
					.slice(QUARTER_LEN, GRID_LEN)
					.map(_.slice(0, QUARTER_LEN))

				val LOWER_RIGHT: Grid = {
					grid
					.slice(QUARTER_LEN, GRID_LEN)
					.map(_.slice(QUARTER_LEN, GRID_LEN))
				}

				Some(
					(
					UPPER_LEFT,
					UPPER_RIGHT,
					LOWER_LEFT,
					LOWER_RIGHT
					)
				)
			}
		}

		def isLeaf(grid: Grid): Boolean = {
			if (grid.isEmpty) return false

			val FIRST_EL: Int = grid.head.head

			grid
			.forall(
				line =>
					line
					.forall(
						el => el == FIRST_EL
					)
			)
		}

		if (isLeaf(grid)) {
			val FIRST_EL: Int = grid.head.head

			new Node(
				FIRST_EL == 1,
				true
			)
		}
		else {
			divideGrid(grid) match {
				case Some(quarters) => {
					val UPPER_LEFT: Grid = quarters._1
					val UPPER_RIGHT: Grid = quarters._2
					val LOWER_LEFT: Grid = quarters._3
					val LOWER_RIGHT: Grid = quarters._4

					var nextNode: Node =
						new Node(
							true,
							false,
						)

					nextNode.topLeft =
						construct(UPPER_LEFT)

					nextNode.topRight =
						construct(UPPER_RIGHT)

					nextNode.bottomLeft =
						construct(LOWER_LEFT)

					nextNode.bottomRight =
						construct(LOWER_RIGHT)

					nextNode
				}

				case None => {
					null
				}
			}
		}

	}
}

