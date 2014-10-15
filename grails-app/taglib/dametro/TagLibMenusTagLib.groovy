package dametro

class TagLibMenusTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
	
	def menus={attrs, body ->
		def status=attrs.status
		def menus=Menu.findAll {subof==0 && menuname!="Home"}
		Menu home=Menu.find {menuname=="Home"}
		def submenus=Menu.findAll {subof!=0}
		out << g.render(template:'/menu/menu', model:[ home:home, menus:menus,submenus:submenus ]);
	}
	
	
}
