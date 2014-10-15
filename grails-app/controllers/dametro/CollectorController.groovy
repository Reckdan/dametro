package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.MultipartFile

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class CollectorController {

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
//        respond Collector.list(params), model:[collectorInstanceCount: Collector.count()]
		Menu home=Menu.find {menuname=="Home"}
		def collectors=Collector.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeCollector.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,collectors:collectors,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Collector(params)
    }

    def show(Collector collectorInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def collectors=Collector.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,collectorInstance:collectorInstance]
//        respond collectorInstance
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
		def collectorInstance=new Collector()
		collectorInstance.properties=params
		//td=TimeCollector.minus(start,tasks.DueDate)
		//
		//respond new Collector(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,collectorInstance:collectorInstance]
       //respond new Collector(params)
    }
	
	@Transactional
	def upload(){
		def file = request.getFile('collectorPicture')
		def gfile=request.getFile('guarantorPicture')
		def collectorInstance = Collector.get(params.id)
		String newFilenameBase
		String originalFileExtension
		String newFilename
		String storageDirectory = grailsApplication.config.uploadFolder?:'C:/Users/Daniel/Dropbox/workspace/dametro/web-app/images/photos'
		if(!file.empty) {
			newFilenameBase = UUID.randomUUID().toString()
			originalFileExtension = file.originalFilename.substring(file.originalFilename.lastIndexOf("."))
			newFilename = newFilenameBase + originalFileExtension
			File newFile = new File("$storageDirectory/$newFilename")
			file.transferTo(newFile)
			
			
			collectorInstance.collectorPicture=newFilename
		}
		if(!gfile.empty){
			newFilenameBase = UUID.randomUUID().toString()
			originalFileExtension = gfile.originalFilename.substring(file.originalFilename.lastIndexOf("."))
			newFilename = newFilenameBase + originalFileExtension
			File newFile = new File("$storageDirectory/$newFilename")
			gfile.transferTo(newFile)
			collectorInstance.guarantorPicture=newFilename
		}
		
//		flash.message = "File cannot be empty"
//		redirect (action:'list', id:params.id)
		
		
		

		
		if (collectorInstance == null) {
			notFound()
			return
		}

		if (collectorInstance.hasErrors()) {
			respond collectorInstance.errors, view:'edit'
			return
		}

		collectorInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'Collector.label', default: 'Collector'), collectorInstance.id])
				redirect collectorInstance
			}
			'*'{ respond collectorInstance, [status: OK] }
		}
	}
	
    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
	
		def collectorInstance=new Collector(params)
		collectorInstance.collectorPicture=''
		collectorInstance.guarantorPicture=''
		collectorInstance.datecreated=new Date()
		collectorInstance.approved=0
		collectorInstance.createdByUser=springSecurityService.getCurrentUser()
		collectorInstance.metro=metro
		//collectorInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (collectorInstance == null) {
            notFound()
            return
        }

        if (collectorInstance.hasErrors()) {
			Menu home=Menu.find {menuname=="Home"}
			
					
					def menus=Menu.findAll {subof==0 && menuname!="Home"}
					def submenus=Menu.findAll {subof!=0}
					
					def loginuser=springSecurityService.getCurrentUser()
					def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
					def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
					Date start=new Date()
					//TimeDuration td=new TimeDuration(0,0,0,0)
					//def collectorInstance=new Collector()
					//collectorInstance.properties=params
					//td=TimeCollector.minus(start,tasks.DueDate)
					//
					//respond new Collector(params)
					//flash.message="list"
			//		if(params["type"]=="addcat"){
			//
			//		}
					
				render(view:'create', model:[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,collectorInstance:collectorInstance])
            //respond collectorInstance.errors, view:'create'
            return
        }

        collectorInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'collectorInstance.label', default: 'Collector'), collectorInstance.id])
                redirect collectorInstance
            }
            '*' { respond collectorInstance, [status: CREATED] }
        }
    }

    def edit(Collector collectorInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,collectorInstance:collectorInstance]
    }

    @Transactional
    def update(Collector collectorInstance) {
        if (collectorInstance == null) {
            notFound()
            return
        }

        if (collectorInstance.hasErrors()) {
            respond collectorInstance.errors, view:'edit'
            return
        }

        collectorInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Collector.label', default: 'Collector'), collectorInstance.id])
                redirect collectorInstance
            }
            '*'{ respond collectorInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Collector collectorInstance) {

        if (collectorInstance == null) {
            notFound()
            return
        }

        collectorInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Collector.label', default: 'Collector'), collectorInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'collectorInstance.label', default: 'Collector'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
