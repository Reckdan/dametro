package dametro

class Muser {

	transient springSecurityService

	String username
	String password
	String metro
	String email
	String firstname
	String lastname
	String fullName
	String datecreated
	String telephone
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static transients = ['springSecurityService']
	static constraints = {
		username blank: false, unique: true
		password blank: false
		email email:true
	}

	static mapping = {
		password column: '`password`'
		fullName formula:"CONCAT(firstname, ' ',lastname)"
	}

	Set<Role> getAuthorities() {
		MuserRole.findAllByMuser(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
