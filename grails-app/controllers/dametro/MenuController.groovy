package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class MenuController {
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
	//        respond Menu.list(params), model:[menuInstanceCount: Menu.count()]
			Menu home=Menu.find {menuname=="Home"}
			//def menus=Menu.findAll()
			
			def menus=Menu.findAll {subof==0 && menuname!="Home"}
			def submenus=Menu.findAll {subof!=0}
			
			def loginuser=springSecurityService.getCurrentUser()
			def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
			def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
	
			//TimeDuration td=new TimeDuration(0,0,0,0)
			
			//td=TimeMenu.minus(start,tasks.DueDate)
			//
			//
			//flash.message="list"
	//		if(params["type"]=="addcat"){
	//
	//		}
			[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser]
			//respond new Menu(params)
		}
	
		def show(Menu menuInstance) {
			Menu home=Menu.find {menuname=="Home"}
			//def menus=Menu.findAll{gcatId=='P' && metro.id==1 }
			
			def menus=Menu.findAll {subof==0 && menuname!="Home"}
			def submenus=Menu.findAll {subof!=0}
			
			def loginuser=springSecurityService.getCurrentUser()
			def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
			def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
			Date start=new Date()
			[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,menuInstance:menuInstance]
	//        respond menuInstance
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
			def menuInstance=new Menu()
			menuInstance.properties=params
			//td=TimeMenu.minus(start,tasks.DueDate)
			//
			//respond new Menu(params)
			//flash.message="list"
	//		if(params["type"]=="addcat"){
	//
	//		}
			
			[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,menuInstance:menuInstance]
		   //respond new Menu(params)
		}
	
		@Transactional
		def save() {
			Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
			if(metro==null){
				notFound()
				return
			}
			def menuInstance=new Menu(params)
			menuInstance.datecreated=new Date()
			menuInstance.dateupdated=new Date()
			menuInstance.createdByUser=springSecurityService.getCurrentUser()
			menuInstance.metro=metro
			menuInstance.updatedByUser=springSecurityService.getCurrentUser()
			if (menuInstance == null) {
				notFound()
				return
			}
	
			if (menuInstance.hasErrors()) {
				respond menuInstance.errors, view:'create'
				return
			}
	
			menuInstance.save flush:true
	
			request.withFormat {
				form multipartForm {
					flash.message = message(code: 'default.created.message', args: [message(code: 'menuInstance.label', default: 'Menu'), menuInstance.id])
					redirect menuInstance
				}
				'*' { respond menuInstance, [status: CREATED] }
			}
		}
	
		def edit(Menu menuInstance) {
			Menu home=Menu.find {menuname=="Home"}
			
			def menus=Menu.findAll {subof==0 && menuname!="Home"}
			def submenus=Menu.findAll {subof!=0}
			
			def loginuser=springSecurityService.getCurrentUser()
			def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
			def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
			Date start=new Date()
			[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,menuInstance:menuInstance]
		}
	
		@Transactional
		def update(Menu menuInstance) {
			if (menuInstance == null) {
				notFound()
				return
			}
	
			if (menuInstance.hasErrors()) {
				respond menuInstance.errors, view:'edit'
				return
			}
	
			menuInstance.save flush:true
	
			request.withFormat {
				form multipartForm {
					flash.message = message(code: 'default.updated.message', args: [message(code: 'Menu.label', default: 'Menu'), menuInstance.id])
					redirect menuInstance
				}
				'*'{ respond menuInstance, [status: OK] }
			}
		}
	
		@Transactional
		def delete(Menu menuInstance) {
	
			if (menuInstance == null) {
				notFound()
				return
			}
	
			menuInstance.delete flush:true
	
			request.withFormat {
				form multipartForm {
					flash.message = message(code: 'default.deleted.message', args: [message(code: 'Menu.label', default: 'Menu'), menuInstance.id])
					redirect action:"index", method:"GET"
				}
				'*'{ render status: NO_CONTENT }
			}
		}
	
		protected void notFound() {
			request.withFormat {
				form multipartForm {
					flash.message = message(code: 'default.not.found.message', args: [message(code: 'menuInstance.label', default: 'Menu'), params.id])
					redirect action: "index", method: "GET"
				}
				'*'{ render status: NOT_FOUND }
			}
		}
}
