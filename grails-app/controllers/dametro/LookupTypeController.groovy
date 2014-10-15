package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class LookupTypeController {

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
//        respond LookupType.list(params), model:[lookupTypeInstanceCount: LookupType.count()]
		Menu home=Menu.find {menuname=="Home"}
		def lookupTypes=LookupType.findAll()
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeLookupType.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,lookupTypes:lookupTypes,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new LookupType(params)
    }

    def show(LookupType lookupTypeInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def lookupTypes=LookupType.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,lookupTypeInstance:lookupTypeInstance]
//        respond lookupTypeInstance
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
		def lookupTypeInstance=new LookupType()
		lookupTypeInstance.properties=params
		//td=TimeLookupType.minus(start,tasks.DueDate)
		//
		//respond new LookupType(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,lookupTypeInstance:lookupTypeInstance]
       //respond new LookupType(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def lookupTypeInstance=new LookupType(params)
	
        if (lookupTypeInstance == null) {
            notFound()
            return
        }

        if (lookupTypeInstance.hasErrors()) {
            respond lookupTypeInstance.errors, view:'create'
            return
        }

        lookupTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lookupTypeInstance.label', default: 'LookupType'), lookupTypeInstance.id])
                redirect lookupTypeInstance
            }
            '*' { respond lookupTypeInstance, [status: CREATED] }
        }
    }

    def edit(LookupType lookupTypeInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,lookupTypeInstance:lookupTypeInstance]
    }

    @Transactional
    def update(LookupType lookupTypeInstance) {
        if (lookupTypeInstance == null) {
            notFound()
            return
        }

        if (lookupTypeInstance.hasErrors()) {
            respond lookupTypeInstance.errors, view:'edit'
            return
        }

        lookupTypeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LookupType.label', default: 'LookupType'), lookupTypeInstance.id])
                redirect lookupTypeInstance
            }
            '*'{ respond lookupTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LookupType lookupTypeInstance) {

        if (lookupTypeInstance == null) {
            notFound()
            return
        }

        lookupTypeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LookupType.label', default: 'LookupType'), lookupTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lookupTypeInstance.label', default: 'LookupType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
