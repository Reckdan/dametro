package dametro

class Menu {
	String menuname
	Character gcatId
	String menucontroller
	String menuaction
	String subof
	Integer position
	
	
    static constraints = {
		menuname nullable:true, maxSize: 50
		subof nullable:false, maxSize: 50
		menucontroller nullable:false, maxSize: 50
		menuaction nullable:false, maxSize:50
		gcatId nullable:true, maxSiz: 1
		position nullable:true
    }
}
