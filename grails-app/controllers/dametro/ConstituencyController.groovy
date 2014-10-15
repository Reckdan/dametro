package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class ConstituencyController {

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
//        respond Constituency.list(params), model:[constituencyInstanceCount: Constituency.count()]
		Menu home=Menu.find {menuname=="Home"}
		def constituencies=Constituency.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeConstituency.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,constituencies:constituencies,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Constituency(params)
    }

    def show(Constituency constituencyInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def constituencies=Constituency.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,constituencyInstance:constituencyInstance]
//        respond constituencyInstance
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
		def constituencyInstance=new Constituency()
		constituencyInstance.properties=params
		//td=TimeConstituency.minus(start,tasks.DueDate)
		//
		//respond new Constituency(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,constituencyInstance:constituencyInstance]
       //respond new Constituency(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def constituencyInstance=new Constituency(params)
		constituencyInstance.datecreated=new Date()
		constituencyInstance.dateupdated=new Date()
		constituencyInstance.createdByUser=springSecurityService.getCurrentUser()
		constituencyInstance.metro=metro
		constituencyInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (constituencyInstance == null) {
            notFound()
            return
        }

        if (constituencyInstance.hasErrors()) {
            respond constituencyInstance.errors, view:'create'
            return
        }

        constituencyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'constituencyInstance.label', default: 'Constituency'), constituencyInstance.id])
                redirect constituencyInstance
            }
            '*' { respond constituencyInstance, [status: CREATED] }
        }
    }

    def edit(Constituency constituencyInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,constituencyInstance:constituencyInstance]
    }

    @Transactional
    def update(Constituency constituencyInstance) {
        if (constituencyInstance == null) {
            notFound()
            return
        }

        if (constituencyInstance.hasErrors()) {
            respond constituencyInstance.errors, view:'edit'
            return
        }

        constituencyInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Constituency.label', default: 'Constituency'), constituencyInstance.id])
                redirect constituencyInstance
            }
            '*'{ respond constituencyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Constituency constituencyInstance) {

        if (constituencyInstance == null) {
            notFound()
            return
        }

        constituencyInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Constituency.label', default: 'Constituency'), constituencyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'constituencyInstance.label', default: 'Constituency'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
