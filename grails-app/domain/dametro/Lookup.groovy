package dametro

class Lookup {

	String label
	Boolean active
	Integer position
	Date dateCreated
	Date dateUpdated
	Muser createdByUser
	Muser updatedByUser
	LookupType type

	static hasMany = [books: Book,
	                  buildingsForPropertyFinancedBy: Building,
	                  buildingsForStatusId: Building,
	                  businessesForLookupByAssessmentTypeId: Business,
	                  businessesForLookupByPremisestypeId: Business,
	                  businessesForLookupByStatusId: Business,
					  businessesForLookupByIndustry: Business,
	                  collectors: Collector]
	static belongsTo = [Muser,LookupType]

	// TODO you have multiple hasMany references for class(es) [Business, Building] 
	//      so you'll need to disambiguate them with the 'mappedBy' property:
	static mappedBy = [buildingsForPropertyFinancedBy: "propertyFinancedBy",
	                   buildingsForStatusId: "status",
	                   businessesForLookupByAssessmentTypeId: "assessmentType",
	                   businessesForLookupByPremisestypeId: "premisetype",
	                   businessesForLookupByStatusId: "status",
					   businessesForLookupByIndustry: "industry"]

	static mapping = {
		id column: "lookup_id"
		version false
	}

	static constraints = {
		label nullable: true, maxSize: 50
		active nullable: true
		position nullable: true
		dateCreated nullable: true
		dateUpdated nullable: true
	}
}
