package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import grails.converters.JSON

@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class FixedfeeController {

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
//        respond Fixedfee.list(params), model:[fixedfeeInstanceCount: Fixedfee.count()]
		Menu home=Menu.find {menuname=="Home"}
		def fixedfees=Fixedfee.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeFixedfee.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,fixedfees:fixedfees,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Fixedfee(params)
    }

    def show(Fixedfee fixedfeeInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def fixedfees=Fixedfee.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,fixedfeeInstance:fixedfeeInstance]
//        respond fixedfeeInstance
    }
	def listcategories(){
		def pr=params.mtype
		def cats=Category.findAll{type.id==pr}
		render cats as JSON
	}
	
	def getMincharge(){
		def pr=params.catval
		Category category=Category.get(pr)
		render category as JSON
	}
	
    def create() {
		Menu home=Menu.find {menuname=="Home"}
		Metro met=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		//TimeDuration td=new TimeDuration(0,0,0,0)
		def fixedfeeInstance=new Fixedfee()
		fixedfeeInstance.properties=params
		def category=Category.findAll{metro.id==met.id}
		def type=Eventtype.findAll{metro.id==met.id}
		//td=TimeFixedfee.minus(start,tasks.DueDate)
		//
		//respond new Fixedfee(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
	
		//def years=[start.year-4,start.year-3,start.year-2,start.year-1,start.year,start.year+1]
		
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,fixedfeeInstance:fixedfeeInstance,category:category,type:type]
       //respond new Fixedfee(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def fixedfeeInstance=new Fixedfee(params)
		fixedfeeInstance.gcatId=fixedfeeInstance.type.gcatId
		fixedfeeInstance.dateCreated=new Date()
		fixedfeeInstance.metro=metro
        if (fixedfeeInstance == null) {
            notFound()
            return
        }

        if (fixedfeeInstance.hasErrors()) {
//            Menu home=Menu.find {menuname=="Home"}
//			def menus=Menu.findAll {subof==0 && menuname!="Home"}
//			def submenus=Menu.findAll {subof!=0}
//			
			
//			def loginuser=springSecurityService.getCurrentUser()
//			def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
//			def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
			//Date start=new Date()
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
			respond fixedfeeInstance, view:'create'
			return
		// render (view:'create', model:[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,fixedfeeInstance:fixedfeeInstance])
        }

        fixedfeeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fixedfeeInstance.label', default: 'Fixedfee'), fixedfeeInstance.id])
                redirect fixedfeeInstance
            }
            '*' { respond fixedfeeInstance, [status: CREATED] }
        }
    }

    def edit(Fixedfee fixedfeeInstance) {
        Menu home=Menu.find {menuname=="Home"}
		Metro met=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		def category=Category.findAll{metro.id==met.id}
		def type=Eventtype.findAll{metro.id==met.id}
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,fixedfeeInstance:fixedfeeInstance,category:category,type:type]
    }

    @Transactional
    def update(Fixedfee fixedfeeInstance) {
        if (fixedfeeInstance == null) {
            notFound()
            return
        }

        if (fixedfeeInstance.hasErrors()) {
//            Menu home=Menu.find {menuname=="Home"}
//			def menus=Menu.findAll {subof==0 && menuname!="Home"}
//			def submenus=Menu.findAll {subof!=0}
//			
//			def loginuser=springSecurityService.getCurrentUser()
//			def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
//			def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
			//Date start=new Date()
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
			respond fixedfeeInstance, view:'edit'
			return
	//	 render (view:'create', model:[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,fixedfeeInstance:fixedfeeInstance])
        }

        fixedfeeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Fixedfee.label', default: 'Fixedfee'), fixedfeeInstance.id])
                redirect fixedfeeInstance
            }
            '*'{ respond fixedfeeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Fixedfee fixedfeeInstance) {

        if (fixedfeeInstance == null) {
            notFound()
            return
        }

        fixedfeeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Fixedfee.label', default: 'Fixedfee'), fixedfeeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fixedfeeInstance.label', default: 'Fixedfee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
