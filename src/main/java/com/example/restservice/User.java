package com.example.restservice;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class User {

    public @Id @GeneratedValue Integer id;

    public @NotEmpty String firstname;
    public String lastname;
    public String email;
    public @NotEmpty Date birthday;
    public String country = "";
    public String town;
    public String code_postal;
    public int nombre_achat;
    public  Boolean subscriber=false;
    public Boolean isValid =false;
    public String description;


    User(){}

    
    public User(Integer id, String firstname, String lastname, String email, Date birthday, String country, String town,
			String code_postal, int nombre_achat, boolean subscriber, boolean isValid, String description) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.birthday = birthday;
		this.country = country;
		this.town = town;
		this.code_postal = code_postal;
		this.nombre_achat = nombre_achat;
		this.subscriber = subscriber;
		this.isValid = isValid;
		this.description = description;
	}


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public boolean isSubscriber() {
        return subscriber;
    }

    public void setSubscriber(boolean subscriber) {
        this.subscriber = subscriber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthdate) {
        this.birthday = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    

    public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public int getNombre_achat() {
		return nombre_achat;
	}

	public void setNombre_achat(int nombre_achat) {
		this.nombre_achat = nombre_achat;
	}
	

	public Boolean isValid() {
		return isValid;
	}

	public void setValid(Boolean isValid) {
		this.isValid = isValid;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((code_postal == null) ? 0 : code_postal.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isValid == null) ? 0 : isValid.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + nombre_achat;
		result = prime * result + ((subscriber == null) ? 0 : subscriber.hashCode());
		result = prime * result + ((town == null) ? 0 : town.hashCode());
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
		User other = (User) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (code_postal == null) {
			if (other.code_postal != null)
				return false;
		} else if (!code_postal.equals(other.code_postal))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isValid == null) {
			if (other.isValid != null)
				return false;
		} else if (!isValid.equals(other.isValid))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (nombre_achat != other.nombre_achat)
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.equals(other.subscriber))
			return false;
		if (town == null) {
			if (other.town != null)
				return false;
		} else if (!town.equals(other.town))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", birthday=" + birthday + ", country=" + country + ", town=" + town + ", code_postal=" + code_postal
				+ ", nombre_achat=" + nombre_achat + ", subscriber=" + subscriber + ", isValid=" + isValid
				+ ", description=" + description + "]";
	}

	
   
}