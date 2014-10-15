package dametro

class PropertyUse {

	String useCode
	String propertyUse
	Metro metro

	static hasMany = [buildings: Building]
	static belongsTo = [Metro]

	static mapping = {
		version false
	}

	static constraints = {
		useCode maxSize: 10
		propertyUse nullable: true, maxSize: 100
	}
}
