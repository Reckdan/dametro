package dametro

class Defaulterslist {

	String accountNo
	Integer billYear
	Double accountBalance
	Double currentBalance
	Character gcatId
	Metro metro

	static belongsTo = [Metro]

	static mapping = {
		id column: "defaulterslist_id"
		version false
	}

	static constraints = {
		accountNo maxSize: 30
		accountBalance nullable: true
		currentBalance nullable: true
		gcatId nullable: true, maxSize: 1
	}
}
