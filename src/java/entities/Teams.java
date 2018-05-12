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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "teams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teams.findAll", query = "SELECT t FROM Teams t")
    , @NamedQuery(name = "Teams.findByFullName", query = "SELECT t FROM Teams t WHERE t.fullName = :fullName")
    , @NamedQuery(name = "Teams.findByFundingDate", query = "SELECT t FROM Teams t WHERE t.fundingDate = :fundingDate")
    , @NamedQuery(name = "Teams.findByCountry", query = "SELECT t FROM Teams t WHERE t.country = :country")})
public class Teams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fullName")
    private String fullName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fundingDate")
    @Temporal(TemporalType.DATE)
    private Date fundingDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "country")
    private String country;
    @JoinColumn(name = "coach", referencedColumnName = "username")
    @ManyToOne
    private Coaches coach;
    @JoinColumn(name = "school", referencedColumnName = "username")
    @ManyToOne
    private Schools school;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private Collection<Players> playersCollection;
    @OneToMany(mappedBy = "team1")
    private Collection<Matches> matchesCollection;
    @OneToMany(mappedBy = "team2")
    private Collection<Matches> matchesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "winner")
    private Collection<Matches> matchesCollection2;

    public Teams() {
    }

    public Teams(String fullName) {
        this.fullName = fullName;
    }

    public Teams(String fullName, Date fundingDate, String country) {
        this.fullName = fullName;
        this.fundingDate = fundingDate;
        this.country = country;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getFundingDate() {
        return fundingDate;
    }

    public void setFundingDate(Date fundingDate) {
        this.fundingDate = fundingDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Coaches getCoach() {
        return coach;
    }

    public void setCoach(Coaches coach) {
        this.coach = coach;
    }

    public Schools getSchool() {
        return school;
    }

    public void setSchool(Schools school) {
        this.school = school;
    }

    @XmlTransient
    public Collection<Players> getPlayersCollection() {
        return playersCollection;
    }

    public void setPlayersCollection(Collection<Players> playersCollection) {
        this.playersCollection = playersCollection;
    }

    @XmlTransient
    public Collection<Matches> getMatchesCollection() {
        return matchesCollection;
    }

    public void setMatchesCollection(Collection<Matches> matchesCollection) {
        this.matchesCollection = matchesCollection;
    }

    @XmlTransient
    public Collection<Matches> getMatchesCollection1() {
        return matchesCollection1;
    }

    public void setMatchesCollection1(Collection<Matches> matchesCollection1) {
        this.matchesCollection1 = matchesCollection1;
    }

    @XmlTransient
    public Collection<Matches> getMatchesCollection2() {
        return matchesCollection2;
    }

    public void setMatchesCollection2(Collection<Matches> matchesCollection2) {
        this.matchesCollection2 = matchesCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fullName != null ? fullName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teams)) {
            return false;
        }
        Teams other = (Teams) object;
        if ((this.fullName == null && other.fullName != null) || (this.fullName != null && !this.fullName.equals(other.fullName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Teams[ fullName=" + fullName + " ]";
    }
    
}
