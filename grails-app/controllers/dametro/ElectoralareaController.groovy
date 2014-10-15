package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class ElectoralareaController {

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
//        respond Electoralarea.list(params), model:[electoralareaInstanceCount: Electoralarea.count()]
		Menu home=Menu.find {menuname=="Home"}
		def electoralareas=Electoralarea.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeElectoralarea.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,electoralareas:electoralareas,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Electoralarea(params)
    }

    def show(Electoralarea electoralareaInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def electoralareas=Electoralarea.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,electoralareaInstance:electoralareaInstance]
//        respond electoralareaInstance
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
		def electoralareaInstance=new Electoralarea()
		electoralareaInstance.properties=params
		//td=TimeElectoralarea.minus(start,tasks.DueDate)
		//
		//respond new Electoralarea(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,electoralareaInstance:electoralareaInstance]
       //respond new Electoralarea(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def electoralareaInstance=new Electoralarea(params)
		electoralareaInstance.datecreated=new Date()
		electoralareaInstance.dateupdated=new Date()
		electoralareaInstance.createdByUser=springSecurityService.getCurrentUser()
		electoralareaInstance.metro=metro
		electoralareaInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (electoralareaInstance == null) {
            notFound()
            return
        }

        if (electoralareaInstance.hasErrors()) {
            respond electoralareaInstance.errors, view:'create'
            return
        }

        electoralareaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'electoralareaInstance.label', default: 'Electoralarea'), electoralareaInstance.id])
                redirect electoralareaInstance
            }
            '*' { respond electoralareaInstance, [status: CREATED] }
        }
    }

    def edit(Electoralarea electoralareaInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,electoralareaInstance:electoralareaInstance]
    }

    @Transactional
    def update(Electoralarea electoralareaInstance) {
        if (electoralareaInstance == null) {
            notFound()
            return
        }

        if (electoralareaInstance.hasErrors()) {
            respond electoralareaInstance.errors, view:'edit'
            return
        }

        electoralareaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Electoralarea.label', default: 'Electoralarea'), electoralareaInstance.id])
                redirect electoralareaInstance
            }
            '*'{ respond electoralareaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Electoralarea electoralareaInstance) {

        if (electoralareaInstance == null) {
            notFound()
            return
        }

        electoralareaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Electoralarea.label', default: 'Electoralarea'), electoralareaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'electoralareaInstance.label', default: 'Electoralarea'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
