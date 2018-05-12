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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "matches")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matches.findAll", query = "SELECT m FROM Matches m")
    , @NamedQuery(name = "Matches.findByMatchDate", query = "SELECT m FROM Matches m WHERE m.matchDate = :matchDate")
    , @NamedQuery(name = "Matches.findByMatchTime", query = "SELECT m FROM Matches m WHERE m.matchTime = :matchTime")
    , @NamedQuery(name = "Matches.findByIdMatches", query = "SELECT m FROM Matches m WHERE m.idMatches = :idMatches")})
public class Matches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "matchDate")
    @Temporal(TemporalType.DATE)
    private Date matchDate;
    @Size(max = 45)
    @Column(name = "matchTime")
    private String matchTime;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_matches")
    private Integer idMatches;
    @JoinColumn(name = "place", referencedColumnName = "username")
    @ManyToOne
    private Schools place;
    @JoinColumn(name = "team1", referencedColumnName = "fullName")
    @ManyToOne
    private Teams team1;
    @JoinColumn(name = "team2", referencedColumnName = "fullName")
    @ManyToOne
    private Teams team2;
    @JoinColumn(name = "winner", referencedColumnName = "fullName")
    @ManyToOne(optional = false)
    private Teams winner;

    public Matches() {
    }

    public Matches(Integer idMatches) {
        this.idMatches = idMatches;
    }

    public Matches(Integer idMatches, Date matchDate) {
        this.idMatches = idMatches;
        this.matchDate = matchDate;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public Integer getIdMatches() {
        return idMatches;
    }

    public void setIdMatches(Integer idMatches) {
        this.idMatches = idMatches;
    }

    public Schools getPlace() {
        return place;
    }

    public void setPlace(Schools place) {
        this.place = place;
    }

    public Teams getTeam1() {
        return team1;
    }

    public void setTeam1(Teams team1) {
        this.team1 = team1;
    }

    public Teams getTeam2() {
        return team2;
    }

    public void setTeam2(Teams team2) {
        this.team2 = team2;
    }

    public Teams getWinner() {
        return winner;
    }

    public void setWinner(Teams winner) {
        this.winner = winner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatches != null ? idMatches.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matches)) {
            return false;
        }
        Matches other = (Matches) object;
        if ((this.idMatches == null && other.idMatches != null) || (this.idMatches != null && !this.idMatches.equals(other.idMatches))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Matches[ idMatches=" + idMatches + " ]";
    }
    
}
