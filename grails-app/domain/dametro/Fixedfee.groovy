package dametro

class Fixedfee {

	Integer yyear
	BigDecimal ratePa
	Date dateCreated
	BigDecimal minCharge
	Character gcatId
	Eventtype type
	Metro metro
	Category category

	static belongsTo = [Category, Metro, Eventtype]

	static mapping = {
		id column: "fixedfee_id"
		version false
	}

	static constraints = {
		ratePa nullable: true, scale: 6
		dateCreated nullable: true
		minCharge nullable: true, scale: 4
		gcatId nullable: true, maxSize: 1
		yyear min:2010
	}
}
