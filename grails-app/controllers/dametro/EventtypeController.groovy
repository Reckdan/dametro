package dametro


import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import groovy.time.TimeDuration


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class EventtypeController {

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
//        respond Eventtype.list(params), model:[typeInstanceCount: Eventtype.count()]
		Menu home=Menu.find {menuname=="Home"}
		def types=Eventtype.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeEventtype.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,types:types,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Eventtype(params)
    }

    def show(Eventtype typeInstance) {
		Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,typeInstance:typeInstance]
//        respond typeInstance
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
		def typeInstance=new Eventtype()
		typeInstance.properties=params
		//td=TimeEventtype.minus(start,tasks.DueDate)
		//
		//respond new Eventtype(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,typeInstance:typeInstance]
       //respond new Eventtype(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def typeInstance=new Eventtype(params)
		typeInstance.dateCreated=new Date()
		typeInstance.dateUpdated=new Date()
		typeInstance.createdByUser=springSecurityService.getCurrentUser()
		typeInstance.metro=metro
		typeInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (typeInstance == null) {
            notFound()
            return
        }

        if (typeInstance.hasErrors()) {
            respond typeInstance.errors, view:'create'
            return
        }

        typeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'typeInstance.label', default: 'Eventtype'), typeInstance.id])
                redirect typeInstance
            }
            '*' { respond typeInstance, [status: CREATED] }
        }
    }

    def edit(Eventtype typeInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,typeInstance:typeInstance]
    }

    @Transactional
    def update(Eventtype typeInstance) {
        if (typeInstance == null) {
            notFound()
            return
        }

        if (typeInstance.hasErrors()) {
            respond typeInstance.errors, view:'edit'
            return
        }
		typeInstance.dateUpdated=new Date()
        typeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Eventtype.label', default: 'Eventtype'), typeInstance.id])
                redirect typeInstance
            }
            '*'{ respond typeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Eventtype typeInstance) {

        if (typeInstance == null) {
            notFound()
            return
        }

        typeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Eventtype.label', default: 'Eventtype'), typeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'typeInstance.label', default: 'Eventtype'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
