package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class PendingtaskController {

   static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

//	def beforeInterceptor = [action:this.&auth]
//	def auth() {
//		if(!session.user) {
//			redirect(controller:"User", action:"index")
//			return false
//		}
//	}
	def springSecurityService
	
    def index() {
		
//        params.max = Math.min(max ?: 10, 100)
//        respond Pendingtask.list(params), model:[pendingtaskInstanceCount: Pendingtask.count()]
		Menu home=Menu.find {menuname=="Home"}
		def pendingtasks=Pendingtask.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimePendingtask.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,pendingtasks:pendingtasks,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Pendingtask(params)
    }

    def show(Pendingtask pendingtaskInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def pendingtasks=Pendingtask.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,pendingtaskInstance:pendingtaskInstance]
//        respond pendingtaskInstance
    }

    def create() {
		Menu home=Menu.find {menuname=="Home"}

		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		//TimeDuration td=new TimeDuration(0,0,0,0)
		def pendingtaskInstance=new Pendingtask()
		pendingtaskInstance.properties=params
		//td=TimePendingtask.minus(start,tasks.DueDate)
		//
		//respond new Pendingtask(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,pendingtaskInstance:pendingtaskInstance]
       //respond new Pendingtask(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def pendingtaskInstance=new Pendingtask(params)
		pendingtaskInstance.datecreated=new Date()
		pendingtaskInstance.dateupdated=new Date()
		pendingtaskInstance.createdByUser=springSecurityService.getCurrentUser()
		pendingtaskInstance.metro=metro
		pendingtaskInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (pendingtaskInstance == null) {
            notFound()
            return
        }

        if (pendingtaskInstance.hasErrors()) {
            respond pendingtaskInstance.errors, view:'create'
            return
        }

        pendingtaskInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pendingtaskInstance.label', default: 'Pendingtask'), pendingtaskInstance.id])
                redirect pendingtaskInstance
            }
            '*' { respond pendingtaskInstance, [status: CREATED] }
        }
    }

    def edit(Pendingtask pendingtaskInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,pendingtaskInstance:pendingtaskInstance]
    }

    @Transactional
    def update(Pendingtask pendingtaskInstance) {
        if (pendingtaskInstance == null) {
            notFound()
            return
        }

        if (pendingtaskInstance.hasErrors()) {
            respond pendingtaskInstance.errors, view:'edit'
            return
        }

        pendingtaskInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pendingtask.label', default: 'Pendingtask'), pendingtaskInstance.id])
                redirect pendingtaskInstance
            }
            '*'{ respond pendingtaskInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Pendingtask pendingtaskInstance) {

        if (pendingtaskInstance == null) {
            notFound()
            return
        }

        pendingtaskInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pendingtask.label', default: 'Pendingtask'), pendingtaskInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pendingtaskInstance.label', default: 'Pendingtask'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
