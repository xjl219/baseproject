package com.xujl.base.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Permission {
		@Id
		@GeneratedValue
	    private Integer permission_id;
	    private String pname;
	    private String permissioncode;
	    private String permission_uri;
	    @ManyToMany(cascade={CascadeType.REFRESH},fetch=FetchType.EAGER)
		@JoinTable(name = "permission_role",
				joinColumns = { @JoinColumn(name = "permission_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "roleId") }) 
	    private Set<Role> roles ;
           
		public Permission() {
			super();
		}

		public Permission(Integer id, String pname, String permissioncode, String permission_uri, Set<Role> roles) {
			super();
			this.permission_id = id;
			this.pname = pname;
			this.permissioncode = permissioncode;
			this.permission_uri = permission_uri;
			this.roles = roles;
		}


		public String getPname() {
			return pname;
		}

		public void setPname(String pname) {
			this.pname = pname;
		}

		public String getPermissioncode() {
			return permissioncode;
		}

		public void setPermissioncode(String permissioncode) {
			this.permissioncode = permissioncode;
		}

		public String getPermission_uri() {
			return permission_uri;
		}

		public void setPermission_uri(String permission_uri) {
			this.permission_uri = permission_uri;
		}

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}

		@Override
		public String toString() {
			return "Permission [id=" + permission_id + ", pname=" + pname + ", permissioncode=" + permissioncode
					+ ", permission_uri=" + permission_uri + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((permission_id == null) ? 0 : permission_id.hashCode());
			result = prime * result + ((permission_uri == null) ? 0 : permission_uri.hashCode());
			result = prime * result + ((permissioncode == null) ? 0 : permissioncode.hashCode());
			result = prime * result + ((pname == null) ? 0 : pname.hashCode());
			//result = prime * result + ((roles == null) ? 0 : roles.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Permission other = (Permission) obj;
			if (permission_id == null) {
				if (other.permission_id != null)
					return false;
			} else if (!permission_id.equals(other.permission_id))
				return false;
			if (permission_uri == null) {
				if (other.permission_uri != null)
					return false;
			} else if (!permission_uri.equals(other.permission_uri))
				return false;
			if (permissioncode == null) {
				if (other.permissioncode != null)
					return false;
			} else if (!permissioncode.equals(other.permissioncode))
				return false;
			if (pname == null) {
				if (other.pname != null)
					return false;
			} else if (!pname.equals(other.pname))
				return false;
			if (roles == null) {
				if (other.roles != null)
					return false;
			} else if (!roles.equals(other.roles))
				return false;
			return true;
		}
	    
}
