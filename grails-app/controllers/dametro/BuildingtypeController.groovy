package dametro
import org.springframework.dao.DataIntegrityViolationException
import org.grails.plugin.easygrid.Easygrid
import org.grails.plugin.easygrid.Filter

@Easygrid
class BuildingtypeController {

    def index() {
		Menu home=Menu.find {menuname=="Home"}
		def menus=Menu.findAll {subof==0 && menuname!='Home'}
		def submenus=Menu.findAll {subof!=0}
	//	def eventtypes=Eventtype.findAll ()
		
//		[eventtypes:eventtypes]
		[menus:menus,submenus:submenus,home:home]
	}
	
	def eventtypesGrid={
		
		
		domainClass Eventtype
		gridImpl 'dataTables'
		inlineEdit false
		
		columns {
			id {
				type 'id'
				enableFilter false
			}
			budgetCode
			dateCreated
			dateUpdated
			code
//			nrCats {
//				enableFilter false
//				value {Eventtype eventtype -> eventtype.categories.size()}
//				jqgrid {
//					sortable false
//				}
//			}
		}
	}
}
