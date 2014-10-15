package dametro
//import org.springframework.dao.DataIntegrityViolationException
//import org.grails.plugin.easygrid.Easygrid


import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import grails.converters.JSON


@Secured(['ROLE_ADMIN'])
@Transactional(readOnly = true)
class BuildingController {
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
//        respond Building.list(params), model:[buildingInstanceCount: Building.count()]
		Menu home=Menu.find {menuname=="Home"}
		def buildings=Building.findAll{metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}

		//TimeDuration td=new TimeDuration(0,0,0,0)
		
		//td=TimeBuilding.minus(start,tasks.DueDate)
		//
		//
		//flash.message="list"
//		if(params["type"]=="addcat"){
//			
//		}
		[menus:menus,submenus:submenus,home:home,buildings:buildings,notifications:notifications,tasks:tasks,loginuser:loginuser]
		//respond new Building(params)
    }

    def show(Building buildingInstance) {
		Menu home=Menu.find {menuname=="Home"}
		//def buildings=Building.findAll{gcatId=='P' && metro.id==1 }
		
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		Date start=new Date()
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,buildingInstance:buildingInstance]
//        respond buildingInstance
    }

    def create() {
		Menu home=Menu.find {menuname=="Home"}

		Metro usermetro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		  def types=Eventtype.findAll{gcatId=='P' && metro.id==usermetro.id}
        def categories=Category.findAll{gcatId=='P' && metro.id==usermetro.id}

        def contacts=Contact.findAll{metro.id==usermetro.id}
        def submetros=Submetro.findAll{metro.id==usermetro.id}
        def constituencies=Constituency.findAll{metro.id==usermetro.id}
        def electoralareas=Electoralarea.findAll{metro.id==usermetro.id}
        def units=Unit.findAll{metro.id==usermetro.id}
        def streets=Street.findAll{metro.id==usermetro.id}
        def communities=Community.findAll{metro.id==usermetro.id}
        def assessmenttypes=Lookup.findAll{type.typeDesc=="Assessment Type"}
        def premisetypes=Lookup.findAll{type.typeDesc=="Premise Type"}
        def propstatus=Lookup.findAll{type.typeDesc=="Status"}
        def modeoffinance=Lookup.findAll{type.typeDesc=="Mode of Finance"}
        
		def buildingInstance=new Building()
		buildingInstance.properties=params
		if(flash.building){
			buildingInstance=flash.building
		}
		
		//td=TimeBuilding.minus(start,tasks.DueDate)
		//
		//respond new Building(params)
		//flash.message="list"
//		if(params["type"]=="addcat"){
//
//		}
		
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,types:types,categories:categories, contacts:contacts, submetros:submetros, constituencies:constituencies,
        electoralareas:electoralareas,units:units,streets:streets,communities:communities, assessmenttypes:assessmenttypes,premisetypes:premisetypes,propstatus:propstatus,modeoffinance:modeoffinance]
       //respond new Building(params)
    }

    def listconstituencies(){
		def submetroid=params.mtype
        def constituencies=Constituency.findAll{submetro.id==submetroid}
        render constituencies as JSON
    }

    def listelectoralereas(){
		def constituencyid=params.mtype
        def electoralareas=Electoralarea.findAll{constituency.id==constituencyid}
        render electoralareas as JSON

    }

    def listunits(){
		def electoralareaid=params.mtype
        def units=Unit.findAll{electoralarea.id==electoralareaid}
        render units as JSON
    }

    @Transactional
    def save() {
		Metro metro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		if(metro==null){
			notFound()
			return
		}
		def buildingInstance=new Building(params)
		buildingInstance.datecreated=new Date()
		buildingInstance.dateupdated=new Date()
		buildingInstance.createdByUser=springSecurityService.getCurrentUser()
		buildingInstance.metro=metro
		buildingInstance.updatedByUser=springSecurityService.getCurrentUser()
        if (buildingInstance == null) {
            notFound()
            return
        }

        if (buildingInstance.hasErrors()) {
			flash.building=buildingInstance
            redirect(action:'create')
            return
        }

        buildingInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'buildingInstance.label', default: 'Building'), buildingInstance.id])
                redirect buildingInstance
            }
            '*' { respond buildingInstance, [status: CREATED] }
        }
    }

    def edit(Building buildingInstance) {
        Menu home=Menu.find {menuname=="Home"}
		Metro usermetro=Metro.find{metro==springSecurityService.getCurrentUser().metro}
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		def submenus=Menu.findAll {subof!=0}
		
		def loginuser=springSecurityService.getCurrentUser()
		def notifications=Notification.findAll{user.username==springSecurityService.getCurrentUser().username}
		def tasks=Pendingtask.findAll{user.username==springSecurityService.getCurrentUser().username}
		  def types=Eventtype.findAll{gcatId=='P' && metro.id==usermetro.id}
        def categories=Category.findAll{type.id==buildingInstance.type.id}

        def contacts=Contact.findAll{metro.id==usermetro.id}
        def submetros=Submetro.findAll{metro.id==usermetro.id}
        def constituencies=Constituency.findAll{submetro.id==buildingInstance.submetro.id}
        def electoralareas=Electoralarea.findAll{constituency.id==buildingInstance.constituency.id}
        def units=Unit.findAll{electoralarea.id==buildingInstance.electoralarea.id}
        def streets=Street.findAll{metro.id==usermetro.id}
        def communities=Community.findAll{metro.id==usermetro.id}
        def assessmenttypes=Lookup.findAll{type.typeDesc=="Assessment Type"}
        def premisetypes=Lookup.findAll{type.typeDesc=="Premise Type"}
        def propstatus=Lookup.findAll{type.typeDesc=="Status"}
        def modeoffinance=Lookup.findAll{type.typeDesc=="Mode of Finance"}
		if(flash.building){
			buildingInstance=flash.buildingInstance
		}
		[menus:menus,submenus:submenus,home:home,notifications:notifications,tasks:tasks,loginuser:loginuser,types:types,categories:categories, contacts:contacts, submetros:submetros, constituencies:constituencies,
        electoralareas:electoralareas,units:units,streets:streets,communities:communities, assessmenttypes:assessmenttypes,premisetypes:premisetypes,propstatus:propstatus,modeoffinance:modeoffinance]
    }

    @Transactional
    def update(Building buildingInstance) {
        if (buildingInstance == null) {
            notFound()
            return
        }

        if (buildingInstance.hasErrors()) {
			flash.building=buildingInstance
            redirect( action:'edit')
            return
        }

        buildingInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Building.label', default: 'Building'), buildingInstance.id])
                redirect buildingInstance
            }
            '*'{ respond buildingInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Building buildingInstance) {

        if (buildingInstance == null) {
            notFound()
            return
        }

        buildingInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Building.label', default: 'Building'), buildingInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildingInstance.label', default: 'Building'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
}
