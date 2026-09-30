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
import java.util.Collection;

/**
 *
 * @author KAMINI
 */
@Entity
@Table(name = "hotelmaster")
@NamedQueries({
    @NamedQuery(name = "Hotelmaster.findAll", query = "SELECT h FROM Hotelmaster h"),
    @NamedQuery(name = "Hotelmaster.findById", query = "SELECT h FROM Hotelmaster h WHERE h.id = :id"),
    @NamedQuery(name = "Hotelmaster.findByHname", query = "SELECT h FROM Hotelmaster h WHERE h.hname = :hname"),
    @NamedQuery(name = "Hotelmaster.findByHtype", query = "SELECT h FROM Hotelmaster h WHERE h.htype = :htype"),
    @NamedQuery(name = "Hotelmaster.findByAddr", query = "SELECT h FROM Hotelmaster h WHERE h.addr = :addr"),
    @NamedQuery(name = "Hotelmaster.findByCity", query = "SELECT h FROM Hotelmaster h WHERE h.city = :city"),
    @NamedQuery(name = "Hotelmaster.findByTroom", query = "SELECT h FROM Hotelmaster h WHERE h.troom = :troom"),
    @NamedQuery(name = "Hotelmaster.findByCon", query = "SELECT h FROM Hotelmaster h WHERE h.con = :con")})
public class Hotelmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "hname")
    private String hname;
    @Basic(optional = false)
    @Column(name = "htype")
    private String htype;
    @Basic(optional = false)
    @Column(name = "addr")
    private String addr;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "troom")
    private int troom;
    @Basic(optional = false)
    @Column(name = "con")
    private String con;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    @JsonbTransient
    private Collection<HotelRoom> hotelRoomCollection;

    public Hotelmaster() {
    }

    public Hotelmaster(Integer id) {
        this.id = id;
    }

    public Hotelmaster(Integer id, String hname, String htype, String addr, String city, int troom, String con) {
        this.id = id;
        this.hname = hname;
        this.htype = htype;
        this.addr = addr;
        this.city = city;
        this.troom = troom;
        this.con = con;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHtype() {
        return htype;
    }

    public void setHtype(String htype) {
        this.htype = htype;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTroom() {
        return troom;
    }

    public void setTroom(int troom) {
        this.troom = troom;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotelmaster)) {
            return false;
        }
        Hotelmaster other = (Hotelmaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hotelmaster[ id=" + id + " ]";
    }
    
}
