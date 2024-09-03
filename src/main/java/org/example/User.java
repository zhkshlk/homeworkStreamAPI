package org.example;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data

public class User {
    private int id;
    private String name;
    private int age;
    private ArrayList<Phone> phone;
}
