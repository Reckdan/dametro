package dametro

class Book {

	Integer startSerial
	Integer endSerial
	String serialrange
	Integer quantity
	String voucherNo
	Date date
	Metro metro
	Lookup type

	static hasMany = [collectorgcrs: Collectorgcr,
	                  gcrserials: Gcrserial,
	                  gcrtransfers: Gcrtransfer]
	static belongsTo = [Lookup, Metro]

	static mapping = {
		quantity formula: 'end_serial-start_serial+1'
		serialrange formula: "CONCAT(start_serial, '-',end_serial)"
		id column: "book_id"
		version true
	}

	static constraints = {
		startSerial nullable:false, min:10000, validator: { val, obj ->
			if(obj.endSerial-val+1>100) return 'serialrangegt100'
			else if(obj.endSerial-val+1<1) return 'largerstartserial'
		}
		endSerial nullable: false, min: 10000
		voucherNo nullable: true, maxSize: 20
		date nullable: true
	}
}
