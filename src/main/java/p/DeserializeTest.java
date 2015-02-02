package p;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

public class DeserializeTest {

    public static void main(String[] args) throws Exception { // TODO: catch IOException and JSONMappingException

	    final ObjectMapper mapper = new ObjectMapper();

        // register custom (de)serializer's
        SimpleModule simpleModule = new SimpleModule("something", new Version(0, 0, 0, "garbage value"));
        simpleModule.addSerializer(p.Foo.Person.class, new FooSerializer());
        simpleModule.addDeserializer(p.Foo.Person.class, new FooDeserializer());
        mapper.registerModule(simpleModule);
        
        String pWithHobbies = mapper.writeValueAsString(p.Foo.personInstance());
        System.out.println("pWithHobbies: " + pWithHobbies);

        String pWithoutHobbies = mapper.writeValueAsString(p.Foo.personNoHobbies());
        System.out.println("pWithoutHobbies: " + pWithoutHobbies);
        
        p.Foo.Person p =  mapper.readValue(pWithHobbies, p.Foo.Person.class);
        System.out.println("de-serialized person: " + p);

        p.Foo.Person pNoHobbies =  mapper.readValue(pWithoutHobbies, p.Foo.Person.class);
        System.out.println("de-serialized person w/out hobbies: " + pNoHobbies);
    }
}