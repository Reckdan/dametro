package dametro

class Propertypayment {

	BigDecimal arrearsPaid
	BigDecimal currentAmtPaid
	BigDecimal amtPaid
	String pmtMode
	Date datePaid
	String gcrnr
	Long cashierId
	String operativeorgOrgname
	String collectorsReceiptNumber
	Integer adate
	Character gcatid
	String generatedReceipt
	Date effectivedate
	Collector collector
	Metro metro
	Building p

	static belongsTo = [Building, Collector, Metro]

	static mapping = {
		id column: "payment_id"
		version false
	}

	static constraints = {
		arrearsPaid nullable: true
		currentAmtPaid nullable: true
		pmtMode nullable: true, maxSize: 50
		datePaid nullable: true
		gcrnr nullable: true, maxSize: 30
		cashierId nullable: true
		operativeorgOrgname nullable: true, maxSize: 100
		collectorsReceiptNumber nullable: true, maxSize: 20
		adate nullable: true
		gcatid nullable: true, maxSize: 1
		generatedReceipt nullable: true, maxSize: 20
		effectivedate nullable: true
	}
}
