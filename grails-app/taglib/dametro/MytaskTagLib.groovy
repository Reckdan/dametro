package dametro

import groovy.time.*
import groovy.xml.MarkupBuilder
import java.text.*
class MytaskTagLib {
    //static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
	//static returnObjectForTags = ['tag']
	
		def danger = { attrs, body ->
			//returns an object (can be boolean)
			DateFormat df = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss")
			def strDate = df.parse(attrs.duedate.toString())
			TimeDuration td=TimeCategory.minus(strDate, new Date())
			Integer days=td.getDays()
			//def html = new MarkupBuilder(new StringWriter())
			if(days<1)
				out << body()
			
		}
		
		def warning = { attrs, body ->
			//returns an object (can be boolean)
			DateFormat df = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss")
			def strDate = df.parse(attrs.duedate.toString())
			TimeDuration td=TimeCategory.minus(strDate, new Date())
			Integer days=td.getDays()
			//def html = new MarkupBuilder(new StringWriter())
			if(days>=1 && days<5)
				out << body()
			
		}
		
		def info = { attrs, body ->
			//returns an object (can be boolean)
			DateFormat df = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss")
			def strDate = df.parse(attrs.duedate.toString())
			TimeDuration td=TimeCategory.minus(strDate, new Date())
			Integer days=td.getDays()
			//def html = new MarkupBuilder(new StringWriter())
			if(days>=5)
				out << body()
			
		}
		
		def timediff = { attrs, body ->
			//returns an object (can be boolean)
			DateFormat df = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss")
			def strDate = df.parse(attrs.duedate.toString())
			TimeDuration td=TimeCategory.minus(new Date(),strDate)
			Integer days=td.getDays()
			Integer hours=td.getHours()
			Integer minutes=td.getMinutes()
			//def html = new MarkupBuilder(new StringWriter())
			//out << day
			if(days>1)
				out << days.toString()+' days'
			else if (hours>1)
				out << hours.toString()+' hours'
			else if(minutes>1)
				out << minutes.toString()+' minutes'
		}
		
		
		
}
