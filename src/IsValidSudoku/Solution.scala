package IsValidSudoku


// https://leetcode.com/problems/valid-sudoku/description/
object Solution {
	def isValidSudoku(board: Array[Array[Char]]): Boolean = {
		def isValidLines: Boolean = {
			def isValidLine(i: Int): Boolean = {
				val boardLineFiltered: Array[Char] =
					board(i)
					.filterNot(_ == '.')

				val occLine: Set[(Char, Int)] =
					boardLineFiltered
					.map(i => (i, boardLineFiltered.count(_ == i)))
					.toSet

				occLine.forall(_._2 == 1)
			}

			(0 until 9)
			.map(isValidLine)
			.forall(_ == true)
		}

		def isValidColumns: Boolean = {
			def isValidColumn(i: Int): Boolean = {
				val boardColumnFiltered: Array[Char] =
					board
					.map(line => line(i))
					.filterNot(_ == '.')

				val occColumn: Set[(Char, Int)] =
					boardColumnFiltered
					.map(i => (i, boardColumnFiltered.count(_ == i)))
					.toSet

				occColumn.forall(_._2 == 1)
			}

			(0 until 9)
			.map(isValidColumn)
			.forall(_ == true)
		}

		def isValidSquares: Boolean = {
			def isValidSquare(i: Int): Boolean = {
				val SQUARE_LINE_START: Int = (i / 3) * 3
				val SQUARE_LINE_END: Int = SQUARE_LINE_START + 3
				val SQUARE_COLUMN_START: Int = (i % 3) * 3
				val SQUARE_COLUMN_END: Int = SQUARE_COLUMN_START + 3

				val SQUARE: Array[Char] =
					board
					.slice(SQUARE_LINE_START, SQUARE_LINE_END)
					.flatMap(
						_.slice(SQUARE_COLUMN_START, SQUARE_COLUMN_END)
					)
					.filterNot(_ == '.')


				val occSquare: Set[(Char, Int)] =
					SQUARE
					.map(el => (el, SQUARE.count(_ == el)))
					.toSet

				occSquare.forall(_._2 == 1)
			}

			(0 until 9)
			.map(isValidSquare)
			.forall(_ == true)
		}

		isValidLines &&
		isValidColumns &&
		isValidSquares
	}
}