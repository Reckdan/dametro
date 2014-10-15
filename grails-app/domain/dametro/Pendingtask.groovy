package dametro

class Pendingtask {
	String taskDescription
	Date dueDate
	Metro metro
	Muser user
	
	
	static belongsTo = [Muser, Metro]
    static constraints = {
		dueDate nullable:false
		taskDescription empty:false, nullable:false
    }

}

