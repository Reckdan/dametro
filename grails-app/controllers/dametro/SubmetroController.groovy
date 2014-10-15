package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class SubmetroController {

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
//        respond Submetro.list(params), model:[submetroInstanceCount: Submetro.count()]
		Menu home=Menu.find {menuname=="Home"}
		def submetros=Submetro.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeSubmetro.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,submetros:submetros,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Submetro(params)
    }

    def show(Submetro submetroInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def submetros=Submetro.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,submetroInstance:submetroInstance]
//        respond submetroInstance
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
		def submetroInstance=new Submetro()
		submetroInstance.properties=params
		//td=TimeSubmetro.minus(start,tasks.DueDate)
		//
		//respond new Submetro(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,submetroInstance:submetroInstance]
       //respond new Submetro(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def submetroInstance=new Submetro(params)
		submetroInstance.dateAdded=new Date()
		
		submetroInstance.addedByUser=springSecurityService.getCurrentUser()
		submetroInstance.metro=metro
		submetroInstance.dateuUdated=new Date()
		submetroInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (submetroInstance == null) {
            notFound()
            return
        }

        if (submetroInstance.hasErrors()) {
            Menu home=Menu.find {menuname=="Home"}
			def menus=Menu.findAll {subof==0 && menuname!="Home"}
			def submenus=Menu.findAll {subof!=0}
			
			def loginuser=springSecurityService.getCurrentUser()
			def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
			def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
			Date start=new Date()
			//TimeDuration td=new TimeDuration(0,0,0,0)
			//def bookInstance=new Book()
			//bookInstance.properties=params
			//td=TimeCategory.minus(start,tasks.DueDate)
			//
			//respond new Category(params)
			//flash.message="list"
	//		if(params["type"]=="addcat"){
	//
	//		}
			
		 //render (view:'edit', )
			//respond bookInstance.errors, view:'create'
	
            respond model:[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,submetroInstance:submetroInstance], view:'edit'
            return
        }

        submetroInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'submetroInstance.label', default: 'Submetro'), submetroInstance.id])
                redirect submetroInstance
            }
            '*' { respond submetroInstance, [status: CREATED] }
        }
    }

    def edit(Submetro submetroInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,submetroInstance:submetroInstance]
    }

    @Transactional
    def update(Submetro submetroInstance) {
		submetroInstance.dateuUdated=new Date()
		submetroInstance.updatedByUser=springSecurityService.getCurrentUser()
		if (submetroInstance == null) {
            notFound()
            return
        }

        if (submetroInstance.hasErrors()) {
			Menu home=Menu.find {menuname=="Home"}
			def menus=Menu.findAll {subof==0 && menuname!="Home"}
			def submenus=Menu.findAll {subof!=0}
			
			def loginuser=springSecurityService.getCurrentUser()
			def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
			def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
			Date start=new Date()
			//TimeDuration td=new TimeDuration(0,0,0,0)
			//def bookInstance=new Book()
			//bookInstance.properties=params
			//td=TimeCategory.minus(start,tasks.DueDate)
			//
			//respond new Category(params)
			//flash.message="list"
	//		if(params["type"]=="addcat"){
	//
	//		}
			
		 //render (view:'edit', )
			//respond bookInstance.errors, view:'create'
	
            respond model:[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,submetroInstance:submetroInstance], view:'edit'
            return
        }

        submetroInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Submetro.label', default: 'Submetro'), submetroInstance.id])
                redirect submetroInstance
            }
            '*'{ respond submetroInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Submetro submetroInstance) {

        if (submetroInstance == null) {
            notFound()
            return
        }

        submetroInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Submetro.label', default: 'Submetro'), submetroInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'submetroInstance.label', default: 'Submetro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
