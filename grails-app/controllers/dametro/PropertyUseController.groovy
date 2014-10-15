package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class PropertyUseController {

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
//        respond PropertyUse.list(params), model:[propertyUseInstanceCount: PropertyUse.count()]
		Menu home=Menu.find {menuname=="Home"}
		def propertyUses=PropertyUse.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimePropertyUse.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,propertyUses:propertyUses,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new PropertyUse(params)
    }

    def show(PropertyUse propertyUseInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def propertyUses=PropertyUse.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,propertyUseInstance:propertyUseInstance]
//        respond propertyUseInstance
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
		def propertyUseInstance=new PropertyUse()
		propertyUseInstance.properties=params
		//td=TimePropertyUse.minus(start,tasks.DueDate)
		//
		//respond new PropertyUse(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,propertyUseInstance:propertyUseInstance]
       //respond new PropertyUse(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def propertyUseInstance=new PropertyUse(params)
		propertyUseInstance.datecreated=new Date()
		propertyUseInstance.dateupdated=new Date()
		propertyUseInstance.createdByUser=springSecurityService.getCurrentUser()
		propertyUseInstance.metro=metro
		propertyUseInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (propertyUseInstance == null) {
            notFound()
            return
        }

        if (propertyUseInstance.hasErrors()) {
            respond propertyUseInstance.errors, view:'create'
            return
        }

        propertyUseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'propertyUseInstance.label', default: 'PropertyUse'), propertyUseInstance.id])
                redirect propertyUseInstance
            }
            '*' { respond propertyUseInstance, [status: CREATED] }
        }
    }

    def edit(PropertyUse propertyUseInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,propertyUseInstance:propertyUseInstance]
    }

    @Transactional
    def update(PropertyUse propertyUseInstance) {
        if (propertyUseInstance == null) {
            notFound()
            return
        }

        if (propertyUseInstance.hasErrors()) {
            respond propertyUseInstance.errors, view:'edit'
            return
        }

        propertyUseInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PropertyUse.label', default: 'PropertyUse'), propertyUseInstance.id])
                redirect propertyUseInstance
            }
            '*'{ respond propertyUseInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PropertyUse propertyUseInstance) {

        if (propertyUseInstance == null) {
            notFound()
            return
        }

        propertyUseInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PropertyUse.label', default: 'PropertyUse'), propertyUseInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'propertyUseInstance.label', default: 'PropertyUse'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
