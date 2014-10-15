package dametro

class Collectionarea {

	String collectionAreaType
	String collectionAreaName
	Metro metro
	Assigncollector asignment

	static belongsTo = [Assigncollector, Metro]

	static mapping = {
		id column: "collection_area_id"
		version false
	}

	static constraints = {
		collectionAreaType nullable: true, maxSize: 30
		collectionAreaName nullable: true, maxSize: 50
	}
}
