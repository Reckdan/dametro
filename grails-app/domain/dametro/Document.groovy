package dametro

class Document {

	String documentType
	String ddocument
	Permitinfo permit

	static belongsTo = [Permitinfo]

	static mapping = {
		version false
	}

	static constraints = {
		documentType nullable: true, maxSize: 50
		ddocument nullable: true, maxSize: 500
	}
}
