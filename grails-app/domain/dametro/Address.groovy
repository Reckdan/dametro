package dametro

class Address {


	Business business
	Building building
	Contact contact
	String phone
	String email

	static mapping = {
		id column: "address_id"
		version true
	}
	static belongsTo =[Business, Building, Contact]
	static constraints = {
		email email:true
	}
}
