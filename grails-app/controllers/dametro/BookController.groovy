package dametro




import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*
@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class BookController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	def springSecurityService
    def index() {
        //params.max = Math.min(max ?: 10, 100)
		Menu home=Menu.find {menuname=="Home"}
		def books=Book.findAll{ metro.id==1 }
		
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
		[menus:menus,submenus:submenus,home:home,books:books,notifications:notifications,tasks:tasks,loginuser:loginuser]
       // respond Book.list(params), model:[bookInstanceCount: Book.count()]
    }

    def show(Book bookInstance) {
        Menu home=Menu.find {menuname=="Home"}
		//def categories=Category.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,bookInstance:bookInstance]
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
				def bookInstance=new Book()
				bookInstance.properties=params
				//td=TimeCategory.minus(start,tasks.DueDate)
				//
				if(flash.book){
				bookInstance=flash.book
				}
				//respond new Category(params)
				//flash.message="list"
		//		if(params["type"]=="addcat"){
		//
		//		}
				
				[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,bookInstance:bookInstance]
        //respond new Book(params)
    }

    @Transactional
    def save(Book bookInstance) {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
        if (bookInstance == null) {
            notFound()
            return
        }

        if (bookInstance.hasErrors()) {
//			Menu home=Menu.find {menuname=="Home"}
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
			flash.book=bookInstance
			//respond new Category(params)
			//flash.message="list"
	//		if(params["type"]=="addcat"){
	//
	//		}
			
		// render (view:'create', model:[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,bookInstance:bookInstance])
            //respond bookInstance, view:'create'
			redirect(action: "create")
			return
        }
		bookInstance.metro=metro
        bookInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bookInstance.label', default: 'Book'), bookInstance.id])
                redirect bookInstance
            }
            '*' { respond bookInstance, [status: CREATED] }
        }
    }

    def edit(Book bookInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		if(flash.book){
			bookInstance=flash.book
			
		}
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,bookInstance:bookInstance]
    }

    @Transactional
    def update() {
		
		def bookInstance = Book.get(params.id)
		if (bookInstance == null) {
			notFound()
			return
		}
		bookInstance.properties = params
		bookInstance.validate()
		if (bookInstance.hasErrors()) {
						//respond bookInstance.errors, view:'create'
			flash.book=bookInstance
			redirect (action:"edit")
			return
		}

		bookInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [message(code: 'Book.label', default: 'Book'), bookInstance.id])
				redirect bookInstance
			}
			'*'{ respond bookInstance, [status: OK] }
		}
    }

    @Transactional
    def delete(Book bookInstance) {

        if (bookInstance == null) {
            notFound()
            return
        }

        bookInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Book.label', default: 'Book'), bookInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bookInstance.label', default: 'Book'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
