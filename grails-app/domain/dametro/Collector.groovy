package dametro

class Collector {

	String collectorCode
	String firstName
	String lastName
	String otherNames
	String homeAddress
	String fullName
	String typeOfId
	String idNumber
	String guarantorName
	String telephone
	String guarantorPlaceofwork
	BigDecimal guaranteeValue
	String collectorPicture
	String guarantorPicture
	String collectorType
	Metro metro
	Lookup type
	Muser createdByUser
	Date datecreated
	Boolean approved

	static hasMany = [assigncollectors: Assigncollector,
	                  businessPayments: BusinessPayment,
	                  collectorgcrs: Collectorgcr,
	                  gcrserials: Gcrserial,
	                  gcrtransfersForTransferedtoCollectorId: Gcrtransfer,
	                  gcrtransfersForTransferfromCollectorId: Gcrtransfer,
	                  propertypayments: Propertypayment]
	static belongsTo = [Lookup, Metro, Muser]

	// TODO you have multiple hasMany references for class(es) [Gcrtransfer] 
	//      so you'll need to disambiguate them with the 'mappedBy' property:
	static mappedBy = [gcrtransfersForTransferedtoCollectorId: "transferedtoCollector",
	                   gcrtransfersForTransferfromCollectorId: "transferfromCollector"]

	static mapping = {
		fullName formula: "CONCAT(first_name, ' ',last_name)"
		id column: "collector_id"
		version true
	}

	static constraints = {
		collectorCode nullable: true, maxSize: 10
		firstName nullable: true, maxSize: 50
		lastName nullable: true, maxSize: 50
		otherNames nullable: true, maxSize: 50
		homeAddress nullable: true, maxSize: 100
		guarantorName nullable: true, maxSize: 100
		telephone nullable: true, maxSize: 20
		guarantorPlaceofwork nullable: true, maxSize: 100
		guaranteeValue nullable: true
		collectorPicture nullable: true
		guarantorPicture nullable: true
		collectorType nullable: true, maxSize: 30
		typeOfId nullable:true, maxSize:30
		idNumber nullable:true, maxSize:20
	}
}
