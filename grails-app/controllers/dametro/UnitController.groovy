package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class UnitController {

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
//        respond Unit.list(params), model:[unitInstanceCount: Unit.count()]
		Menu home=Menu.find {menuname=="Home"}
		def units=Unit.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeUnit.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,units:units,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Unit(params)
    }

    def show(Unit unitInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def units=Unit.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,unitInstance:unitInstance]
//        respond unitInstance
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
		def unitInstance=new Unit()
		unitInstance.properties=params
		//td=TimeUnit.minus(start,tasks.DueDate)
		//
		//respond new Unit(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,unitInstance:unitInstance]
       //respond new Unit(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def unitInstance=new Unit(params)
		unitInstance.datecreated=new Date()
		unitInstance.dateupdated=new Date()
		unitInstance.createdByUser=springSecurityService.getCurrentUser()
		unitInstance.metro=metro
		unitInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (unitInstance == null) {
            notFound()
            return
        }

        if (unitInstance.hasErrors()) {
            respond unitInstance.errors, view:'create'
            return
        }

        unitInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'unitInstance.label', default: 'Unit'), unitInstance.id])
                redirect unitInstance
            }
            '*' { respond unitInstance, [status: CREATED] }
        }
    }

    def edit(Unit unitInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,unitInstance:unitInstance]
    }

    @Transactional
    def update(Unit unitInstance) {
        if (unitInstance == null) {
            notFound()
            return
        }

        if (unitInstance.hasErrors()) {
            respond unitInstance.errors, view:'edit'
            return
        }

        unitInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Unit.label', default: 'Unit'), unitInstance.id])
                redirect unitInstance
            }
            '*'{ respond unitInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Unit unitInstance) {

        if (unitInstance == null) {
            notFound()
            return
        }

        unitInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Unit.label', default: 'Unit'), unitInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'unitInstance.label', default: 'Unit'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
