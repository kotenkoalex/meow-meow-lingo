package com.meow.lingo.directobject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DirectObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String directObjectVocabulary;
    private String directObjectExtra;
    private String translateDirectObjectVocabulary;
    private String translateDirectObjectExtra;
    private boolean incorrectData;

    public DirectObject(String directObjectVocabulary, String directObjectExtra, String translateDirectObjectVocabulary, String translateDirectObjectExtra, boolean incorrectData) {
        this.directObjectVocabulary = directObjectVocabulary;
        this.directObjectExtra = directObjectExtra;
        this.translateDirectObjectVocabulary = translateDirectObjectVocabulary;
        this.translateDirectObjectExtra = translateDirectObjectExtra;
        this.incorrectData = incorrectData;
    }
}
