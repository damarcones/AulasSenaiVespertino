package escola.secretaria.Model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Resultados")
public class Resultados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRES")
    private long idRes;

    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "matricula")
    private Aluno matricula;

    
    @OneToOne
    @JoinColumn(name = "idDis")
    private DisciplinasModel idDis;

    @Column(name  = "PriNota")
    private double priNota;

    @Column(name  = "SegNota")
    private double segNota;

    public double getPriNota() {
        return priNota;
    }

    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriNota(double priNota) {
        this.priNota = priNota;
    }

    public double getSegNota() {
        return segNota;
    }

    public void setSegNota(double segNota) {
        this.segNota = segNota;
    }

    public double getTerNota() {
        return terNota;
    }

    public void setTerNota(double terNota) {
        this.terNota = terNota;
    }

    public double getQuaNota() {
        return quaNota;
    }

    public void setQuaNota(double quaNota) {
        this.quaNota = quaNota;
    }

    public double getMedia() {
        return media;
    }
    public void resultado(double pri, double seg, double ter, double qua){
        double media = 0.0;
        media = (pri + seg + ter + qua)/4;
        setMedia(media);
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Column(name  = "TerNota")
    private double terNota;

    @Column(name  = "QuaNota")
    private double quaNota;

    @Column(name  = "Media")
    private double media;


    public long getIdRes() {
        return idRes;
    }

    public void setIdRes(long idRes) {
        this.idRes = idRes;
    }

    public Aluno getMatricula() {
        return matricula;
    }

    public void setMatricula(Aluno matricula) {
        this.matricula = matricula;
    }

    public DisciplinasModel getIdDis() {
        return idDis;
    }

    public void setIdDis(DisciplinasModel idDis) {
        this.idDis = idDis;
    }

    public void statusNota(){
        double media = getMedia();
        
        if(media>=6)
            setStatus("Aprovado");
        else if(media>= 5 && media<=5.9)
            setStatus("Recuperação");
        else
            setStatus("Repovrado");

    }

}
