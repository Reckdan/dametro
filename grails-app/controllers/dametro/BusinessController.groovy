package dametro

import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)

class BusinessController {

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
//        respond Business.list(params), model:[businessInstanceCount: Business.count()]
		Menu home=Menu.find {menuname=="Home"}
		def businesses=Business.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeBusiness.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,businesses:businesses,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Business(params)
    }

    def show(Business businessInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def businesses=Business.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,businessInstance:businessInstance]
//        respond businessInstance
    }

    def create() {
		Menu home=Menu.find {menuname=="Home"}

		Metro usermetro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		def types=Eventtype.findAll{gcatId=='B' && metro.id==usermetro.id}
		def categories=Category.findAll{gcatId=='B' && metro.id==usermetro.id}
		def contacts=Contact.findAll{metro.id==usermetro.id}
		def headoffice=Business.findAll{isheadoffice==true}
		def buildings=Building.findAll{metro.id==usermetro.id}
		def submetros=Submetro.findAll{metro.id==usermetro.id}
		def constituencies=Constituency.findAll{metro.id==usermetro.id}
		def electoralareas=Electoralarea.findAll{metro.id==usermetro.id}
		def units=Unit.findAll{metro.id==usermetro.id}
		def streets=Street.findAll{metro.id==usermetro.id}
		def communities=Community.findAll{metro.id==usermetro.id}
		def assessmenttypes=Lookup.findAll{type.typeDesc=="Assessment Type"}
		def premisetypes=Lookup.findAll{type.typeDesc=="Premise Type"}
		
		Date start=new Date()
		//TimeDuration td=new TimeDuration(0,0,0,0)
		def businessInstance=new Business()
		businessInstance.properties=params
		//td=TimeBusiness.minus(start,tasks.DueDate)
		//
		//respond new Business(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,businessInstance:businessInstance,
			headoffice:headoffice, types:types, categories:categories, contacts:contacts,buildings:buildings, submetros:submetros, constituencies:constituencies,
			electoralareas:electoralareas, units:units, streets:streets, communities:communities, assessmenttypes:assessmenttypes, premisetypes:premisetypes]
       //respond new Business(params)
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def businessInstance=new Business(params)
		businessInstance.datecreated=new Date()
		businessInstance.dateupdated=new Date()
		businessInstance.createdByUser=springSecurityService.getCurrentUser()
		businessInstance.metro=metro
		businessInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (businessInstance == null) {
            notFound()
            return
        }

        if (businessInstance.hasErrors()) {
            respond businessInstance.errors, view:'create'
            return
        }

        businessInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'businessInstance.label', default: 'Business'), businessInstance.id])
                redirect businessInstance
            }
            '*' { respond businessInstance, [status: CREATED] }
        }
    }

    def edit(Business businessInstance) {
        Menu home=Menu.find {menuname=="Home"}
		Metro usermetro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		def types=Eventtype.findAll{gcatId=='B' && metro.id==usermetro.id}
		def categories=Category.findAll{gcatId=='B' && metro.id==usermetro.id}
		def contacts=Contact.findAll{metro.id==usermetro.id}
		def headoffice=Business.findAll{isheadoffice==true}
		def buildings=Building.findAll{metro.id==usermetro.id}
		def submetros=Submetro.findAll{metro.id==usermetro.id}
		def constituencies=Constituency.findAll{metro.id==usermetro.id}
		def electoralareas=Electoralarea.findAll{metro.id==usermetro.id}
		def units=Unit.findAll{metro.id==usermetro.id}
		def streets=Street.findAll{metro.id==usermetro.id}
		def communities=Community.findAll{metro.id==usermetro.id}
		def assessmenttypes=Lookup.findAll{type.typeDesc=="Assessment Type"}
		def premisetypes=Lookup.findAll{type.typeDesc=="Premise Type"}
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,businessInstance:businessInstance,
			headoffice:headoffice, types:types, categories:categories, contacts:contacts,buildings:buildings, submetros:submetros, constituencies:constituencies,
			electoralareas:electoralareas, units:units, streets:streets, communities:communities, assessmenttypes:assessmenttypes, premisetypes:premisetypes]
    }

    @Transactional
    def update(Business businessInstance) {
        if (businessInstance == null) {
            notFound()
            return
        }

        if (businessInstance.hasErrors()) {
            respond businessInstance.errors, view:'edit'
            return
        }

        businessInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Business.label', default: 'Business'), businessInstance.id])
                redirect businessInstance
            }
            '*'{ respond businessInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Business businessInstance) {

        if (businessInstance == null) {
            notFound()
            return
        }

        businessInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Business.label', default: 'Business'), businessInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'businessInstance.label', default: 'Business'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
