package dametro

class Permitinfo {

	String permitNo
	Date dateReceived
	String buildingNumber
	String unitNumber
	String lotPlotNo
	String planNumber
	BigDecimal estimatedCost
	String areaOfWork
	String purposeOfApplication
	String purposeOfBuilding
	String currentUseOfBuilding
	String appilcantIs
	String permitStatus
	String comments
	Metro metro
	Community community
	Electoralarea electoralarea
	Street street
	Contact applicant
	Contact owner
	Unit unit
	Submetro submetro
	Constituency constituency

	static hasMany = [buildings: Building,
	                  documents: Document,
	                  permitinspections: Permitinspection,
	                  permitpayments: Permitpayment]
	static belongsTo = [Community, Constituency, Contact, Electoralarea, Metro, Street, Submetro, Unit]

	static mapping = {
		id column: "permitinfo_id"
		version false
	}

	static constraints = {
		permitNo maxSize: 30, unique: true
		dateReceived nullable: true
		buildingNumber nullable: true, maxSize: 30
		unitNumber nullable: true, maxSize: 20
		lotPlotNo nullable: true, maxSize: 20
		planNumber nullable: true, maxSize: 50
		estimatedCost nullable: true
		areaOfWork nullable: true, maxSize: 20
		purposeOfApplication nullable: true, maxSize: 50
		purposeOfBuilding nullable: true, maxSize: 100
		currentUseOfBuilding nullable: true, maxSize: 100
		appilcantIs nullable: true, maxSize: 50
		permitStatus nullable: true, maxSize: 20
		comments nullable: true, maxSize: 1000
	}
}
