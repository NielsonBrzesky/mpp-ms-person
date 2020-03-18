package mpp.com.person.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "consumer_contacts")
public class Person {

    @Id
    private String id;

    @Field("consumer_id")
    private Integer consumerId;

    private Map<String, Integer> contacts;
}
