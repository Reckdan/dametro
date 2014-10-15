package dametro

class Collectorgcr {

	Date dateAssigned
	Date dateReturn
	String typeCode
	String ownerType
	Boolean isReturned
	Boolean isDamaged
	Boolean isMissing
	Boolean isUsed
	Boolean instock
	Collector collector
	Book book
	Metro metro

	static belongsTo = [Book, Collector, Metro]

	static mapping = {
		id column: "collectorgcr_id"
		version false
	}

	static constraints = {
		dateAssigned nullable: true
		dateReturn nullable: true
		typeCode nullable: true, maxSize: 6
		ownerType nullable: true, maxSize: 20
		isReturned nullable: true, maxSize: 1
		isDamaged nullable: true, maxSize: 1
		isMissing nullable: true, maxSize: 1
		isUsed nullable: true, maxSize: 1
		instock nullable: true, maxSize: 1
	}
}
