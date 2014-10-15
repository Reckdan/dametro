package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class PermitinfoController {

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
	//        respond Permitinfo.list(params), model:[permitinfoInstanceCount: Permitinfo.count()]
			Menu home=Menu.find {menuname=="Home"}
			def permitinfos=Permitinfo.findAll{metro.id==1 }
			
			def menus=Menu.findAll {subof==0 && menuname!="Home"}
			def submenus=Menu.findAll {subof!=0}
			
			def loginuser=springSecurityService.getCurrentUser()
			def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
			def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
	
			//TimeDuration td=new TimeDuration(0,0,0,0)
			
			//td=TimePermitinfo.minus(start,tasks.DueDate)
			//
			//
			//flash.message="list"
	//		if(params["type"]=="addcat"){
	//
	//		}
			[menus:menus,submenus:submenus,home:home,permitinfos:permitinfos,notifications:notifications,tasks:tasks,loginuser:loginuser]
			//respond new Permitinfo(params)
		}
	
		def show(Permitinfo permitinfoInstance) {
			Menu home=Menu.find {menuname=="Home"}
			//def permitinfos=Permitinfo.findAll{gcatId=='P' && metro.id==1 }
			
			def menus=Menu.findAll {subof==0 && menuname!="Home"}
			def submenus=Menu.findAll {subof!=0}
			
			def loginuser=springSecurityService.getCurrentUser()
			def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
			def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
			Date start=new Date()
			[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,permitinfoInstance:permitinfoInstance]
	//        respond permitinfoInstance
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
			def permitinfoInstance=new Permitinfo()
			permitinfoInstance.properties=params
			//td=TimePermitinfo.minus(start,tasks.DueDate)
			//
			//respond new Permitinfo(params)
			//flash.message="list"
	//		if(params["type"]=="addcat"){
	//
	//		}
			
			[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,permitinfoInstance:permitinfoInstance]
		   //respond new Permitinfo(params)
		}
	
		@Transactional
		def save() {
			Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
			if(metro==null){
				notFound()
				return
			}
			def permitinfoInstance=new Permitinfo(params)
			permitinfoInstance.datecreated=new Date()
			permitinfoInstance.dateupdated=new Date()
			permitinfoInstance.createdByUser=springSecurityService.getCurrentUser()
			permitinfoInstance.metro=metro
			permitinfoInstance.updatedByUser=springSecurityService.getCurrentUser()
			if (permitinfoInstance == null) {
				notFound()
				return
			}
	
			if (permitinfoInstance.hasErrors()) {
				respond permitinfoInstance.errors, view:'create'
				return
			}
	
			permitinfoInstance.save flush:true
	
			request.withFormat {
				form multipartForm {
					flash.message = message(code: 'default.created.message', args: [message(code: 'permitinfoInstance.label', default: 'Permitinfo'), permitinfoInstance.id])
					redirect permitinfoInstance
				}
				'*' { respond permitinfoInstance, [status: CREATED] }
			}
		}
	
		def edit(Permitinfo permitinfoInstance) {
			Menu home=Menu.find {menuname=="Home"}
			
			def menus=Menu.findAll {subof==0 && menuname!="Home"}
			def submenus=Menu.findAll {subof!=0}
			
			def loginuser=springSecurityService.getCurrentUser()
			def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
			def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
			Date start=new Date()
			[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,permitinfoInstance:permitinfoInstance]
		}
	
		@Transactional
		def update(Permitinfo permitinfoInstance) {
			if (permitinfoInstance == null) {
				notFound()
				return
			}
	
			if (permitinfoInstance.hasErrors()) {
				respond permitinfoInstance.errors, view:'edit'
				return
			}
	
			permitinfoInstance.save flush:true
	
			request.withFormat {
				form multipartForm {
					flash.message = message(code: 'default.updated.message', args: [message(code: 'Permitinfo.label', default: 'Permitinfo'), permitinfoInstance.id])
					redirect permitinfoInstance
				}
				'*'{ respond permitinfoInstance, [status: OK] }
			}
		}
	
		@Transactional
		def delete(Permitinfo permitinfoInstance) {
	
			if (permitinfoInstance == null) {
				notFound()
				return
			}
	
			permitinfoInstance.delete flush:true
	
			request.withFormat {
				form multipartForm {
					flash.message = message(code: 'default.deleted.message', args: [message(code: 'Permitinfo.label', default: 'Permitinfo'), permitinfoInstance.id])
					redirect action:"index", method:"GET"
				}
				'*'{ render status: NO_CONTENT }
			}
		}
	
		protected void notFound() {
			request.withFormat {
				form multipartForm {
					flash.message = message(code: 'default.not.found.message', args: [message(code: 'permitinfoInstance.label', default: 'Permitinfo'), params.id])
					redirect action: "index", method: "GET"
				}
				'*'{ render status: NOT_FOUND }
			}
		}
}
