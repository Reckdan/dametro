package dametro

class BusinessPayment {

	BigDecimal arrearsPaid
	BigDecimal curruntAmtPaid
	BigDecimal amtPaid
	String pmtMode
	Date datePaid
	String gcrnr
	Long cashierId
	String collectorsReceiptNumber
	Integer adate
	Character gcatid
	String receiptGenerated
	Date effectivedate
	Collector collector
	Metro metro
	Business business

	static belongsTo = [Business, Collector, Metro]

	static mapping = {
		id column: "payment_id"
		version false
	}

	static constraints = {
		arrearsPaid nullable: true
		curruntAmtPaid nullable: true
		pmtMode nullable: true, maxSize: 50
		datePaid nullable: true
		gcrnr nullable: true, maxSize: 30
		cashierId nullable: true
		collectorsReceiptNumber nullable: true, maxSize: 20
		adate nullable: true
		gcatid nullable: true, maxSize: 1
		receiptGenerated nullable: true, maxSize: 20
		effectivedate nullable: true
	}
}
