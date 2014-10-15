package dametro
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class CommunityController {

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
//        respond Community.list(params), model:[communityInstanceCount: Community.count()]
		Menu home=Menu.find {menuname=="Home"}
		def communities=Community.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeCommunity.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,communities:communities,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Community(params)
    }

    def show(Community communityInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def communities=Community.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,communityInstance:communityInstance]
//        respond communityInstance
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
		def communityInstance=new Community()
		communityInstance.properties=params
		//td=TimeCommunity.minus(start,tasks.DueDate)
		//
		//respond new Community(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,communityInstance:communityInstance]
       //respond new Community(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def communityInstance=new Community(params)
		communityInstance.datecreated=new Date()
		communityInstance.dateupdated=new Date()
		communityInstance.createdByUser=springSecurityService.getCurrentUser()
		communityInstance.metro=metro
		communityInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (communityInstance == null) {
            notFound()
            return
        }

        if (communityInstance.hasErrors()) {
            respond communityInstance.errors, view:'create'
            return
        }

        communityInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'communityInstance.label', default: 'Community'), communityInstance.id])
                redirect communityInstance
            }
            '*' { respond communityInstance, [status: CREATED] }
        }
    }

    def edit(Community communityInstance) {
        Menu home=Menu.find {menuname=="Home"}
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,communityInstance:communityInstance]
    }

    @Transactional
    def update(Community communityInstance) {
        if (communityInstance == null) {
            notFound()
            return
        }

        if (communityInstance.hasErrors()) {
            respond communityInstance.errors, view:'edit'
            return
        }

        communityInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Community.label', default: 'Community'), communityInstance.id])
                redirect communityInstance
            }
            '*'{ respond communityInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Community communityInstance) {

        if (communityInstance == null) {
            notFound()
            return
        }

        communityInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Community.label', default: 'Community'), communityInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'communityInstance.label', default: 'Community'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
