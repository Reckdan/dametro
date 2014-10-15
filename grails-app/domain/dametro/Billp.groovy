package dametro

class Billp {

	BigDecimal balanceBf
	BigDecimal ratePa
	BigDecimal rateableValue
	BigDecimal accountBalance
	Date billDate
	Integer billYear
	Character printed
	BigDecimal imposedRate
	Character gcatid
	BigDecimal addedArrears
	BigDecimal prevYearBill
	BigDecimal totalPaid
	Date dateUpdated
	//String preparedBy
	Muser preparedBy
	Muser updatedBy
	Building p

	static belongsTo = [Building, Muser]

	static mapping = {
		id column: "billp_id"
		version false
	}

	static constraints = {
		balanceBf nullable: true
		ratePa nullable: true
		rateableValue nullable: true
		accountBalance nullable: true
		billDate nullable: true
		printed nullable: true, maxSize: 1
		imposedRate nullable: true, scale: 6
		gcatid nullable: true, maxSize: 1
		addedArrears nullable: true
		prevYearBill nullable: true
		totalPaid nullable: true
		dateUpdated nullable: true
		preparedBy nullable: true, maxSize: 50
	}
}
