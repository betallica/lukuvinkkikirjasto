/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import ohtu.database.dto.BookHintDto;
import ohtu.service.BookHintService;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootHintServiceTest {
    @Autowired
    private BookHintService bookHintService;
    
    private BookHintDto mockBookHintDto;

    @Before
    public void setUp() {
        mockBookHintDto = new BookHintDto();
        mockBookHintDto.setName("The Elements of Scrum");
        mockBookHintDto.setAuthor("Sims and Johnson");
        mockBookHintDto.setIsbn("9780982866917");
    }
    
    @Test
    public void bookHintServiceIsNotNull() {
        assertNotNull(bookHintService);
    }
    
    @Test
    public void createBookReturnObjectHasCorrectName() {
        assertEquals("The Elements of Scrum", bookHintService.createBookHint(mockBookHintDto).getName());
    }
   
    @Test
    public void createBookReturnObjectHasCorrectAuthor() {
        assertEquals("Sims and Johnson", bookHintService.createBookHint(mockBookHintDto).getAuthor());
    }
   
    @Test
    public void createBookReturnObjectHasCorrectIsbnNumber() {
        assertEquals("9780982866917", bookHintService.createBookHint(mockBookHintDto).getIsbn());
    }
    
}
