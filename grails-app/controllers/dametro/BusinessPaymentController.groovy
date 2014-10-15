package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class BusinessPaymentController {

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
//        respond BusinessPayment.list(params), model:[businessPaymentsInstanceCount: BusinessPayment.count()]
		Menu home=Menu.find {menuname=="Home"}
		def businessPayments=BusinessPayment.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeBusinessPayment.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,businessPayments:businessPayments,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new BusinessPayment(params)
    }

    def show(BusinessPayment businessPaymentsInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def businessPayments=BusinessPayment.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,businessPaymentsInstance:businessPaymentsInstance]
//        respond businessPaymentsInstance
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
		def businessPaymentsInstance=new BusinessPayment()
		businessPaymentsInstance.properties=params
		//td=TimeBusinessPayment.minus(start,tasks.DueDate)
		//
		//respond new BusinessPayment(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,businessPaymentsInstance:businessPaymentsInstance]
       //respond new BusinessPayment(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def businessPaymentsInstance=new BusinessPayment(params)
		businessPaymentsInstance.datecreated=new Date()
		businessPaymentsInstance.dateupdated=new Date()
		businessPaymentsInstance.createdByUser=springSecurityService.getCurrentUser()
		businessPaymentsInstance.metro=metro
		businessPaymentsInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (businessPaymentsInstance == null) {
            notFound()
            return
        }

        if (businessPaymentsInstance.hasErrors()) {
            respond businessPaymentsInstance.errors, view:'create'
            return
        }

        businessPaymentsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'businessPaymentsInstance.label', default: 'BusinessPayment'), businessPaymentsInstance.id])
                redirect businessPaymentsInstance
            }
            '*' { respond businessPaymentsInstance, [status: CREATED] }
        }
    }

    def edit(BusinessPayment businessPaymentsInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,businessPaymentsInstance:businessPaymentsInstance]
    }

    @Transactional
    def update(BusinessPayment businessPaymentsInstance) {
        if (businessPaymentsInstance == null) {
            notFound()
            return
        }

        if (businessPaymentsInstance.hasErrors()) {
            respond businessPaymentsInstance.errors, view:'edit'
            return
        }

        businessPaymentsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'BusinessPayment.label', default: 'BusinessPayment'), businessPaymentsInstance.id])
                redirect businessPaymentsInstance
            }
            '*'{ respond businessPaymentsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(BusinessPayment businessPaymentsInstance) {

        if (businessPaymentsInstance == null) {
            notFound()
            return
        }

        businessPaymentsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'BusinessPayment.label', default: 'BusinessPayment'), businessPaymentsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'businessPaymentsInstance.label', default: 'BusinessPayment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
