package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class GcrserialController {

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
//        respond Gcrserial.list(params), model:[gcrserialInstanceCount: Gcrserial.count()]
		Menu home=Menu.find {menuname=="Home"}
		def gcrserials=Gcrserial.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeGcrserial.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,gcrserials:gcrserials,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Gcrserial(params)
    }

    def show(Gcrserial gcrserialInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def gcrserials=Gcrserial.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,gcrserialInstance:gcrserialInstance]
//        respond gcrserialInstance
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
		def gcrserialInstance=new Gcrserial()
		gcrserialInstance.properties=params
		//td=TimeGcrserial.minus(start,tasks.DueDate)
		//
		//respond new Gcrserial(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,gcrserialInstance:gcrserialInstance]
       //respond new Gcrserial(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def gcrserialInstance=new Gcrserial(params)
		gcrserialInstance.datecreated=new Date()
		gcrserialInstance.dateupdated=new Date()
		gcrserialInstance.createdByUser=springSecurityService.getCurrentUser()
		gcrserialInstance.metro=metro
		gcrserialInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (gcrserialInstance == null) {
            notFound()
            return
        }

        if (gcrserialInstance.hasErrors()) {
            respond gcrserialInstance.errors, view:'create'
            return
        }

        gcrserialInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'gcrserialInstance.label', default: 'Gcrserial'), gcrserialInstance.id])
                redirect gcrserialInstance
            }
            '*' { respond gcrserialInstance, [status: CREATED] }
        }
    }

    def edit(Gcrserial gcrserialInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,gcrserialInstance:gcrserialInstance]
    }

    @Transactional
    def update(Gcrserial gcrserialInstance) {
        if (gcrserialInstance == null) {
            notFound()
            return
        }

        if (gcrserialInstance.hasErrors()) {
            respond gcrserialInstance.errors, view:'edit'
            return
        }

        gcrserialInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Gcrserial.label', default: 'Gcrserial'), gcrserialInstance.id])
                redirect gcrserialInstance
            }
            '*'{ respond gcrserialInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Gcrserial gcrserialInstance) {

        if (gcrserialInstance == null) {
            notFound()
            return
        }

        gcrserialInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Gcrserial.label', default: 'Gcrserial'), gcrserialInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'gcrserialInstance.label', default: 'Gcrserial'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
