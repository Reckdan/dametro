package dametro

class Contact {

	String firstName
	String lastName
	String otherNames
	String fullName
	String organizationName
	String emailAddress
	String address
	String phone
	String mobile
	String city
	String streetAddress
	Boolean isBusiness
	String idNumber
	String idType
	Date dob
	Date dateCreated
	Date dateUpdated
	Muser createdByUser
	Muser updatedByUser
	Metro metro

	static hasMany = [buildings: Building,
	                  businesses: Business,
	                  permitinfosForApplicantId: Permitinfo,
	                  permitinfosForOwnerId: Permitinfo]
	
	static belongsTo=[Muser,Metro]

	// TODO you have multiple hasMany references for class(es) [Permitinfo] 
	//      so you'll need to disambiguate them with the 'mappedBy' property:
	static mappedBy = [permitinfosForApplicantId: "applicant",
	                   permitinfosForOwnerId: "owner"]

	static mapping = {
		version true
		fullName formula:"CONCAT(first_name,' ',last_name)"
	}

	static constraints = {
		firstName nullable: true
		lastName nullable: true
		otherNames nullable: true
		organizationName nullable: true
		emailAddress email:true, nullable: true, maxSize: 100
		address nullable: true
		phone nullable: true, maxSize: 15
		mobile nullable: true, maxSize: 15
		city nullable: true, maxSize: 50
		streetAddress nullable: true
		isBusiness nullable: true
		idNumber nullable: true, maxSize: 20
		idType nullable: true, maxSize: 50
		dob nullable: true
	}
}
