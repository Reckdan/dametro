package dametro

class Business {

	String accountNo
	String businessName
	String tin
	String vatno
	Lookup industry
	String address
	String registrationNo
	Date registrationDate
	Date commencementDate
	String phoneno
	String fax
	String email
	Integer noOfEmployee
	Integer numMale
	Integer numFemale
	BigDecimal floorSpace
	Short isDeleted
	Lookup status
	Contact contact
	Lookup premisetype
	Lookup assessmentType
	Metro metro
	Muser createdByUser
	Eventtype type
	Muser updatedByUser
	Category category
	Boolean isheadoffice
	Business headoffice
	Building building
	Boolean usepropertyaddress
	Submetro submetro
	Constituency constituency
	Electoralarea electoralarea
	Community community
	Unit unit
	Street street
	String housenumber

	static hasMany = [billbs: Billb,
	                  businessPayments: BusinessPayment]
	static belongsTo = [Category,Building, Contact,  Lookup, Metro, Muser, Eventtype, Lookup]

	static mapping = {
		id column: "bid", headoffice:"none"
		version false
	}

	static constraints = {
		accountNo nullable: false,minSize:1, maxSize: 30, unique: true, blank:false
		businessName nullable: true, maxSize: 100
		tin nullable: true, maxSize: 20
		vatno nullable: true, maxSize: 20
		address nullable: true, maxSize: 100
		registrationNo nullable: true, maxSize: 20
		registrationDate nullable: true
		commencementDate nullable: true
		phoneno nullable: true, maxSize: 15
		fax nullable: true, maxSize: 15
		email nullable: true, maxSize: 50
		noOfEmployee nullable: true
		numMale nullable: true
		numFemale nullable: true
		floorSpace nullable: true
		isDeleted nullable: true
	}
}
