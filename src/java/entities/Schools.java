/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JOSEP Mª
 */
@Entity
@Table(name = "schools")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schools.findAll", query = "SELECT s FROM Schools s")
    , @NamedQuery(name = "Schools.findByFullName", query = "SELECT s FROM Schools s WHERE s.fullName = :fullName")
    , @NamedQuery(name = "Schools.findByCountry", query = "SELECT s FROM Schools s WHERE s.country = :country")
    , @NamedQuery(name = "Schools.findByUsername", query = "SELECT s FROM Schools s WHERE s.username = :username")
    , @NamedQuery(name = "Schools.findByPassword", query = "SELECT s FROM Schools s WHERE s.password = :password")})
public class Schools implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fullName")
    private String fullName;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
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
    @OneToMany(mappedBy = "school")
    private Collection<Teams> teamsCollection;
    @OneToMany(mappedBy = "place")
    private Collection<Matches> matchesCollection;

    public Schools() {
    }

    public Schools(String username) {
        this.username = username;
    }

    public Schools(String username, String fullName, String password) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @XmlTransient
    public Collection<Matches> getMatchesCollection() {
        return matchesCollection;
    }

    public void setMatchesCollection(Collection<Matches> matchesCollection) {
        this.matchesCollection = matchesCollection;
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
        if (!(object instanceof Schools)) {
            return false;
        }
        Schools other = (Schools) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Schools[ username=" + username + " ]";
    }
    
}
