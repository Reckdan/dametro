package dametro

class Accountsetting {

	Integer metroId
	Integer accountLength
	Character autogenerate
	String code
	Integer submetroStart
	Integer submetroEnd
	Integer electoralAreaStart
	Integer electoralAreaEnd
	Integer townareaStart
	Integer townareaEnd
	Integer streetStart
	Integer streetEnd
	String gcatId
	String locationCodeLength

	static mapping = {
		id column: "accountsetting_id"
		version true
	}

	static constraints = {
		accountLength nullable: true
		autogenerate nullable: true, maxSize: 1
		code nullable: true, maxSize: 50
		submetroStart nullable: true
		submetroEnd nullable: true
		electoralAreaStart nullable: true
		electoralAreaEnd nullable: true
		townareaStart nullable: true
		townareaEnd nullable: true
		streetStart nullable: true
		streetEnd nullable: true
		gcatId maxSize: 2
		locationCodeLength nullable: true, maxSize: 10
	}
}
