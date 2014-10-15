package dametro

class Constituency {

	String constituencyName
	Date dateCreated
	Date dateUpdated
	Metro metro
	Muser createdByUser
	Muser updatedByUser
	Submetro submetro

	static hasMany = [buildings: Building,
	                  businesses: Business,
	                  electoralareas: Electoralarea,
	                  permitinfos: Permitinfo,
	                  units: Unit]
	static belongsTo = [Metro, Muser, Submetro]

	static mapping = {
		id column: "constituency_id"
		version false
	}

	static constraints = {
		constituencyName nullable: true, maxSize: 50
		dateCreated nullable: true
		dateUpdated nullable: true
	}
}
