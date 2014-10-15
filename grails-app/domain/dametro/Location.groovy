package dametro

class Location {

	String locationName
	Date locationTime
	String city
	String region
	String state
	String country
	String postalCode
	Metro metro

	static hasMany = [musers: Muser]
	static belongsTo = [Metro]

	static mapping = {
		id column: "location_id"
		version false
	}

	static constraints = {
		locationName nullable: true, maxSize: 50
		locationTime nullable: true
		city nullable: true, maxSize: 50
		region nullable: true, maxSize: 50
		state nullable: true, maxSize: 50
		country nullable: true, maxSize: 50
		postalCode nullable: true, maxSize: 15
	}
}
