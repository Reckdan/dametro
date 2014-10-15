package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class StreetController {

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
//        respond Street.list(params), model:[streetInstanceCount: Street.count()]
		Menu home=Menu.find {menuname=="Home"}
		def streets=Street.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeStreet.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,streets:streets,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Street(params)
    }

    def show(Street streetInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def streets=Street.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,streetInstance:streetInstance]
//        respond streetInstance
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
		def streetInstance=new Street()
		streetInstance.properties=params
		//td=TimeStreet.minus(start,tasks.DueDate)
		//
		//respond new Street(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,streetInstance:streetInstance]
       //respond new Street(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def streetInstance=new Street(params)
		streetInstance.datecreated=new Date()
		streetInstance.dateupdated=new Date()
		streetInstance.createdByUser=springSecurityService.getCurrentUser()
		streetInstance.metro=metro
		streetInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (streetInstance == null) {
            notFound()
            return
        }

        if (streetInstance.hasErrors()) {
            respond streetInstance.errors, view:'create'
            return
        }

        streetInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'streetInstance.label', default: 'Street'), streetInstance.id])
                redirect streetInstance
            }
            '*' { respond streetInstance, [status: CREATED] }
        }
    }

    def edit(Street streetInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,streetInstance:streetInstance]
    }

    @Transactional
    def update(Street streetInstance) {
        if (streetInstance == null) {
            notFound()
            return
        }

        if (streetInstance.hasErrors()) {
            respond streetInstance.errors, view:'edit'
            return
        }

        streetInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Street.label', default: 'Street'), streetInstance.id])
                redirect streetInstance
            }
            '*'{ respond streetInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Street streetInstance) {

        if (streetInstance == null) {
            notFound()
            return
        }

        streetInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Street.label', default: 'Street'), streetInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'streetInstance.label', default: 'Street'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
