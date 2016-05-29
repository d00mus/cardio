/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mdl;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author d00mus
 */
@Entity
@Table(name = "PSG_RESULT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsgResult.findAll", query = "SELECT p FROM PsgResult p"),
    @NamedQuery(name = "PsgResult.findById", query = "SELECT p FROM PsgResult p WHERE p.id = :id"),
    @NamedQuery(name = "PsgResult.findByDgIag", query = "SELECT p FROM PsgResult p WHERE p.dgIag = :dgIag"),
    @NamedQuery(name = "PsgResult.findByDgOaEpis", query = "SELECT p FROM PsgResult p WHERE p.dgOaEpis = :dgOaEpis"),
    @NamedQuery(name = "PsgResult.findByDgGipoEpis", query = "SELECT p FROM PsgResult p WHERE p.dgGipoEpis = :dgGipoEpis"),
    @NamedQuery(name = "PsgResult.findByDgCaEpis", query = "SELECT p FROM PsgResult p WHERE p.dgCaEpis = :dgCaEpis"),
    @NamedQuery(name = "PsgResult.findByDgAvgSpo2", query = "SELECT p FROM PsgResult p WHERE p.dgAvgSpo2 = :dgAvgSpo2"),
    @NamedQuery(name = "PsgResult.findByDgMinSpo2", query = "SELECT p FROM PsgResult p WHERE p.dgMinSpo2 = :dgMinSpo2"),
    @NamedQuery(name = "PsgResult.findByDgDesaturIdx", query = "SELECT p FROM PsgResult p WHERE p.dgDesaturIdx = :dgDesaturIdx"),
    @NamedQuery(name = "PsgResult.findByNeckSize", query = "SELECT p FROM PsgResult p WHERE p.neckSize = :neckSize"),
    @NamedQuery(name = "PsgResult.findByHeight", query = "SELECT p FROM PsgResult p WHERE p.height = :height"),
    @NamedQuery(name = "PsgResult.findByWeigth", query = "SELECT p FROM PsgResult p WHERE p.weigth = :weigth"),
    @NamedQuery(name = "PsgResult.findByWgIdx", query = "SELECT p FROM PsgResult p WHERE p.wgIdx = :wgIdx"),
    @NamedQuery(name = "PsgResult.findByWaist", query = "SELECT p FROM PsgResult p WHERE p.waist = :waist"),
    @NamedQuery(name = "PsgResult.findByStegna", query = "SELECT p FROM PsgResult p WHERE p.stegna = :stegna"),
    @NamedQuery(name = "PsgResult.findByChest", query = "SELECT p FROM PsgResult p WHERE p.chest = :chest"),
    @NamedQuery(name = "PsgResult.findByTrIag", query = "SELECT p FROM PsgResult p WHERE p.trIag = :trIag"),
    @NamedQuery(name = "PsgResult.findByTrOaEpis", query = "SELECT p FROM PsgResult p WHERE p.trOaEpis = :trOaEpis"),
    @NamedQuery(name = "PsgResult.findByTrGipoEpis", query = "SELECT p FROM PsgResult p WHERE p.trGipoEpis = :trGipoEpis"),
    @NamedQuery(name = "PsgResult.findByTrCaEpis", query = "SELECT p FROM PsgResult p WHERE p.trCaEpis = :trCaEpis"),
    @NamedQuery(name = "PsgResult.findByTrAvgSpo2", query = "SELECT p FROM PsgResult p WHERE p.trAvgSpo2 = :trAvgSpo2"),
    @NamedQuery(name = "PsgResult.findByTrMinSpo2", query = "SELECT p FROM PsgResult p WHERE p.trMinSpo2 = :trMinSpo2"),
    @NamedQuery(name = "PsgResult.findByTrDesaturIdx", query = "SELECT p FROM PsgResult p WHERE p.trDesaturIdx = :trDesaturIdx")})
