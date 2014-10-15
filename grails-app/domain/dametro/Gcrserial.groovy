package dametro

class Gcrserial {

	String gcrno
	Character isUsed
	Character isDamaged
	Collector collector
	Book book
	Metro metro

	static belongsTo = [Book, Collector, Metro]

	static mapping = {
		id column: "gcrserial_id"
		version false
	}

	static constraints = {
		gcrno maxSize: 20
		isUsed nullable: true, maxSize: 1
		isDamaged nullable: true, maxSize: 1
	}
}
