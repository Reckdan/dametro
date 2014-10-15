package dametro

class LookupType {

	String typeDesc

	static mapping = {
		id column: "lookup_type_id"
		version false
	}

	static constraints = {
		typeDesc nullable: true, maxSize: 30
	}
}
