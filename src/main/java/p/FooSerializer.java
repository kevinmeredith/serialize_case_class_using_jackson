package p;

import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

public class FooSerializer extends JsonSerializer<Foo.Person> {
    @Override
    public void serialize(Foo.Person value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeStringField("name", value.name());
        jgen.writeNumberField("age", value.age());
        if(value.hobbies().isDefined()) { // hobbies :: Option[String]
            jgen.writeStringField("hobbies", value.hobbies().get());
        }
        jgen.writeEndObject();
    }
}
