package dametro

class Cashier {

	String firstName
	String lastName
	String otherNames
	String houseAddress
	String fullName
	String postalAddress
	String telephone
	String email
	BigDecimal pctCommission
	Date dateAdded
	Date dateUpdated
	Metro metro
	Muser updatedByUser
	Muser addedByUser

	static belongsTo = [Metro, Muser]

	static mapping = {
		id column: "cashier_id"
		version true
		fullName formula: "CONCAT(first_name,' ',last_name)"
	}

	static constraints = {
		firstName nullable: true, maxSize: 50
		lastName nullable: true, maxSize: 50
		otherNames nullable: true, maxSize: 50
		houseAddress nullable: true, maxSize: 100
		postalAddress nullable: true, maxSize: 100
		telephone nullable: true, maxSize: 12
		email email:true, nullable: true, maxSize: 50
		pctCommission nullable: true, scale: 4
		dateAdded nullable: true
		dateUpdated nullable: true
	}
}
