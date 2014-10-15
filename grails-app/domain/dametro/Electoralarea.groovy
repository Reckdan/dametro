package dametro

class Electoralarea {

	String electoralareaName
	Date dateCreated
	Date dateUpdated
	Metro metro
	Muser createdByUser
	Muser updatedByUser
	Submetro submetro
	Constituency constituency

	static hasMany = [buildings: Building,
	                  businesses: Business,
	                  permitinfos: Permitinfo,
	                  units: Unit]
	static belongsTo = [Constituency, Metro, Muser, Submetro]

	static mapping = {
		id column: "electoral_area_id"
		version false
	}

	static constraints = {
		electoralareaName nullable: true, maxSize: 50
		dateCreated nullable: true
		dateUpdated nullable: true
	}
}
