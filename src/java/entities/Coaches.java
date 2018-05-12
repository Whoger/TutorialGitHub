/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JOSEP Mª
 */
@Entity
@Table(name = "coaches")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coaches.findAll", query = "SELECT c FROM Coaches c")
    , @NamedQuery(name = "Coaches.findByFullName", query = "SELECT c FROM Coaches c WHERE c.fullName = :fullName")
    , @NamedQuery(name = "Coaches.findByBirthDate", query = "SELECT c FROM Coaches c WHERE c.birthDate = :birthDate")
    , @NamedQuery(name = "Coaches.findByBirthPlace", query = "SELECT c FROM Coaches c WHERE c.birthPlace = :birthPlace")
    , @NamedQuery(name = "Coaches.findByChildFromMuggle", query = "SELECT c FROM Coaches c WHERE c.childFromMuggle = :childFromMuggle")
    , @NamedQuery(name = "Coaches.findByUsername", query = "SELECT c FROM Coaches c WHERE c.username = :username")
    , @NamedQuery(name = "Coaches.findByPassword", query = "SELECT c FROM Coaches c WHERE c.password = :password")})
public class Coaches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fullName")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Size(max = 50)
    @Column(name = "birthPlace")
    private String birthPlace;
    @Column(name = "childFromMuggle")
    private Short childFromMuggle;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "coach")
    private Collection<Teams> teamsCollection;

    public Coaches() {
    }

    public Coaches(String username) {
        this.username = username;
    }

    public Coaches(String username, String fullName, Date birthDate, String password) {
        this.username = username;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Short getChildFromMuggle() {
        return childFromMuggle;
    }

    public void setChildFromMuggle(Short childFromMuggle) {
        this.childFromMuggle = childFromMuggle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Teams> getTeamsCollection() {
        return teamsCollection;
    }

    public void setTeamsCollection(Collection<Teams> teamsCollection) {
        this.teamsCollection = teamsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coaches)) {
            return false;
        }
        Coaches other = (Coaches) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Coaches[ username=" + username + " ]";
    }
    
}
