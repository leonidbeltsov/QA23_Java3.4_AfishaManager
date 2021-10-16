package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Film {
    private int id;
    private String name;
    private String type;
    private boolean premiereIsTomorrow;
}