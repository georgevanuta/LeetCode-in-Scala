import scala.collection.immutable.HashMap
import scala.annotation.tailrec
import java.io.{ File, PrintWriter }


object Main {
	private final val README_PATH: String =
		"../../README.md"


	private final val DIFFICULTIES: Set[String] =
		Set("E", "M", "H")


	private final val EASY_HEADER: String = "## Easy"
	private final val MEDIUM_HEADER: String = "## Medium"
	private final val HARD_HEADER: String = "## Hard"


	private final val DIFF_MAP: HashMap[String, String] =
		HashMap(
		"E" -> EASY_HEADER,
		"M" -> MEDIUM_HEADER,
		"H" -> HARD_HEADER
		)


	private def exitIf(cond: Boolean, msg: String): Unit = {
		if (cond) {
			println(msg)
			sys.exit(1)
		}
	}


	private def extractProblemNumber(title: String): Option[Int] = {
		f"^[0-9]+"
		.r
		.findFirstIn(title) match {
			case Some(nr) => Some(nr.toInt)
			case None => None
		}
	}


	private def updateREADME(title: String, number: Int, difficulty: String): Unit = {
		val source = scala.io.Source.fromFile(README_PATH)

		val SOURCE_LINES: List[String] =
			source
			.getLines()
			.toList

		val HEADER: String = DIFF_MAP.getOrElse(difficulty, "")

		def getLineNrForHeader(header: String): Int = {
			SOURCE_LINES
			.indexWhere(_ == header)
		}


		def getNextHeaderIndex(header: String): Int = {
			if (header == EASY_HEADER)
				getLineNrForHeader(MEDIUM_HEADER)
			else if (header == MEDIUM_HEADER)
				getLineNrForHeader(HARD_HEADER)
			else
				SOURCE_LINES.length
		}

		val START_INDEX: Int = getLineNrForHeader(HEADER) + 2
		def END_INDEX: Int =
			getNextHeaderIndex(HEADER) -
			{
				if (HEADER == HARD_HEADER) 0
				else 1
			}

		val LINES_OF_INTEREST: List[String] =
			SOURCE_LINES
			.slice(START_INDEX, END_INDEX)


		var isLastLine: Boolean = false

		@tailrec
		def searchForInsertIndex(
								problemNr: Int = number,
								lines: List[String] = LINES_OF_INTEREST,
								lastIndex: Int = 0,
								): Int = {

			if (lines.isEmpty) {
				isLastLine = true
				lastIndex
			}
			else if (lines.head.isEmpty)
				searchForInsertIndex(
					problemNr,
					lines.tail,
					lastIndex + 1
				)
			else {
				val LINE_NR: Option[Int] =
					extractProblemNumber(lines.head.tail)


				LINE_NR match {
					case Some(nr) => {
						exitIf(
							nr == problemNr,
							"[ERROR]: Problem is already present"
						)

						if (nr > problemNr) {
							lastIndex
						}
						else
							searchForInsertIndex(
								problemNr,
								lines.tail,
								lastIndex + 1
							)

					}
					case None =>
						searchForInsertIndex(
							problemNr,
							lines.tail,
							lastIndex + 1
						)
				}
			}
		}




		def getLineMD: String = {
			val ABSOLUTE_SOLUTION_PATH: String =
				System.getProperty("user.dir")

			def getRelativePathToReadMe(absPath: String = ABSOLUTE_SOLUTION_PATH): String = {
				val SRC_DIR: String = "src"


				val SRC_INDEX: Int =
					absPath
					.split("/")
					.indexWhere(_ == SRC_DIR)

				absPath
				.split("/")
				.zipWithIndex
				.filter(
					pr => {
						pr._2 >= SRC_INDEX
					}
				)
				.map(_._1)
				.mkString("/")
			}

			val RELATIVE_SOLUTION_PATH: String =
				getRelativePathToReadMe()

			val FILE_NAMES: Array[String] =
				(new File(ABSOLUTE_SOLUTION_PATH))
				.listFiles
				.map(_.getName)

			exitIf(
				FILE_NAMES.isEmpty,
				"[ERROR]: No solution provided"
			)

			val SOLUTION_FILE_NAME: String =
				FILE_NAMES.head

			f"[$title]($RELATIVE_SOLUTION_PATH/$SOLUTION_FILE_NAME)" ++
			{
				if (isLastLine) ""
				else " \\"
			}
		}

		val RELATIVE_INSERT_INDEX: Int =
			searchForInsertIndex()

		val PROBLEM_LINE_MD: String =
			getLineMD

		val LINES_OF_INTEREST_UPDATED: List[String] =
			if (isLastLine) {
				LINES_OF_INTEREST
				.reverse
				.tail
				.reverse :+
				f"${LINES_OF_INTEREST.last} \\"
			}
			else LINES_OF_INTEREST

		val UPDATED_SECTION: List[String] =
			((LINES_OF_INTEREST_UPDATED.slice(0, RELATIVE_INSERT_INDEX) :+ PROBLEM_LINE_MD) ++
			LINES_OF_INTEREST_UPDATED.slice(RELATIVE_INSERT_INDEX, LINES_OF_INTEREST_UPDATED.length))

		val UPDATED_README: String =
			(
			SOURCE_LINES
			.slice(0, START_INDEX) ++
			UPDATED_SECTION ++
			SOURCE_LINES
			.slice(END_INDEX, SOURCE_LINES.length)
			)
			.mkString("\n")


		new PrintWriter(README_PATH) {
			try write(UPDATED_README)
			finally close()
		}

		source.close()
	}


	def pushToGit(number: Int): Unit = {
		import sys.process._

		f"git add ${README_PATH}".!!
		f"git add ${System.getProperty("user.dir")}".!!
		f"git commit -m \"added $number\"".!!
		"git push -f origin main".!!

		println("[UPDATE]: Solution pushed")
	}


	def main(args: Array[String]): Unit = {
		exitIf(
			args.length != 2,
			"[USAGE]: scala-cli ../../leet.scala -- \"<PROBLEM_NUMBER>. <PROBLEM_TITLE>\" \"<DIFFICULTY>\""
		)

		val PROBLEM_TITLE: String = args(0)

		val PROBLEM_NUMBER: Int =
			extractProblemNumber(PROBLEM_TITLE) match {
				case Some(nr) => nr
				case None => {
					exitIf(
						true,
						"[USAGE]: first argument should be in the following format: \"<PROBLEM_NR>. <PROBLEM_TITLE>\""
					)
					-1
				}
			}

		val DIFFICULTY: String = args(1)

		exitIf(
			!DIFFICULTIES.contains(DIFFICULTY),
			"[USAGE]: second argument should be E (EASY), M (MEDIUM) or H (HARD)"
		)

		updateREADME(PROBLEM_TITLE, PROBLEM_NUMBER, DIFFICULTY)

		pushToGit(PROBLEM_NUMBER)
	}

}

