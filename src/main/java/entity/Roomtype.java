/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author KAMINI
 */
@Entity
@Table(name = "roomtype")
@NamedQueries({
    @NamedQuery(name = "Roomtype.findAll", query = "SELECT r FROM Roomtype r"),
    @NamedQuery(name = "Roomtype.findByTid", query = "SELECT r FROM Roomtype r WHERE r.tid = :tid"),
    @NamedQuery(name = "Roomtype.findByTname", query = "SELECT r FROM Roomtype r WHERE r.tname = :tname"),
    @NamedQuery(name = "Roomtype.findByCharge", query = "SELECT r FROM Roomtype r WHERE r.charge = :charge"),
    @NamedQuery(name = "Roomtype.findByAroom", query = "SELECT r FROM Roomtype r WHERE r.aroom = :aroom")})
public class Roomtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tid")
    private Integer tid;
    @Basic(optional = false)
    @Column(name = "tname")
    private String tname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "charge")
    private BigDecimal charge;
    @Basic(optional = false)
    @Column(name = "aroom")
    private int aroom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tid")
    @JsonbTransient
    private Collection<HotelRoom> hotelRoomCollection;

    public Roomtype() {
    }

    public Roomtype(Integer tid) {
        this.tid = tid;
    }

    public Roomtype(Integer tid, String tname, BigDecimal charge, int aroom) {
        this.tid = tid;
        this.tname = tname;
        this.charge = charge;
        this.aroom = aroom;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public int getAroom() {
        return aroom;
    }

    public void setAroom(int aroom) {
        this.aroom = aroom;
    }

    public Collection<HotelRoom> getHotelRoomCollection() {
        return hotelRoomCollection;
    }

    public void setHotelRoomCollection(Collection<HotelRoom> hotelRoomCollection) {
        this.hotelRoomCollection = hotelRoomCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roomtype)) {
            return false;
        }
        Roomtype other = (Roomtype) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Roomtype[ tid=" + tid + " ]";
    }
    
}
