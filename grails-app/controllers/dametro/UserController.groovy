package dametro

import java.text.SimpleDateFormat

//import com.metop.Metro;

class UserController {

    def index() {
		
		//redirect(action:login)
	}
	def login={
		def user =Muser.findByUserIdAndPssword(params.username,params.password) 					//EndUser.findByUserNameAndPassword(params.userName, params.password)
		if(user){
			session.user = user
			flash.message = "Hello ${user.firstName} ${user.lastName}!"
			//return "Hello ${user.firstName} ${user.lastName}!"
			//render("Hello ${user.firstName} ${user.lastName}!")
			//redirect(action:"index")
			redirect(controller:"Category", action:"index")
			
		}else{
			flash.message = "Sorry, ${params.username}. Please try again."
			//render ("Sorry, ${params.userName}. Please try again.")
			redirect(action:"index")
		}
		
		
		/*def now = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss").format(new Date())
		println "getting content... " + now
		render(template:"mylogin", model:[now:now])*/
	}
}
