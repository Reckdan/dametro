package dametro

class Street {

	String streetName
	Date dateCreated
	Date dateUpdated
	Metro metro
	Muser createdByUser
	Muser updatedByUser
	Constituency constituency
	Submetro submetro

	static hasMany = [buildings: Building,
	                  businesses: Business,
	                  permitinfos: Permitinfo]
	static belongsTo = [Metro, Muser, Submetro,Constituency]

	static mapping = {
		id column: "street_id"
		version false
	}

	static constraints = {
		streetName nullable: true, maxSize: 50
		dateCreated nullable: true
		dateUpdated nullable: true
	}
}
