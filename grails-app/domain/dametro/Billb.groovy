package dametro

class Billb {

	BigDecimal balancebf
	BigDecimal ratePa
	BigDecimal rateableValue
	BigDecimal accountBalance
	Date billDate
	Integer billYear
	Character printed
	BigDecimal imposedRate
	Character gcatId
	BigDecimal addedArrears
	BigDecimal prevYearBill
	BigDecimal totalPaid
	Date dateUpdated
	Muser preparedBy
	Muser updatedBy
	Business b

	static belongsTo = [Business, Muser]

	static mapping = {
		id column: "billb_id"
		version false
	}

	static constraints = {
		balancebf nullable: true
		ratePa nullable: true
		rateableValue nullable: true
		accountBalance nullable: true
		billDate nullable: true
		printed nullable: true, maxSize: 1
		imposedRate nullable: true, scale: 6
		gcatId nullable: true, maxSize: 1
		addedArrears nullable: true
		prevYearBill nullable: true
		totalPaid nullable: true
		dateUpdated nullable: true
	}
}
