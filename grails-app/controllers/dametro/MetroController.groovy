package dametro

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import groovy.time.TimeDuration


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class MetroController {
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
//        respond Metro.list(params), model:[metroInstanceCount: Metro.count()]
		Menu home=Menu.find {menuname=="Home"}
		def metros=Metro.findAll()
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		//Date start=new Date()
		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeMetro.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,metros:metros,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Metro(params)
    }

    def show(Metro metroInstance) {
		Menu home=Menu.find {menuname=="Home"}
		
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,metroInstance:metroInstance]
//        respond metroInstance
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
		def metroInstance=new Metro()
		metroInstance.properties=params
		//td=TimeMetro.minus(start,tasks.DueDate)
		//
		//respond new Metro(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,metroInstance:metroInstance]
       //respond new Metro(params)
    }
	def uploadfile() {
		Menu home=Menu.find {menuname=="Home"}
		
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		//TimeDuration td=new TimeDuration(0,0,0,0)
		def fileuploadInstance=new Fileupload()
		fileuploadInstance.properties=params
		//td=TimeMetro.minus(start,tasks.DueDate)
		//
		//respond new Metro(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,fileuploadInstance:fileuploadInstance]
	   //respond new Metro(params)
	}

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def metroInstance=new Metro(params)
		metroInstance.datecreated=new Date()
		metroInstance.dateupdated=new Date()
		metroInstance.createdByUser=springSecurityService.getCurrentUser()
		metroInstance.metro=metro
		metroInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (metroInstance == null) {
            notFound()
            return
        }

        if (metroInstance.hasErrors()) {
            respond metroInstance.errors, view:'create'
            return
        }

        metroInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'metroInstance.label', default: 'Metro'), metroInstance.id])
                redirect metroInstance
            }
            '*' { respond metroInstance, [status: CREATED] }
        }
    }
	
	def upload() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def file = request.getFile('myFile')
		String newFilenameBase = UUID.randomUUID().toString()
		String originalFileExtension = file.originalFilename.substring(file.originalFilename.lastIndexOf("."))
		String newFilename = newFilenameBase + originalFileExtension
		String storageDirectory = grailsApplication.config.file.upload.directory?:'c:/tmp'

		File newFile = new File("$storageDirectory/$newFilename")
		file.transferTo(newFile)

		
		def fileuploadInstance=new Fileupload(params)
		fileuploadInstance.filetype=originalFileExtension
		fileuploadInstance.filename=newFilename
		fileuploadInstance.metro=metro
		if (fileuploadInstance == null) {
			notFound()
			return
		}

		if (fileuploadInstance.hasErrors()) {
			respond fileuploadInstance.errors, view:'create'
			return
		}

		fileuploadInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [message(code: 'metroInstance.label', default: 'Metro'), metroInstance.id])
				redirect metroInstance
			}
			'*' { respond metroInstance, [status: CREATED] }
		}
	}
	

    def edit(Metro metroInstance) {
        Menu home=Menu.find {menuname=="Home"}
	
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,metroInstance:metroInstance]
    }

    @Transactional
    def update(Metro metroInstance) {
        if (metroInstance == null) {
            notFound()
            return
        }

        if (metroInstance.hasErrors()) {
            respond metroInstance.errors, view:'edit'
            return
        }

        metroInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Metro.label', default: 'Metro'), metroInstance.id])
                redirect metroInstance
            }
            '*'{ respond metroInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Metro metroInstance) {

        if (metroInstance == null) {
            notFound()
            return
        }

        metroInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Metro.label', default: 'Metro'), metroInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'metroInstance.label', default: 'Metro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
