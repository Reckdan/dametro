package dametro

class UsermainController {

    def index() {
		Menu home=Menu.find {menuname=="Home"}
		def menus=Menu.findAll {subof==0 && menuname!='Home'}
		def submenus=Menu.findAll {subof!=0}
		[menus:menus,submenus:submenus,home:home]
		
	}
}
