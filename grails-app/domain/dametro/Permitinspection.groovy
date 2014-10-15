package dametro

class Permitinspection {

	String inspectionType
	Date expectedInspectionDate
	Date actualInspectionDate
	String inspectionComment
	Permitinfo permit

	static belongsTo = [Permitinfo]

	static mapping = {
		id column: "permitinspection_id"
		version false
	}

	static constraints = {
		inspectionType nullable: true, maxSize: 50
		expectedInspectionDate nullable: true
		actualInspectionDate nullable: true
		inspectionComment nullable: true, maxSize: 1000
	}
}
