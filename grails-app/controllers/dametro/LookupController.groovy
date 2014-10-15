package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class LookupController {

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
//        respond Lookup.list(params), model:[lookupInstanceCount: Lookup.count()]
		Menu home=Menu.find {menuname=="Home"}
		def lookups=Lookup.findAll()
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeLookup.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,lookups:lookups,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Lookup(params)
    }

    def show(Lookup lookupInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def lookups=Lookup.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,lookupInstance:lookupInstance]
//        respond lookupInstance
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
		def lookupInstance=new Lookup()
		lookupInstance.properties=params
		//td=TimeLookup.minus(start,tasks.DueDate)
		//
		//respond new Lookup(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,lookupInstance:lookupInstance]
       //respond new Lookup(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def lookupInstance=new Lookup(params)
		lookupInstance.dateCreated=new Date()
		lookupInstance.dateUpdated=new Date()
		lookupInstance.createdByUser=springSecurityService.getCurrentUser()
		lookupInstance.updatedByUser=springSecurityService.getCurrentUser()
		lookupInstance.position=0
        if (lookupInstance == null) {
            notFound()
            return
        }

        if (lookupInstance.hasErrors()) {
            respond lookupInstance.errors, view:'create'
            return
        }

        lookupInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lookupInstance.label', default: 'Lookup'), lookupInstance.id])
                redirect lookupInstance
            }
            '*' { respond lookupInstance, [status: CREATED] }
        }
    }

    def edit(Lookup lookupInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,lookupInstance:lookupInstance]
    }

    @Transactional
    def update(Lookup lookupInstance) {
        if (lookupInstance == null) {
            notFound()
            return
        }

        if (lookupInstance.hasErrors()) {
            respond lookupInstance.errors, view:'edit'
            return
        }
		lookupInstance.dateUpdated=new Date()
		lookupInstance.updatedByUser=springSecurityService.getCurrentUser()
        lookupInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Lookup.label', default: 'Lookup'), lookupInstance.id])
                redirect lookupInstance
            }
            '*'{ respond lookupInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Lookup lookupInstance) {

        if (lookupInstance == null) {
            notFound()
            return
        }

        lookupInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Lookup.label', default: 'Lookup'), lookupInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lookupInstance.label', default: 'Lookup'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
