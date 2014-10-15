package dametro

class Collectoralert {

	String accountNo
	Long collectorId
	Date dateofvisit
	Date expectedCollectionDate

	static mapping = {
		id column: "collectoralert_id"
		version false
	}

	static constraints = {
		accountNo nullable: true, maxSize: 20
		collectorId nullable: true
		dateofvisit nullable: true
		expectedCollectionDate nullable: true
	}
}