public class PsgResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name="PSG_RESULT_ID_GENERATOR", sequenceName="PSG_RESULT_SEQ",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PSG_RESULT_ID_GENERATOR")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "DG_IAG")
    private BigDecimal dgIag;
    
    @Column(name = "DG_OA_EPIS")
    private Integer dgOaEpis;
    
    @Column(name = "DG_GIPO_EPIS")
    private Integer dgGipoEpis;
    
    @Column(name = "DG_CA_EPIS")
    private Integer dgCaEpis;
    
    @Column(name = "DG_AVG_SPO2")
    private BigDecimal dgAvgSpo2;
    
    @Column(name = "DG_MIN_SPO2")
    private BigDecimal dgMinSpo2;
    
    @Column(name = "DG_DESATUR_IDX")
    private BigDecimal dgDesaturIdx;
    
    @Column(name = "NECK_SIZE")
    private BigDecimal neckSize;
    
    @Column(name = "HEIGHT")
    private BigDecimal height;
    
    @Column(name = "WEIGTH")
    private BigDecimal weigth;
    
    @Column(name = "WG_IDX")
    private BigDecimal wgIdx;
    
    @Column(name = "WAIST")
    private BigDecimal waist;
    
    @Column(name = "STEGNA")
    private BigDecimal stegna;
    
    @Column(name = "CHEST")
    private BigDecimal chest;
    
    @Column(name = "TR_IAG")
    private BigDecimal trIag;
    
    @Column(name = "TR_OA_EPIS")
    private Integer trOaEpis;
    
    @Column(name = "TR_GIPO_EPIS")
    private Integer trGipoEpis;
    
    @Column(name = "TR_CA_EPIS")
    private Integer trCaEpis;
    
    @Column(name = "TR_AVG_SPO2")
    private BigDecimal trAvgSpo2;
    
    @Column(name = "TR_MIN_SPO2")
    private BigDecimal trMinSpo2;
    
    @Column(name = "TR_DESATUR_IDX")
    private BigDecimal trDesaturIdx;
    
    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PsgResultAuthor author;

    @JoinColumn(name = "PSG_ID", referencedColumnName = "ID")
    @OneToOne(optional = false, fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Psg psg;

    public PsgResult() {
    }

    public PsgResult(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDgIag() {
        return dgIag;
    }

    public void setDgIag(BigDecimal dgIag) {
        this.dgIag = dgIag;
    }

    public Integer getDgOaEpis() {
        return dgOaEpis;
    }

    public void setDgOaEpis(Integer dgOaEpis) {
        this.dgOaEpis = dgOaEpis;
    }

    public Integer getDgGipoEpis() {
        return dgGipoEpis;
    }

    public void setDgGipoEpis(Integer dgGipoEpis) {
        this.dgGipoEpis = dgGipoEpis;
    }

    public Integer getDgCaEpis() {
        return dgCaEpis;
    }

    public void setDgCaEpis(Integer dgCaEpis) {
        this.dgCaEpis = dgCaEpis;
    }

    public BigDecimal getDgAvgSpo2() {
        return dgAvgSpo2;
    }

    public void setDgAvgSpo2(BigDecimal dgAvgSpo2) {
        this.dgAvgSpo2 = dgAvgSpo2;
    }

    public BigDecimal getDgMinSpo2() {
        return dgMinSpo2;
    }

    public void setDgMinSpo2(BigDecimal dgMinSpo2) {
        this.dgMinSpo2 = dgMinSpo2;
    }

    public BigDecimal getDgDesaturIdx() {
        return dgDesaturIdx;
    }

    public void setDgDesaturIdx(BigDecimal dgDesaturIdx) {
        this.dgDesaturIdx = dgDesaturIdx;
    }

    public BigDecimal getNeckSize() {
        return neckSize;
    }

    public void setNeckSize(BigDecimal neckSize) {
        this.neckSize = neckSize;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeigth() {
        return weigth;
    }

    public void setWeigth(BigDecimal weigth) {
        this.weigth = weigth;
    }

    public BigDecimal getWgIdx() {
        return wgIdx;
    }

    public void setWgIdx(BigDecimal wgIdx) {
        this.wgIdx = wgIdx;
    }

    public BigDecimal getWaist() {
        return waist;
    }

    public void setWaist(BigDecimal waist) {
        this.waist = waist;
    }

    public BigDecimal getStegna() {
        return stegna;
    }

    public void setStegna(BigDecimal stegna) {
        this.stegna = stegna;
    }

    public BigDecimal getChest() {
        return chest;
    }

    public void setChest(BigDecimal chest) {
        this.chest = chest;
    }

    public BigDecimal getTrIag() {
        return trIag;
    }

    public void setTrIag(BigDecimal trIag) {
        this.trIag = trIag;
    }

    public Integer getTrOaEpis() {
        return trOaEpis;
    }

    public void setTrOaEpis(Integer trOaEpis) {
        this.trOaEpis = trOaEpis;
    }

    public Integer getTrGipoEpis() {
        return trGipoEpis;
    }

    public void setTrGipoEpis(Integer trGipoEpis) {
        this.trGipoEpis = trGipoEpis;
    }

    public Integer getTrCaEpis() {
        return trCaEpis;
    }

    public void setTrCaEpis(Integer trCaEpis) {
        this.trCaEpis = trCaEpis;
    }

    public BigDecimal getTrAvgSpo2() {
        return trAvgSpo2;
    }

    public void setTrAvgSpo2(BigDecimal trAvgSpo2) {
        this.trAvgSpo2 = trAvgSpo2;
    }

    public BigDecimal getTrMinSpo2() {
        return trMinSpo2;
    }

    public void setTrMinSpo2(BigDecimal trMinSpo2) {
        this.trMinSpo2 = trMinSpo2;
    }

    public BigDecimal getTrDesaturIdx() {
        return trDesaturIdx;
    }

    public void setTrDesaturIdx(BigDecimal trDesaturIdx) {
        this.trDesaturIdx = trDesaturIdx;
    }

    public PsgResultAuthor getAuthor() {
        return author;
    }

    public void setAuthor(PsgResultAuthor author) {
        this.author = author;
    }

    public Psg getPsg() {
        return psg;
    }

    public void setPsg(Psg psg) {
        this.psg = psg;
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
        if (!(object instanceof PsgResult)) {
            return false;
        }
        PsgResult other = (PsgResult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mdl.PsgResult[ id=" + id + " ]";
    }
    
}
