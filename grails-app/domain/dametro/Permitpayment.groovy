package dametro

class Permitpayment {

	BigDecimal amountPaid
	String paymentFor
	Date datePaid
	String modeOfPayment
	String receiptNo
	Permitinfo permit

	static belongsTo = [Permitinfo]

	static mapping = {
		id column: "payment_id"
		version false
	}

	static constraints = {
		amountPaid nullable: true
		paymentFor nullable: true, maxSize: 30
		datePaid nullable: true
		modeOfPayment nullable: true, maxSize: 30
		receiptNo nullable: true, maxSize: 20
	}
}
