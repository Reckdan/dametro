package dametro

class Industry {

	String industry

	static mapping = {
		id column: "industry_id"
		version false
	}

	static constraints = {
		industry nullable: true, maxSize: 100
	}
}
