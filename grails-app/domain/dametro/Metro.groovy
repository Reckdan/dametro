package dametro

class Metro {

	String metro
	String city
	String region
	String logo
	String signature
	String organizationType
	String cordinatorsNumbers
	String enquires
	String businessNotice
	String propertyNotice
	String billMsg
	String paymentNotification
	String submetro
	String electoralArea
	Boolean autogenerateID

	static hasMany = [adjustarrears: Adjustarrear,
	                  assigncollectors: Assigncollector,
	                  books: Book,
	                  buildings: Building,
	                  businessPayments: BusinessPayment,
	                  businesses: Business,
	                  cashiers: Cashier,
	                  categories: Category,
	                  collectionareas: Collectionarea,
	                  collectorgcrs: Collectorgcr,
	                  collectors: Collector,
	                  communities: Community,
	                  constituencies: Constituency,
	                  defaulterslists: Defaulterslist,
	                  electoralareas: Electoralarea,
	                  fixedfees: Fixedfee,
	                  gcrserials: Gcrserial,
	                  gcrtransfers: Gcrtransfer,
	                  locations: Location,
	                  permitinfos: Permitinfo,
	                  propertyUses: PropertyUse,
	                  propertypayments: Propertypayment,
	                  roles: Role,
	                  streets: Street,
	                  submetros: Submetro,
	                  types: Eventtype,
	                  units: Unit]

	static mapping = {
		id column: "metro_id"
		version false
	}

	static constraints = {
		metro nullable: false, maxSize: 100
		city nullable: true, maxSize: 50
		region nullable: true, maxSize: 50
		logo nullable: true, maxSize: 50
		signature nullable: true, maxSize: 50
		organizationType nullable: true, maxSize: 20
		cordinatorsNumbers nullable: true, maxSize: 15
		enquires nullable: true, maxSize: 1000
		businessNotice nullable: true, maxSize: 1000
		propertyNotice nullable: true, maxSize: 1000
		billMsg nullable: true, maxSize: 160
		paymentNotification nullable: true, maxSize: 160
		submetro nullable: true, maxSize: 20
		electoralArea nullable: true, maxSize: 20
		autogenerateID empty:false
	}
}
