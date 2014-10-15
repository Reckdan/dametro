package com.odelia.grails.plugins.flot


class FlotTagLib {

    static namespace = 'flot'
    
    def resources = { attrs ->
        //def flotDir = "${resource(dir: pluginContextPath+'/js/flot', file: '')}"

        def includeJQueryLib = true
        def includeExCanvasLib = true
        if (attrs.includeJQueryLib)
            includeJQueryLib = attrs.includeJQueryLib.toBoolean()
        if (attrs.includeExCanvasLib)
        	  includeExCanvasLib = attrs.includeExCanvasLib.toBoolean()
        if (includeJQueryLib)
            //out << "<script type=\"text/javascript\" src=\"${flotDir}/jquery.min.js\"></script>\n"
			out << g.javascript(plugin: 'flot', src: 'flot/jquery.min.js') << '\n'
        //out << "<script type=\"text/javascript\" src=\"${flotDir}/jquery.flot.min.js\"></script>\n"
		out << g.javascript(plugin: 'flot', src: 'flot/jquery.flot.min.js') << '\n'
        if (includeExCanvasLib)
        	//out << "<!--[if IE]><script type=\"text/javascript\" src=\"${flotDir}/excanvas.min.js\"></script><![endif]-->\n"
			out << '<!--[if IE]>' << g.javascript(plugin: 'flot', src: "flot/excanvas.min.js") << '<![endif]-->\n'
        if (attrs.plugins instanceof ArrayList) {
            attrs.plugins.each { pluginName ->              
                //out << "<script type=\"text/javascript\" src=\"${flotDir}/jquery.flot.${pluginName}.js\"></script>\n"
				out << g.javascript(plugin: 'flot', src: "flot/jquery.flot.${pluginName}.js") << '\n'
            }
        }
    }

    def plot = { attrs ->
        if (!attrs.id) {
            throwTagError("Tag flot is missing required attribute [id]")
        }
        if (!attrs.data) {
            throwTagError("Tag flot is missing required attribute [data]")
        }
        def id = attrs.remove('id')
        def style = attrs.remove('style')
        def data = attrs.remove('data')
        def options = attrs.remove('options')

        if (style)
            out << "<div id='${id}' style='${style}'></div>"
        else
            out << "<div id='${id}'></div>"
        out << "<script type='text/javascript'>"
        out << 'jQuery(function () {'
        out << 'jQuery.plot(jQuery("#'+ id +'"),' + data
        if (options) out << ", $options"
        out << ");"
        out << '});'
        out << "</script>"
    }

}
