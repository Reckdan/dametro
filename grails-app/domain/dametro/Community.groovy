package dametro

class Community {

	
	String communityName
	Date dateCreated
	Date dateUpdated
	Metro metro
	Muser createdByUser
	Muser updatedByUser
	Submetro submetro

	static hasMany = [buildings: Building,
	                  businesses: Business,
	                  permitinfos: Permitinfo]
	static belongsTo = [Metro, Muser, Submetro]

	static mapping = {
		id column: "community_id"
		version false
	}

	static constraints = {
		
		communityName nullable: true, maxSize: 50
		dateCreated nullable: true
		dateUpdated nullable: true
	}
}
