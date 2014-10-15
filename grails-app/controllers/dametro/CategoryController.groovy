package dametro



import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class CategoryController {

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
//        respond Category.list(params), model:[categoryInstanceCount: Category.count()]
		Menu home=Menu.find {menuname=="Home"}
		def categories=Category.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeCategory.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,categories:categories,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Category(params)
    }

    def show(Category categoryInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def categories=Category.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,categoryInstance:categoryInstance]
//        respond categoryInstance
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
		def categoryInstance=new Category()
		categoryInstance.properties=params
		//td=TimeCategory.minus(start,tasks.DueDate)
		//
		//respond new Category(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,categoryInstance:categoryInstance]
       //respond new Category(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def categoryInstance=new Category(params)
		categoryInstance.datecreated=new Date()
		categoryInstance.dateupdated=new Date()
		categoryInstance.createdByUser=springSecurityService.getCurrentUser()
		categoryInstance.metro=metro
		categoryInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (categoryInstance == null) {
            notFound()
            return
        }

        if (categoryInstance.hasErrors()) {
            respond categoryInstance.errors, view:'create'
            return
        }

        categoryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoryInstance.label', default: 'Category'), categoryInstance.id])
                redirect categoryInstance
            }
            '*' { respond categoryInstance, [status: CREATED] }
        }
    }

    def edit(Category categoryInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,categoryInstance:categoryInstance]
    }

    @Transactional
    def update(Category categoryInstance) {
        if (categoryInstance == null) {
            notFound()
            return
        }

        if (categoryInstance.hasErrors()) {
            respond categoryInstance.errors, view:'edit'
            return
        }

        categoryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Category.label', default: 'Category'), categoryInstance.id])
                redirect categoryInstance
            }
            '*'{ respond categoryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Category categoryInstance) {

        if (categoryInstance == null) {
            notFound()
            return
        }

        categoryInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Category.label', default: 'Category'), categoryInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoryInstance.label', default: 'Category'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
