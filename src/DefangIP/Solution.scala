package DefangIP


// https://leetcode.com/problems/defanging-an-ip-address/
object Solution {
	def defangIPaddr(address: String): String = {
		address
		.replace(".", "[.]")
	}
}
