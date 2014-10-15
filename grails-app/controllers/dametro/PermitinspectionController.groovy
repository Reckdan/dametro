package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class PermitinspectionController {

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
//        respond Permitinspection.list(params), model:[permitinspectionInstanceCount: Permitinspection.count()]
		Menu home=Menu.find {menuname=="Home"}
		def permitinspections=Permitinspection.findAll()
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimePermitinspection.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,permitinspections:permitinspections,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Permitinspection(params)
    }

    def show(Permitinspection permitinspectionInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def permitinspections=Permitinspection.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,permitinspectionInstance:permitinspectionInstance]
//        respond permitinspectionInstance
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
		def permitinspectionInstance=new Permitinspection()
		permitinspectionInstance.properties=params
		//td=TimePermitinspection.minus(start,tasks.DueDate)
		//
		//respond new Permitinspection(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,permitinspectionInstance:permitinspectionInstance]
       //respond new Permitinspection(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def permitinspectionInstance=new Permitinspection(params)
		permitinspectionInstance.datecreated=new Date()
		permitinspectionInstance.dateupdated=new Date()
		permitinspectionInstance.createdByUser=springSecurityService.getCurrentUser()
		permitinspectionInstance.metro=metro
		permitinspectionInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (permitinspectionInstance == null) {
            notFound()
            return
        }

        if (permitinspectionInstance.hasErrors()) {
            respond permitinspectionInstance.errors, view:'create'
            return
        }

        permitinspectionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'permitinspectionInstance.label', default: 'Permitinspection'), permitinspectionInstance.id])
                redirect permitinspectionInstance
            }
            '*' { respond permitinspectionInstance, [status: CREATED] }
        }
    }

    def edit(Permitinspection permitinspectionInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,permitinspectionInstance:permitinspectionInstance]
    }

    @Transactional
    def update(Permitinspection permitinspectionInstance) {
        if (permitinspectionInstance == null) {
            notFound()
            return
        }

        if (permitinspectionInstance.hasErrors()) {
            respond permitinspectionInstance.errors, view:'edit'
            return
        }

        permitinspectionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Permitinspection.label', default: 'Permitinspection'), permitinspectionInstance.id])
                redirect permitinspectionInstance
            }
            '*'{ respond permitinspectionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Permitinspection permitinspectionInstance) {

        if (permitinspectionInstance == null) {
            notFound()
            return
        }

        permitinspectionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Permitinspection.label', default: 'Permitinspection'), permitinspectionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'permitinspectionInstance.label', default: 'Permitinspection'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
