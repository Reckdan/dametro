package dametro

class Category {

	String code
	String categoryName
	BigDecimal minCharge
	Character gcatId
	Date datecreated
	Date dateupdated
	Eventtype type
	Metro metro
	Muser createdByUser
	Muser updatedByUser

	static hasMany = [buildings: Building,
	                  businesses: Business,
	                  fixedfees: Fixedfee]
	static belongsTo = [Metro, Muser, Eventtype]

	static mapping = {
		id column: "category_id"
		version false
	}

	static constraints = {
		code nullable: true, maxSize: 6
		categoryName nullable: true, maxSize: 100
		minCharge nullable: true, min:10.0
		gcatId nullable: true, maxSize: 1
		datecreated nullable: true
		dateupdated nullable: true
	}
}
