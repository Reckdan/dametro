package dametro

class Eventtype {

	String code
	String typeName
	Character gcatId
	String budgetCode
	Date dateCreated
	Date dateUpdated
	Metro metro
	Muser createdByUser
	Muser updatedByUser

	static hasMany = [buildings: Building,
	                  businesses: Business,
	                  categories: Category,
	                  fixedfees: Fixedfee]
	static belongsTo = [Metro, Muser]

	static mapping = {
		id column: "type_id"
		version false
	}

	static constraints = {
		code nullable: true, maxSize: 6
		typeName nullable: true, maxSize: 100
		gcatId nullable: true, maxSize: 1
		budgetCode nullable: true, maxSize: 10
		dateCreated nullable: true
		dateUpdated nullable: true
	}
}
