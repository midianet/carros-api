package midianet.carros.entity.converter;

import midianet.carros.entity.Carro;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CarroTipoConverter  implements AttributeConverter<Carro.Tipo,String> {
    @Override
    public String convertToDatabaseColumn(Carro.Tipo tipo) {
        return tipo.getSigla();
    }

    @Override
    public Carro.Tipo convertToEntityAttribute(String sigla) {
        return Carro.Tipo.toEnum(sigla);
    }

}