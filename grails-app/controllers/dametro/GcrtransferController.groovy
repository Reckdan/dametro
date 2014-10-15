package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class GcrtransferController {

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
//        respond Gcrtransfer.list(params), model:[gcrtransferInstanceCount: Gcrtransfer.count()]
		Menu home=Menu.find {menuname=="Home"}
		def gcrtransfers=Gcrtransfer.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeGcrtransfer.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,gcrtransfers:gcrtransfers,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Gcrtransfer(params)
    }

    def show(Gcrtransfer gcrtransferInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def gcrtransfers=Gcrtransfer.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,gcrtransferInstance:gcrtransferInstance]
//        respond gcrtransferInstance
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
		def gcrtransferInstance=new Gcrtransfer()
		gcrtransferInstance.properties=params
		//td=TimeGcrtransfer.minus(start,tasks.DueDate)
		//
		//respond new Gcrtransfer(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,gcrtransferInstance:gcrtransferInstance]
       //respond new Gcrtransfer(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def gcrtransferInstance=new Gcrtransfer(params)
		gcrtransferInstance.datecreated=new Date()
		gcrtransferInstance.dateupdated=new Date()
		gcrtransferInstance.createdByUser=springSecurityService.getCurrentUser()
		gcrtransferInstance.metro=metro
		gcrtransferInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (gcrtransferInstance == null) {
            notFound()
            return
        }

        if (gcrtransferInstance.hasErrors()) {
            respond gcrtransferInstance.errors, view:'create'
            return
        }

        gcrtransferInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'gcrtransferInstance.label', default: 'Gcrtransfer'), gcrtransferInstance.id])
                redirect gcrtransferInstance
            }
            '*' { respond gcrtransferInstance, [status: CREATED] }
        }
    }

    def edit(Gcrtransfer gcrtransferInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,gcrtransferInstance:gcrtransferInstance]
    }

    @Transactional
    def update(Gcrtransfer gcrtransferInstance) {
        if (gcrtransferInstance == null) {
            notFound()
            return
        }

        if (gcrtransferInstance.hasErrors()) {
            respond gcrtransferInstance.errors, view:'edit'
            return
        }

        gcrtransferInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Gcrtransfer.label', default: 'Gcrtransfer'), gcrtransferInstance.id])
                redirect gcrtransferInstance
            }
            '*'{ respond gcrtransferInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Gcrtransfer gcrtransferInstance) {

        if (gcrtransferInstance == null) {
            notFound()
            return
        }

        gcrtransferInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Gcrtransfer.label', default: 'Gcrtransfer'), gcrtransferInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'gcrtransferInstance.label', default: 'Gcrtransfer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
