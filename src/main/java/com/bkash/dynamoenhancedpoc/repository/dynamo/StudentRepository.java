package com.bkash.dynamoenhancedpoc.repository.dynamo;

import com.bkash.dynamoenhancedpoc.dao.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;

@Slf4j
@Repository
public class StudentRepository extends AbstractDynamoRepository<Student>{


    public StudentRepository(Environment environment, DynamoDbEnhancedAsyncClient dynamoDbEnhancedClient) {
        super(environment.getActiveProfiles()[0] + "-students", dynamoDbEnhancedClient, Student.class);

    }

    public Flux<Student> getAllStudents(){

        return Flux.from(findAllItems().items());
    }


    public Mono<Void> saveStudent(Student student){

        return Mono.fromFuture(saveItem(student));
    }

}
