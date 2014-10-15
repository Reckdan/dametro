package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class CashierController {

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
//        respond Cashier.list(params), model:[cashierInstanceCount: Cashier.count()]
		Menu home=Menu.find {menuname=="Home"}
		def cashiers=Cashier.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeCashier.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,cashiers:cashiers,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Cashier(params)
    }

    def show(Cashier cashierInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def cashiers=Cashier.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,cashierInstance:cashierInstance]
//        respond cashierInstance
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
		def cashierInstance=new Cashier()
		cashierInstance.properties=params
		//td=TimeCashier.minus(start,tasks.DueDate)
		//
		//respond new Cashier(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,cashierInstance:cashierInstance]
       //respond new Cashier(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def cashierInstance=new Cashier(params)
		cashierInstance.datecreated=new Date()
		cashierInstance.dateupdated=new Date()
		cashierInstance.createdByUser=springSecurityService.getCurrentUser()
		cashierInstance.metro=metro
		cashierInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (cashierInstance == null) {
            notFound()
            return
        }

        if (cashierInstance.hasErrors()) {
            respond cashierInstance.errors, view:'create'
            return
        }

        cashierInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cashierInstance.label', default: 'Cashier'), cashierInstance.id])
                redirect cashierInstance
            }
            '*' { respond cashierInstance, [status: CREATED] }
        }
    }

    def edit(Cashier cashierInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,cashierInstance:cashierInstance]
    }

    @Transactional
    def update(Cashier cashierInstance) {
        if (cashierInstance == null) {
            notFound()
            return
        }

        if (cashierInstance.hasErrors()) {
            respond cashierInstance.errors, view:'edit'
            return
        }

        cashierInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Cashier.label', default: 'Cashier'), cashierInstance.id])
                redirect cashierInstance
            }
            '*'{ respond cashierInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Cashier cashierInstance) {

        if (cashierInstance == null) {
            notFound()
            return
        }

        cashierInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Cashier.label', default: 'Cashier'), cashierInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cashierInstance.label', default: 'Cashier'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
