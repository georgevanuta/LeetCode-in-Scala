package EmployeeImportance

class Employee() {
	var id: Int = 0
	var importance: Int = 0
	var subordinates: List[Int] = List()
}


// https://leetcode.com/problems/employee-importance/
object Solution {
	def getImportance(employees: List[Employee], id: Int): Int = {
		var allSubordinates: Set[Int] = Set()
		var importance: Int = 0

		def findEmployeeById(emId: Int): Employee = {
			employees.find(e => e.id == emId) match {
				case Some(em) => em
				case None => throw new IllegalArgumentException("Employee not found")
			}
		}

		def recurse(emId: Int): Unit = {
			if (!allSubordinates.contains(emId)) {
				val currEmployee: Employee = findEmployeeById(emId)
				allSubordinates += emId
				importance += currEmployee.importance
				for (sub <- currEmployee.subordinates) recurse(sub)
			}
		}

		recurse(id)

		importance
	}
}