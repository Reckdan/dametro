package dametro

import org.apache.commons.lang.builder.HashCodeBuilder

class MuserRole implements Serializable {

	private static final long serialVersionUID = 1

	Muser muser
	Role role

	boolean equals(other) {
		if (!(other instanceof MuserRole)) {
			return false
		}

		other.muser?.id == muser?.id &&
		other.role?.id == role?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (muser) builder.append(muser.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static MuserRole get(long muserId, long roleId) {
		MuserRole.where {
			muser == Muser.load(muserId) &&
			role == Role.load(roleId)
		}.get()
	}

	static boolean exists(long muserId, long roleId) {
		MuserRole.where {
			muser == Muser.load(muserId) &&
			role == Role.load(roleId)
		}.count() > 0
	}

	static MuserRole create(Muser muser, Role role, boolean flush = false) {
		def instance = new MuserRole(muser: muser, role: role)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(Muser u, Role r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = MuserRole.where {
			muser == Muser.load(u.id) &&
			role == Role.load(r.id)
		}.deleteAll()

		if (flush) { MuserRole.withSession { it.flush() } }

		rowCount > 0
	}

	static void removeAll(Muser u, boolean flush = false) {
		if (u == null) return

		MuserRole.where {
			muser == Muser.load(u.id)
		}.deleteAll()

		if (flush) { MuserRole.withSession { it.flush() } }
	}

	static void removeAll(Role r, boolean flush = false) {
		if (r == null) return

		MuserRole.where {
			role == Role.load(r.id)
		}.deleteAll()

		if (flush) { MuserRole.withSession { it.flush() } }
	}

	static constraints = {
		role validator: { Role r, MuserRole ur ->
			if (ur.muser == null) return
			boolean existing = false
			MuserRole.withNewSession {
				existing = MuserRole.exists(ur.muser.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['role', 'muser']
		version false
	}
}
