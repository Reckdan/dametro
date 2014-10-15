package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class CollectorgcrController {

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
//        respond Collectorgcr.list(params), model:[collectorgcrInstanceCount: Collectorgcr.count()]
		Menu home=Menu.find {menuname=="Home"}
		def collectorgcrs=Collectorgcr.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeCollectorgcr.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,collectorgcrs:collectorgcrs,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Collectorgcr(params)
    }

    def show(Collectorgcr collectorgcrInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def collectorgcrs=Collectorgcr.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,collectorgcrInstance:collectorgcrInstance]
//        respond collectorgcrInstance
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
		def collectorgcrInstance=new Collectorgcr()
		collectorgcrInstance.properties=params
		//td=TimeCollectorgcr.minus(start,tasks.DueDate)
		//
		//respond new Collectorgcr(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,collectorgcrInstance:collectorgcrInstance]
       //respond new Collectorgcr(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def collectorgcrInstance=new Collectorgcr(params)
		collectorgcrInstance.datecreated=new Date()
		collectorgcrInstance.dateupdated=new Date()
		collectorgcrInstance.createdByUser=springSecurityService.getCurrentUser()
		collectorgcrInstance.metro=metro
		collectorgcrInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (collectorgcrInstance == null) {
            notFound()
            return
        }

        if (collectorgcrInstance.hasErrors()) {
            respond collectorgcrInstance.errors, view:'create'
            return
        }

        collectorgcrInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'collectorgcrInstance.label', default: 'Collectorgcr'), collectorgcrInstance.id])
                redirect collectorgcrInstance
            }
            '*' { respond collectorgcrInstance, [status: CREATED] }
        }
    }

    def edit(Collectorgcr collectorgcrInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,collectorgcrInstance:collectorgcrInstance]
    }

    @Transactional
    def update(Collectorgcr collectorgcrInstance) {
        if (collectorgcrInstance == null) {
            notFound()
            return
        }

        if (collectorgcrInstance.hasErrors()) {
            respond collectorgcrInstance.errors, view:'edit'
            return
        }

        collectorgcrInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Collectorgcr.label', default: 'Collectorgcr'), collectorgcrInstance.id])
                redirect collectorgcrInstance
            }
            '*'{ respond collectorgcrInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Collectorgcr collectorgcrInstance) {

        if (collectorgcrInstance == null) {
            notFound()
            return
        }

        collectorgcrInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Collectorgcr.label', default: 'Collectorgcr'), collectorgcrInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'collectorgcrInstance.label', default: 'Collectorgcr'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
