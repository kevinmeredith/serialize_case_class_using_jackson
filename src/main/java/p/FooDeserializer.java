package p;

import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.node.IntNode;

import java.io.IOException;

public class FooDeserializer extends JsonDeserializer<p.Foo.Person> {

    @Override
    public p.Foo.Person deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        final p.Foo.Person person;
        JsonNode node = jp.getCodec().readTree(jp);
        String name   = node.get("name").asText();
        int age       = (Integer) ((IntNode) node.get("age")).asInt();
        if (node.has("hobbies")) {
            String hobbies = node.get("hobbies").asText();
            person = p.Foo.buildPersonWithHobbies(name, age, hobbies);
        }
        else {
            person = p.Foo.buildPersonWithoutHobbies(name ,age);
        }
        return person;
    }
}