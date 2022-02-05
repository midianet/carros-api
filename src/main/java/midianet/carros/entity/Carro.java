package midianet.carros.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Random;

@Data
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long codigo;

    //@NotBlank
    @Column(length = 40)
    private String nome;

    @Column(length = 5000)
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

    @Column(length = 1)
    private Tipo tipo;

    private Integer velocidade;

    private Integer potencia;

    @Transient
    private Integer ranking = new Random().nextInt((10 - 1) + 1) + 1;

    @AllArgsConstructor
    public enum Tipo {
        ESPORTIVO("E"), LUXO("L"), CLASSICO("C");

        @Getter
        private String sigla;
       
        public static Tipo byName(@NonNull final String name){
           return Tipo.valueOf(name);
        }

        public static Tipo byDescricao(@NonNull final String sigla){
            return Arrays.asList(Tipo.values()).stream()
                .filter(tipo -> tipo.sigla.equals(sigla))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Sigla de Tipo inválida"));
       }
        
    }

}
