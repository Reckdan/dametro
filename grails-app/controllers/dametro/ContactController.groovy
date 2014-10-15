package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class ContactController {

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
//        respond Contact.list(params), model:[contactInstanceCount: Contact.count()]
		Menu home=Menu.find {menuname=="Home"}
		def contacts=Contact.findAll()
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeContact.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,contacts:contacts,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Contact(params)
    }

    def show(Contact contactInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def contacts=Contact.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,contactInstance:contactInstance]
//        respond contactInstance
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
		def contactInstance=new Contact()
		contactInstance.properties=params
		//td=TimeContact.minus(start,tasks.DueDate)
		//
		//respond new Contact(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,contactInstance:contactInstance]
       //respond new Contact(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def contactInstance=new Contact(params)
		contactInstance.datecreated=new Date()
		contactInstance.dateupdated=new Date()
		contactInstance.createdByUser=springSecurityService.getCurrentUser()
		contactInstance.metro=metro
		contactInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (contactInstance == null) {
            notFound()
            return
        }

        if (contactInstance.hasErrors()) {
            respond contactInstance.errors, view:'create'
            return
        }

        contactInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'contactInstance.label', default: 'Contact'), contactInstance.id])
                redirect contactInstance
            }
            '*' { respond contactInstance, [status: CREATED] }
        }
    }

    def edit(Contact contactInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,contactInstance:contactInstance]
    }

    @Transactional
    def update(Contact contactInstance) {
        if (contactInstance == null) {
            notFound()
            return
        }

        if (contactInstance.hasErrors()) {
            respond contactInstance.errors, view:'edit'
            return
        }

        contactInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Contact.label', default: 'Contact'), contactInstance.id])
                redirect contactInstance
            }
            '*'{ respond contactInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Contact contactInstance) {

        if (contactInstance == null) {
            notFound()
            return
        }

        contactInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Contact.label', default: 'Contact'), contactInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contactInstance.label', default: 'Contact'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
