package midianet.carros.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long codigo;

    //@NotBlank
    @Column(length = 40)
    private String nome;

    @Column(length = 2000)
    private String descricao;

    @Column(length = 200)
    private String urlFoto;

    @Column(length = 200)
    private String urlVideo;

    @Column(length = 10)
    private String latitude;

    @Column(length = 10)
    private String longitude;

    private Integer peso;

    @Column(length = 10)
    private String tipo;
   // private Tipo tipo;

    private Integer velocidade;

    private Integer potencia;

    @Transient
    private Integer ranking;

    @AllArgsConstructor
    public enum Tipo {
        ESPORTIVO("E"), LUXO("L"), CLASSICO("C");

        @Getter
        private String sigla;

        public static Tipo toEnum(String sigla){
            for(var tipo : Tipo.values()){
                if(tipo.sigla.equals(sigla)) return tipo;
            }
            throw new IllegalArgumentException("Valor da sigla de Enumerador Sexo inválido");
        }

    }

}