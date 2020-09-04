package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hamcrest.collection.IsMapContaining;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    Map<String, String> app = new HashMap<>();
    FileOpenManager manager = new FileOpenManager(app);
    Map<String, String> expected = new HashMap<>();

    @BeforeEach
    void setUp() {
        expected.put("jpg", "Paint");
        expected.put("txt", "Notepad");
        expected.put("docx", "Notepad");
        expected.put("rtf", "Word");
        expected.put("pdf", "Acrobat Reader");
    }

    @Test
    void add() {
        manager.add("Jpg", "Paint");  //Проверяю параллельно на разном регистре
        manager.add("txt", "Notepad");
        manager.add("Docx", "Notepad"); //Проверяю параллельно на разном регистре
        manager.add("rtf", "Word");
        manager.add("pdf", "Acrobat Reader");
        assertThat(app, is(expected));
    }

    @Test
    void getAppName() {
        manager.add("rtf", "Word");
        manager.add("pdf", "Acrobat Reader");
        String expected = "Word";
        String actual = manager.getAppName("Rtf"); //Проверяю параллельно на разном регистре
        assertEquals(expected, actual);

    }

    @Test
    void deleteLink() {
        manager.add("Jpg", "Paint");
        manager.add("txt", "Notepad");
        manager.add("Docx", "Notepad");
        manager.add("rtf", "Word");
        manager.add("pdf", "Acrobat Reader");
        manager.deleteLink("jpg");
        assertThat(app, not(IsMapContaining.hasValue("Paint")));

    }

    @Test
    void getAllExtension() {
        manager.add("Jpg", "Paint");
        manager.add("txt", "Notepad");
        manager.add("Docx", "Notepad");
        Collection<String> expected = List.of("jpg", "txt", "docx");
        Collection<String> actual = manager.getAllExtension(app);
        assertEquals(expected, actual);


    }

    @Test
    void getAllAppName() {
        manager.add("Jpg", "Paint");
        manager.add("txt", "Notepad");
        manager.add("Docx", "Notepad");
        Set<String> expected = new HashSet<>(Arrays.asList("Paint", "Notepad"));
        Set<String> actual = manager.getAllAppName(app);
        assertEquals(expected, actual);
    }
}