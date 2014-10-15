package dametro

class Submetro {

	String submetroName
	Date dateAdded
	Date dateUpdated
	Metro metro
	Muser updatedByUser
	Muser addedByUser

	static hasMany = [buildings: Building,
	                  businesses: Business,
	                  constituencies: Constituency,
	                  electoralareas: Electoralarea,
	                  permitinfos: Permitinfo,
	                  streets: Street,
	                  units: Unit]
	static belongsTo = [Metro, Muser]

	static mapping = {
		id column: "submetro_id"
		version false
	}

	static constraints = {
		submetroName nullable: true, maxSize: 50
		dateAdded nullable: true
	}
}
