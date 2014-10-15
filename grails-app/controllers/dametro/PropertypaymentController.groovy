package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class PropertypaymentController {

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
//        respond Propertypayment.list(params), model:[propertypaymentInstanceCount: Propertypayment.count()]
		Menu home=Menu.find {menuname=="Home"}
		def propertypayments=Propertypayment.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimePropertypayment.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,propertypayments:propertypayments,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Propertypayment(params)
    }

    def show(Propertypayment propertypaymentInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def propertypayments=Propertypayment.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,propertypaymentInstance:propertypaymentInstance]
//        respond propertypaymentInstance
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
		def propertypaymentInstance=new Propertypayment()
		propertypaymentInstance.properties=params
		//td=TimePropertypayment.minus(start,tasks.DueDate)
		//
		//respond new Propertypayment(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,propertypaymentInstance:propertypaymentInstance]
       //respond new Propertypayment(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def propertypaymentInstance=new Propertypayment(params)
		propertypaymentInstance.datecreated=new Date()
		propertypaymentInstance.dateupdated=new Date()
		propertypaymentInstance.createdByUser=springSecurityService.getCurrentUser()
		propertypaymentInstance.metro=metro
		propertypaymentInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (propertypaymentInstance == null) {
            notFound()
            return
        }

        if (propertypaymentInstance.hasErrors()) {
            respond propertypaymentInstance.errors, view:'create'
            return
        }

        propertypaymentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'propertypaymentInstance.label', default: 'Propertypayment'), propertypaymentInstance.id])
                redirect propertypaymentInstance
            }
            '*' { respond propertypaymentInstance, [status: CREATED] }
        }
    }

    def edit(Propertypayment propertypaymentInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,propertypaymentInstance:propertypaymentInstance]
    }

    @Transactional
    def update(Propertypayment propertypaymentInstance) {
        if (propertypaymentInstance == null) {
            notFound()
            return
        }

        if (propertypaymentInstance.hasErrors()) {
            respond propertypaymentInstance.errors, view:'edit'
            return
        }

        propertypaymentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Propertypayment.label', default: 'Propertypayment'), propertypaymentInstance.id])
                redirect propertypaymentInstance
            }
            '*'{ respond propertypaymentInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Propertypayment propertypaymentInstance) {

        if (propertypaymentInstance == null) {
            notFound()
            return
        }

        propertypaymentInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Propertypayment.label', default: 'Propertypayment'), propertypaymentInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'propertypaymentInstance.label', default: 'Propertypayment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
