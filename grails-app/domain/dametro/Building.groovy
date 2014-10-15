package dametro

class Building {

	String accountNo
	BigDecimal rateableValue
	Date datecreated
	Date dateUpdated
	String houseNo
	String houseaddress
	String division
	String serialNo
	Date permitDate
	String valuationNo
	Date valuationDate
	String contructionMaterial
	Integer constructionYear
	String roofingMaterial
	Integer noOfHouseholds
	Integer noOfBedrooms
	Integer noOfWcs
	Integer noOfOtherToilets
	Integer noOfBathrooms
	Integer noOfKitchens
	Integer noOfGarages
	Integer noOfShops
	Integer noOfOutHouses
	Character gwc
	Character gwcMetered
	Character ecg
	Character ecgMetered
	Character phone
	String modeOfRefuseCollection
	String occupancy
	String longitude
	String latitude
	String picName
	Contact contact
	Short isDeleted
	Permitinfo buildingPermit
	Electoralarea electoralarea
	PropertyUse propertyUse
	Street street
	Eventtype type
	Lookup propertyFinancedBy
	Submetro submetro
	Metro metro
	Muser createdByUser
	Community community
	Category category
	Lookup status
	Unit unit
	Constituency constituency

	static hasMany = [billps: Billp,
	                  businesses: Business,
	                  propertypayments: Propertypayment]
	static belongsTo = [Category, Community, Constituency, Electoralarea, Lookup, Metro, Muser, Permitinfo, PropertyUse, Street, Submetro, Eventtype, Unit, Contact]

	static mapping = {
		id column: "pid"
		version true
		//houseaddress formula:"CONCAT(house_no,' ',street_name)"
	}

	static constraints = {
		accountNo maxSize: 30,nullable:false,blank:false,minSize:1
		rateableValue nullable: true, scale: 4
		dateUpdated nullable: false
		houseNo nullable: true, maxSize: 30
		division nullable: true, maxSize: 50
		serialNo nullable: true, maxSize: 50
		permitDate nullable: true
		valuationNo nullable: true, maxSize: 20
		valuationDate nullable: true
		contructionMaterial nullable: true, maxSize: 100
		constructionYear nullable: true
		roofingMaterial nullable: true, maxSize: 100
		noOfHouseholds nullable: true
		noOfBedrooms nullable: true
		noOfWcs nullable: true
		noOfOtherToilets nullable: true
		noOfBathrooms nullable: true
		noOfKitchens nullable: true
		noOfGarages nullable: true
		noOfShops nullable: true
		noOfOutHouses nullable: true
		gwc nullable: true, maxSize: 1		
		gwcMetered nullable: true, maxSize: 1
		ecg nullable: true, maxSize: 1
		ecgMetered nullable: true, maxSize: 1
		phone nullable: true, maxSize: 1
		modeOfRefuseCollection nullable: true, maxSize: 100
		occupancy nullable: true, maxSize: 50
		longitude nullable: true, maxSize: 20
		latitude nullable: true, maxSize: 20
		picName nullable: true, maxSize: 100
		
		isDeleted nullable: true

	}
}
