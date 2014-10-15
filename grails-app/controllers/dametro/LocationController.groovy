package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class LocationController {

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
//        respond Location.list(params), model:[locationInstanceCount: Location.count()]
		Menu home=Menu.find {menuname=="Home"}
		def locations=Location.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeLocation.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,locations:locations,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Location(params)
    }

    def show(Location locationInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def locations=Location.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,locationInstance:locationInstance]
//        respond locationInstance
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
		def locationInstance=new Location()
		locationInstance.properties=params
		//td=TimeLocation.minus(start,tasks.DueDate)
		//
		//respond new Location(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,locationInstance:locationInstance]
       //respond new Location(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def locationInstance=new Location(params)
		locationInstance.datecreated=new Date()
		locationInstance.dateupdated=new Date()
		locationInstance.createdByUser=springSecurityService.getCurrentUser()
		locationInstance.metro=metro
		locationInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (locationInstance == null) {
            notFound()
            return
        }

        if (locationInstance.hasErrors()) {
            respond locationInstance.errors, view:'create'
            return
        }

        locationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'locationInstance.label', default: 'Location'), locationInstance.id])
                redirect locationInstance
            }
            '*' { respond locationInstance, [status: CREATED] }
        }
    }

    def edit(Location locationInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,locationInstance:locationInstance]
    }

    @Transactional
    def update(Location locationInstance) {
        if (locationInstance == null) {
            notFound()
            return
        }

        if (locationInstance.hasErrors()) {
            respond locationInstance.errors, view:'edit'
            return
        }

        locationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Location.label', default: 'Location'), locationInstance.id])
                redirect locationInstance
            }
            '*'{ respond locationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Location locationInstance) {

        if (locationInstance == null) {
            notFound()
            return
        }

        locationInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Location.label', default: 'Location'), locationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'locationInstance.label', default: 'Location'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
