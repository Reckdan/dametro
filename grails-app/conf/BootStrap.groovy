import dametro.*
class BootStrap {

    def init = { servletContext ->
	 /*def adminRole=Role.findOrSaveWhere(authority:'ROLE_ADMIN')
	
	 def datecreated=new Date()
	 def user=Muser.findOrSaveWhere(firstname:'Daniel',lastname:'Antwi',username:'reckdan',email:'reckdan@gmail.com',datecreated:datecreated.format('mm/dd/yyyy'),password:'password',telephone:'6138901334',metro:'all')
	 	if(!user.authorities.contains(adminRole)){
			 MuserRole.create(user,adminRole,true)
		 }*/
    }
    def destroy = {
    }
}
