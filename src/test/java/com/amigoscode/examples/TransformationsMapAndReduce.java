package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        Function<Person, PersonDTO> personPersonDTOFunction = person ->
                new PersonDTO(
                        person.getId(), person.getFirstName(), person.getAge()
                );

        List<PersonDTO> listPersonDTO = people.stream()
                .filter(person -> person.getAge() > 20)
                .map(personPersonDTOFunction
                ).collect(Collectors.toList());
        listPersonDTO.forEach(System.out::println);
        assertThat(people.size()).isGreaterThan(listPersonDTO.size());

    }

    @Test
    void yourFirstTransformationWithMap2() throws IOException {
        List<Person> people = MockData.getPeople();

        List<PersonDTO> listPersonDTO = people.stream()
                .map(PersonDTO::map).collect(Collectors.toList());
        listPersonDTO.forEach(System.out::println);
        assertThat(people.size()).isEqualTo(listPersonDTO.size());

    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        double avg = cars.stream().mapToDouble(Car::getPrice).average().orElse(0);
        assertEquals(avg,52693.19979);
        System.out.println(avg);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    }
}

