package dametro

class Assigncollector {

	Date startDate
	Date endDate
	Integer collectionYear
	Date dateAdded
	Date dateUpdated
	BigDecimal targetAmt
	Collector collector
	Metro metro
	Muser updatedByUser
	Muser addedByUser

	static hasMany = [collectionareas: Collectionarea]
	static belongsTo = [Collector, Metro, Muser]

	static mapping = {
		id generator: "assigned"
		version false
	}

	static constraints = {
		startDate nullable: true
		endDate nullable: true
		collectionYear nullable: true
		dateAdded nullable: true
		dateUpdated nullable: true
		targetAmt nullable: true
	}
}
