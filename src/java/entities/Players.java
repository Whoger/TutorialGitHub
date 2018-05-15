/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JOSEP Mª
 */
@Entity
@Table(name = "players")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Players.findAll", query = "SELECT p FROM Players p")
    , @NamedQuery(name = "Players.findByFullName", query = "SELECT p FROM Players p WHERE p.fullName = :fullName")
    , @NamedQuery(name = "Players.findByPosition", query = "SELECT p FROM Players p WHERE p.position = :position")
    , @NamedQuery(name = "Players.findByBirthDate", query = "SELECT p FROM Players p WHERE p.birthDate = :birthDate")
    , @NamedQuery(name = "Players.findByBirthPlace", query = "SELECT p FROM Players p WHERE p.birthPlace = :birthPlace")
    , @NamedQuery(name = "Players.findByChildFromMuggle", query = "SELECT p FROM Players p WHERE p.childFromMuggle = :childFromMuggle")
    , @NamedQuery(name = "Players.findByBroomStick", query = "SELECT p FROM Players p WHERE p.broomStick = :broomStick")
    , @NamedQuery(name = "Players.findByUsername", query = "SELECT p FROM Players p WHERE p.username = :username")
    , @NamedQuery(name = "Players.findByPassword", query = "SELECT p FROM Players p WHERE p.password = :password")})
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fullName")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "position")
    private String position;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Size(max = 45)
    @Column(name = "birthPlace")
    private String birthPlace;
    @Column(name = "childFromMuggle")
    private Short childFromMuggle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "broomStick")
    private String broomStick;
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
    @JoinColumn(name = "team", referencedColumnName = "fullName")
    @ManyToOne(optional = false)
    private Teams team;

    public Players() {
    }

    public Players(String username) {
        this.username = username;
    }

    public Players(String fullName, String position, Date birthDate, String birthPlace, Short childFromMuggle, String broomStick, String username, String password) {
        this.fullName = fullName;
        this.position = position;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.childFromMuggle = childFromMuggle;
        this.broomStick = broomStick;
        this.username = username;
        this.password = password;
    }

    public Players(String username, String fullName, String position, Date birthDate, String broomStick, String password) {
        this.username = username;
        this.fullName = fullName;
        this.position = position;
        this.birthDate = birthDate;
        this.broomStick = broomStick;
        this.password = password;
    }

    public Players(String fullName, String position, Date birthDate, String birthPlace, Short childFromMuggle, String broomStick, String username, String password, Teams team) {
        this.fullName = fullName;
        this.position = position;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.childFromMuggle = childFromMuggle;
        this.broomStick = broomStick;
        this.username = username;
        this.password = password;
        this.team = team;
    }

    public Players(String fullName, String username, String password, Teams team) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.team = team;
    }

    
    
    
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getBroomStick() {
        return broomStick;
    }

    public void setBroomStick(String broomStick) {
        this.broomStick = broomStick;
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

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        this.team = team;
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
        if (!(object instanceof Players)) {
            return false;
        }
        Players other = (Players) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Players[ username=" + username + " ]";
    }
    
}
