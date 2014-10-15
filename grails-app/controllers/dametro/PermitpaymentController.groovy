package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class PermitpaymentController {

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
//        respond Permitpayment.list(params), model:[permitpaymentInstanceCount: Permitpayment.count()]
		Menu home=Menu.find {menuname=="Home"}
		def permitpayments=Permitpayment.findAll()
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimePermitpayment.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,permitpayments:permitpayments,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Permitpayment(params)
    }

    def show(Permitpayment permitpaymentInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def permitpayments=Permitpayment.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,permitpaymentInstance:permitpaymentInstance]
//        respond permitpaymentInstance
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
		def permitpaymentInstance=new Permitpayment()
		permitpaymentInstance.properties=params
		//td=TimePermitpayment.minus(start,tasks.DueDate)
		//
		//respond new Permitpayment(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,permitpaymentInstance:permitpaymentInstance]
       //respond new Permitpayment(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def permitpaymentInstance=new Permitpayment(params)
		permitpaymentInstance.datecreated=new Date()
		permitpaymentInstance.dateupdated=new Date()
		permitpaymentInstance.createdByUser=springSecurityService.getCurrentUser()
		permitpaymentInstance.metro=metro
		permitpaymentInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (permitpaymentInstance == null) {
            notFound()
            return
        }

        if (permitpaymentInstance.hasErrors()) {
            respond permitpaymentInstance.errors, view:'create'
            return
        }

        permitpaymentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'permitpaymentInstance.label', default: 'Permitpayment'), permitpaymentInstance.id])
                redirect permitpaymentInstance
            }
            '*' { respond permitpaymentInstance, [status: CREATED] }
        }
    }

    def edit(Permitpayment permitpaymentInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,permitpaymentInstance:permitpaymentInstance]
    }

    @Transactional
    def update(Permitpayment permitpaymentInstance) {
        if (permitpaymentInstance == null) {
            notFound()
            return
        }

        if (permitpaymentInstance.hasErrors()) {
            respond permitpaymentInstance.errors, view:'edit'
            return
        }

        permitpaymentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Permitpayment.label', default: 'Permitpayment'), permitpaymentInstance.id])
                redirect permitpaymentInstance
            }
            '*'{ respond permitpaymentInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Permitpayment permitpaymentInstance) {

        if (permitpaymentInstance == null) {
            notFound()
            return
        }

        permitpaymentInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Permitpayment.label', default: 'Permitpayment'), permitpaymentInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'permitpaymentInstance.label', default: 'Permitpayment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
