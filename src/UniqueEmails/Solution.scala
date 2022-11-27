package UniqueEmails

// https://leetcode.com/problems/unique-email-addresses/
object Solution {
	def toNormalEmail(email: String): String = {
		val emailSplit: Array[String] =
			email.split("@")

		var localName: String =
			emailSplit(0)
		val domain: String =
			emailSplit(1)


		localName =
			"\\.".r.replaceAllIn(localName, "")
		localName =
			localName.split('+')(0)

		s"${localName}@${domain}"
	}

	def numUniqueEmails(emails: Array[String]): Int = {
		emails.map(toNormalEmail(_)).toSet.size
	}
}

object Main {
	def main(args: Array[String]): Unit = {
		val emails: Array[String] =
			Array("test.email+alex@leetcode.com",
				  "test.e.mail+bob.cathy@leetcode.com",
				  "testemail+david@lee.tcode.com")

		println(Solution.numUniqueEmails(emails))
	}
}