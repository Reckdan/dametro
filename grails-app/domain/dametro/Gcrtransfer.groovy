package dametro

class Gcrtransfer {

	Date datetransferred
	String typeCode
	Boolean isused
	Boolean isdamaged
	Boolean ismissing
	Book book
	Metro metro
	Collector transferedtoCollector
	Collector transferfromCollector

	static belongsTo = [Book, Collector, Metro]

	static mapping = {
		id column: "gcrtransfer_id"
		version false
	}

	static constraints = {
		datetransferred nullable: true
		typeCode nullable: true, maxSize: 6
		isused nullable: true, maxSize: 1
		isdamaged nullable: true, maxSize: 1
		ismissing nullable: true, maxSize: 1
	}
}
