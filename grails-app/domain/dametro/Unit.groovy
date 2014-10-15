package dametro

class Unit {

	String unitName
	Date dateCreated
	Date dateUpdated
	Metro metro
	Muser createdByUser
	Electoralarea electoralarea
	Muser updatedByUser
	Submetro submetro
	Constituency constituency

	static hasMany = [buildings: Building,
	                  businesses: Business,
	                  permitinfos: Permitinfo]
	static belongsTo = [Constituency, Electoralarea, Metro, Muser, Submetro]

	static mapping = {
		id column: "unit_id"
		version false
	}

	static constraints = {
		unitName nullable: true, maxSize: 50
		dateCreated nullable: true
		dateUpdated nullable: true
	}
}
