package dametro

class Adjustarrear {

	String accountNo
	Integer billYear
	BigDecimal amount
	Date adjustmentDate
	Character gcatId
	Metro metro
	Muser adjustedByUser

	static belongsTo = [Metro, Muser]

	static mapping = {
		id column: "adjustarrear_id"
		version false
	}

	static constraints = {
		accountNo maxSize: 30, blank:false
		amount nullable: true
		adjustmentDate nullable: true
		gcatId nullable: true, maxSize: 1
	}
}
