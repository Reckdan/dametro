package dametro

class Fileupload {
	String filename
	String filetype
	String filecategory
	String title
	Metro metro
	
	static belongsTo = [Metro]
    static constraints = {
		filename nullable:false
		filecategory nullable:false
		title nullable:false
    }
}
