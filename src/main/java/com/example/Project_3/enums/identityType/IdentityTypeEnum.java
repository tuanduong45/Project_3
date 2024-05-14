package com.example.Project_3.enums.identityType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum IdentityTypeEnum {

    ID_CARD("Chứng minh thư nhân dân",1),
    CITIZEN_ID_CARD("Căn cước công dân",2),
    PASSPORT( "Hộ chiếu",3);




    private final String typeName;
    private final int value;


    public int getValueFromTypeName(String typeName){
        return switch (typeName) {
            case "Chứng minh thư nhân dân" -> 1;
            case "Căn cước công dân" -> 2;
            case "Hộ chiếu" -> 3;
            default -> 0;
        };
    }
    public static IdentityTypeEnum typeOf(String value) {
        if (Objects.isNull(value)) return null;
        return switch (value) {
            case "Chứng minh nhân dân" -> ID_CARD;
            case "Căn cước công dân" -> CITIZEN_ID_CARD;
            case "Hộ chiếu" -> PASSPORT;
            default -> null;
        };
    }


}
