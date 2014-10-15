package dametro

class Notification {
	String itemDesc
	Date dueDate
	Integer noofdaystonotify
	Muser user
	Metro metro
	static belongsTo = [Muser, Metro]
    static constraints = {
		itemDesc nullable:false,empty:false
		noofdaystonotify minSize:1
    }
}
